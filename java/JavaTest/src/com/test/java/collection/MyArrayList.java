package com.test.java.collection;

public class MyArrayList {

	private String[] list; // 숫자의 상태가 중요하다
	private int index; // 숫자의 상태가 중요하다

	public MyArrayList() {
		this.index = 0;
	}

	public boolean add(String s) {

		// 배열의 끝에 아이템 넣기
		// 1. 처음 넣을 때 배열 만들기
		// 1.5 방이 모자라면 배열을 2배로 늘리기
		// 2. 데이터 넣기

		try {
			init();

			if (checkLength()) {
				doubleList();
			}

			this.list[this.index] = s;
			this.index++; // Append

			return true;

		} catch (Exception e) {

			return false;
		}

	}

	private boolean checkLength() {

		// 방이 꽉찼는지?
		if (this.index == this.list.length) {
			return true;
		}

		return false;
	}

	private void doubleList() {

		// 1. 2배 길이의 배열 생성
		// 2. 깊은 복사
		// 3. 교체

		String[] temp = new String[this.list.length * 2];

		for (int i = 0; i < this.list.length; i++) {
			temp[i] = this.list[i];
		}

		this.list = temp;
	}

	private void init() {

		// 처음 넣을 때 배열 만들기
		if (this.index == 0) {
			this.list = new String[4];
		}

	}

	public String get(int index) {

		if (!checkIndex(index)) {
			// 잘못된 방번호
			throw new IndexOutOfBoundsException(); // 에러를 강제로 발생
		}

		return this.list[index];
	}

	private boolean checkIndex(int index) {

		// 유효한 index의 범위?
		// 0 ~ index - 1

		if (index >= 0 && index < this.index) {
			return true;
		}
		return false;
	}

	public int size() {
		return this.index;
	}

	public String set(int index, String value) {

		if (!checkIndex(index)) { // 세세하게 에러까지도 신경써야한다.
			// 잘못된 방번호
			throw new IndexOutOfBoundsException(); // 에러를 강제로 발생
		}

		String temp = this.list[index];

		this.list[index] = value;

		return temp;
	}

	public String remove(int index) {

		String temp = this.list[index];

		// Left Shift 처리
		for (int i = index; i < this.list.length - 1; i++) {
			this.list[i] = this.list[i + 1];
		}

		// 데이터 1개 삭제 > this.index 반영
		this.index--;

		return temp;
	}

	public boolean add(int index, String value) {

		try {

			// 삽입 > Right Shift
			if (checkLength()) {
				doubleList();
			}

			for (int i = this.list.length - 2; i >= index; i--) {
				this.list[i + 1] = this.list[i];
			}
			this.list[index] = value; // 새치기
			this.index++;

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public int indexOf(String value) {
		for(int i=0; i<this.index; i++) {
			if(this.list[i].equals(value)) {
				return i; //찾은 방 번호 반환
			}
		}
			return -1; //못찾음
	}
	
	public int lastIndexOf(String value) {
		for(int i=this.index - 1; i>=0; i--) {
			if(this.list[i].equals(value)) {
				return i; //찾은 방 번호 반환
			}
		}
			return -1; //못찾음
	}
	
	public void clear() {
		
		//모든 요소 삭제
		/*
		//Case 1. 배열의 길이가 길다면 오래걸린다.. 쓰레기 배열이 안만들어진다..
		
		for (int i=0; i<this.index; i++) {
			this.list[i] = null;
		}
		*/
		
		//Case 2. 비용면에서는 비싸다
		//this.list = new String[this.list.length];
		
		//Case 3.
		this.index = 0; //속도, 경제
	}
	
	public void trimToSize() {
		
		//배열 늘리기의 반대 작업
		String[] temp = new String[this.index];
		
		for(int i=0; i<this.index; i++) {
			temp[i] = this.list[i];
		}
		this.list = temp;
		
	}



	@Override
	public String toString() { // 덤프 > 현재 상태를 알아볼 수 있는 정확하게 잘 짜는게 좋다..

		// 객체의 상태를 확인하는 용도
		// > 되도록 상황에 따라 보기 좋게 구현

		String temp = "";

		temp += "\n";
		temp += String.format("length: %d\n", this.list.length); // 배열의 실제 길이
		temp += String.format("index: %d\n", this.index); // 현재 방의 번호
		temp += String.format("[\n");

		for (int i = 0; i < this.list.length; i++) {
			temp += String.format("  %d: %s,\n", i, this.list[i]); // 배열안의 상태
		}

		temp += String.format("\n]");

		return temp;
	}

}// MyArrayList


