package com.project.dentist.dataClass;

public class DoctorPay {

	// 1,25,9536000


	private String seq;
	private String years;
	private String pay;

	public DoctorPay(String seq, String years, String pay) {
		super();
		this.seq = seq;
		this.years = years;
		this.pay = pay;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getYears() {
		return years;
	}

	public void setYears(String years) {
		this.years = years;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	@Override
	public String toString() {
		return String.format("DoctorPay [seq=%s, years=%s, pay=%s]", seq, years, pay);
	}



}
