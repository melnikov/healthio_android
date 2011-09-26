package com.hospital.activity;
import java.util.ArrayList;
final class ProfileComponentAlert {
	private static ArrayList<String> alert;
	public static ArrayList<String> getAlert() {
		alert=new ArrayList<String>();
		alert.add("1 alert");
		alert.add("2 alert");
		alert.add("3 alert");
		return alert;
	}
}