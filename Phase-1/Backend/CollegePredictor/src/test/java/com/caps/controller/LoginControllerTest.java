package com.caps.controller;

import com.caps.dao.IAdminDao;
import com.caps.dao.ILoginDao;
import com.caps.entity.Login;
import com.caps.entity.User;
import com.caps.service.IAdminService;
import com.caps.service.ILoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoginController.class)
@ActiveProfiles("test")
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ILoginService loginService;

    @Test
    public void shouldReturnOk_whenLoginIsSuccess() throws Exception {

        //Arrange
        String loginJson = "\n" +
                "{\n" +
                "\t\"mobNum\":9951882024,\n" +
                "\t\"password\":\"Mahi@123\"\n" +
                "}";

        Login login = new Login();
        login.setMobNum(1234567890);
        login.setPassword("password");

        when(loginService.login(login)).thenReturn(Boolean.TRUE);


        //Act
        mockMvc.perform(post("/adminLogin")
                .contentType("application/json;charset=UTF-8")
                .content(loginJson)
        )

                //Assert
                .andExpect(status().isCreated());

    }

    @Test
    public void shouldReturnOk_whenRegistrationIsDone() throws Exception {

        //Arrange
        String loginJson = "\n" +
                "{\n" +
                "\t\"mobNum\":9951882024,\n" +
                "\t\"password\":\"Mahi@123\"\n" +
                "}";

        Login login = new Login();
        login.setMobNum(1234567890);
        login.setPassword("password");

        when(loginService.register(login)).thenReturn(Boolean.TRUE);


        //Act
        mockMvc.perform(post("/adminLogin")
                .contentType("application/json;charset=UTF-8")
                .content(loginJson)
        )

                //Assert
                .andExpect(status().isCreated());

    }

}