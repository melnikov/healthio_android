package com.hospital.activity;
import java.util.ArrayList;
class DateComponentRepeatMonth {
	private ArrayList<String> month;
	public ArrayList<String> monthOutput() {
		month=new ArrayList<String>();
		for (int i=1; i<=28; i++) {
			month.add(i+"");
		}
		month.add("Last day of month");
		return month;
	}
}