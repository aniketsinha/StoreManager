package com.grocerystore.reports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.grocerystore.Bill;
import com.grocerystore.Util;
import com.grocerystore.inventory.Item;
/**
 * bill details for any day
 * @author aniketsinha
 *
 */
public class DailySales {
	private String yyyymmddString;
	private double totalSaleValueToday;
	private double totalCashReceivedToday;
	private ArrayList<Bill> allBills;
	private HashMap<Item, Float> itemsSold;
	
	public DailySales(String dateString) {
		//fetch all bills of specified date
		this.yyyymmddString = dateString;
	}
	
	public ArrayList<Bill> getAllBills() {
		return allBills;
	}
	public void setAllBills() {
		this.allBills = BillsCollection.getBillsOfDate(yyyymmddString);
	}
	public double getTotalSales() {
		return allBills.size();
	}

	public void generateAndPrint() {
		setAllBills();
		itemsSold = new HashMap<Item, Float>();
		for(Bill iterBill: getAllBills()) {
			setTotalSaleValueToday(getTotalSaleValueToday() + iterBill.getBillAmount());
			setTotalCashReceivedToday(getTotalCashReceivedToday() + iterBill.getNetPayableAmount());
			HashMap<Item, Float> itemsSoldInBill = iterBill.getBilledItems(); 
			for(Map.Entry<Item, Float> entry: itemsSoldInBill.entrySet()) {
				Item entryKey = entry.getKey();
				if(itemsSold.containsKey(entryKey)) {
					itemsSold.put(entryKey, itemsSold.get(entryKey) + entry.getValue());
				}
				else {
					itemsSold.put(entryKey, entry.getValue());
				}
			}
		}
		System.out.println(toString());
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		String dateString = yyyymmddString.substring(0, 4) + "/" + yyyymmddString.substring(4,6) + "/" + yyyymmddString.substring(6);
		sb.append("\n\nReport Date: ").append(dateString).append("\n");
		sb.append("Total Bills Generated: ").append(getAllBills().size()).append("\n");
		sb.append("Total Sales Value: ").append(getTotalSaleValueTodayAsString()).append("\n");
		sb.append("Total Cash Received: ").append(Util.getFormattedString(getTotalCashReceivedToday())).append("\n");
		sb.append("Items Sold:\n");
		int i=0;
		for(Map.Entry<Item, Float> entry: itemsSold.entrySet()) {
			sb.append(++i).append(". ").append(entry.getKey().getName()).append(": ").append(entry.getValue()).append("\n");
		}
		return sb.toString();
	}

	/**
	 * @return the totalRevenueToday
	 */
	public double getTotalSaleValueToday() {
		return totalSaleValueToday;
	}
	
	/**
	 * @return the totalRevenueToday
	 */
	public String getTotalSaleValueTodayAsString() {
		return  Util.getFormattedString(getTotalSaleValueToday());
	}

	/**
	 * @param totalRevenueToday the totalRevenueToday to set
	 */
	public void setTotalSaleValueToday(double totalRevenueToday) {
		this.totalSaleValueToday = totalRevenueToday;
	}


	/**
	 * @return the totalCashReceivedToday
	 */
	public double getTotalCashReceivedToday() {
		return totalCashReceivedToday;
	}

	/**
	 * @param totalCashReceivedToday the totalCashReceivedToday to set
	 */
	public void setTotalCashReceivedToday(double totalCashReceivedToday) {
		this.totalCashReceivedToday = totalCashReceivedToday;
	}
	
}
