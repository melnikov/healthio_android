package com.hospital.activity;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import com.hospital.activity.item.Item;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
public class DateComponentIntentIndication extends Activity {
	private IndicationsLauncher parentActivity;
	private static ArrayList<DateComponent> objectRepeat=new ArrayList<DateComponent>();
	private static ArrayList<DateComponentIntentObject> objectIntent=new ArrayList<DateComponentIntentObject>();
	private Intent intent;
	private Bundle bundle;
	private int idObjectTimes=0;
	private int identIntent=0;
	private String nameIntent="";
	private String descriptionIntent="";
	private String startsIntent="";
	private String endsIntent="";
	private int repeatIntent=0;
	private int severityIntent=0;
	private int treatmentTypeIntent=0;
	private String treatmentStrengthIntent="";
	private int treatmentSystemIntent=0;
	private EditText formDate;
	private String formDateDefault="";
	private EditText formTime;
	private String formTimeDefault="";
	private EditText formWeek;
	private String formWeekDefault="";
	private EditText formMonth;
	private String formMonthDefault="";
	private EditText formYear;
	private String formYearDefault="";
	private StringBuilder formTimeString;
	private static final int DATE_DIALOG_ID=0;
	private static final int IDD_CHECK_CATS=1;
	private static final int WEEK_DIALOG_ID=2;
	private static final int MONTH_DIALOG_ID=3;
	private static final int YEAR_DIALOG_ID=4;
	private int yearObj=0;
	private int monthObj=0;
	private boolean clickMonthObj=false;
	private boolean noclickMonthObj=false;
	private int dayObj=0;
	private int weekdayObj=0;
	private int weekdayTemp=0;
	private static ArrayList<DateComponentRepeatTimeconstructor> objectRepeatTime=new ArrayList<DateComponentRepeatTimeconstructor>();
	private int hourObj=0;
	private int minuteObj=0;
	private int oldRepeat=-1;
	private int dbRepeat=-1;
	private boolean[] mCheckedItems;
	int onceExe=0;
	/** called when the activity is first created */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		parentActivity=(IndicationsLauncher) getParent();
		intent=getIntent();
		bundle=intent.getExtras();
		if (bundle!=null) {
			if (objectIntent.size()!=0) {
				DateComponentIntentObject oldObject=objectIntent.get(0);
				oldRepeat=oldObject.getRepeat();
			}
			setObjIntentClear();
			if (bundle.getInt("defStrIDObjectTimes")!=0) {
				idObjectTimes=bundle.getInt("defStrIDObjectTimes");
			}
			identIntent=bundle.getInt("defStrIdent");
			nameIntent=bundle.getString("defStrName");
			descriptionIntent=bundle.getString("defStrDescription");
			startsIntent=bundle.getString("defStrStarts");
			endsIntent=bundle.getString("defStrEnds");
			repeatIntent=bundle.getInt("defStrRepeat");
			severityIntent=bundle.getInt("defStrSeverity");
			if (bundle.getInt("defStrTreatmentType")!=0) {
				treatmentTypeIntent=bundle.getInt("defStrTreatmentType");
			}
			if (bundle.getString("defStrTreatmentStrength")!=null) {
				treatmentStrengthIntent=bundle.getString("defStrTreatmentStrength");
			}
			if (bundle.getInt("defStrTreatmentSystem")!=0) {
				treatmentSystemIntent=bundle.getInt("defStrTreatmentSystem");
			}
			objectIntent.add(new DateComponentIntentObject(identIntent, nameIntent, descriptionIntent, startsIntent, endsIntent, repeatIntent, severityIntent, treatmentTypeIntent, treatmentStrengthIntent, treatmentSystemIntent));
		}
		objectRepeatTime.clear();
		switch (identIntent) {
			case 0:
				setContentView(R.layout.date_component_intent_once);
				formDate=(EditText) findViewById(R.id.date);
				break;
			case 2:
				setContentView(R.layout.date_component_intent_daily);
				break;
			case 4:
				setContentView(R.layout.date_component_intent_weekly);
				formWeek=(EditText) findViewById(R.id.week);
				break;
			case 8:
				setContentView(R.layout.date_component_intent_monthly);
				formMonth=(EditText) findViewById(R.id.month);
				break;
			case 16:
				setContentView(R.layout.date_component_intent_yearly);
				formMonth=(EditText) findViewById(R.id.month);
				formYear=(EditText) findViewById(R.id.year);
				break;
		}
		final Calendar c=Calendar.getInstance();
		yearObj=c.get(Calendar.YEAR);
		monthObj=c.get(Calendar.MONTH);
		dayObj=c.get(Calendar.DAY_OF_MONTH);
		weekdayTemp=c.get(Calendar.DAY_OF_WEEK);
		if (weekdayTemp==1) {
			weekdayObj=7;
		}
		else {
			weekdayObj=weekdayTemp-1;
		}
		// take information for fill fields (begin)
		boolean objYes=false;
		ArrayList<DateComponent> repeatTimes=null;
		if (idObjectTimes>0) {
			int objectRepeatLength=objectRepeat.size();
			if (objectRepeatLength>0) {
				repeatTimes=objectRepeat;
				objYes=true;
			}
			else {
				ArrayList<Item> onetabObject=OneTab.outputObject();
				IndicationsItem element=(IndicationsItem) onetabObject.get(idObjectTimes);
				repeatTimes=element.repeatTimes;
				dbRepeat=element.repeat;
				onceExe=1;
				objYes=true;
			}
		}
		else {
			int objectRepeatLength=objectRepeat.size();
			if (objectRepeatLength>0) {
				repeatTimes=objectRepeat;
				objYes=true;
			}
		}
		if (objYes==true) {
			if ((oldRepeat==repeatIntent) || (onceExe==1 && dbRepeat==repeatIntent)) {
				int repeatTimesLength=repeatTimes.size();
				StringBuilder tempTime=new StringBuilder();
				for (int q=0; q<repeatTimesLength; q++) {
					DateComponent repeatTimeElement=(DateComponent) repeatTimes.get(q);
					int endElement=repeatTimesLength-1;
					String prefix;
					if (repeatTimeElement.getHour()<=9) {
						prefix="0";
					}
					else {
						prefix="";
					}
					if (q<endElement) {
						tempTime.append(prefix+repeatTimeElement.getHour()+":00, ");
					}
					else {
						tempTime.append(prefix+repeatTimeElement.getHour()+":00");
					}
					objectRepeatTime.add(new DateComponentRepeatTimeconstructor(repeatTimeElement.getHour(), repeatTimeElement.getMinute()));
				}
				formTimeDefault=tempTime.toString();
				DateComponent repeatDateElement=(DateComponent) repeatTimes.get(0);
				int repeatDateElementYear=repeatDateElement.getYear();
				yearObj=repeatDateElementYear;
				int repeatDateElementMonth=repeatDateElement.getMonth();
				monthObj=repeatDateElementMonth;
				noclickMonthObj=true;
				int repeatDateElementDay=repeatDateElement.getDay();
				dayObj=repeatDateElementDay;
				int repeatDateElementWeekday=repeatDateElement.getWeekday();
				weekdayObj=repeatDateElementWeekday;
				Locale local=new Locale("en", "EN");
				DateFormat df=DateFormat.getDateInstance(DateFormat.DEFAULT, local);
				Date tempDate=new Date(repeatDateElementYear-1900, repeatDateElementMonth-1, repeatDateElementDay);
				formDateDefault=df.format(tempDate);
				formWeekDefault=DateComponentRepeatWeek.getWeekName(weekdayObj);
				if (dayObj<=28) {
					formMonthDefault=dayObj+"";
				}
				else {
					formMonthDefault="Last day of month";
				}
				formYearDefault=DateComponentRepeatYear.getYearName(monthObj);
				// output (begin)
				EditText formTime=(EditText) findViewById(R.id.time);
				formTime.setText(formTimeDefault);
				switch (identIntent) {
					case 0:
						EditText formDate=(EditText) findViewById(R.id.date);
						formDate.setText(formDateDefault);
						break;
					case 4:
						EditText formWeek=(EditText) findViewById(R.id.week);
						formWeek.setText(formWeekDefault);
						break;
					case 8:
						EditText formMonth=(EditText) findViewById(R.id.month);
						formMonth.setText(formMonthDefault);
						break;
					case 16:
						formMonth=(EditText) findViewById(R.id.month);
						formMonth.setText(formMonthDefault);
						EditText formYear=(EditText) findViewById(R.id.year);
						formYear.setText(formYearDefault);
						break;
				}
				// output (end)
			}
		}
		// take information for fill fields (end)
	}
	public void select_date(View target) {
		showDialog(DATE_DIALOG_ID);
	}
	private void updateDate() {
		Locale local=new Locale("en", "EN");
		DateFormat df=DateFormat.getDateInstance(DateFormat.DEFAULT, local);
		Date date=new Date(yearObj-1900, monthObj, dayObj);
		weekdayTemp=date.getDay();
		weekdayObj=weekdayTemp;
		String dateFormat=df.format(date);
		formDate.setText(dateFormat);
	}
	public void select_time(View target) {
		showDialog(IDD_CHECK_CATS);
	}
	private DatePickerDialog.OnDateSetListener mDateSetListener=new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			clickMonthObj=true;
			yearObj=year;
			monthObj=monthOfYear;
			dayObj=dayOfMonth;
			updateDate();
		}
	};
	public void select_week(View target) {
		showDialog(WEEK_DIALOG_ID);
	}
	public void select_month(View target) {
		showDialog(MONTH_DIALOG_ID);
	}
	public void select_year(View target) {
		showDialog(YEAR_DIALOG_ID);
		clickMonthObj=true;
	}
	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog tmp=null;
		switch (id) {
			case DATE_DIALOG_ID:
				if (noclickMonthObj==false) {
					tmp=new DatePickerDialog(getParent(), mDateSetListener, yearObj, monthObj, dayObj);
				}
				else {
					Calendar cal=Calendar.getInstance();
					int yearCurrent=cal.get(Calendar.YEAR);
					int monthCurrent=cal.get(Calendar.MONTH);
					int dayCurrent=cal.get(Calendar.DAY_OF_MONTH);
					tmp=new DatePickerDialog(getParent(), mDateSetListener, yearCurrent, monthCurrent, dayCurrent);
				}
				return tmp;
			case IDD_CHECK_CATS:
				DateComponentRepeatTime timeObj=new DateComponentRepeatTime();
		        final ArrayList<String> timeArray=timeObj.timeOutput();
				String[] arrayElements;
				arrayElements=new String[timeArray.size()];
				for(int i=0; i<timeArray.size(); i++) {
					arrayElements[i]=timeArray.get(i);
				}
				final CharSequence[] items=arrayElements;
				AlertDialog.Builder alert=new AlertDialog.Builder(parentActivity);
				alert.setTitle("Select Time");
				formTime=(EditText) findViewById(R.id.time);
				Editable formTimeEdit=formTime.getText();
		    	String formTimeText=formTimeEdit.toString()+"";
		    	mCheckedItems=new boolean[24];
		    	if (formTimeText!="") {
		    		ArrayList<DateComponent> stringParse;
		    		if (objectRepeat.size()!=0) {
		    			stringParse=objectRepeat;
		    		}
		    		else {
						ArrayList<Item> onetabObject=OneTab.outputObject();
						IndicationsItem element=(IndicationsItem) onetabObject.get(idObjectTimes);
						stringParse=element.repeatTimes;
		    		}
		    		if (stringParse.size()!=0) {
		    			int stringParseLength=stringParse.size();
		    			for (int q=0; q<stringParseLength; q++) {
		    				DateComponent stringParseElement=stringParse.get(q);
		    				int hour=stringParseElement.getHour();
		    				mCheckedItems[hour]=true;
		    			}
			    		for (int i=0; i<24; i++) {
			    			if (mCheckedItems[i]!=true) {
			    				mCheckedItems[i]=false;
			    			}
			    		}
		    		}
		    	}
		    	else {
		    		for (int i=0; i<24; i++) {
		    			mCheckedItems[i]=false;
		    		}
		    	}
				alert.setMultiChoiceItems(items, mCheckedItems, new DialogInterface.OnMultiChoiceClickListener() {
					@Override
				    public void onClick(DialogInterface alert, int item, boolean isChecked) {
						mCheckedItems[item]=isChecked;
				    }
				});
				alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {
			        @Override
			        public void onClick(DialogInterface dialog, int id) {
			        	formTimeString=new StringBuilder();
			        	objectRepeatTime.clear();
				        for (int i=0; i<items.length; i++) {
				        	if (mCheckedItems[i]) {
				        		if (objectRepeatTime.size()!=0) {
				        			formTimeString.append(", ");
				        		}
				        		hourObj=i;
				        		objectRepeatTime.add(new DateComponentRepeatTimeconstructor(hourObj, minuteObj));
				        		String hourObjString="";
				        		if (i<10) {
				        			hourObjString="0"+i;
				        		}
				        		else {
				        			hourObjString=""+i;
				        		}
				        		String minuteObjString="00";
				        		formTimeString.append(hourObjString+":"+minuteObjString);
				        	}
				        }
				        formTime.setText(formTimeString.toString());
			        }
			    });
				alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
				tmp=alert.create();
				return tmp;
			case WEEK_DIALOG_ID:
		        final ArrayList<String> weekArray=DateComponentRepeatWeek.weekOutput();
				arrayElements=null;
				arrayElements=new String[weekArray.size()];
				for(int i=0; i<weekArray.size(); i++) {
					arrayElements[i]=weekArray.get(i);
				}
				final CharSequence[] itemsWeek=arrayElements;
				alert=new AlertDialog.Builder(parentActivity);
				alert.setTitle("Select Day of Week");
				alert.setItems(itemsWeek, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int item) {
						// TODO Auto-generated method stub
						formWeek.setText(itemsWeek[item]);
						weekdayObj=item+1;
					}
				});
			    tmp=alert.create();
				return tmp;
			case MONTH_DIALOG_ID:
				DateComponentRepeatMonth monthObjThis=new DateComponentRepeatMonth();
		        final ArrayList<String> monthArray=monthObjThis.monthOutput();
				arrayElements=null;
				arrayElements=new String[monthArray.size()];
				for(int i=0; i<monthArray.size(); i++) {
					arrayElements[i]=monthArray.get(i);
				}
				final CharSequence[] itemsMonth=arrayElements;
				alert=new AlertDialog.Builder(parentActivity);
				alert.setTitle("Select Day of Month");
				alert.setItems(itemsMonth, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int item) {
						// TODO Auto-generated method stub
						formMonth.setText(itemsMonth[item]);
						if (item==28) {
							dayObj=31;
						}
						else {
							dayObj=item+1;
						}
					}
				});
			    tmp=alert.create();
				return tmp;
			case YEAR_DIALOG_ID:
		        final ArrayList<String> yearArray=DateComponentRepeatYear.yearOutput();
				arrayElements=null;
				arrayElements=new String[yearArray.size()];
				for(int i=0; i<yearArray.size(); i++) {
					arrayElements[i]=yearArray.get(i);
				}
				final CharSequence[] itemsYear=arrayElements;
				alert=new AlertDialog.Builder(parentActivity);
				alert.setTitle("Select Month");
				alert.setItems(itemsYear, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int item) {
						// TODO Auto-generated method stub
						formYear.setText(itemsYear[item]);
						monthObj=item;
					}
				});
			    tmp=alert.create();
				return tmp;
		}
		return tmp;
	}
	public void submit(View target) {
		IndicationAddForm.transitionOnetab=false;
		IndicationEditObj.transitionOnetab=false;
		if ((clickMonthObj==true && noclickMonthObj!=true) || (clickMonthObj==true)) {
			monthObj++;
		}
		switch (identIntent) {
			case 0:
				Calendar cal=Calendar.getInstance();
				weekdayTemp=cal.get(Calendar.DAY_OF_WEEK);
				if (weekdayTemp==1) {
					weekdayObj=7;
				}
				else {
					weekdayObj=weekdayTemp-1;
				}
				EditText dateForm=(EditText) findViewById(R.id.date);
		    	Editable dateEdit=dateForm.getText();
		    	String date=dateEdit.toString()+"";
				if (date!="" && objectRepeatTime.size()!=0) {
					objectRepeat.clear();
					int sizeTimes=objectRepeatTime.size();
					for (int q=0; q<sizeTimes; q++) {
						Object item=(Object) objectRepeatTime.get(q);
						if (item instanceof DateComponentRepeatTimeconstructor) {
							DateComponentRepeatTimeconstructor itemObj=(DateComponentRepeatTimeconstructor) item;
							int hourItem=itemObj.getHour();
							int minuteItem=itemObj.getMinute();
							objectRepeat.add(new DateComponent (yearObj, monthObj, dayObj, weekdayObj, hourItem, minuteItem));
						}
					}
					super.onBackPressed();
				}
				else {
					Toast.makeText(getApplicationContext(), "You do not fill in all fields!", Toast.LENGTH_SHORT).show();
				}
				break;
			case 2:
				if (noclickMonthObj!=true) {
					monthObj++;
				}
				if (objectRepeatTime.size()!=0) {
					objectRepeat.clear();
					int sizeTimes=objectRepeatTime.size();
					for (int q=0; q<sizeTimes; q++) {
						Object item=(Object) objectRepeatTime.get(q);
						if (item instanceof DateComponentRepeatTimeconstructor) {
							DateComponentRepeatTimeconstructor itemObj=(DateComponentRepeatTimeconstructor) item;
							int hourItem=itemObj.getHour();
							int minuteItem=itemObj.getMinute();
							objectRepeat.add(new DateComponent (yearObj, monthObj, dayObj, weekdayObj, hourItem, minuteItem));
						}
					}
					super.onBackPressed();
				}
				else {
					Toast.makeText(getApplicationContext(), "You do not fill in all fields!", Toast.LENGTH_SHORT).show();
				}
				break;
			case 4:
				if (noclickMonthObj!=true) {
					monthObj++;
				}
				EditText weekForm=(EditText) findViewById(R.id.week);
		    	Editable weekEdit=weekForm.getText();
		    	String week=weekEdit.toString()+"";
				if (week!="" && objectRepeatTime.size()!=0) {
					objectRepeat.clear();
					int sizeTimes=objectRepeatTime.size();
					for (int q=0; q<sizeTimes; q++) {
						Object item=(Object) objectRepeatTime.get(q);
						if (item instanceof DateComponentRepeatTimeconstructor) {
							DateComponentRepeatTimeconstructor itemObj=(DateComponentRepeatTimeconstructor) item;
							int hourItem=itemObj.getHour();
							int minuteItem=itemObj.getMinute();
							objectRepeat.add(new DateComponent (yearObj, monthObj, dayObj, weekdayObj, hourItem, minuteItem));
						}
					}
					super.onBackPressed();
				}
				else {
					Toast.makeText(getApplicationContext(), "You do not fill in all fields!", Toast.LENGTH_SHORT).show();
				}
				break;
			case 8:
				if (noclickMonthObj!=true) {
					monthObj++;
				}
				EditText monthForm=(EditText) findViewById(R.id.month);
		    	Editable monthEdit=monthForm.getText();
		    	String month=monthEdit.toString()+"";
				if (month!="" && objectRepeatTime.size()!=0) {
					objectRepeat.clear();
					int sizeTimes=objectRepeatTime.size();
					for (int q=0; q<sizeTimes; q++) {
						Object item=(Object) objectRepeatTime.get(q);
						if (item instanceof DateComponentRepeatTimeconstructor) {
							DateComponentRepeatTimeconstructor itemObj=(DateComponentRepeatTimeconstructor) item;
							int hourItem=itemObj.getHour();
							int minuteItem=itemObj.getMinute();
							objectRepeat.add(new DateComponent (yearObj, monthObj, dayObj, weekdayObj, hourItem, minuteItem));
						}
					}
					super.onBackPressed();
				}
				else {
					Toast.makeText(getApplicationContext(), "You do not fill in all fields!", Toast.LENGTH_SHORT).show();
				}
				break;
			case 16:
				if (noclickMonthObj!=true && clickMonthObj!=true) {
					monthObj++;
				}
				EditText yearForm=(EditText) findViewById(R.id.year);
				Editable yearEdit=yearForm.getText();
				String year=yearEdit.toString()+"";
				monthForm=(EditText) findViewById(R.id.month);
		    	monthEdit=monthForm.getText();
		    	month=monthEdit.toString()+"";
				if (month!="" && year!="" && objectRepeatTime.size()!=0) {
					objectRepeat.clear();
					int sizeTimes=objectRepeatTime.size();
					for (int q=0; q<sizeTimes; q++) {
						Object item=(Object) objectRepeatTime.get(q);
						if (item instanceof DateComponentRepeatTimeconstructor) {
							DateComponentRepeatTimeconstructor itemObj=(DateComponentRepeatTimeconstructor) item;
							int hourItem=itemObj.getHour();
							int minuteItem=itemObj.getMinute();
							objectRepeat.add(new DateComponent (yearObj, monthObj, dayObj, weekdayObj, hourItem, minuteItem));
						}
					}
					super.onBackPressed();
				}
				else {
					Toast.makeText(getApplicationContext(), "You do not fill in all fields!", Toast.LENGTH_SHORT).show();
				}
				break;
		}
	}
	public ArrayList<DateComponent> getObjRepeat() {
		return objectRepeat;
	}
	public ArrayList<DateComponentIntentObject> getObjIntent() {
		return objectIntent;
	}
	public void setObjIntentClear() {
		objectIntent.clear();
	}
	public void setObjRepeatClear() {
		objectRepeat.clear();
	}
}