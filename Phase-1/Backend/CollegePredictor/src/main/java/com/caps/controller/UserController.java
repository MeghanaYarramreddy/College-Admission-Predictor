package com.caps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caps.entity.College;
import com.caps.entity.User;
import com.caps.service.IUserService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class UserController {
	
	@Autowired
	IUserService service;
	
	
	@PostMapping(value="/register" , consumes = "application/json")
	public ResponseEntity<Boolean> register(@RequestBody User user)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.register(user));
		
	}
	@GetMapping(value="/login")
	public boolean login(@RequestParam Long phoneNo, String password)
	{
	   return service.login(phoneNo,password); 
		
			
	}
	
	@PutMapping(value="/setpassword")
    public boolean setPassword(@RequestParam Long phoneNo,String securityQuestion,String answer, String password)
    {
       return service.setPassword(phoneNo,securityQuestion,answer,password);
      
          
    }
	 @GetMapping("/viewp/{phoneNo}/{branch}")
     public List<College> getdetails(@PathVariable("phoneNo") long phoneNo,@PathVariable("branch") String branch) {
         return service.viewPredictedColleges(phoneNo, branch);
     }
	
	@GetMapping(value="/viewall")
	public List<College> viewAll()
	{
	 
	   return  service.getAllColleges(); 
		
	   
			
	}
//	@GetMapping(value="/viewUsers")
//	public List<User> viewAllUsers()
//	{
//	 
//	   return  service.getAllUsers(); 
//		
//	   
//			
//	}
	
	@GetMapping(value="/profile")
    public User profile(@RequestParam Long phoneNo)
    {
    	return service.getProfile(phoneNo);
    	
    }
	
	@GetMapping(value="/getUserName")
    public User getUserName(@RequestParam Long phoneNo)
    {
    	return service.getUserName(phoneNo);
    	
    }
	
    @PutMapping(value="/updateprofile")
    public boolean updateProfile(@RequestBody User user)
    {
       return service.updateProfile(user);
       
           
    }
    
    @GetMapping("/viewM/{phoneNo}")
    public List<College> getdetailsByMarks(@PathVariable("phoneNo") long phoneNo) {
        return service.viewCollegesBasedOnMarks(phoneNo);
    }
    
    
    @GetMapping(value="/getAll/{state}/{city}/{branch}")
    public List<College> getAll(@PathVariable("state") String state,@PathVariable("city") String city,@PathVariable("branch") String branch)
    {
        return  service.getByAll(state, city, branch);
               
    }
    @GetMapping(value="/getAllByStateAndCity/{state}/{city}")
    public List<College> getAllByStateAndCity(@PathVariable("state") String state,@PathVariable("city") String city)
    {
        return  service.getBystateandcity(state, city);
               
    }
    @GetMapping(value="/getAllByCityAndBranch/{city}/{branch}")
    public List<College> getAllByCityAndBranch(@PathVariable("city") String city,@PathVariable("branch") String branch)
    {
        return  service.getBycityandbranch(city, branch);
               
    }
    @GetMapping(value="/getAllByStateAndBranch/{state}/{branch}")
    public List<College> getAllByStateAndBranch(@PathVariable("state") String state,@PathVariable("branch") String branch)
    {
        return  service.getBystateandbranch(state, branch);
               
    }
    @GetMapping(value="/getAllByState/{state}")
    public List<College> getAllByState(@PathVariable("state") String state)
    {
        return  service.getByState(state);
               
    }
    @GetMapping(value="/getAllByCity/{city}")
    public List<College> getAllByCity(@PathVariable("city") String city)
    {
        return  service.getByCity(city);
               
    }
    @GetMapping(value="/getAllByBranch/{branch}")
    public List<College> getAllByBranch(@PathVariable("branch") String branch)
    {
        return  service.getByBranch(branch);
               
    }
	
}
