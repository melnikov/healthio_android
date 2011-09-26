package com.hospital.activity;
import java.util.ArrayList;
final public class TreatmentSystemData {
	private static ArrayList<String> TreatmentSystem;
	public static ArrayList<String> treatmentSystemOutput() {
		TreatmentSystem=new ArrayList<String>();
		TreatmentSystem.add("Allopathy (Western)");
		TreatmentSystem.add("Ayurveda (Indian)");
		TreatmentSystem.add("Aromatherapy");
		TreatmentSystem.add("Acupressure");
		TreatmentSystem.add("Bioelectromagnetic");
		TreatmentSystem.add("Chinese (Traditional)");
		TreatmentSystem.add("Chelation Therapy");
		TreatmentSystem.add("Chiropracty");
		TreatmentSystem.add("Diet & Nutrition");
		TreatmentSystem.add("Homeopathy");
		TreatmentSystem.add("Hypnotherapy");
		TreatmentSystem.add("Hydrotherapy");
		TreatmentSystem.add("Massage Therapy");
		TreatmentSystem.add("Osteopathy");
		TreatmentSystem.add("Reiki");
		TreatmentSystem.add("Tai-Chi (Qi�Gong)");
		TreatmentSystem.add("Unani");
		TreatmentSystem.add("Other");
		return TreatmentSystem;
	}
}