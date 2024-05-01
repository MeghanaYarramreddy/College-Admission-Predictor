package com.caps.service;

import com.caps.dao.IAdminDao;
import com.caps.dao.ILoginDao;
import com.caps.entity.Login;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginServiceImplTest {

    @InjectMocks
    private LoginServiceImpl loginService;

    @Mock
    private ILoginDao loginDao;

    @Test
    public void shouldReturnTrue_whenLoginIsSuccessfull() {

        //Arrange
        Login login = new Login();
        login.setMobNum(1234567890);
        login.setPassword("password");

        when(loginDao.existsById(login.getMobNum())).thenReturn(TRUE);
        when(loginDao.getOne(login.getMobNum())).thenReturn(login);

        //Act
        boolean result = loginService.login(login);

        //Assert
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void shouldReturnFalse_whenLoginIsNotSuccessfull() {

        //Arrange
        Login login = new Login();

        when(loginDao.existsById(login.getMobNum())).thenReturn(FALSE);

        //Act
        boolean result = loginService.login(login);

        //Assert
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void shouldReturnTrue_whenNewUserIsRegistering() {

        //Arrange
        Login login = new Login();


        when(loginDao.existsById(login.getMobNum())).thenReturn(FALSE);
        when(loginDao.save(login)).thenReturn(any());

        //Act
        boolean result = loginService.register(login);

        //Assert
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void shouldReturnFalse_whenUserIsAlreadyExists() {

        //Arrange
        Login login = new Login();
        login.setMobNum(1234567890);

        when(loginDao.existsById(login.getMobNum())).thenReturn(TRUE);

        //Act
        boolean result = loginService.register(login);

        //Assert
        assertThat(result).isEqualTo(false);
    }
}

