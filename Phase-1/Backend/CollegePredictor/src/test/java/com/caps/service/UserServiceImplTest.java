package com.caps.service;

import com.caps.dao.CollegeDao;
import com.caps.dao.UserDao;
import com.caps.entity.College;
import com.caps.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserDao userDao;

    @InjectMocks
    private CollegeServiceImpl collegeService;

    @Mock
    private CollegeDao collegeDao;


    @Test
    public void shouldReturnNull_whenCollegeDetailsIsEmpty() {

        //Mock
        when(collegeDao.findAll()).thenReturn(null);

        //Act
        List<College> result = collegeService.getAllColleges();

        //Assert
        assertEquals(null, result);
    }

    @Test
    public void ShouldReturnValues_whenCollegeDetailsIsNotEmpty() {

        //Arrange
        HashMap<String, Double> cutOffList = new HashMap<>();
        cutOffList.put("CS", 60.0);

        College college = new College();
        college.setCollegeCode("16987");
        college.setCollegeName("College Name");
        college.setCity("city");
        college.setAddress("address");
        college.setContactNumber(23456765l);
        college.setState("state");
        college.setBranchCutoff(cutOffList);

        ArrayList<College> collegeList = new ArrayList<>();
        collegeList.add(college);

        when(collegeService.getAllColleges()).thenReturn(collegeList);

        when(collegeDao.findAll()).thenReturn(collegeList);

        //Act
        List<College> result = collegeService.getAllColleges();

        //Assert
        assertEquals(collegeList, result);
    }

    @Test
    public void shouldReturnTrue_whenLoginIsSuccessfull() {

        //Arrange
        Long phoneNo = 1234567890l;
        String password = "password";

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

        when(userDao.existsById(phoneNo)).thenReturn(TRUE);
        when(userDao.getOne(phoneNo)).thenReturn(mockedUser);

        //Act
        boolean result = userService.login(phoneNo, password);

        //Assert
        assertThat(result).isNotNull();
    }

    @Test
    public void shouldReturnFalse_whenLoginIsNotSuccessfull() {

        //Arrange
        Long phoneNo = 1234567890l;
        String password = "password";

        when(userDao.existsById(phoneNo)).thenReturn(FALSE);

        //Act
        boolean result = userService.login(phoneNo, password);

        //Assert
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void shouldReturnTrue_whenNewUserIsRegistering() {

        //Arrange
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

        when(userDao.existsById(mockedUser.getPhoneNo())).thenReturn(FALSE);
        when(userDao.save(mockedUser)).thenReturn(any());

        //Act
        boolean result = userService.register(mockedUser);

        //Assert
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void shouldReturnFalse_whenUserIsAlreadyExists() {

        //Arrange
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

        when(userDao.existsById(mockedUser.getPhoneNo())).thenReturn(TRUE);

        //Act
        boolean result = userService.register(mockedUser);

        //Assert
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void shouldGetUserProfile_whenUserExists() {

        //Arrange
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

        Optional<User> optionalUser = Optional.ofNullable(mockedUser);

        when(userDao.existsById(mockedUser.getPhoneNo())).thenReturn(TRUE);
        when(userDao.findById(mockedUser.getPhoneNo())).thenReturn(optionalUser);

        //Act
        User result = userService.getProfile(mockedUser.getPhoneNo());

        //Assert
        assertThat(result).isNotNull();
    }

    @Test
    public void shouldReturnNull_whenUserDoesntExists() {

        //Arrange
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

        when(userDao.existsById(mockedUser.getPhoneNo())).thenReturn(FALSE);

        //Act
        User result = userService.getProfile(mockedUser.getPhoneNo());

        //Assert
        assertThat(result).isNull();
    }

    @Test
    public void shouldReturnTrue_whenUpdateProfileIsSuccess() {

        //Arrange
        User mockedUser = new User();
        mockedUser.setPhoneNo(123456987);
        mockedUser.setName("abcd");
        mockedUser.setEmail("abc@gmail.com");
        mockedUser.setGender("female");
        mockedUser.setDob("june 5th");
        mockedUser.setSecurityQuestion("what's your fav color?");
        mockedUser.setAnswer("black");
        mockedUser.setPassword("password");

        User updatedUser = new User();
        updatedUser.setPhoneNo(123456987);
        updatedUser.setName("updatedUser");
        updatedUser.setEmail("user@gmail.com");
        updatedUser.setGender("female");
        updatedUser.setDob("june 5th");
        updatedUser.setSecurityQuestion("what's your fav color?");
        updatedUser.setAnswer("black");
        updatedUser.setPassword("new_password");
        updatedUser.setMarks(70);

        when(userDao.existsById(mockedUser.getPhoneNo())).thenReturn(TRUE);
        when(userDao.getOne(mockedUser.getPhoneNo())).thenReturn(updatedUser);
        when(userDao.save(mockedUser)).thenReturn(updatedUser);

        //Act
        boolean result = userService.updateProfile(mockedUser);

        //Assert
        assertThat(result).isTrue();
    }

    @Test
    public void shouldNotUpdateProfile_whenUserNotExists() {

        //Arrange
        User mockedUser = new User();

        when(userDao.existsById(mockedUser.getPhoneNo())).thenReturn(FALSE);

        //Act
        boolean result = userService.updateProfile(mockedUser);

        //Assert
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void shouldNotUpdatePassword_whenUserNotExists() {

        //Arrange
        User updatedUser = new User();

        when(userDao.existsById(updatedUser.getPhoneNo())).thenReturn(FALSE);

        //Act
        boolean result = userService.setPassword(updatedUser.getPhoneNo(), updatedUser.getSecurityQuestion(),
                updatedUser.getAnswer(), updatedUser.getPassword());

        //Assert
        assertThat(result).isFalse();
    }

    @Test
    public void shouldUpdateNewPassword_whenUserExists() {

        //Arrange
        User updatedUser = new User();
        updatedUser.setPhoneNo(123456987);
        updatedUser.setName("updatedUser");
        updatedUser.setEmail("user@gmail.com");
        updatedUser.setGender("female");
        updatedUser.setDob("june 5th");
        updatedUser.setSecurityQuestion("what's your fav color?");
        updatedUser.setAnswer("black");
        updatedUser.setPassword("new_password");
        updatedUser.setMarks(70);

        when(userDao.existsById(updatedUser.getPhoneNo())).thenReturn(TRUE);
        when(userDao.getOne(updatedUser.getPhoneNo())).thenReturn(updatedUser);

        //Act
        boolean result = userService.setPassword(updatedUser.getPhoneNo(), updatedUser.getSecurityQuestion(),
                updatedUser.getAnswer(), updatedUser.getPassword());

        //Assert
        assertThat(result).isTrue();
    }
}

