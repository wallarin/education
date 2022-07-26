package com.project.dentist.dataClass;

public class Payment {


	// 1,20000,4
	// 결제번호,결제금액,시술번호


	private String seq;
	private String pay;
	private String surgeSeq;

	public Payment(String seq, String pay, String surgeSeq) {
		super();
		this.seq = seq;
		this.pay = pay;
		this.surgeSeq = surgeSeq;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getSurgeSeq() {
		return surgeSeq;
	}

	public void setSurgeSeq(String surgeSeq) {
		this.surgeSeq = surgeSeq;
	}

	@Override
	public String toString() {
		return String.format("Payment [seq=%s, pay=%s, surgeSeq=%s]", seq, pay, surgeSeq);
	}



}
