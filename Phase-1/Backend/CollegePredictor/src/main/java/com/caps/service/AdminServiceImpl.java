package com.caps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caps.dao.IAdminDao;
import com.caps.entity.User;


@Service
public class AdminServiceImpl implements IAdminService {
 @Autowired
 IAdminDao dao;
	
	@Override
	public List<User> getuserdeails() {
		return dao.findAll();
	}

}