package com.hospital.activity;
import java.util.ArrayList;
final class ProfileComponentHeight {
	private static ArrayList<String> height;
	public static ArrayList<String> getHeight() {
		height=new ArrayList<String>();
		height.add("Below 50");
		height.add("50-99");
		height.add("100-149");
		height.add("150-199");
		height.add("200-249");
		height.add("250-299");
		height.add("Over 300");
		return height;
	}
}