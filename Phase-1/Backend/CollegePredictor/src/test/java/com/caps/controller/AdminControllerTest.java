package com.caps.controller;

import com.caps.dao.CollegeDao;
import com.caps.dao.IAdminDao;
import com.caps.entity.College;
import com.caps.entity.User;
import com.caps.service.IAdminService;
import com.caps.service.ICollegeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdminController.class)
@ActiveProfiles("test")
class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IAdminService adminService;

    @MockBean
    private IAdminDao adminDao;

    @Test
    public void shouldReturnOk_whenGetAllCollegeIsSuccess() throws Exception {

        //Arrange
        User mockeduser = new User();
        mockeduser.setEmail("abc@gmail.com");
        mockeduser.setGender("female");
        mockeduser.setMarks(77);
        mockeduser.setPhoneNo(1234567890);
        mockeduser.setName("sravya");

        ArrayList<User> userlist = new ArrayList<>();
        userlist.add(mockeduser);

        when(adminService.getuserdeails()).thenReturn(userlist);


        //Act
        mockMvc.perform(get("/getUserDetails")
                .contentType("application/json;charset=UTF-8")
        )

                //Assert
                .andExpect(status().isOk());

    }

}