package com.caps.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caps.entity.User;





public interface IAdminDao extends JpaRepository<User, Long> {

}
