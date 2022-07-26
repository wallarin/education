package com.project.dentist.dataClass;

import java.util.Calendar;

//예약
public class Appointment {

	private String seq;
	private String patientNum; //(F)
	private String doctorNum; //(F)

	private Calendar dateTime;  //date + time 하나로 저장***  > 초기화 시에는 따로 넣어줌
	private String classficationNum; //증상번호(F)
	
	
	
	public Appointment(String seq, String patientNum, String doctorNum, String date, String time,
			String classficationNum) {

		this.seq = seq;
		this.patientNum = patientNum;
		this.doctorNum = doctorNum;
		this.classficationNum = classficationNum;

		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(date.split("-")[0])
				, Integer.parseInt(date.split("-")[1])-1
				, Integer.parseInt(date.split("-")[2])
				, Integer.parseInt(time.split(":")[0])
				, Integer.parseInt(time.split(":")[1]));
		
		this.dateTime = c;		
	}
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getPatientNum() {
		return patientNum;
	}
	public void setPatientNum(String patientNum) {
		this.patientNum = patientNum;
	}
	public String getDoctorNum() {
		return doctorNum;
	}
	public void setDoctorNum(String doctorNum) {
		this.doctorNum = doctorNum;
	}
	public Calendar getDateTime() {
		return dateTime;
	}
	public String getDate() {
		return String.format("%tF", dateTime);
	}
	public String getTime() {
		return dateTime.get(Calendar.HOUR_OF_DAY) + ":" + (dateTime.get(Calendar.MINUTE) < 10 ? "0" + dateTime.get(Calendar.MINUTE) : dateTime.get(Calendar.MINUTE));
	}
	public void setDate(String date) { //XXX
		String[] dates = date.split("-");
		dateTime.set(Integer.parseInt(dates[0]), 
						Integer.parseInt(dates[1]) - 1, 
						Integer.parseInt(dates[2]));
	}
	public void setTime(String time) { //XXX
		
		String[] times = time.split(":");
		dateTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(times[0]));
		dateTime.set(Calendar.MINUTE, Integer.parseInt(times[1]));
		
	}
	public void setDateTime(String date, String time) {
		setDate(date);
		setTime(time);
	}
	public void setDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}
	public String getClassficationNum() {
		return classficationNum;
	}
	public void setClassficationNum(String classficationNum) {
		this.classficationNum = classficationNum;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Reservation [seq=%s, patientNum=%s, doctorNum=%s, dateTime=%s, classficationNum=%s]",
				seq, patientNum, doctorNum, dateTime, classficationNum);
	}
	
	
	

}
