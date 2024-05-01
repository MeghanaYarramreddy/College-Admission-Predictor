package com.caps.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caps.entity.Branches;
import com.caps.entity.College;
import com.caps.entity.Login;
import com.caps.exception.InvalidCollege;
import com.caps.service.ICollegeService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
public class CollegeController {
	@Autowired
	private ICollegeService collegeService;

	
	@PostMapping(value = "/addCollege" , consumes ="application/json")
	public ResponseEntity<Boolean> addCollege(@RequestBody College college) {

		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(collegeService.addCollege(college));
		} catch (InvalidCollege e) {
			
			System.out.println(e.getMessage());
			e.getMessage();
			return (ResponseEntity<Boolean>) ResponseEntity.status(HttpStatus.NOT_FOUND);

		}

	}
	
	@PostMapping(value = "/addCollegeTest")
	public boolean addCollegeTest() throws InvalidCollege {
		College college=null;

			return collegeService.addCollege(college);

	}
	
	@PostMapping(value = "/addBranches")
	public void addBranches(@RequestBody List<Branches> branches) {

		System.out.println("branchController");
		 collegeService.addBranches(branches);

	}

	@GetMapping(value = "/getAllcolleges")
	public List<College> getAllColleges() {
		return collegeService.getAllColleges();

	}
	
	@PutMapping(value = "/updateCollege")
	public boolean updateCollege(@RequestBody College college) {

		
		return collegeService.updateCollege(college);

	}
	@DeleteMapping(value = "/deleteCollege/{collegeCode}")
	public void deleteCollege(@PathVariable String collegeCode) {
		 collegeService.deleteById(collegeCode);

	}
	
	@GetMapping("/getStates")
    public List<String> showStates() {
        List<String> l=collegeService.showStates();
        List<String> s=new ArrayList<String>();
        for (String string : l) {
        s.add(string);
        }
        return s;
        }
   
    @GetMapping("/getCities")
    public List<String> showCities() {
        List<String> l=collegeService.showCities();
        List<String> s=new ArrayList<String>();
        for (String string : l) {
        s.add(string);
        }
        return s;
        }

}
