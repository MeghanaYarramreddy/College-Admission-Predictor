package com.caps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caps.entity.User;
import com.caps.service.IAdminService;

@RestController
@CrossOrigin
public class AdminController {
	
	@Autowired
	IAdminService adminservice;
	
	@GetMapping(value="/getUserDetails" ,produces = "application/json")
	public List<User> getUserDeatails(){
		return adminservice.getuserdeails();
		
	}


}
