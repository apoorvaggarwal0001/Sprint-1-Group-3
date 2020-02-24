package com.capgemini.login.dao;
import java.sql.SQLException;

import com.capgemini.dto.Login;

public interface LoginDao {

	public boolean LoginUser(Login login)  throws SQLException;
	
	
}
