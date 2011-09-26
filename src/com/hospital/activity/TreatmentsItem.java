package com.hospital.activity;
import java.util.ArrayList;
import java.util.Date;
public class TreatmentsItem extends IndicationsItem {
	public int treatmentType;
	public String treatmentStrength;
	public int medicalSystem;
	TreatmentsItem(String aTitle, String aSubtitle, Date asDate, Date aeDate, int aidSection, int aRepeat, ArrayList<DateComponent> aRepeatTimes, int aSeverity, Date aLastUpdateDate,	int aID, int aTreatmentType, String aTreatmentStrength, int aMedicalSystem) {
		super(aTitle, aSubtitle, asDate, aeDate, aidSection, aRepeat, aRepeatTimes, aSeverity, aLastUpdateDate, aID);
		// TODO Auto-generated constructor stub
		treatmentType=aTreatmentType;
		treatmentStrength=aTreatmentStrength;
		medicalSystem=aMedicalSystem;
	}
}