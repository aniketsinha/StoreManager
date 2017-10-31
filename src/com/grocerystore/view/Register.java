package com.grocerystore.view;

import com.grocerystore.viewimpl.RegisterViewExtn;

public class Register {
	private int registerNumber;
	public Register(int registerNumber) {
		this.registerNumber = registerNumber;
	}
	
	/**
	 * @return the registerNumber
	 */
	public int getRegisterNumber() {
		return registerNumber;
	}

	/**
	 * @param registerNumber the registerNumber to set
	 */
	public void setRegisterNumber(int registerNumber) {
		this.registerNumber = registerNumber;
	}

	public void loginThisUser(RegisterViewExtn register, String username, String password) throws Exception {
		System.out.println("\nLogging in as "+username+"...");
//		Thread.sleep(1500);
		register.doLogin(username, password);
	}
}
