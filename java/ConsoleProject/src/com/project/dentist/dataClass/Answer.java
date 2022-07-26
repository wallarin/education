package com.project.dentist.dataClass;
//온라인상담 답글
public class Answer {
	private String num;
	private String cnum;
	private String content;

	public Answer(String num, String cnum, String content) {
		this.num = num;
		this.cnum = cnum;
		this.content = content;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getCnum() {
		return cnum;
	}

	public void setCnum(String cnum) {
		this.cnum = cnum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return String.format("Answer [num=%s, cnum=%s, content=%s]", num, cnum, content);
	}
	
	


}
