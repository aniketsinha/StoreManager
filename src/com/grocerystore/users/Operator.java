package com.grocerystore.users;

import com.grocerystore.view.User;
import com.grocerystore.viewimpl.OperatorViewImpl;

public class Operator extends OperatorViewImpl implements User {

	@Override
	public long getUserId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRoleId() {
		// TODO Auto-generated method stub
		return UserType.OPERATOR.getRoleId();
	}

	@Override
	public void setUseridFromDB(String username, String password) {
		// TODO Auto-generated method stub
		
	}

}
