package com.hospital.activity;
import java.util.ArrayList;
final public class TreatmentTypeData {
	private static ArrayList<String> treatmentType;
	public static ArrayList<String> treatmentTypeOutput() {
		treatmentType=new ArrayList<String>();
		treatmentType.add("Tablet");
		treatmentType.add("Capsule");
		treatmentType.add("Injection");
		treatmentType.add("Syrup");
		treatmentType.add("Ointment");
		treatmentType.add("Device");
		treatmentType.add("Patch");
		treatmentType.add("Other");
		return treatmentType;
	}
}