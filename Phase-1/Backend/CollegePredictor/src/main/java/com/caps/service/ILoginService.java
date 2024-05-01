package com.caps.service;

import com.caps.entity.Login;

public interface ILoginService {
	public boolean login(Login login);
	
	public boolean register(Login login);
	
	public boolean changePasword(long mobNum,String curPass,String newPass);
}
