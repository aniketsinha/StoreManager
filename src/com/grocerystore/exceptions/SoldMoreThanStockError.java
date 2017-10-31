package com.grocerystore.exceptions;

public class SoldMoreThanStockError extends Exception {

	private static final long serialVersionUID = 9222234434241469481L;
	public SoldMoreThanStockError() {
		super();
	}
	public SoldMoreThanStockError(String message) {
		super(message);
	}
}
