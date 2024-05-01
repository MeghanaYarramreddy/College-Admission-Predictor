package com.caps.service;

import com.caps.dao.FeedBackDao;
import com.caps.dao.UserDao;
import com.caps.entity.FeedBack;
import com.caps.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FeedbackServiceImplTest {

    @InjectMocks
    private FeedbackServiceImpl feedbackService;

    @Mock
    private UserDao userDao;

    @Mock
    private FeedBackDao feedBackDao;

    @Test
    public void shouldSaveFeedback_whenUserPhoneNumberIsExists() {

        //Arrange
        FeedBack mockedFeedback = new FeedBack();
        mockedFeedback.setFeedbackId(1234);
        mockedFeedback.setUserName("username");
        mockedFeedback.setUserEmail("abc@gmail.com");
        mockedFeedback.setPhoneNo(1234567890);
        mockedFeedback.setFeedback("qwertyuiasdfgh qwertyuioasdfgh");
        mockedFeedback.setDescription("ok");

        User mockedUser = new User();
        mockedUser.setPhoneNo(1234567890);

        Optional<User> optionalUser = Optional.ofNullable(mockedUser);


        when(userDao.existsById(mockedFeedback.getPhoneNo())).thenReturn(TRUE);
        when(userDao.findById(mockedFeedback.getPhoneNo())).thenReturn(optionalUser);
        when(feedBackDao.save(mockedFeedback)).thenReturn(mockedFeedback);

        //Act
        boolean expectedResult = feedbackService.giveFeedback(mockedFeedback);

        //Assert
        assertThat(userDao.findById(mockedFeedback.getPhoneNo()).get()).isNotNull();
        assertThat(expectedResult).isEqualTo(true);
    }

    @Test
    public void shouldNotSaveFeedback_whenUserPhoneNumberNotExists() {

        //Arrange
        FeedBack mockedFeedback = new FeedBack();
        mockedFeedback.setFeedbackId(1234);
        mockedFeedback.setUserEmail("abc@gmail.com");
        mockedFeedback.setFeedback("qwertyuiasdfgh qwertyuioasdfgh");

        User mockedUser = new User();
        Optional<User> optionalUser = Optional.ofNullable(mockedUser);

        when(userDao.existsById(mockedFeedback.getPhoneNo())).thenReturn(FALSE);
        when(userDao.findById(mockedFeedback.getPhoneNo())).thenReturn(optionalUser);


        //Act
        boolean expectedResult = feedbackService.giveFeedback(mockedFeedback);

        //Assert
        assertThat(expectedResult).isEqualTo(false);
    }

    @Test
    public void shouldReturnNull_whenFeedbackIsEmpty() {

        //Mock
        when(feedBackDao.findAll()).thenReturn(null);

        //Act
        List<FeedBack> result = feedbackService.getFeedback();

        //Assert
        assertEquals(null, result);
    }

    @Test
    public void ShouldReturnValues_whenFeedbackIsNotEmpty() {

        //Arrange
        FeedBack mockedFeedback = new FeedBack();
        mockedFeedback.setFeedbackId(1234);
        mockedFeedback.setUserName("username");
        mockedFeedback.setPhoneNo(1234567890);
        mockedFeedback.setUserEmail("abc@gmail.com");
        mockedFeedback.setFeedback("qwertyuiasdfgh qwertyuioasdfgh");
        mockedFeedback.setDescription("ok");

        ArrayList<FeedBack> feedbackList = new ArrayList<>();
        feedbackList.add(mockedFeedback);

        when(feedbackService.getFeedback()).thenReturn(feedbackList);

        when(feedBackDao.findAll()).thenReturn(feedbackList);

        //Act
        List<FeedBack> result = feedbackService.getFeedback();

        //Assert
        assertEquals(feedbackList, result);
    }

}