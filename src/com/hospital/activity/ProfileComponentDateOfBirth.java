package com.hospital.activity;
import java.util.ArrayList;
final class ProfileComponentDateOfBirth {
	private static ArrayList<String> dateOfBirth;
	public static ArrayList<String> getDateOfBirth() {
		dateOfBirth=new ArrayList<String>();
		dateOfBirth.add("2010-2019");
		dateOfBirth.add("2000-2009");
		dateOfBirth.add("1990-1999");
		dateOfBirth.add("1980-1989");
		dateOfBirth.add("1970-1979");
		dateOfBirth.add("1960-1969");
		dateOfBirth.add("1950-1959");
		dateOfBirth.add("1940-1949");
		dateOfBirth.add("1930-1939");
		dateOfBirth.add("1920-1929");
		dateOfBirth.add("1910-1919");
		return dateOfBirth;
	}
}