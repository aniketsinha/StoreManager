package com.grocerystore.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.grocerystore.Bill;
import com.grocerystore.exceptions.SoldMoreThanStockError;

public class Inventory {
	public static ArrayList<Category> categories = new ArrayList<Category>();
	public static HashMap<Item, Double> stock = new HashMap<Item, Double>();
	public static HashMap<Integer, Item> itemIdMapper = new HashMap<Integer, Item>();
	public static int addCategory(Category newCategory) {
		if(newCategory.getCode() == 0) {
			newCategory.setCode(categories.size());
		}
		categories.add(newCategory);
		return newCategory.getCode();
	}
	
	public static double addItem(Item item, double quantity) {
		stock.put(item, quantity);
		itemIdMapper.put(item.getCode(), item);
		return quantity;
	}
	
	public static void printInventory() {
		System.out.println("Printing Categories and Inventory Items...");
		printCategories();
		printItems();
	}

	private static void printCategories() {
		System.out.println("\nAll Categories");
		for(Category cat: categories) {
			System.out.println(cat.getCode() + ": "+ cat.getName());
		}
		System.out.println("------------------------------------------------------------------------------------------------------------------------");
	}
	
	public static void printItems() {
		System.out.printf("\nAll Inventory Items\nCode\tName\t\t\t\tQuantity\tPrice per unit\tTotal Item Price\tNet Selling Price","");
		for(Map.Entry<Item,Double> entry: stock.entrySet()) {
			Item item = entry.getKey();
			double itemCountInStock = entry.getValue();
			double sp = item.getPrice().getSellingPrice();
			Discount priceDiscount = item.getPrice().getDiscount();
			Discount itemDiscount = item.getDiscount();
			
			Discount anyDiscount = (itemDiscount != null)?itemDiscount : (priceDiscount != null)?priceDiscount:null ;
			
			String discountString = (anyDiscount != null) ? anyDiscount.toString() : " - ";
			System.out.printf("\n%s\t%-20.20s\t\t%.2f\t\t%.2f\t\t%.2f\t\t\t%.2f\t%s",item.getCode() ,item.getName(),itemCountInStock,sp,(itemCountInStock*sp), item.getPrice().getNetSellingPrice(), discountString);
		}
		System.out.println("\n------------------------------------------------------------------------------------------------------------------------");
	}
	
	public static void decreaseItem(Item item, double quantity) throws SoldMoreThanStockError {
		Item inventoryStock =  itemIdMapper.get(item.getCode());
		Double oldQuantity =  stock.get(inventoryStock);
		if(oldQuantity - quantity >=0 ) {
			stock.put(inventoryStock, oldQuantity - quantity);
		}
		else {
			throw new SoldMoreThanStockError("Sold Quantity: "+quantity+ " is more than availabe stock quantity of "+oldQuantity);
		}
	}

	public static void decreaseBilledItems(Bill bill) throws SoldMoreThanStockError {
		HashMap<Item, Float> soldItems = bill.getBilledItems();
		for(Map.Entry<Item, Float> entry: soldItems.entrySet()) {
			decreaseItem(entry.getKey(), entry.getValue());
		}
		
	}
	
	public static void updateInventory(Item item, double quantity) {
		
	}
}
