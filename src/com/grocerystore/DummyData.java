package com.grocerystore;

import com.grocerystore.inventory.Category;
import com.grocerystore.inventory.Discount;
import com.grocerystore.inventory.Item;
import com.grocerystore.inventory.Price;

public class DummyData {
	public Category chips = new Category("Chips").withCode(10);
	public Category vegetables = new Category("Vegetables").withCode(11);
	public Discount employee = new Discount("Employee Discount", 0, 15, 0, false, 15, 0);
	public Discount seniorCitizen = new Discount("Senior Citizen", 0, 10, 0, false, 15, 0);
	public Discount noDiscount = new Discount("No Discount", 0, 0, 0, true, 0, 0);
	public Discount flat5Off = new Discount("Offer 5", 1, 0, 5, true, 0, 5);
	public Discount diwaliOffer = new Discount("Diwali Offer", 0, 10, 0, true, 10, 0);
	public Price tenRupeesWithoutDiscount = new Price(10, 8.5, noDiscount);
	public Price ninetyRupeesWithFlat5Off = new Price(90, 75, flat5Off);
	public Item lays = new Item("Lays 100gm Pack", chips, tenRupeesWithoutDiscount).withItemCode(1111);
	public Item capscicum = new Item("Capscicum", vegetables, ninetyRupeesWithFlat5Off).withItemCode(2222);
	
}
