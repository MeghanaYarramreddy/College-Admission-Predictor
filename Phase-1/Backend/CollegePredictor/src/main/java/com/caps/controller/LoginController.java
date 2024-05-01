package com.caps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caps.entity.Login;
import com.caps.service.ILoginService;


/**
 * @author Mahesh Kommi
 *
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class LoginController {

	@Autowired
	ILoginService service; 
	 
	/**
	 * @param login
	 * @return boolean
	 * 
	 * returns true if the credentials are true
	 * else false
	 */
	@PostMapping(value="/adminLogin")
	public ResponseEntity<Boolean> login(@RequestBody Login login)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(service.login(login));
			
	}
	/**
	 * @param reg
	 * @return boolean
	 * 
	 * storing  admin credentials
	 */
	@PostMapping(value="/addAdmin" , consumes = "application/json")
	public boolean register(@RequestBody Login reg)
	{
		System.out.println("HII");
		return service.register(reg);
		
	} 
	
	/**
	 * @param mobile number
	 * @param current password
	 * @param new password
	 * @return boolean
	 * 
	 * change the password for admin
	 */
	@GetMapping(value="/changeAdminPassword/{mobNum}/{curPass}/{newPass}")
	public boolean changePassword(@PathVariable("mobNum") long mobNum,@PathVariable("curPass") String curPass,@PathVariable("newPass") String newPass)
	{ 
		return service.changePasword(mobNum, curPass, newPass);
		
	} 
	
	
}
