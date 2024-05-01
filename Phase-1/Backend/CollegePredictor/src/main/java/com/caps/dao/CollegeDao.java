package com.caps.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.caps.entity.College;
@Repository
public interface CollegeDao extends JpaRepository<College, String> {
	
	@Query("select DISTINCT state from College")
    public List<String> showStates();
    @Query("select DISTINCT city from College")
    public List<String> showCities();
}
