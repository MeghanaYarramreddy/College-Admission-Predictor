package com.caps.service;

import java.util.List;

import com.caps.entity.College;
import com.caps.entity.User;

public interface IUserService {
	public boolean register(User user);
	public boolean login(long phoneNo, String password);
	boolean setPassword(long phoneNo, String securityQuestion, String answer, String password);
	
	public List<College> getAllColleges();
	List<College> viewPredictedColleges(long phoneNo, String branch);
	public User getProfile(long phoneNo);
	public boolean updateProfile(User user);
	List<College> viewCollegesBasedOnMarks(long phoneNo);
	List<College> getBystateandcity(String state, String city);
	List<College> getBystateandbranch(String state, String branch);
	List<College> getBycityandbranch(String city, String branch);
	List<College> getByState(String state);
	List<College> getByCity(String city);
	List<College> getByBranch(String branch);
	public List<College> getByAll(String state, String city, String branch);
	User getUserName(long phoneNo);
}
