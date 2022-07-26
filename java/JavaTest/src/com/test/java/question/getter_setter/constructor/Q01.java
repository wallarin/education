package com.test.java.question.getter_setter.constructor;

public class Q01 {
	
	public static void main(String[] args) {
		
		//학생 1
		Student s1 = new Student(); //기본 생성자 호출
		System.out.println(s1.info());

		//학생 2
		Student s2= new Student("홍길동", 13); //오버로딩 생성자 호출
		System.out.println(s2.info());

		//학생 3
		Student s3= new Student(3, 10, 30); //오버로딩 생성자 호출
		System.out.println(s3.info());

		//학생 4
		Student s4= new Student("아무개", 12, 1, 5, 11); //오버로딩 생성자 호출
		System.out.println(s4.info());
		
	} //main

} //Q01

class Student {
	
	private String name;
	private int age;
	private int grade;
	private int classNumber;
	private int number;
	
	public Student() {
		this("미정", 0, 0, 0, 0);
	}
	
	public Student(String name, int age, int grade, int classNumber, int number) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.classNumber = classNumber;
		this.number = number;
	}
	
	public Student(String name, int age) {
		this(name, age, 0, 0, 0);
	}
	
	public Student(int grade, int classNumber, int number) {
		this("미정", 0, grade, classNumber, number);
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	String info() {
		/*
		
		StringBuilder sb = new StringBuilder();
		sb.append("" + this.name);
		if (this.age == 0) {
			sb.append("(나이 : 미정");
		} else {
			sb.append("(나이 : " + this.age + "세");
		}
		sb.append(", 학년 : " + this.grade);
		sb.append(", 반 : " + this.classNumber);
		sb.append(", 번호 : " + this.number + ")");
		sb.append("\r\n");
		
		return sb.toString();
		
		*/
		//System.out.printf("%s", this.age == 0 ? "미정" : this.age); > 방법 1
		
		//가장 깔끔한 방법
		return String.format("%s(나이 : %s, 학년 : %s, 반 : %s, 번호: %s)"
				, this.name
				, this.age == 0 ? "미정" : Integer.toString(this.age) + "세"
				, this.grade == 0 ? "미정" : Integer.toString(this.grade)
				, this.classNumber == 0 ? "미정" : Integer.toString(this.classNumber)
				, this.number == 0 ? "미정" : Integer.toString(this.number));
		
		
	}
	
}









