package com.project.dentist.dataClass;

public class Diagnosis {


	// 1,치아교정

	private String seq;
	private String diagnosis_name;

	public Diagnosis(String seq, String diagnosis_name) {
		super();
		this.seq = seq;
		this.diagnosis_name = diagnosis_name;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getDiagnosis_name() {
		return diagnosis_name;
	}

	public void setDiagnosis_name(String diagnosis_name) {
		this.diagnosis_name = diagnosis_name;
	}

	@Override
	public String toString() {
		return String.format("DiagnosisDivision [seq=%s, diagnosis_name=%s]", seq, diagnosis_name);
	}



}
