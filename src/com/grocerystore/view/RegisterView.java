package com.grocerystore.view;

import com.grocerystore.exceptions.InvalidUserCredentialsException;
import com.grocerystore.exceptions.NoSuchUserException;
import com.grocerystore.users.Admin;
import com.grocerystore.users.Operator;
import com.grocerystore.users.UserType;

public abstract class RegisterView {
	protected User user = null;
	public User getUser() {
		return user;
	}
	public void doLogin(String username, String password) throws Exception {
		User loggedInUserDetails = processForm(username, password);
//		Thread.sleep(1500);
		int loggedInUserRoleId = loggedInUserDetails.getRoleId();
		if(loggedInUserRoleId == UserType.OPERATOR.getRoleId()) {
			showOperatorScreen();
		}
		else if(loggedInUserRoleId == UserType.ADMIN.getRoleId()) {
			showAdminScreen();
		}
		else {
			throw new NoSuchUserException("No user found!");
		}
	}
	public User processForm(String username,String password) {
		if(validateAndSetUser(username, password) ) {
			return user;
		}
		return null;	
	}

	private boolean validateAndSetUser(String username, String password) throws InvalidUserCredentialsException {
		// validate username and password, and get user details from DB
		if(username.equals("admin")) {
			user = new Admin();
			return true;
		}
		else if(username.equals("operator")) {
			user = new Operator();
			return true;
		}
		return false;
	}
	
	public abstract void showOperatorScreen() throws Exception;
	public abstract void showAdminScreen() throws Exception;

}
