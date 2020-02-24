package com.capgemini.test.dto;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Set;

public class Test {
	
	private int testId;
	private String testTitle;
	private int testDuration;
	private String testQuestions;
	//  private int testTotalMarks;
	//	private int testMarksScored;
	//private LocalTime startTime;
	//private LocalTime endTime;
	
	
	public Test(int testId, String testTitle, int testDuration, String testQuestions) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testDuration = testDuration;
		//this.testTotalMarks = testTotalMarks;
		this.testQuestions= testQuestions;
	}
	
	public Test() {
		// TODO Auto-generated constructor stub
	}

	public String getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(String testQuestions) {
		this.testQuestions = testQuestions;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public void setTestDuration(int testDuration) {
		this.testDuration = testDuration;
	}

	

//	public void setTestTotalMarks(int testTotalMarks) {
//		this.testTotalMarks = testTotalMarks;
//	}
//
//	public void setTestMarksScored(int testMarksScored) {
//		this.testMarksScored = testMarksScored;
//	}

//	public void setStartTime(Time time) {
//		this.startTime = startTime;
//	}
//
//	public void setEndTime(Time time) {
//		this.endTime = endTime;
//	}

	public int getTestId() {
		return testId;
	}
	public String getTestTitle() {
		return testTitle;
	}
	public int getTestDuration() {
		return testDuration;
	}

	@Override
	public String toString() {
		return "All Tests--> testId= " + testId + ", testTitle= " + testTitle + ", testDuration= " + testDuration
				+ ", testQuestions= " + testQuestions;
	}

//	public int getTestTotalMarks() {
//		return testTotalMarks;
//	}
//	public int getTestMarksScored() {
//		return testMarksScored;
//	}

//	public LocalTime getStartTime() {
//		return startTime;
//	}
//	public LocalTime getEndTime() {
//		return endTime;
//	}
	
	
}
