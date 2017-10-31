package com.grocerystore.users;

import com.grocerystore.view.User;
import com.grocerystore.viewimpl.AdminViewImpl;

public class Admin extends AdminViewImpl implements User {
	Long userid;
	@Override
	public long getUserId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRoleId() {
		return UserType.ADMIN.getRoleId();
	}

	@Override
	public void setUseridFromDB(String username, String password) {
		this.userid = 1234l;//fetch from DB
		
	}

}
