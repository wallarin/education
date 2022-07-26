package com.test.java.question.collection;

public class MyStack {
	
	private String[] list;
	private int index;
	
	public MyStack() {
		this.index = 0;
	}
	
	public void push(String value) {
		if (this.index == 0) {
			this.list = new String[4];
		}

		if (this.index == this.list.length) {
			String[] copy = this.list;
			this.list = new String[this.list.length * 2];

			for (int i = 0; i < copy.length; i++) {
				this.list[i] = copy[i];
			}

		}
		this.list[this.index] = value;
		this.index++;
	}
	
	public String pop() {
		String tmp = this.list[index-1].toString();
		this.list[index-1] = null;
		this.index--;
		
		return tmp;
	}
	
	public int size() {
		return this.index;
	}
	
	public String peek() {
		return this.list[index-1]; //.toString() 굳이 필요없음
	}
	
	public void clear() {
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

}


