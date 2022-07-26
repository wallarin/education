package com.project.dentist.dataClass;

public class Treatment { //시술클래스

	private String seq;
	private String classificationNum;  //진료구분번호 == 증상번호
	private String treamentName;
	private String itemNum1;
	private String itemNum2;
	private String itemNum3;
	
	
	
	public Treatment(String seq, String classificationNum, String treamentName, String itemNum1,
			String itemNum2, String itemNum3) {
		this.seq = seq;
		this.classificationNum = classificationNum;
		this.treamentName = treamentName;
		this.itemNum1 = itemNum1;
		this.itemNum2 = itemNum2;
		this.itemNum3 = itemNum3;
	}
	public String getSeq() {
		return seq;
	}
	public String getClassificationNum() {
		return classificationNum;
	}
	public String getTreamentName() {
		return treamentName;
	}
	public String getItemNum1() {
		return itemNum1;
	}
	public String getItemNum2() {
		return itemNum2;
	}
	public String getItemNum3() {
		return itemNum3;
	}
	public String[] getItemAllNums() {
		return new String[] { itemNum1, itemNum2, itemNum3 };
	}
	
	
	@Override
	public String toString() {
		return String.format(
				"Treatment [seq=%s, classificationNum=%s, treamentName=%s, itemNum1=%s, itemNum2=%s, itemNum3=%s]",
				seq, classificationNum, treamentName, itemNum1, itemNum2, itemNum3);
	}
	
}
