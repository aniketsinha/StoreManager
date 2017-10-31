package com.grocerystore.viewimpl;

import java.util.HashMap;

import com.grocerystore.Bill;
import com.grocerystore.DummyData;
import com.grocerystore.exceptions.SoldMoreThanStockError;
import com.grocerystore.inventory.Inventory;
import com.grocerystore.inventory.Item;
import com.grocerystore.reports.BillsCollection;
import com.grocerystore.users.Operator;
import com.grocerystore.view.Register;
import com.grocerystore.view.RegisterView;

public class RegisterViewExtn extends RegisterView {
	
	Register thisRegister;

	public RegisterViewExtn(Register thisRegister) {
		this.thisRegister = thisRegister;
	}
	
	@Override
	public void showOperatorScreen() throws Exception {
		
		System.out.println("Welcome to Operator Panel!\n");
//		Thread.sleep(1500);
		OperatorViewImpl operatorScreen = new OperatorViewImpl();

		DummyData dummy = new DummyData();
		HashMap<Item, Float> cart = new HashMap<Item, Float>();

		Item coke = dummy.capscicum;
		Item lays = dummy.lays;

		try {
			Thread.sleep(2000);
			System.out.println("Generating Bill 1...");
			operatorScreen.addItemToCart(coke, 2.4f, cart);
			operatorScreen.addItemToCart(lays, 5.0f, cart);
			Bill bill = operatorScreen.generateNewBill(cart, thisRegister,dummy.diwaliOffer,(Operator) user);
			Inventory.decreaseBilledItems(bill);
			operatorScreen.printBill(bill);
			BillsCollection.addBill(bill);
			Thread.sleep(2000);
			System.out.println("Generating Bill 2...");
			cart = new HashMap<Item, Float>();
			operatorScreen.addItemToCart(lays, 2f, cart);
			operatorScreen.updateItemInCart(lays, 12f, cart);
			Bill bill2 = operatorScreen.generateNewBill(cart, thisRegister,dummy.employee,(Operator) user);
			Inventory.decreaseBilledItems(bill2);
			operatorScreen.printBill(bill2);
			BillsCollection.addBill(bill2);
			
		} catch (SoldMoreThanStockError e) {
			e.printStackTrace();
		}
		
	}


	public Register getThisRegister() {
		return thisRegister;
	}


	public void setThisRegister(Register thisRegister) {
		this.thisRegister = thisRegister;
	}


	@Override
	public void showAdminScreen() throws Exception {
		AdminViewImpl adminView = new AdminViewImpl();
		System.out.println("Welcome to Admin Panel!\n");
		Thread.sleep(1500);
		System.out.println("Adding dummy categories...");
		DummyData dummy = new DummyData();
		adminView.addNewCategory(dummy.chips);
		adminView.addNewCategory(dummy.vegetables);
		System.out.println("Adding dummy items...");
		adminView.addItemInInventory(dummy.lays, 750);//   ventory(item, stock, price);
		adminView.addItemInInventory(dummy.capscicum, 50);
		adminView.printInventory();
		
	}
}
