package com.capgemini.pl;

import java.sql.SQLException;

import com.capgemini.exception.LoginException;
import com.capgemini.service.LoginService;
import com.capgemini.service.LoginServiceImpl;

public class LoginMain {

	public static void main(String[] args) {
		
		try {
			LoginService loginService=new LoginServiceImpl();
			loginService.userLogin();
			
		} catch (SQLException|LoginException e) {
		System.err.println(e.getMessage());
			
			e.printStackTrace();
		}
	}
}
