package com.test.toy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import com.test.toy.DBUtil;

public class Dummy {

	public static void main(String[] args) {
		
		//게시글 더미 생성하기
		
		String sql = "insert into tblBoard (seq, subject, content, id, regdate, readcount) values (seqBoard.nextVal, ?, ?, ?, default, default)";
		
		//시드 데이터
		String[] subject = { "게시판을", "안녕", "반갑습니다.", "내일은", "무엇을", "번개가", "빨간색", "신호등", "파란색", "토르", "러브앤썬더", "닥터", "스트레인지보다", "재미없어요", "누가", "뭐라고", "그랬음?" };
		
		String content = "테스트로 작성된 내용입니다.~";
		
		String[] id = { "hong", "hong1", "hong2", "admin" };
		
		Connection conn = null;
		PreparedStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
			stat = conn.prepareStatement(sql);
			
			Random rnd = new Random();
			
			for (int i=0; i<256; i++) {
				stat.setString(1, subject[rnd.nextInt(subject.length)] + " " + subject[rnd.nextInt(subject.length)] + " " + subject[rnd.nextInt(subject.length)] + " " + subject[rnd.nextInt(subject.length)] + " " + subject[rnd.nextInt(subject.length)] + "." );
				
				stat.setString(2, content);
				stat.setString(3, id[rnd.nextInt(id.length)]);
				
				stat.executeUpdate();
				
				System.out.println(i);
			}
			
		} catch (Exception e) {
			System.out.println("Dummy.main");
			e.printStackTrace();
		}
		
	}
	
}
















