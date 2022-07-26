package com.test.java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;
import oracle.jdbc.OracleTypes;

public class Ex06_CallableStatement {
	
	public static void main(String[] args) {
		
		//JDBC는 기본적으로 모든 SQL의 실행은 자동 커밋이 수반된다. > executeXXX() 호출할때마다
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		m6();
		
	}

	private static void m6() {
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			//부서명 입력 > 부서의 직원의 보너스 지급내역 출력
			Scanner scan = new Scanner(System.in);
			
			System.out.print("부서명: ");
			String buseo = scan.nextLine();
			
			String sql = "{ call procM6(?,?) }";
			
			stat = conn.prepareCall(sql);
			
			stat.setString(1, buseo);
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			rs = (ResultSet)stat.getObject(2);
			
			System.out.println("== 보너스 지급 내역 ==");
			System.out.println("[직원명]\t    [지급액]");
			
			while (rs.next()) {
				System.out.printf(" %s\t%,10d원\n"
									, rs.getString("name")
									
									//the column value; if the value is SQL NULL, thevalue returned is 0
									//> SQL 값이 NULL이면 0으로 처리해준다.
									, rs.getInt("bonus"));	
			}
			
			rs.close();
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.temp");
			e.printStackTrace();
		}
		
	}

	private static void m5() {
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call procM5(?,?) }";
			
			stat = conn.prepareCall(sql);
			
			stat.setString(1, "개발부");
			stat.registerOutParameter(2, OracleTypes.CURSOR);
			
			stat.executeQuery();
			
			//오라클 커서 == 자바 ResultSet > ******
			rs = (ResultSet)stat.getObject(2);
			
			while (rs.next()) {
				
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("jikwi"));
				System.out.println(rs.getString("basicpay"));
				System.out.println();
				
			}
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.temp");
			e.printStackTrace();
		}
		
	}

	private static void m4() {
		
		//문제. 직원 번호를 입력하면, 이름, 부서, 직위, 지역을 반환 출력
		// procM4 
		// - in > 직원 번호
		// - out > 이름
		// - out > 부서
		// - out > 직위
		// - out > 지역
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		Scanner scan = new Scanner(System.in);
		
		try {
			
			conn = DBUtil.open();
			
			System.out.print("직원번호를 입력하세요. : ");
			String r_num = scan.nextLine();
			
			String sql = "{ call procM4(?, ?, ?, ?, ?) }";
			
			stat = conn.prepareCall(sql);
			stat.setString(1, r_num);
			System.out.println();
			
			stat.registerOutParameter(2, OracleTypes.VARCHAR);
			stat.registerOutParameter(3, OracleTypes.VARCHAR);
			stat.registerOutParameter(4, OracleTypes.VARCHAR);
			stat.registerOutParameter(5, OracleTypes.VARCHAR);
			
			stat.executeQuery();
			
			System.out.println("이름: " + stat.getString(2));
			System.out.println("부서: " + stat.getString(3));
			System.out.println("직위: " + stat.getString(4));
			System.out.println("지역: " + stat.getString(5));
			
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.temp");
			e.printStackTrace();
		}
		
	}

	private static void m3() {

		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			String sql = "{ call procM3(?) }";
			
			stat = conn.prepareCall(sql);
			
			//in 매개변수
			//stat.setString(1, 값)
			
			//out 매개변수
			stat.registerOutParameter(1, OracleTypes.NUMBER);
			
			
			//PLSQL 문에서 인출을 수행할 수 없습니다.: next
			//rs = stat.executeQuery();
			//System.out.println(rs.next());
			
			stat.executeQuery(); //rs(X)
			
			int count = stat.getInt(1); //Out Parameter 가져오는 역할
			
			System.out.println(count);
			
			stat.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.temp");
			e.printStackTrace();
		}
		
	}

	private static void m2() {

		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			//begin
		    //	procM2('테스트', 32, 'f', '010-3232-4421', '서울시 동작구 노량진동');
			//end;
			//String sql = "{ Call procM2('상수', 22, 'm', '010-2222-2222', '주소') }";
			
			String sql = "{ call procM2(?, ?, ?, ?, ?) }";
			
			stat = conn.prepareCall(sql);
			
			stat.setString(1, "홍길동");
			stat.setString(2, "25");
			stat.setString(3, "f");
			stat.setString(4, "010-0000-0000");
			stat.setString(5, "동작구");
			
			int result = stat.executeUpdate();
			
			System.out.println(result);
			
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.temp");
			e.printStackTrace();
		}
		
	}

	private static void m1() {
		
		//Statement > 정적 쿼리
		//PreparedStatement > 동적 쿼리
		//CallableStatement > 프로시저 호출
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			//프로시저 호출하기
			String sql = "{ call procM1 }";
			
			stat = conn.prepareCall(sql); //매개변수 처리 능력 보유 > ? 지원
			
			int result = stat.executeUpdate();
			
			System.out.println(result);
			
			stat.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.temp");
			e.printStackTrace();
		}
		
	}
	
	private static void temp() {
		
		Connection conn = null;
		CallableStatement stat = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			
			
		} catch (Exception e) {
			System.out.println("Ex06_CallableStatement.temp");
			e.printStackTrace();
		}
		
	}

}
