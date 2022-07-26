package com.test.java.question.getter_setter.constructor;

public class Q02 {
	
	public static void main(String[] args) {
		
		//시간 1
		Time t1 = new Time(); //기본 생성자 호출
		System.out.println(t1.info());

		//시간 2
		Time t2 = new Time(2, 30, 45); //오버로딩 생성자 호출
		System.out.println(t2.info());

		//시간 3
		Time t3 = new Time(1, 70, 30); //오버로딩 생성자 호출
		System.out.println(t3.info());

		//시간 4
		Time t4 = new Time(30, 10); //오버로딩 생성자 호출
		System.out.println(t4.info());

		//시간 5
		Time t5 = new Time(90, 10); //오버로딩 생성자 호출
		System.out.println(t5.info());

		//시간 6
		Time t6 = new Time(50); //오버로딩 생성자 호출
		System.out.println(t6.info());

		//시간 7
		Time t7 = new Time(10000); //오버로딩 생성자 호출
		System.out.println(t7.info());
		
	}

}


class Time {

	private int hour;
	private int minute;
	private int second;

	public Time() {
		this(0,0,0);
	}

	public Time(int hour, int minute, int second) {
		if (hour < 0) {
			System.out.println("올바르지 않은 시간입니다.");
		} else {
			this.hour = hour;
		}
		
		if (minute < 0) {
			System.out.println("올바르지 않은 분입니다.");
		} else {
			if (minute > 60) {
				this.hour += minute / 60;
				this.minute = minute % 60;
			} else {
				this.minute = minute;
			}
		}
				
		if (second < 0) {
			System.out.println("올바르지 않은 초입니다.");
		} else {
			if (second > 60) {
				this.hour += second / 60 / 60;
				this.minute += second / 60 % 60;
				this.second = second % 60;
			} else {
				this.second = second;
			}
		}	

	}

	public Time(int minute, int second) {
		this(0,minute,second);
	}

	public Time(int minute) {
		this(0,0,minute);
	}



	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	
	String info() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("%02d:%02d:%02d", this.hour, this.minute, this.second));
		
		return sb.toString();
	}
	
}