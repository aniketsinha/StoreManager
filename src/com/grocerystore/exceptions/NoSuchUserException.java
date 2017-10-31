package com.grocerystore.exceptions;

public class NoSuchUserException extends RuntimeException {

	private static final long serialVersionUID = -2704255707847830446L;
	public NoSuchUserException() {
		super();
	}
	public NoSuchUserException(String message) {
		super(message);
	}
	
}
