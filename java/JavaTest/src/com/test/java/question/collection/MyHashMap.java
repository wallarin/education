package com.test.java.question.collection;

public class MyHashMap {
	private int index;
	private String[] key;
	private String[] value;
	
	public MyHashMap() {
		this.index = 0;
	}
	
	public String put(String key, String value) { //자료 넣기
		
		int index = indexOf(key);
		
		if (this.index == 0) {
			this.key = new String[4];
			this.value = new String[4];
		}
		
		if (index > -1) {
			String temp = this.value[index];
			this.value[index] = value;
			return temp;
		}
		
		if (checkLength()) {
			putgrow();
		}

		this.key[this.index] = key;
		this.value[this.index] = value;
		this.index++;

		return null;
		
	}
	
	private boolean checkLength() {
		
		if (this.index == this.key.length) {
			return true;
		}
		return false;
	}

	private int indexOf(String key) {
		for (int i = 0; i < this.index; i++) {
			if(this.key[i].equals(key)) {
				return i;
			}
		}
		return -1;
	}


	private void putgrow() { //배열 증가
		
		String[] temp = new String[this.key.length * 2];
		String[] temp2 = new String[this.value.length * 2];
		
		for (int i = 0; i < key.length; i++) {
			temp[i] = this.key[i];
			temp2[i] = this.value[i];
		}
		this.key = temp;
		this.value = temp2;
		
	}

	public String get(String key) {
		
		for(int i = 0; i < this.index; i++) {
			if(this.key[i].equals(key)) {
				return this.value[i];
			}
		}
		return null;
	}
	
	public int size() {
		return this.index;
	}
	
	public String remove(String key) {
		
		for (int i=index; i<this.key.length-1; i++) {
			this.key[i] = this.key[i+1];
			this.value[i] = this.value[i+1];
		}
		
		this.index--;
		
		return this.value[index];
	}
	
	public boolean containKey(String key) {
		
		if (indexOf(key) > -1) {
		return true;
		}
		
		return false;
	}

	public boolean containsValue(String value) {
		
		for(int i = 0; i < this.index; i++) {
			if (this.value[i].equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public void clear() {
		this.index = 0;
	}
	
	public void trimToSize() {
		String[] temp = new String[this.index];
		String[] temp2 = new String[this.index];
		
		for(int i=0; i<index; i++) {
			temp[i] = this.key[i];
			temp2[i] = this.value[i];
		}
		this.key = temp;
		this.value = temp2;
	}
	
	public String toString() {
		String temp = "";
		temp += String.format("배열의 길이 : %d\n", this.key.length);
		temp += String.format("들어갈 방번호 : %d\n", this.index);
		for (int i = 0; i < this.key.length; i++) {
			temp += String.format("  %d: %s - %s,\n", i, this.key[i], this.value[i]); // 배열안의 상태
		}
		return temp;
	}

}
