package com.grocerystore.view;

public interface User {
	public long getUserId();
	public int getRoleId();
	void setUseridFromDB(String username, String password);
}
