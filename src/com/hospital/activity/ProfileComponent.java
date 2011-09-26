package com.hospital.activity;
class ProfileComponent {
	private int ID;
	private String city;
	private String email;
	private int height;
	private int weight;
	private int dateOfBirth;
	private int gender;
	private int tobacco;
	private int alcohol;
	private int alert;
	ProfileComponent(int aID, String aCity, String aEmail, int aHeight, int aWeight, int aDateOfBirth, int aGender, int aTobacco, int aAlcohol, int aAlert) {
		this.ID=aID;
		this.city=aCity;
		this.email=aEmail;
		this.height=aHeight;
		this.weight=aWeight;
		this.dateOfBirth=aDateOfBirth;
		this.gender=aGender;
		this.tobacco=aTobacco;
		this.alcohol=aAlcohol;
		this.alert=aAlert;
	}
	public int getID() {
		return ID;
	}
	public void setID(int mID) {
		this.ID=mID;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String mCity) {
		this.city=mCity;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String mEmail) {
		this.email=mEmail;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int mHeight) {
		this.height=mHeight;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int mWeight) {
		this.weight=mWeight;
	}
	public int getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(int mDateOfBirth) {
		this.dateOfBirth=mDateOfBirth;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int mGender) {
		this.gender=mGender;
	}
	public int getTobacco() {
		return tobacco;
	}
	public void setTobacco(int mTobacco) {
		this.tobacco=mTobacco;
	}
	public int getAlcohol() {
		return alcohol;
	}
	public void setAlcohol(int mAlcohol) {
		this.alcohol=mAlcohol;
	}
	public int getAlert() {
		return alert;
	}
	public void setAlert(int mAlert) {
		this.alert=mAlert;
	}
}