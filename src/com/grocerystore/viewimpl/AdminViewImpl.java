package com.grocerystore.viewimpl;

import java.util.Date;

import com.grocerystore.Bill;
import com.grocerystore.Util;
import com.grocerystore.inventory.Category;
import com.grocerystore.inventory.Discount;
import com.grocerystore.inventory.Inventory;
import com.grocerystore.inventory.Item;
import com.grocerystore.reports.ArchivedSalesReport;
import com.grocerystore.view.AdminView;

public class AdminViewImpl implements AdminView {

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
		ArchivedSalesReport.generateReport(startDate, endDate);
	}

	@Override
	public void updateInventory(int itemCode, double newStock) {
		Item itemToBeUpdated = Inventory.itemIdMapper.get(itemCode);
		Inventory.updateInventory(itemToBeUpdated, newStock);
	}

	@Override
	public void addItemInInventory(Item item, double stock) {
		Inventory.addItem(item, stock);
	}

	@Override
	public int addNewCategory(Category category) {
		return Inventory.addCategory(category);
	}

	@Override
	public void printBill(Bill bill) {
		try {
			Util.printBill(bill);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
