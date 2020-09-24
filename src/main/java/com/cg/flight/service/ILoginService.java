package com.cg.flight.service;

import com.cg.flight.entity.User;
import com.cg.flight.exceptions.LoginException;

public interface ILoginService {
	
	public User doLogin(String userID, String password) throws LoginException;
	public String encryptUser(User user);
	

}