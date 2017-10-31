package com.grocerystore.inventory;

public enum DiscountType {
	PERCENT(0),FLATOFF(1);
	int type;
	private DiscountType(int type) {
		this.type = type;
	}
	
	public int getDiscountType() {
		return this.type;
	}
}
