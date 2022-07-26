package com.test.java.question.collection;

// ArrayList와 동일한 동작을 하는 클래스를 선언하시오.
// 모든 기능의 디테일 > 실제 ArrayList와 비교
public class MyArrayList {

	private String[] list; // ArrayList의 내부 배열(******)
	private int index; // 가장 중요한 역할(********) 방번호로 사용.

	public MyArrayList() {
		this.index = 0;
	}

	public boolean add(String value) {

		// 첫 add 인지??
		if (this.index == 0) {
			this.list = new String[4];
		}

		// 현재 배열의 길이보다 많은 데이터를 입력하려고 하는지??
		// > 배열의 길이를 2배로 늘려 + 복사 교체

		if (this.index == this.list.length) {
			String[] copy = this.list;
			this.list = new String[this.list.length * 2];

			for (int i = 0; i < copy.length; i++) {// 배열 복사
				this.list[i] = copy[i];
			}

		}
		this.list[this.index] = value;
		this.index++;
		
		return true;

	}

	public String get(int index) {

		// 없는 방번호를 요청했을때?
		if (index > this.list.length || index < 0) {
			throw new IndexOutOfBoundsException(": Index " + index + " out of bounds for length " + this.list.length);
		}
		
		return this.list[index];

	}

	public int size() {
		return this.index;
	}

	public String set(int index, String value) {
		if (index > this.list.length || index < 0) {
			throw new IndexOutOfBoundsException(": Index " + index + " out of bounds for length " + this.list.length);
		}
		this.list[index] = value;
		return this.get(index);
	}

	public String remove(int index) {
		this.list[index] = this.list[index + 1];
		this.index--;
		return this.list[index];
	}

	public boolean add(int index, String value) { //꽉 찼을때 방도 늘려야한다.
		for (int i = this.list.length - 1; i >= index; i--) {
			this.list[i] = this.list[i - 1];
			if (i == index) {
				list[index] = value;
				this.index++;
				break;
			}
		}
			return true;
	}

	public int indexOf(String value) {
		if (value != null) {
			for (int i = 0; i <this.list.length; i++) { //i < this.list.length >>>> index까지만 돌아도 된다..
				if (this.list[i].equals(value)) {
					return i;
				}
			}
		}

		return -1;
	}

	public int lastIndexOf(String value) {
		if (value != null) {
			for (int i = list.length - 1; i >= 0; i--) {
				if (this.list[i] == value) {
					return i;
				}
			}
		}

		return -1;
	}

	public void clear() { //한번에 두가지 방법을 썼다.. 쓸데 없는 짓
		//참고 선생님의 MyArrayList
		for (int i = 0; i < this.list.length; i++) {
			list[i] = null;
			this.index = 0;
		}
	}

	public void trimToSize() {
		String[] copy = new String[index];
		for (int i = 0; i < copy.length; i++) {
			copy[i] = this.list[i];
		}
		this.list = copy;
	}



}// MyArrayList

