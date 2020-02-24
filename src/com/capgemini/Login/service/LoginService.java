package com.capgemini.service;

import java.sql.SQLException;

import com.capgemini.exception.LoginException;

public interface LoginService {

	public void userLogin() throws LoginException, SQLException;
	
	
}

