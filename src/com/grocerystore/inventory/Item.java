package com.grocerystore.inventory;

public class Item {
	
	private String name ;
	private Category category;
	private Price price;
	private int code;
	private Discount discount;
	
	public Item(String name, Category category, Price price ) {
		setName(name);
		setCategory(category);
		setPrice(price);
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Item withItemCode(int itemCode) {
		this.code = itemCode;
		return this;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
}
