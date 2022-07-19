package com.exam.exspring.reply;

import java.util.Date;

public class ReplyVo {
	private int repNo;
	private String repContent;
	private String repWriter;
	private Date repRegDate;
	public int getRepNo() {
		return repNo;
	}
	public void setRepNo(int repNo) {
		this.repNo = repNo;
	}
	public String getRepContent() {
		return repContent;
	}
	public void setRepContent(String repContent) {
		this.repContent = repContent;
	}
	public String getRepWriter() {
		return repWriter;
	}
	public void setRepWriter(String repWriter) {
		this.repWriter = repWriter;
	}
	public Date getRepRegDate() {
		return repRegDate;
	}
	public void setRepRegDate(Date repRegDate) {
		this.repRegDate = repRegDate;
	}
	public String getRepBbsNo() {
		return repBbsNo;
	}
	public void setRepBbsNo(String repBbsNo) {
		this.repBbsNo = repBbsNo;
	}
	private String repBbsNo;
}
