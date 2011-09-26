package com.hospital.activity;
import java.util.ArrayList;
final class ProfileComponentTobacco {
	private static ArrayList<String> tobacco;
	public static ArrayList<String> getTobacco() {
		tobacco=new ArrayList<String>();
		tobacco.add("Non-smoker");
		tobacco.add("1-2");
		tobacco.add("3-5");
		tobacco.add("5-10");
		tobacco.add("10-20");
		tobacco.add("20 or more");
		return tobacco;
	}
}