package com.test.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Work_03_select {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = Work_01_접속하기.open();
			stat = conn.createStatement();
			
			//반환값이 1행 1열
			String sql = "select count(*) as cnt from tblInsa";
			rs = stat.executeQuery(sql);
			rs.next();
			int cnt2 = rs.getInt("cnt");
			System.out.println(cnt2);
			
			//반환값이 1행 N열(컬럼이 여러개)
			sql = "select name, age, tel, address from tblAddress where seq = 5";
			rs = stat.executeQuery(sql);
			
			if (rs.next()) { //가져올 값의 갯수를 정확히 알때
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("age"));
				System.out.println(rs.getString("tel"));
				System.out.println(rs.getString("address"));
			} else {
				System.out.println("데이터가 없습니다.");
			}
			
			//반환값이 N행 1열(행이 여러개)
			sql = "select name from tblInsa order by name";
			rs = stat.executeQuery(sql);
			
			while (rs.next()) { //가져올 값의 갯수를 모를때
				System.out.println(rs.getString("name"));
			}
			
			//반환값이 N행 N열
			System.out.println("== 총무부 명단 ==");
			sql = "select name, jikwi, city, basicpay from tblInsa where buseo = '총무부'";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("jikwi"));
				System.out.println(rs.getString("city"));
				System.out.println(rs.getString("basicpay"));
			}
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Work_03_select.main");
			e.printStackTrace();
		}
		
	}

}
