package com.caps.exception;

public class InvalidCollege extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	public InvalidCollege(String message) {
		super(message);
	}
	
	
}
