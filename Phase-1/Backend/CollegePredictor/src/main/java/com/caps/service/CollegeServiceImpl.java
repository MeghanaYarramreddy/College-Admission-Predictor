package com.caps.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caps.dao.CollegeDao;
import com.caps.entity.Branches;
import com.caps.entity.College;
import com.caps.entity.Login;
import com.caps.exception.InvalidCollege;
@Service
@Transactional
public class CollegeServiceImpl implements ICollegeService{
	@Autowired
	private CollegeDao collegeDao;
	
	List<Branches> branchestoAdd= new ArrayList<>();
	HashMap<String,Double> br=new HashMap<String,Double>();
	@Override
	public boolean addCollege(College college) throws InvalidCollege {
		if(college !=null){
			boolean existedCollege=collegeDao.existsById(college.getCollegeCode());

		if(existedCollege == false)
		{
			System.out.println("coll"+branchestoAdd);
			if(branchestoAdd != null || !branchestoAdd.isEmpty()){
				for(Branches branch:branchestoAdd){
					br.put(branch.getName(), branch.getCutOff());
				 
				}
				System.out.println(br);
				college.setBranchCutoff(br);
				
			}
			collegeDao.save(college);
			branchestoAdd.clear();
			br.clear();
			return true;
		}
		else
		{
			return false;
		}
		}
		else
			throw new InvalidCollege("College should not be null");
	}
	@Override
	public List<Branches> addBranches(List<Branches> branches) {
		System.out.println("branches"+branches);
		branchestoAdd.addAll(branches);
		return branches;
	}


	@Override
	public List<College> getAllColleges() {
		return collegeDao.findAll();
	}

	@Override
	public boolean updateCollege(College college) {
		boolean existedCollege=collegeDao.existsById(college.getCollegeCode());
		
		if(existedCollege)
		{
		College	clg=collegeDao.findById(college.getCollegeCode()).get();
		clg.getBranchCutoff().clear();
		collegeDao.save(clg);
			System.out.println("coll"+branchestoAdd);
			if(branchestoAdd != null || !branchestoAdd.isEmpty()){
				for(Branches branch:branchestoAdd){
					br.put(branch.getName(), branch.getCutOff());
				 
				}
				System.out.println(br);
				college.setBranchCutoff(br);
				
			}
			collegeDao.save(college);
			branchestoAdd.clear();
			br.clear();
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void deleteById(String collegeCode) {
		collegeDao.deleteById(collegeCode);
	}
	public CollegeServiceImpl() {
	}  
	@Override
    public List<String> showStates() {
    return collegeDao.showStates();
    }

 

    @Override
    public List<String> showCities() {
        
        return collegeDao.showCities();
    }
 

	
}
