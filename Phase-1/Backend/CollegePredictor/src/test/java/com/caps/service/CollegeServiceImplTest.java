package com.caps.service;

import com.caps.dao.CollegeDao;
import com.caps.entity.Branches;
import com.caps.entity.College;
import com.caps.exception.InvalidCollege;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CollegeServiceImplTest {

    @InjectMocks
    private CollegeServiceImpl collegeService;

    @Mock
    private CollegeDao collegeDao;

    @Test
    public void shouldReturnTrue_whenAddCollegeIsSuccess() throws InvalidCollege {

        //Arrange
        HashMap<String, Double> cutOffList = new HashMap<>();
        cutOffList.put("CS", 60.0);

        College college = new College();
        college.setCollegeCode("16987");
        college.setCollegeName("CollegeName");
        college.setCity("city");
        college.setAddress("address");
        college.setContactNumber(23456765l);
        college.setState("state");
        college.setBranchCutoff(cutOffList);

        when(collegeDao.save(college)).thenReturn(college);
        when(collegeDao.existsById(college.getCollegeCode())).thenReturn(false);

        //Act
        boolean expectedResult = collegeService.addCollege(college);

        //Assert
        assertThat(expectedResult).isEqualTo(true);
    }

    @Test
    public void shouldReturnFalse_whenCollegeAlreadyExists() throws InvalidCollege {

        //Arrange
        College college = new College();

        when(collegeDao.existsById(college.getCollegeCode())).thenReturn(true);

        //Act
        boolean expectedResult = collegeService.addCollege(college);

        //Assert
        assertThat(expectedResult).isEqualTo(false);
    }

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
    public void shouldReturnTrue_whenUpdateCollegeIsSuccess() {

        //Arrange
        HashMap<String, Double> cutOffList = new HashMap<>();
        cutOffList.put("CS", 60.0);

        College college = new College();
        college.setCollegeCode("16987");
        college.setCollegeName("CollegeName");
        college.setCity("city");
        college.setAddress("address");
        college.setContactNumber(23456765l);
        college.setState("state");
        college.setBranchCutoff(cutOffList);

        Optional<College> optionalCollege = Optional.ofNullable(college);

        Branches branch = new Branches();
        branch.setName("CS");
        branch.setCutOff(60.0);

        ArrayList<Branches> branchList = new ArrayList<>();
        branchList.add(branch);

        when(collegeDao.existsById(college.getCollegeCode())).thenReturn(true);
        when(collegeDao.findById(college.getCollegeCode())).thenReturn(optionalCollege);
        when(collegeDao.save(college)).thenReturn(college);

        //Act
        boolean expectedResult = collegeService.updateCollege(college);

        //Assert
        assertThat(collegeDao.findById(college.getCollegeCode()).get()).isNotNull();
        assertThat(expectedResult).isEqualTo(true);
    }

    @Test
    public void shouldNotUpdateCollege_whenCollegeNotExists() {

        //Arrange
        College college = new College();

        when(collegeDao.existsById(college.getCollegeCode())).thenReturn(false);

        //Act
        boolean expectedResult = collegeService.updateCollege(college);

        //Assert
        assertThat(expectedResult).isEqualTo(false);
    }

    @Test
    public void shouldDeleteCollege_whenCollegeCodeIsGiven() {

        //Arrange
        String collegeCode = "COLLG";

        //Act
        collegeService.deleteById(collegeCode);

        //Assert
        verify(collegeDao).deleteById(collegeCode);
    }


    @Test
    public void shouldNotDeleteCollege_whenCollegeCodeNotExists() {

        //Arrange

        //Act
        collegeService.deleteById(null);

        //Assert
        verify(collegeDao).deleteById(null);
    }


}