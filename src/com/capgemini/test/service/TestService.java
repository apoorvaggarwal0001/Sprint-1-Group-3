package com.capgemini.test.service;

import java.sql.SQLException;

import com.capgemini.test.dto.Test;
import com.capgemini.test.exception.TestException;

public interface TestService {
	public void showAllTests() throws SQLException;
	public void showAllTestQuestions() throws SQLException;
	public void insertTest() throws SQLException, TestException;
	public void deleteTest() throws SQLException, TestException; 
	public void getTotalMarks() throws SQLException, TestException;
}
