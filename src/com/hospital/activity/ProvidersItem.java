package com.hospital.activity;
import com.hospital.activity.item.Item;
public class ProvidersItem implements Item {
	public String title;
	public int idSection;
	public int specialty;
	public String affiliation;
	public String cityName;
	public String phone;
	public String fax;
	public String email;
	public float rating;
	public int ID;
	public final static String[] sections=new String[] {"Conditions", "Symptoms", "Test Results"};
	public ProvidersItem(String title, String cityName) {
		this.title=title;
		this.cityName=cityName;
	}
	ProvidersItem(String aTitle, int aIdSection, int aSpecialty, String aAffiliation, String aCityName, String aPhone, String aFax, String aEmail, float aRating, int aID) {
		title=new String(aTitle);
		idSection=aIdSection;
		specialty=aSpecialty;
		affiliation=new String(aAffiliation);
		cityName=new String(aCityName);
		phone=new String(aPhone);
		fax=new String (aFax);
		email=new String(aEmail);
		rating=aRating;
		ID=aID;
	}
	@Override
	public boolean isSection() {
		// TODO Auto-generated method stub
		return false;
	}
	static public String outSections(int id) {
		String element=sections[id-1];
		return element;
	}
}