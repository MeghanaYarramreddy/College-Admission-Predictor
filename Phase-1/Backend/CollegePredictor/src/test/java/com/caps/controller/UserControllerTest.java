package com.caps.controller;

import com.caps.dao.UserDao;
import com.caps.entity.College;
import com.caps.entity.FeedBack;
import com.caps.entity.User;
import com.caps.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static java.lang.Boolean.TRUE;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@ActiveProfiles("test")
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUserService userService;

    @MockBean
    private UserDao userDao;

    @Test
    public void shouldReturn201_whenRegistrationIsDone() throws Exception {

        //Arrange
        String userInput = "{\n" +
                "\t\"phoneno\": 123456987,\n" +
                "    \"name\":\"abcd\",\n" +
                "    \"email\":\"abc@gmail.com\",\n" +
                "    \"gender\":\"female\",\n" +
                "    \"dob\":\"june 5th\",\n" +
                "    \"securityQuestion\":\"what's your fav color?\",\n" +
                "    \"answer\":\"black\",\n" +
                "    \"password\":\"password\",\n" +
                "    \"hallTicketNumber\": 25678,\n" +
                "    \"marks\": 70\n" +
                "}";

        User mockedUser = new User();
        mockedUser.setPhoneNo(123456987);
        mockedUser.setName("abcd");
        mockedUser.setEmail("abc@gmail.com");
        mockedUser.setGender("female");
        mockedUser.setDob("june 5th");
        mockedUser.setSecurityQuestion("what's your fav color?");
        mockedUser.setAnswer("black");
        mockedUser.setPassword("password");
        mockedUser.setMarks(70);

        when(userService.register(mockedUser)).thenReturn(TRUE);

        //Act
        mockMvc.perform(post("/register")
                .contentType("application/json;charset=UTF-8")
                .content(userInput)
        )

        //Assert
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturnOk_whenLoginIsSuccessfull() throws Exception {

        //Arrange
        String userPassword = "password";
        Long userPhone = 1234567890l;

        when(userService.login(userPhone,userPassword)).thenReturn(TRUE);
        when(userDao.existsById(userPhone)).thenReturn(TRUE);

        //Act
        mockMvc.perform(get("/login")
                .param("phoneNo", String.valueOf(1234567890l))
                .param("password", "password")
                .contentType("application/json;charset=UTF-8"))

        //Assert
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnOk_whenSetPasswordIsSuccessfull() throws Exception {

        //Arrange
        String userPassword = "password";
        String securityQuestion = "what's your fav color?";
        String answer= "black";
        Long userPhone = 1234567890l;

        when(userService.setPassword(userPhone,securityQuestion,answer,userPassword)).thenReturn(TRUE);
        when(userDao.existsById(userPhone)).thenReturn(TRUE);

        //Act
        mockMvc.perform(put("/setpassword")
                .param("phoneNo", String.valueOf(1234567890l))
                .param("securityQuestion","what's your fav color?")
                .param("answer","black")
                .param("password", "password")
                .contentType("application/json;charset=UTF-8"))

                //Assert
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnOk_whenGetAllCollegeDetailsIsSuccess() throws Exception {

        //Arrange
        Long phoneNo = 1234567890l;
        String branch = "CS";

        when(userService.viewPredictedColleges(phoneNo,branch)).thenReturn(any());
        when(userDao.existsById(phoneNo)).thenReturn(TRUE);

        //Act
        mockMvc.perform(get("/viewp/{phoneNo}/{branch}",1234567890l,"CS" )
                .contentType("application/json;charset=UTF-8"))

                //Assert
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnOk_whenViewCollegeIsSuccess() throws Exception {

        //Arrange
        College college = new College();
        college.setCollegeCode("1234");
        college.setCollegeName("College Name");
        college.setCity("city");
        college.setAddress("address");
        college.setContactNumber(23456765l);
        college.setState("state");

        ArrayList<College> contactList = new ArrayList<>();
        contactList.add(college);

        when(userService.getAllColleges()).thenReturn(contactList);

        //Act
        mockMvc.perform(get("/viewall")
                .contentType("application/json;charset=UTF-8"))

                //Assert
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnOk_whenGetProfileIsSuccessfull() throws Exception {

        //Arrange
        Long userPhone = 1234567890l;

        User mockedUser = new User();
        mockedUser.setPhoneNo(123456987);
        mockedUser.setName("abcd");
        mockedUser.setEmail("abc@gmail.com");
        mockedUser.setGender("female");
        mockedUser.setDob("june 5th");
        mockedUser.setSecurityQuestion("what's your fav color?");
        mockedUser.setAnswer("black");
        mockedUser.setPassword("password");
        mockedUser.setMarks(70);


        when(userService.getProfile(userPhone)).thenReturn(mockedUser);
        when(userDao.existsById(userPhone)).thenReturn(TRUE);

        //Act
        mockMvc.perform(get("/profile")
                .param("phoneNo", String.valueOf(1234567890l))
                .contentType("application/json;charset=UTF-8"))

                //Assert
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturn201_whenUpdateProfileIsDone() throws Exception {

        //Arrange
        String userInput = "{\n" +
                "\t\"phoneno\": 123456987,\n" +
                "    \"name\":\"abcd\",\n" +
                "    \"email\":\"abc@gmail.com\",\n" +
                "    \"gender\":\"female\",\n" +
                "    \"dob\":\"june 5th\",\n" +
                "    \"securityQuestion\":\"what's your fav color?\",\n" +
                "    \"answer\":\"black\",\n" +
                "    \"password\":\"password\",\n" +
                "    \"hallTicketNumber\": 25678,\n" +
                "    \"marks\": 70\n" +
                "}";

        User mockedUser = new User();
        mockedUser.setPhoneNo(123456987);
        mockedUser.setName("abcd");
        mockedUser.setEmail("abc@gmail.com");
        mockedUser.setGender("female");
        mockedUser.setDob("june 5th");
        mockedUser.setSecurityQuestion("what's your fav color?");
        mockedUser.setAnswer("black");
        mockedUser.setPassword("password");
        mockedUser.setMarks(70);

        when(userService.updateProfile(mockedUser)).thenReturn(TRUE);

        //Act
        mockMvc.perform(put("/updateprofile")
                .contentType("application/json;charset=UTF-8")
                .content(userInput)
        )

                //Assert
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnOk_whenViewCollegeByMarksIsSuccess() throws Exception {

        //Arrange
        Long phoneNo = 1234567890l;

        when(userService.viewCollegesBasedOnMarks(phoneNo)).thenReturn(any());
        when(userDao.existsById(phoneNo)).thenReturn(TRUE);

        //Act
        mockMvc.perform(get("/viewM/{phoneNo}",1234567890l )
                .contentType("application/json;charset=UTF-8"))

                //Assert
                .andExpect(status().isOk());
    }


}