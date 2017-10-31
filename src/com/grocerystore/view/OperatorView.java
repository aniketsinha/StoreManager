package com.grocerystore.view;

import java.util.HashMap;

import com.grocerystore.Bill;
import com.grocerystore.inventory.Discount;
import com.grocerystore.inventory.Item;
import com.grocerystore.users.Operator;

public interface OperatorView extends View,Report {
	Bill generateNewBill(HashMap<Item, Float> cart, Register fromRegister, Discount additionalDiscount, Operator operator);
	void addItemToCart(Item item, float quantity, HashMap<Item, Float> cart);
	void updateItemInCart(Item item, float quantity, HashMap<Item, Float> cart);
	void removeItemFromCart(Item item, HashMap<Item, Float> cart);
}
