package com.capgemini.test.dao;

import java.sql.SQLException;
import java.util.HashMap;

import com.capgemini.Questions.dto.Question;
import com.capgemini.test.dto.Test;

public interface TestDao {
	public HashMap<Integer, Test> getAllTests() throws SQLException;
	public Test SearchTest(int testId) throws SQLException;
	public HashMap<Integer, Question> getAllQuestionsInTest(int testId) throws SQLException;
	public boolean AddTest(Test test) throws SQLException;
	public boolean DeleteTest(Test test) throws SQLException;
	public float calculateTotalMarks(Test test) throws SQLException;
}
