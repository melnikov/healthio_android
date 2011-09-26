package com.hospital.activity;
class DateComponent {
	private int year;
	private int month;
	private int day;
	private int weekday;
	private int hour;
	private int minute;
	DateComponent(int aYear, int aMonth, int aDay, int aWeekday, int aHour, int aMinute) {
		this.year=aYear;
		this.month=aMonth;
		this.day=aDay;
		this.weekday=aWeekday;
		this.hour=aHour;
		this.minute=aMinute;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public int getWeekday() {
		return weekday;
	}
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
}