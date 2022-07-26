package com.test.java;

public class Item {

	private String seq;
	private String date;
	private String item;
	
	public Item() {
		this(null, null, null);
	}
	
	public Item(String seq, String date, String item) {
		super();
		this.seq = seq;
		this.item = item;
		this.date = date;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return String.format("[seq=%s, item=%s, date=%s]", seq, item, date);
	}
	
}
