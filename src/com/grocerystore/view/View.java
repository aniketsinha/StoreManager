package com.grocerystore.view;

import com.grocerystore.Bill;
import com.grocerystore.inventory.Category;
import com.grocerystore.inventory.Discount;
import com.grocerystore.inventory.Item;

public interface View {
	void printBill(Bill bill);
	void applyDiscount(Item item, Discount discount);
	void applyDiscount(Category category, Discount discount);
}
