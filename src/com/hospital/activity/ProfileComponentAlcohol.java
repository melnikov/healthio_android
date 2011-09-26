package com.hospital.activity;
import java.util.ArrayList;
final class ProfileComponentAlcohol {
	private static ArrayList<String> alcohol;
	public static ArrayList<String> getAlcohol() {
		alcohol=new ArrayList<String>();
		alcohol.add("Non-drinker");
		alcohol.add("1-2");
		alcohol.add("5-10");
		alcohol.add("10-20");
		alcohol.add("More than 20");
		return alcohol;
	}
}