package com.grocerystore.users;

public enum UserType {
	ADMIN(1),
	OPERATOR(2);
	
	private int roleId;
	UserType(int roleId) {
		this.roleId = roleId;
	}
	
	public int getRoleId() {
		return this.roleId;
	}
}
