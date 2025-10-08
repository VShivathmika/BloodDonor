package com.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class ExceptionClass extends RuntimeException{
	private String donorexceptionmsg;

	public ExceptionClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionClass(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ExceptionClass(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionClass(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionClass(String donorexceptionmsg) {
		super();
		this.donorexceptionmsg = donorexceptionmsg;
	}

	public String getDonorexceptionmsg() {
		return donorexceptionmsg;
	}

	public void setDonorexceptionmsg(String donorexceptionmsg) {
		this.donorexceptionmsg = donorexceptionmsg;
	}

	@Override
	public String toString() {
		return "ExceptionClass [donorexceptionmsg=" + donorexceptionmsg + "]";
	}

	
}
