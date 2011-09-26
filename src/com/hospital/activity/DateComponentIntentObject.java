package com.hospital.activity;
public class DateComponentIntentObject {
	private int ID;
	private String name;
	private String description;
	private String starts;
	private String ends;
	private int repeat;
	public int severity;
	private int treatmentType;
	public String treatmentStrength;
	private int treatmentSystem;
	public DateComponentIntentObject(int aID, String aName, String aDescription, String aStarts, String aEnds, int aRepeat, int aSeverity, int aTreatmentType, String atreatmentStrength, int aTreatmentSystem) {
		ID=aID;
		name=new String(aName);
		description=new String(aDescription);
		starts=new String(aStarts);
		ends=new String(aEnds);
		repeat=aRepeat;
		severity=aSeverity;
		treatmentType=aTreatmentType;
		treatmentStrength=atreatmentStrength;
		treatmentSystem=aTreatmentSystem;
	}
	public int getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getStarts() {
		return starts;
	}
	public String getEnds() {
		return ends;
	}
	public int getRepeat() {
		return repeat;
	}
	public int getSeverity() {
		return severity;
	}
	public int getTreatmentType() {
		return treatmentType;
	}
	public String getTreatmentStrength() {
		return treatmentStrength;
	}
	public int getTreatmentSystem() {
		return treatmentSystem;
	}
}