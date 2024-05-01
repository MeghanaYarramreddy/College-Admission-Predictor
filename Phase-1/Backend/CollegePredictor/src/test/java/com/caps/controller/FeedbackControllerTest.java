package com.caps.controller;

import com.caps.entity.FeedBack;
import com.caps.service.IFeedBackService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FeedbackController.class)
@ActiveProfiles("test")
class FeedbackControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IFeedBackService feedbackService;

    @Test
    public void shouldReturn201_whenFeedbackIsSaved() throws Exception {

        //Arrange
        String feedbackRequest = "{\n" +
                "\t\"feedbackId\": \"1234\",\n" +
                "    \"userEmail\":\"abc@gmail.com\",\n" +
                "    \"phoneNo\":1234567890,\n" +
                "    \"feedback\":\"qwertyuiasdfgh qwertyuioasdfgh\"\n" +
                "}";


        FeedBack mockedFeedback = new FeedBack();
        mockedFeedback.setFeedbackId(1234);
        mockedFeedback.setUserEmail("abc@gmail.com");
        mockedFeedback.setPhoneNo(1234567890);
        mockedFeedback.setFeedback("qwertyuiasdfgh qwertyuioasdfgh");


        when(feedbackService.giveFeedback(mockedFeedback)).thenReturn(Boolean.TRUE);

        //Act
        mockMvc.perform(post("/feedback")
                .contentType("application/json;charset=UTF-8")
                .content(feedbackRequest)
        )
                //Assert
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturn200_whenFeedbackRequestIsSuccess() throws Exception {

        //Arrange
        FeedBack mockedFeedback = new FeedBack();
        mockedFeedback.setFeedbackId(1234);
        mockedFeedback.setUserEmail("abc@gmail.com");
        mockedFeedback.setPhoneNo(1234567890);
        mockedFeedback.setFeedback("qwertyuiasdfgh qwertyuioasdfgh");

        mockedFeedback.getFeedbackId();
        mockedFeedback.getUserEmail();
        mockedFeedback.getPhoneNo();
        mockedFeedback.getFeedback();

        ArrayList<FeedBack> feedbackList = new ArrayList<>();
        feedbackList.add(mockedFeedback);

        when(feedbackService.getFeedback()).thenReturn(feedbackList);

        //Act
        mockMvc.perform(get("/getFeedback")
                .contentType("application/json;charset=UTF-8"))

                //Assert
                .andExpect(status().isOk());
    }
}

