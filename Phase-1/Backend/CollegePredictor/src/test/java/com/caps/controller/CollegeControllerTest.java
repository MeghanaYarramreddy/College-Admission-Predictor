package com.caps.controller;

import com.caps.dao.CollegeDao;
import com.caps.dao.UserDao;
import com.caps.entity.College;
import com.caps.service.ICollegeService;
import com.caps.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CollegeController.class)
@ActiveProfiles("test")
class CollegeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICollegeService collegeService;

    @Test
    public void shouldReturnCreated_whenAddCollegeIsSuccess() throws Exception {

        //Arrange
        String collegeInput = "{\n" +
                "\t\"collegeCode\":\"cvsr\",\n" +
                "\t\"collegeName\":\"Anurag Group of Institutions\",\n" +
                "\t\"state\":\"Telangana\",\n" +
                "\t\"city\":\"Hyderabad\",\n" +
                "\t\"address\":\"Ghatkesar\",\n" +
                "\t\"contactNumber\":9876543210,\n" +
                "\t\"branchCutoff\":{\n" +
                "\t\"CSE\":123.0,\n" +
                "\t\"EEE\":456.0\n" +
                "\t}\n" +
                "} ";

        HashMap<String, Double> cutOffList = new HashMap<>();
        cutOffList.put("CS",60.0);

        College college = new College();
        college.setCollegeCode("16987");
        college.setCollegeName("CollegeName");
        college.setCity("city");
        college.setAddress("address");
        college.setContactNumber(23456765l);
        college.setState("state");
        college.setBranchCutoff(cutOffList);

        when(collegeService.addCollege(college)).thenReturn(Boolean.TRUE);

        //Act
        mockMvc.perform(post("/addCollege")
                .contentType("application/json;charset=UTF-8")
                .content(collegeInput)
        )

        //Assert
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldReturnOk_whenGetAllCollegeIsSuccess() throws Exception {

        //Arrange
        HashMap<String, Double> cutOffList = new HashMap<>();
        cutOffList.put("CS",60.0);

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

        //Act
        mockMvc.perform(get("/getAllcolleges")
                .contentType("application/json;charset=UTF-8")
        )

                //Assert
                .andExpect(status().isOk());

    }

    @Test
    public void shouldReturnOk_whenUpdateCollegeIsSuccess() throws Exception {

        //Arrange
        String collegeInput = "{\n" +
                "\t\"collegeCode\":\"cvsr\",\n" +
                "\t\"collegeName\":\"Anurag Group of Institutions\",\n" +
                "\t\"state\":\"Telangana\",\n" +
                "\t\"city\":\"Hyderabad\",\n" +
                "\t\"address\":\"Ghatkesar\",\n" +
                "\t\"contactNumber\":9876543210,\n" +
                "\t\"branchCutoff\":{\n" +
                "\t\"CSE\":123.0,\n" +
                "\t\"EEE\":456.0\n" +
                "\t}\n" +
                "} ";

        HashMap<String, Double> cutOffList = new HashMap<>();
        cutOffList.put("CS",60.0);

        College college = new College();
        college.setCollegeCode("16987");
        college.setCollegeName("CollegeName");
        college.setCity("city");
        college.setAddress("address");
        college.setContactNumber(23456765l);
        college.setState("state");
        college.setBranchCutoff(cutOffList);

        when(collegeService.updateCollege(college)).thenReturn(Boolean.TRUE);

        //Act
        mockMvc.perform(put("/updateCollege")
                .contentType("application/json;charset=UTF-8")
                .content(collegeInput)
        )

                //Assert
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnOk_whenDeleteCollegeIsSuccess() throws Exception {

        //Arrange
        String collegeCode = "clg123";

        //Act
        mockMvc.perform(delete("/deleteCollege/{collegeCode}", collegeCode)
                .contentType("application/json;charset=UTF-8")
        )

                //Assert
                .andExpect(status().isOk());

        verify(collegeService).deleteById(collegeCode);

    }


}