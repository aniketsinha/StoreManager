package com.grocerystore.inventory;

import com.grocerystore.Util;

public class Price extends Discount{

	private double sellingPrice;
	private double costPrice;
	private Discount discount;
	
	public Price(double sellingPrice, double costPrice, String name, int type0Percent1Flatoff, float percent, float flatOffPrice, boolean isCapped,float maxPercent, float maxOff) {		
		super(name, type0Percent1Flatoff, percent, flatOffPrice, isCapped, maxPercent, maxOff);
		this.sellingPrice = sellingPrice;
		this.costPrice = costPrice;
	}
	public Price(double sellingPrice, double costPrice, Discount discount) {
		super(discount.getName(), discount.getType(), discount.getPercent(), discount.getFlatOff(), discount.isCapped(), discount.getMaxPercent(), discount.getMaxOff());
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.discount = discount;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public double getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(double costPrice) {
		this.costPrice = costPrice;
	}
	public double getMargin() {
		return sellingPrice - costPrice;
	}
	public double getNetSellingPrice() {
		return Util.getEffectivePrice(sellingPrice, discount);
	}
}
