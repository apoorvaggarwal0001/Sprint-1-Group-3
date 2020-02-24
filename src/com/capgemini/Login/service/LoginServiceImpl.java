package com.capgemini.service;

import java.io.Console;
import java.sql.SQLException;

import com.capgemini.login.dao.LoginDao;
import com.capgemini.login.dao.LoginDaoImpl;
import com.capgemini.dto.Login;
import com.capgemini.exception.LoginException;

public class LoginServiceImpl implements LoginService {

	Login login;
	Console console;
	LoginDao dao;

	public LoginServiceImpl() throws SQLException {
		console = System.console();
		dao = new LoginDaoImpl();
	}

	@Override
	public void userLogin() throws LoginException, SQLException {
		if (console == null)
			System.out.println("console is null");
		login = new Login();
		System.out.println("Enter Id");
		login.setId(Integer.parseInt(console.readLine()));

		System.out.println("Enter Password");
		login.setPassword(console.readPassword().toString());

		System.out.println("Re Enter Password");
		String s = new String(console.readPassword());
		login.setPassword(s);

		boolean status = false, status1 = false;
		if (!s.equals(login.getPassword())) {
			System.err.println("Renter password is wrong");
			status = true;
		}

		if (status) {
			System.out.println("Renter password again");
			s = console.readPassword().toString();
			login.setPassword(s);
		}
		if (!s.equals(login.getPassword())) 
			throw new LoginException("Reneter password wrong Login Denied");

			System.out.println("Enter UserType Admin or User");
			login.setUserType(console.readLine());

			if (dao.LoginUser(login)) {
				System.out.println("user login successfull");
			} else
				System.err.println("login denied either id or password problem");

		}

	}

