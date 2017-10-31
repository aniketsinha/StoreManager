package com.grocerystore.exceptions;

public class InvalidUserCredentialsException extends RuntimeException {
	
	private static final long serialVersionUID = 1195858451468213329L;
	public InvalidUserCredentialsException() {
		super();
	}
	InvalidUserCredentialsException(String message) {
		super(message);
	}
	
}
