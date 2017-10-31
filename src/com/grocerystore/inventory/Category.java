package com.grocerystore.inventory;

public class Category {
	private int code;
	private String name;
	private Discount discount;
	
	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public static Category getInstance(String name) {
		return new Category(name);
	}
	
	public Category(String name) {
		this.name = name;
	}
	
	public void setCode(int code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	public Category withCode(int code) {
		this.code = code;
		return this;
	}
	
}
