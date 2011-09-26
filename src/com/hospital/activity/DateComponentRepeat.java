package com.hospital.activity;
import java.util.ArrayList;
final public class DateComponentRepeat {
	private ArrayList<String> repeat;
	public ArrayList<String> repeatOutput() {
		repeat=new ArrayList<String>();
		repeat.add("Once");
		repeat.add("Daily");
		repeat.add("Weekly");
		repeat.add("Monthly");
		repeat.add("Yearly");
		return repeat;
	}
}