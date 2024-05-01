package com.caps.service;

import com.caps.dao.IAdminDao;
import com.caps.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AdminServiceImplTest {

    @InjectMocks
    private AdminServiceImpl adminService;

    @Mock
    private IAdminDao admindao;


    @Test
    public void shouldReturnNull_whenUserDetailsIsEmpty() {

        //Mock
        when(admindao.findAll()).thenReturn(null);

        //Act
        List<User> result = adminService.getuserdeails();

        //Assert
        assertEquals(null, result);
    }

    @Test
    public void ShouldReturnValues_whenUserDetailsIsNotEmpty() {

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

        when(admindao.findAll()).thenReturn(userlist);

        //Act
        List<User> result = adminService.getuserdeails();

        //Assert
        assertEquals(userlist, result);
    }

}