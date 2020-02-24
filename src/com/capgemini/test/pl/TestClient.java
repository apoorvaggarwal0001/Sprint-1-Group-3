package com.capgemini.test.pl;

import java.sql.SQLException;
import java.util.Scanner;


import com.capgemini.test.exception.TestException;
import com.capgemini.test.service.TestService;
import com.capgemini.test.service.TestServiceImpl;

public class TestClient {
	public static void main(String[] args) throws TestException {
		Scanner sc=new Scanner(System.in);
		String ch="yes";
		TestService service = null;
		try {
			service=new TestServiceImpl();
		}
		catch(SQLException e1){
			System.err.println(e1.getMessage());
		}
		
		while(ch.equalsIgnoreCase("yes")) {
			System.out.println("Select Operation");
			System.out.println("1. Add Test");
			System.out.println("2. Show All Test");
			System.out.println("3. Show All Test Questions");
			System.out.println("4. Delete Test");
			//System.out.println("5. Search Test");
			
			int op=sc.nextInt();
			
			switch(op) {
			case 1:
				try {
					service.insertTest();
				}
				catch(SQLException e1) {
					System.err.println(e1.getMessage());
				}
				break;
			case 2:
				try {
					service.showAllTests();
				}catch(SQLException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				try {
					service.showAllTestQuestions();
				}catch(SQLException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 4:
				try {
					service.deleteTest();
				}catch(SQLException e) {
					System.err.println(e.getMessage());
				}
				break;
			default:
				break;
			}
			System.out.println("Continue yes/no");
			ch=sc.next();
		}
		
	}
}
