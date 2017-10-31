package com.grocerystore.reports;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.grocerystore.Bill;
import com.grocerystore.Util;
/**
 * storage of all bills to simulate DB
 * @author aniketsinha
 *
 */
public class BillsCollection {
	private static PriorityQueue<Bill> allBills = new PriorityQueue<Bill>(Util.getBillComparator());
	/**
	 * @return the allBills
	 */
	public PriorityQueue<Bill> getAllBills() {
		return allBills;
	}

	public static void addBill(Bill newBill) {
		allBills.add(newBill);
	}
	public static ArrayList<Bill> getBillsOfDate(String yyyymmddString) {
		ArrayList<Bill> daysBill = new ArrayList<Bill>();
		for(Bill iterBill: allBills) {
			if(iterBill.getYyyymmdd().equals(yyyymmddString)) {
				daysBill.add(iterBill);
			}
		}
		return daysBill;
	}
}
