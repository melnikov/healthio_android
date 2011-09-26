package com.hospital.activity;
import java.util.ArrayList;
final class DateComponentRepeatWeek {
	private static ArrayList<String> week;
	public static ArrayList<String> weekOutput() {
		week=new ArrayList<String>();
		week.add("Monday");
	    week.add("Tuesday");
	    week.add("Wednesday");
	    week.add("Thursday");
	    week.add("Friday");
	    week.add("Saturday");
	    week.add("Sunday");
		return week;
	}
	public static String getWeekName(int i) {
		int num=i-1;
		ArrayList<String> valueArray=weekOutput();
		String value=valueArray.get(num);
		return value;
	}
}