package com.hospital.activity;
import java.util.ArrayList;
import java.util.Date;
import com.hospital.activity.item.Item;
public class IndicationsItem implements Item {
	public String title;
	public String subtitle;
	public Date startDate;
	public Date endDate;
	public int idSection;
	public int repeat;
	public ArrayList<DateComponent> repeatTimes;
	public int severity;
	public Date lastUpdateDate;
	public int ID;
	public final static String[] sections=new String[] {"Conditions", "Symptoms", "Test Results"};
	public IndicationsItem(String title, String subtitle) {
		this.title=title;
		this.subtitle=subtitle;
	}
	IndicationsItem(String aTitle, String aSubtitle, Date asDate, Date aeDate, int aidSection, int aRepeat, ArrayList<DateComponent> aRepeatTimes, int aSeverity, Date aLastUpdateDate, int aID) {
		title=new String(aTitle);
		subtitle=new String(aSubtitle);
		startDate=asDate;
		endDate=aeDate;
		idSection=aidSection;
		repeat=aRepeat;
		repeatTimes=new ArrayList<DateComponent> (aRepeatTimes);
		severity=aSeverity;
		lastUpdateDate=aLastUpdateDate;
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