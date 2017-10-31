package com.grocerystore;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.grocerystore.exceptions.SoldMoreThanStockError;
import com.grocerystore.inventory.Discount;
import com.grocerystore.inventory.DiscountType;
import com.grocerystore.inventory.Inventory;
import com.grocerystore.inventory.Item;

public class Util {
	
	public static void printBill(Bill bill) throws Exception {
		System.out.println("\nPrinting bill...");
		Thread.sleep(1500);
		System.out.println(bill);
	}

	public static double getEffectivePrice(double totalPrice, Discount discount) {
		int discountType = discount.getType();
		if(discountType == DiscountType.PERCENT.getDiscountType()) {
			float netPercent = discount.getPercent();
			if(discount.isCapped()) {
				netPercent = Math.min(netPercent, discount.getMaxPercent());
			}
			return totalPrice * (1 - (netPercent/100));
		}
		else {
			float netOff = discount.getFlatOff();
			if(discount.isCapped()) {
				netOff = Math.min(netOff, discount.getMaxOff());
			}
			return totalPrice - netOff;
		}
		
	}

	public static void decreaseFromInventory( Bill bill) throws SoldMoreThanStockError {
		HashMap<Item, Float> soldItems = bill.getBilledItems();
		for(Map.Entry<Item, Float> entry: soldItems.entrySet()) {
			Inventory.decreaseItem(entry.getKey(), entry.getValue());
		}
	}
	public static Comparator<Bill> getBillComparator() {
		Comparator<Bill> billComparator = new Comparator<Bill>() {
			@Override
			public int compare(Bill o1, Bill o2) {
				return Integer.parseInt(""+ (o1.getBillNumber() - o2.getBillNumber()));
			}
		};
		return billComparator;
	}

	public static String getFormattedString(double doubleValue) {
		return String.format("%.2f",doubleValue);
	}
}
