package com.capgemini.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import com.capgemini.Questions.dao.QuestionDao;
import com.capgemini.Questions.dao.QuestionOptionDao;
import com.capgemini.Questions.dto.Question;
import com.capgemini.Questions.dto.QuestionOptions;
import com.capgemini.Questions.service.QuestionService;
import com.capgemini.Questions.service.QuestionServiceImpl;
import com.capgemini.test.dto.Test;
import com.capgemini.test.util.DatabaseUtil;

public class TestDaoImpl implements TestDao{
	Connection connection;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	PreparedStatement pst1;
	Test test;
	Question question;

	HashMap<Integer, Test>hashMap;
	HashMap<Integer, Question>hashMap2;
	
	public TestDaoImpl() throws SQLException{
		connection=DatabaseUtil.myConnection();
	}
	
	@Override
	public HashMap<Integer, Test> getAllTests() throws SQLException {
		st=connection.createStatement();
		rs=st.executeQuery("select * from test");
		hashMap=new HashMap<>();
		while(rs.next()) {
			test=null;
			test=new Test();
			test.setTestId(rs.getInt(1));
			test.setTestTitle(rs.getString(2));
			test.setTestDuration(rs.getInt(3));
			test.setTestQuestions(rs.getString(4));
//			test.setTestTotalMarks(rs.getInt(5));
//			test.setTestMarksScored(rs.getInt(6));
			hashMap.put(rs.getInt(1), test);
			//System.out.println(hashMap);
		}
		return hashMap;
	}
	HashMap<Integer,Question> questionMap;
	HashMap<Integer,QuestionOptions> optionMap;
	@Override
	public HashMap<Integer, Question> getAllQuestionsInTest(int testId) throws SQLException{
		QuestionDao questiondao = null;
		QuestionOptionDao questionoptiondao = null;
		pst=connection.prepareStatement("select testQuestions from test where testId=?");
		pst.setInt(1, testId);
		//hashMap2=new HashMap<>();
		rs=null;
		rs=pst.executeQuery();
		String b[];
		int c=0;
		while(rs.next()) {
			String a=rs.getString(1);
			b=a.split(" ");
			c=b.length;
		}
		
		Question question= new Question();
		QuestionOptions options=new QuestionOptions();
		for(int i=0;i<c;i++) {
			question.setQuestionId(1001);
		}
		
		QuestionService service = new QuestionServiceImpl();
		service.viewQuestion(question.getQuestionId());
		options.setId1(question.getQuestionId());
		service.viewOption(options.getId1());
		
		
//		for(int i=0;i<c;i++) {
//			pst1=connection.prepareStatement("select questionId, questionTitle, questionMarks from question1 where questionId=?");
//			pst1.setInt(1, question.getQuestionId());
//			hashMap2.put(rs.getInt(1), question);
//		}
		return null;
	}
	
	@Override
	public Test SearchTest(int testId) throws SQLException {
		pst=connection.prepareStatement("select * from test where testId=?");
		pst.setInt(1, testId);
			rs=null;
			rs=pst.executeQuery();
			if(rs.next()) {
				test=null;
				test=new  Test();
				
				test.setTestId(rs.getInt(1));
				test.setTestTitle(rs.getString(2));
				test.setTestDuration(rs.getInt(3));
				test.setTestQuestions(rs.getString(4));
//				test.setTestTotalMarks(rs.getInt(5));
//				test.setTestMarksScored(rs.getInt(6));
			}
			return null;
	}

	@Override
	public boolean AddTest(Test test1) throws SQLException {

			pst=connection.prepareStatement("insert into test values(?,?,?,?)");
			pst.setInt(1, test1.getTestId());
			pst.setString(2, test1.getTestTitle());
			pst.setInt(3, test1.getTestDuration());
			pst.setString(4, test1.getTestQuestions());
//			pst.setInt(5, test1.getTestTotalMarks());
//			pst.setInt(6, test1.getTestMarksScored());
			int res=pst.executeUpdate();
			if(res==1)
				return true;
			else
				return false;
	}
	
	String ch;
	Scanner sc=new Scanner("System.in");
	
	@Override
	public boolean DeleteTest(Test test1) throws SQLException {
		test=SearchTest(test1.getTestId());
		if (test == null) {
			pst = null;
			pst=connection.prepareStatement("delete from test where testid=?");
			pst.setInt(1, test1.getTestId());
			int res = pst.executeUpdate();
			if (res == 1) {
//				System.out.println("Commit (y/n):");
//				ch = sc.next();
//				if (ch.equalsIgnoreCase("y"))
//					connection.commit();
//				else
//					connection.rollback();
				return true;
			} else
				return false;
		}
		return false;
	}

	float a=0;
	
	@Override
	public float calculateTotalMarks(Test test) throws SQLException {
		pst=connection.prepareStatement("select testQuestions from test where testId=?");
		pst.setInt(1, test.getTestId());
		rs=null;
		rs=pst.executeQuery();
		String b[];
		int c=0;
		while(rs.next()) {
			String a=rs.getString(1);
			b=a.split(" ");
			c=b.length;
		}
		for(int i=0;i<c;i++) {
			pst1=connection.prepareStatement("select questionmarks from question1 where questionId=?");
			pst.setFloat(1, question.getQuestionMarks());
			a=a+rs.getInt(1);
		}
		return a;
	}
}
