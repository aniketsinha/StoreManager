package com.grocerystore.reports;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
/**
 * Archives Daily Sales Report by date
 * @author aniketsinha
 *
 */
public class ArchivedSalesReport {
	private static HashMap<String, DailySales> dailyReportsMap = new HashMap<String, DailySales>();
	
	/**
	 * generates today's report
	 */
	public static void generateTodaysReport() {
		Calendar now = Calendar.getInstance();
		String yyyymmdd = ""+now.get(Calendar.YEAR)  + (now.get(Calendar.MONTH)+1) + now.get(Calendar.DAY_OF_MONTH);
		generateDaysReport(yyyymmdd);
	}
	/**
	 * Generates report of date
	 * @param yyyymmdd date string in yyyymmdd format
	 */
	public static void generateDaysReport(String yyyymmdd) {
		DailySales todaysSaleReport = new DailySales(yyyymmdd);
		todaysSaleReport.generateAndPrint();
		dailyReportsMap.put(yyyymmdd, todaysSaleReport);
	}
	
	public static void generateReport(Date startDate, Date endDate) {
		//TODO: check all days between these days, inclusive of these dates
	}
}
