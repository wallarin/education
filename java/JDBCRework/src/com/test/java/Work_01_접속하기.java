package com.test.java;

import java.sql.Connection;
import java.sql.DriverManager;

public class Work_01_접속하기 {
	
	private static Connection conn = null;
	
	public static Connection open() {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "hr";
		String pw = "java1234";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
			
			return conn;
			
		} catch (Exception e) {
			System.out.println("Work_01_접속하기.open");
			e.printStackTrace();
		}
		
		return null;
		
	}// open
	
	public static void close() {
		
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("Work_01_접속하기.close");
			e.printStackTrace();
		}
		
	}

}
