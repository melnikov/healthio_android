package com.hospital.activity;
import java.util.ArrayList;
final class ProfileComponentGender {
	private static ArrayList<String> gender;
	public static ArrayList<String> getGender() {
		gender=new ArrayList<String>();
		gender.add("Male");
		gender.add("Female");
		return gender;
	}
}