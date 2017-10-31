package com.grocerystore.view;

import java.util.Date;

public interface Report {
	void printInventory();
	void printTotalSales(Date startDate, Date endDate);
}
