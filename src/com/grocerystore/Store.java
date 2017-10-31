package com.grocerystore;

import com.grocerystore.inventory.Inventory;
import com.grocerystore.reports.ArchivedSalesReport;
import com.grocerystore.view.Register;
import com.grocerystore.viewimpl.RegisterViewExtn;

public class Store {

	public static void main(String[] args) throws Exception {
		Register regMachine = new Register(7);	//dummy register		
		RegisterViewExtn register = new RegisterViewExtn(regMachine);//inventory);
		
		regMachine.loginThisUser(register, "admin", "admin");

		Thread.sleep(5000);

		regMachine.loginThisUser(register, "operator", "operator");		
		Thread.sleep(5000);

		System.out.println("\n\nFinal Inventory at the end of day");
		Inventory.printItems();
		System.out.println("Generating today's sales report...");
		Thread.sleep(2500);
		ArchivedSalesReport.generateTodaysReport();
	}

}
