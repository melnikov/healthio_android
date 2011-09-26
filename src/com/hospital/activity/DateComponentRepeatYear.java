package com.hospital.activity;
import java.util.ArrayList;
final class DateComponentRepeatYear {
	private static ArrayList<String> year;
	public static ArrayList<String> yearOutput() {
		year=new ArrayList<String>();
		year.add("January");
	    year.add("Fefruary");
	    year.add("March");
	    year.add("April");
	    year.add("May");
	    year.add("June");
	    year.add("July");
	    year.add("August");
	    year.add("September");
	    year.add("October");
	    year.add("November");
	    year.add("December");
		return year;
	}
	public static String getYearName(int i) {
		int num=i-1;
		ArrayList<String> valueArray=yearOutput();
		String value=valueArray.get(num);
		return value;
	}
}