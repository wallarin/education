package com.test.java;

public class User {
	
	//번호,아이디,암호,이름,등급(1:일반회원,2:관리자)
	//1,hong,1111,홍길동,1
	//2,test,1111,테스트,1  > 일반회원
	//3,admin,1111,아무개,2 > 관리자
	
	private String seq;
	private String id;
	private String pw;
	private String name;
	private String level;
	
	public User() {
		this(null, null, null, null, null);
	}
	
	public User(String seq, String id, String pw, String name, String level) {
		this.seq = seq;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.level = level;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return String.format("[seq=%s, id=%s, pw=%s, name=%s, level=%s]", seq, id, pw, name,
				level);
	}

}
