package com.project.dentist.dataClass;

public class Order {
	private String seq;
	private String itemseq;
	private String itemprice;
	private int itemauto;
	private String date;
	
	public Order(String seq, String itemseq, String itemprice, int itemauto, String date) {
		this.seq = seq;
		this.itemseq = itemseq;
		this.itemprice = itemprice;
		this.itemauto = itemauto;
		this.date = date;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getItemseq() {
		return itemseq;
	}

	public void setItemseq(String itemseq) {
		this.itemseq = itemseq;
	}

	public String getItemprice() {
		return itemprice;
	}

	public void setItemprice(String itemprice) {
		this.itemprice = itemprice;
	}

	public int getItemauto() {
		return itemauto;
	}

	public void setItemauto(int itemauto) {
		this.itemauto = itemauto;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return String.format("Order [seq=%s, itemseq=%s, itemprice=%s, itemauto=%s, date=%s]", seq,
				itemseq, itemprice, itemauto, date);
	}
	
}
