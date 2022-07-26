package com.project.dentist.dataClass;

public class WaitingList {

	private String seq;
	private String appointmentSeq;
	private String patientSeq1;
	private String patientSeq2;
	private String patientSeq3;
	
	
	public WaitingList(String seq, String appointmentSeq, String patientSeq) { //대기하기용
		this.seq = seq;
		this.appointmentSeq = appointmentSeq;
		this.patientSeq1 = patientSeq;
		
	}
	
	public WaitingList(String seq, String appointmentSeq, String patientSeq1, String patientSeq2,
			String patientSeq3) {
		this.seq = seq;
		this.appointmentSeq = appointmentSeq;
		this.patientSeq1 = patientSeq1;
		this.patientSeq2 = patientSeq2;
		this.patientSeq3 = patientSeq3;
	}
	

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getAppointmentSeq() {
		return appointmentSeq;
	}

	public void setAppointmentSeq(String appointmentSeq) {
		this.appointmentSeq = appointmentSeq;
	}

	public String getPatientSeq1() {
		return patientSeq1;
	}

	public void setPatientSeq1(String patientSeq1) {
		this.patientSeq1 = patientSeq1;
	}

	public String getPatientSeq2() {
		return patientSeq2;
	}

	public void setPatientSeq2(String patientSeq2) {
		this.patientSeq2 = patientSeq2;
	}

	public String getPatientSeq3() {
		return patientSeq3;
	}

	public void setPatientSeq3(String patientSeq3) {
		this.patientSeq3 = patientSeq3;
	}

	public String[] getAllPatientSeq() {
		return new String[] { patientSeq1, patientSeq2, patientSeq3 };
	}
	
	public int waitingSize() {
		int count = 0; 
		if(patientSeq1.equals("null")) { //XXX
			count++;
		} 
		if(patientSeq2.equals("null")) {
			count++;
		} 
		if(patientSeq3.equals("null")) {
			count++;
		} 
		return count;
	}
	
	public boolean canWait() { //XXX
		if(!patientSeq1.equals("null") && !patientSeq2.equals("null") && !patientSeq3.equals("null")) {
			return false;
		}
		return true;
	}
	
	public boolean addPatient(String patientSeq) {
		
		if(patientSeq2.equals("null")) { //XXX
			patientSeq2 = patientSeq;
			return true;
		} else if(patientSeq3.equals("null")) { //XXX
			patientSeq3 = patientSeq;
			return true;
		} 
		
		return false;
	}
	

	@Override
	public String toString() {
		return String.format(
				"WaitingList [seq=%s, appointmentSeq=%s, patientSeq1=%s, patientSeq2=%s, patientSeq3=%s]",
				seq, appointmentSeq, patientSeq1, patientSeq2, patientSeq3);
	}


	
	
	
}
