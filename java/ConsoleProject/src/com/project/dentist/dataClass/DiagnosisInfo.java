package com.project.dentist.dataClass;

import java.util.Calendar;
import com.project.dentist.Data;
//진료정보
public class DiagnosisInfo {
	
	private String seq;
	private String treatmentNum; //시술번호
	private String appointmentNum;
	private String patientNum;
	private String doctorNum;
	private String date;
	private String time;
	private String classficationNum;
	
	
	public DiagnosisInfo(String seq, String treatmentNum, Appointment appointment) { //진단서 작성시 사용
		
		this.seq = seq;
		this.treatmentNum = treatmentNum;
		this.appointmentNum = appointment.getSeq();
		this.patientNum = appointment.getPatientNum();
		this.doctorNum = appointment.getDoctorNum();
		this.date = appointment.getDate();
		//XXX 수정(Time 변경)
		String time = appointment.getTime().split(":")[0] + ":" + String.format("%02d",(int)(Math.random() * 60));
		this.time = time;

		this.classficationNum = findDiagnosisSeq(treatmentNum);
	}
	
	public DiagnosisInfo(String seq, String treatmentNum, String appointmentNum, String patientNum,
			String doctorNum, String date, String time, String classficationNum) {

		this.seq = seq;
		this.treatmentNum = treatmentNum;
		this.appointmentNum = appointmentNum;
		this.patientNum = patientNum;
		this.doctorNum = doctorNum;
		this.date = date;
		this.time = time;
		this.classficationNum = classficationNum;
	}
	
	private String findDiagnosisSeq(String treatmentNum) {

		for(Treatment t : Data.tlist) {
			if(t.getSeq().equals(treatmentNum)) {
				return t.getClassificationNum();
			}
		}
		return null;
	}

	public String getSeq() {
		return seq;
	}

	public String getTreatmentNum() {
		return treatmentNum;
	}

	public String getAppointmentNum() {
		return appointmentNum;
	}

	public String getPatientNum() {
		return patientNum;
	}

	public String getDoctorNum() {
		return doctorNum;
	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}
	
	public Calendar getDateTime() {  //XXX 수정(추가)
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(date.split("-")[0])
				, Integer.parseInt(date.split("-")[1])
				, Integer.parseInt(date.split("-")[2])
				, Integer.parseInt(time.split(":")[0])
				, Integer.parseInt(time.split(":")[1]));
		return c;
	}

	public String getClassficationNum() {
		return classficationNum;
	}

	@Override
	public String toString() {
		return String.format(
				"DiagnosisInfo [seq=%s, treatmentNum=%s, appointmentNum=%s, patientNum=%s, doctorNum=%s, date=%s, time=%s, classficationNum=%s]",
				seq, treatmentNum, appointmentNum, patientNum, doctorNum, date, time, classficationNum);
	}

	
	

	
	
	
}
