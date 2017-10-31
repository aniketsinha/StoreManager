package com.grocerystore.viewimpl;

import java.util.Date;
import java.util.HashMap;

import com.grocerystore.Bill;
import com.grocerystore.Util;
import com.grocerystore.inventory.Category;
import com.grocerystore.inventory.Discount;
import com.grocerystore.inventory.Inventory;
import com.grocerystore.inventory.Item;
import com.grocerystore.reports.ArchivedSalesReport;
import com.grocerystore.users.Operator;
import com.grocerystore.view.OperatorView;
import com.grocerystore.view.Register;

public class OperatorViewImpl implements OperatorView {

	@Override
	public void applyDiscount(Item item, Discount discount) {
		item.setDiscount(discount);
	}

	@Override
	public void applyDiscount(Category category, Discount discount) {
		category.setDiscount(discount);

	}

	@Override
	public void printInventory() {
		Inventory.printInventory();
	}

	@Override
	public void printTotalSales(Date startDate, Date endDate) {
		ArchivedSalesReport.generateTodaysReport();

	}

	@Override
	public Bill generateNewBill(HashMap<Item, Float> cart, Register fromRegister, Discount additionalDiscount, Operator operator) {
		
		Bill bill = new Bill(cart, operator);
		bill.setBilledFromRegister(fromRegister);
		if(additionalDiscount !=null) {
			bill.setDiscount(additionalDiscount);
		}
		bill.generate();
		return bill;
	}

	@Override
	/**
	 * adds specified quantity of item to cart
	 */
	public void addItemToCart(Item item, float quantity, HashMap<Item, Float> cart) {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("\nAdded %.2f %s to cart.",quantity, item.getName());
		cart.put(item, quantity);

	}

	@Override
	public void updateItemInCart(Item item, float quantity, HashMap<Item, Float> cart) {
		System.out.printf("\nCart updated to %.2f items of %s.",quantity, item.getName());
		cart.put(item, quantity);

	}

	@Override
	public void removeItemFromCart(Item item, HashMap<Item, Float> cart) {
		cart.remove(item);

	}

	@Override
	public void printBill(Bill bill) {
		try {
			Util.printBill(bill);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
