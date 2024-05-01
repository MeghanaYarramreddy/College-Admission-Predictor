package com.caps.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caps.dao.ILoginDao;
import com.caps.entity.Login;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService {

	@Autowired
	ILoginDao loginDao;

	@Override
	public boolean login(Login login) {
		boolean existedReg = loginDao.existsById(login.getMobNum());

		if (existedReg) {
			Login reg = loginDao.getOne(login.getMobNum());

			if (reg.getPassword().equals(login.getPassword())) {
				return true;
			}

			else
				return false;
		} else
			return false;

	}

	@Override
	public boolean register(Login login) {
		long phoneNo = login.getMobNum();
		boolean existedReg = loginDao.existsById(phoneNo);

		if (existedReg == false) {
			loginDao.save(login);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean changePasword(long mobNum, String curPass, String newPass) {
		boolean existedReg = loginDao.existsById(mobNum);
		if (existedReg) {
			Login login = loginDao.getOne(mobNum);
			if (login.getPassword().equals(curPass)) {
				login.setPassword(newPass);
				loginDao.save(login);
				return true;
			} else
				return false;
		} else {
			return false;
		}
	}

}
