package com.techno.assignment;

public class NewInvalidException extends Exception {
	String msg;

	public NewInvalidException(String msg) {
		
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "msg";
	}

}
