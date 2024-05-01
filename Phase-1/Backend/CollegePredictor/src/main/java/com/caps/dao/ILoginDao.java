package com.caps.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.caps.entity.Login;


@Repository
@Transactional
public interface ILoginDao extends JpaRepository<Login, Long>{

}
