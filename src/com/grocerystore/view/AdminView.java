package com.grocerystore.view;

import com.grocerystore.inventory.Category;
import com.grocerystore.inventory.Item;

public interface AdminView extends View,Report {
	void updateInventory(int itemCode, double newStock);
	void addItemInInventory(Item newItem, double stock);
	int addNewCategory(Category category);
}
