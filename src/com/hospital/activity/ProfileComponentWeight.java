package com.hospital.activity;
import java.util.ArrayList;
final class ProfileComponentWeight {
	private static ArrayList<String> weight;
	public static ArrayList<String> getWeight() {
		weight=new ArrayList<String>();
		weight.add("Below 50");
		weight.add("50-74");
		weight.add("75-99");
		weight.add("100-124");
		weight.add("125-149");
		weight.add("Over 150");
		return weight;
	}
}