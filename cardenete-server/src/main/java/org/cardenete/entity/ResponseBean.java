package org.cardenete.entity;

public class ResponseBean {

	private int status;
	private String msg;
	private long timeStamp;
	
	public ResponseBean() {
		
	}
	
	public ResponseBean(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public ResponseBean(int status, String msg, long timeStamp) {
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}







