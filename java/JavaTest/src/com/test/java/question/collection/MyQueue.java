package com.test.java.question.collection;

public class MyQueue {
	
	private String[] list;
	private int index;
	
	public MyQueue() {
		this.index = 0;
	}
	
	public void add(String value) {
		
		if (this.index == 0) {
			this.list = new String[4];
		}
		
		if (this.index == this.list.length) {
			String[] tmp = this.list;
			this.list = new String[this.list.length * 2];
			for(int i=0; i<tmp.length; i++) {
				this.list[i] = tmp[i];
			}
		}
		this.list[this.index] = value;
		this.index++;
	}
	
	public String poll() {
		if (index > 0) {
			String tmp = this.list[0];
			for(int i=0; i<index; i++) {
				list[i] = list[i+1];
			}
			this.list[index-1] = null;
			index--;
			return tmp;
		} else {
			return "Null";
		}
		
		
	}
	
	public int size() {
		return index;
	}
	
	public String peek() {
		if (list[0] != null) {
			return list[0].toString();
		} else {
			return "Null";
		}
			
	}
	
	public void clear() {
		for(int i=0; i<this.index; i++) {
			this.list[i] = null;
		}
		this.index = 0;
	}
	
	public void trimToSize() {
		
	}

}












