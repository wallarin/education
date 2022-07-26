package com.test.java;

import java.sql.Connection;
import java.sql.Statement;

public class Work_02_statement {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stat = null;
		
		try {
			
			//insert 하는 방법
			conn = Work_01_접속하기.open();
			String sql = "insert into tblAddress (seq, name, age, gender, tel, address, regdate) values (seqAddress.nextVal, '아무개', 15, 'm', '010-9988-8899', '서울', default)";
			//입력받아서 INSERT하는 방법
			//1. scanner로 입력을 받는다.
			//2. String sql를 String.format 으로 변환후 값들을 입력값으로 바꾼다.
			stat = conn.createStatement();
			
			int result = stat.executeUpdate(sql); // 반환값이 없을때 사용한다..
			System.out.println(result);
			
			//update 하기
			sql = "update tblAddress set age = age + 1 where seq = 1";
			
			result = stat.executeUpdate(sql);
			System.out.println(result);
			
			//create table
			sql = "Create table tblAddress ("
					+ "seq number primary key,"
					+ "name varchar2(10) not null,"
					+ "age number(3) not null check(age between 0 and 150),"
					+ "gender char(1) not null check(gender in('m','f')),"
					+ "tel varchar2(15) not null,"
					+ "address varchar2(300) not null,"
					+ "regdate date default sysdate not null"
					+ ")";
			result = stat.executeUpdate(sql);
			System.out.println(result);
			
			stat.close();
			Work_01_접속하기.close();
			
		} catch (Exception e) {
			System.out.println("Work_02_statement.main");
			e.printStackTrace();
		}
		
	}

}
