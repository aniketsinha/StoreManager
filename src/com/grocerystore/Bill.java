package com.grocerystore;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.grocerystore.inventory.Discount;
import com.grocerystore.inventory.Item;
import com.grocerystore.users.Operator;
import com.grocerystore.view.Register;

public class Bill {
	
	private Long billNumber;
	private HashMap<Item, Float> billedItems;
	private Register billedFromRegister;
	private Date billedTime;
	private Discount discount;
	private Operator billingOperator;
	private double billAmount;
	private double netPayableAmount;
	private String yyyymmdd;
	
	public String getYyyymmdd() {
		return yyyymmdd;
	}

	public void setYyyymmdd(String yyyymmdd) {
		this.yyyymmdd = yyyymmdd;
	}

	public Bill(HashMap<Item, Float> billedItems, Operator operator) {
		this.billedItems =  billedItems;
		setBillingOperator(operator);
	}
	
	public Long getBillNumber() {
		return billNumber;
	}
	private void setBillNumber(Long billNumber) {
		this.billNumber = billNumber;
	}
	public HashMap<Item, Float> getBilledItems() {
		return billedItems;
	}
	public void setBilledItems(HashMap<Item, Float> billedItems) {
		this.billedItems = billedItems;
	}
	public Register getBilledFromRegister() {
		return billedFromRegister;
	}
	public void setBilledFromRegister(Register billedFromRegister) {
		this.billedFromRegister = billedFromRegister;
	}
	public Date getBilledTime() {
		return billedTime;
	}
	private void setBilledTime(Date billedTime) {
		this.billedTime = billedTime;
	}
	public Discount getDiscount() {
		return discount;
	}
	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	public int getTotalItems() {
		return billedItems.keySet().size();
	}
	public Long generate() {
		Calendar now = Calendar.getInstance();
		Date nowDate = now.getTime();
		setBilledTime(nowDate);
		setBillNumber(now.getTimeInMillis());
		String ymdString = ""+now.get(Calendar.YEAR)  + (now.get(Calendar.MONTH)+1) + now.get(Calendar.DAY_OF_MONTH);
		setYyyymmdd(ymdString);
		return getBillNumber();
	}
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("\n------------------------------------------------------------------------------------------------------------------------\n");
		sb.append("Bill Number: ").append(getBillNumber()).append("\n");
		sb.append("Billed Time: ").append(getBilledTime()).append("\n");
		sb.append("Billing Operator: ").append(getBillingOperator().getRoleId()).append("\n");
		sb.append("Register: ").append(getBilledFromRegister().getRegisterNumber()).append("\n");
		sb.append("\nItems: ").append("\n");
		sb.append("#  Code Name \t\t    Category").append("\t").append("List Price\t").append("Selling Price   x Quantity").append("\t= ").append("Item Total\t").append("Discount").append("\n");
		HashMap<Item, Float> items = getBilledItems();
		double totalPrice = 0;
		int i=0;
		for(Map.Entry<Item, Float> entry: items.entrySet()) {
			Item iterItem = entry.getKey();
			double listPrice = iterItem.getPrice().getSellingPrice();
			double netSellingPrice = iterItem.getPrice().getNetSellingPrice();
			double priceForItem = netSellingPrice*entry.getValue();
			totalPrice += priceForItem;
			sb.append(++i).append(". ").append(iterItem.getCode()).append(" ").append( String.format("%-20.20s", iterItem.getName())  ).append( String.format("%1$-10s", iterItem.getCategory().getName()) ).append("\t").append(listPrice).append("\t\t").append(netSellingPrice).append("\t\tx ").append(entry.getValue()).append("\t\t= ").append(String.format("%.2f",priceForItem)).append(" \t");
			if(iterItem.getPrice().getDiscount() != null) {
				sb.append(iterItem.getPrice().getDiscount().toString());
			}
			sb.append("\n");
		}
		setBillAmount(getBillAmount() + totalPrice);
		sb.append("Total Items: ").append(getTotalItems()).append("\n");
		sb.append("Total Price: ").append(String.format("%.2f", totalPrice)).append("\n");
		sb.append("Discount: ").append(discount.toString()).append("\n");
		String netBill = String.format("%.2f", Util.getEffectivePrice(totalPrice, discount));
		setNetPayableAmount(Double.parseDouble(netBill));
		sb.append("Amount to be paid: ").append(netBill);
		sb.append("\n------------------------------------------------------------------------------------------------------------------------");
		return sb.toString();
	}

	public Operator getBillingOperator() {
		return billingOperator;
	}

	public void setBillingOperator(Operator billingOperator) {
		this.billingOperator = billingOperator;
	}

	/**
	 * @return the billAmount
	 */
	public double getBillAmount() {
		return billAmount;
	}

	/**
	 * @param billAmount the billAmount to set
	 */
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	/**
	 * @return the netPayableAmount
	 */
	public double getNetPayableAmount() {
		return netPayableAmount;
	}

	/**
	 * @param netPayableAmount the netPayableAmount to set
	 */
	public void setNetPayableAmount(double netPayableAmount) {
		this.netPayableAmount = netPayableAmount;
	}
	
}
