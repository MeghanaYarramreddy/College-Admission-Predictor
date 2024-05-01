package com.caps.service;

import java.util.List;

import com.caps.entity.Branches;
import com.caps.entity.College;
import com.caps.exception.InvalidCollege;

public interface ICollegeService {
	public boolean addCollege(College college) throws InvalidCollege;
	public List<College> getAllColleges();
	public boolean updateCollege(College college);
	void deleteById(String collegeCode);
	public List<Branches> addBranches(List<Branches> branches);
	public List<String> showStates();

    public List<String> showCities();

}
