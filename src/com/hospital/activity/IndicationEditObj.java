package com.hospital.activity;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import com.hospital.activity.item.Item;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
public class IndicationEditObj extends Activity implements SeekBar.OnSeekBarChangeListener {
	Intent intent;
	Bundle bundle;
	int identIntent=0;
	String titleIntent="";
	String subtitleIntent="";
	String startDateIntent="";
	String endDateIntent="";
	int repeatIntent=0;
	private int repeatIntentDefault=0;
	private int repeatTempID=0;
	int severityIntent=0;
	int IDIntent=0;
	TextView mTextSeverity;
	private EditText startdate;
	private EditText enddate;
	private EditText repeat;
	private int mYear;
	private int mMonth;
	private int mDay;
	private static final int DATE_DIALOG_ID=0;
	private static final int REPEAT_DIALOG_ID=1;
	private int flagChoise=0;
	public static boolean transitionOnetab;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.indication_edit_object);
		//int ppp=5*5-5*5/0;
		final Calendar c=Calendar.getInstance();
		mYear=c.get(Calendar.YEAR);
		mMonth=c.get(Calendar.MONTH);
		mDay=c.get(Calendar.DAY_OF_MONTH);
		intent=getIntent();
		bundle=intent.getExtras();
		if (bundle!=null) {
			identIntent=bundle.getInt("defStrIdent");
			titleIntent=bundle.getString("defStrTitle");
			subtitleIntent=bundle.getString("defStrSubtitle");
			startDateIntent=bundle.getString("defStrStartDate");
			endDateIntent=bundle.getString("defStrEndDate");
			repeatIntent=bundle.getInt("defStrRepeat");
			severityIntent=bundle.getInt("defStrSeverity");
			IDIntent=bundle.getInt("defStrID");
		}
		// get data from class DateComponentIntent (begin)
		DateComponentIntentIndication repeatInt=new DateComponentIntentIndication();
		ArrayList<DateComponent> repeatObject=repeatInt.getObjRepeat();
		if (transitionOnetab==true) {
			repeatInt.setObjRepeatClear();
		}
		if (repeatObject.size()!=0) {
			ArrayList<DateComponentIntentObject> repeatIntObj=repeatInt.getObjIntent();
			titleIntent=repeatIntObj.get(0).getName();
			subtitleIntent=repeatIntObj.get(0).getDescription();
			startDateIntent=repeatIntObj.get(0).getStarts();
			endDateIntent=repeatIntObj.get(0).getEnds();
			repeatIntent=repeatIntObj.get(0).getRepeat();
			severityIntent=repeatIntObj.get(0).getSeverity();
			// set default values (begin)
			EditText title=(EditText) findViewById(R.id.title);
			title.setText(titleIntent);
			EditText subtitle=(EditText) findViewById(R.id.subtitle);
			subtitle.setText(subtitleIntent);
			startdate=(EditText) findViewById(R.id.startdate);
			startdate.setText(startDateIntent);
			enddate=(EditText) findViewById(R.id.enddate);
			enddate.setText(endDateIntent);
			mTextSeverity=(TextView) findViewById(R.id.severity_out);
			final SeekBar seekbar=(SeekBar) findViewById(R.id.severity);
			seekbar.setMax(101);
			seekbar.setProgress(severityIntent+1);
	        if (severityIntent>=0) {
	        	mTextSeverity.setText(severityIntent+"%");
	        }
	        else {
	        	String noset=getResources().getString(R.string.severity_noset);
	        	mTextSeverity.setText(noset);
	        }
			// set default values (end)
		}
		// get data from class DateComponentIntent (end)
		EditText title=(EditText) findViewById(R.id.title);
		title.setText(titleIntent);
		EditText subtitle=(EditText) findViewById(R.id.subtitle);
		subtitle.setText(subtitleIntent);
		startdate=(EditText) findViewById(R.id.startdate);
		startdate.setText(startDateIntent);
		startdate.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				showDialog(DATE_DIALOG_ID);
				flagChoise=1;
				return false;
			}
		});
		enddate=(EditText) findViewById(R.id.enddate);
		enddate.setText(endDateIntent);
		enddate.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				showDialog(DATE_DIALOG_ID);
				flagChoise=2;
				return false;
			}
		});
		// repeat (begin)
		repeat=(EditText) findViewById(R.id.repeat);
		switch (repeatIntent) {
			case 0:
				repeat.setText("Once");
				repeatIntentDefault=0;
				break;
			case 2:
				repeat.setText("Daily");
				repeatIntentDefault=1;
				break;
			case 4:
				repeat.setText("Weekly");
				repeatIntentDefault=2;
				break;
			case 8:
				repeat.setText("Montly");
				repeatIntentDefault=3;
				break;
			case 16:
				repeat.setText("Yearly");
				repeatIntentDefault=4;
				break;
		}
		repeat.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				showDialog(REPEAT_DIALOG_ID);
				return false;
			}
		});
		// repeat (end)
		mTextSeverity=(TextView) findViewById(R.id.severity_out);
		final SeekBar seekbar=(SeekBar) findViewById(R.id.severity);
        seekbar.setOnSeekBarChangeListener(this);
        seekbar.setMax(101);
        seekbar.setProgress(severityIntent+1);
        if (severityIntent>=0) {
        	mTextSeverity.setText(severityIntent+"%");
        }
        else {
        	String noset=getResources().getString(R.string.severity_noset);
        	mTextSeverity.setText(noset);
        }
	}
	public void submit(View target) throws ParseException {
		ArrayList<Item> onetabObject=OneTab.outputObject();
		IndicationsItem element=(IndicationsItem) onetabObject.get(identIntent);
		SimpleDateFormat formatter=new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
		element.lastUpdateDate=new Date();
		EditText titleForm=(EditText) findViewById(R.id.title);
    	Editable titleEdit=titleForm.getText();
    	String title=titleEdit.toString()+"";
		EditText subtitleForm=(EditText) findViewById(R.id.subtitle);
    	Editable subtitleEdit=subtitleForm.getText();
    	String subtitle=subtitleEdit.toString()+"";
		EditText startDateForm=(EditText) findViewById(R.id.startdate);
    	Editable startDateEdit=startDateForm.getText();
    	String startDateTemp=startDateEdit.toString();
    	Date startDate=formatter.parse(startDateTemp);
		EditText endDateForm=(EditText) findViewById(R.id.enddate);
    	Editable endDateEdit=endDateForm.getText();
    	String endDateTemp=endDateEdit.toString();
    	Date endDate=formatter.parse(endDateTemp);
		SeekBar severityForm=(SeekBar) findViewById(R.id.severity);
		int severity=severityForm.getProgress()-1;
		long numStartdate=startDate.getTime();
		long numEnddate=endDate.getTime();
		if (title=="" || subtitle=="" || startDate==null || endDate==null || numStartdate>numEnddate) {
			Toast.makeText(getApplicationContext(), "You do not fill in all fields!", Toast.LENGTH_SHORT).show();
		}
		else {
			DateComponentIntentIndication repeat=new DateComponentIntentIndication();
			ArrayList<DateComponent> repeatObject=repeat.getObjRepeat();
			if (repeatObject.size()!=0) {
				element.repeat=repeatIntent;
				element.repeatTimes=new ArrayList<DateComponent> (repeatObject);
				repeat.setObjRepeatClear();
				repeat.setObjIntentClear();
			}
			element.title=title;
			element.subtitle=subtitle;
			element.startDate=startDate;
			element.endDate=endDate;
			element.severity=severity;
			onetabObject.set(identIntent, element);
			// SQLITE-query (begin)
			IndicationsLauncher parentActivity=(IndicationsLauncher) getParent();
			SQLiteHelper dbOpenHelper=new SQLiteHelper(parentActivity);
			SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
			ContentValues cv=new ContentValues();
			cv.put("name", title);
			cv.put("description", subtitle);
			cv.put("startdate", startDateTemp);
			cv.put("enddate", endDateTemp);
			SimpleDateFormat formatterLD=new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.ENGLISH);
			String lastUpdateDateDB=formatterLD.format(new Date());
			cv.put("lastupdate", lastUpdateDateDB);
			cv.put("repeatdate", repeatIntent);
			cv.put("severity", severity);
			cv.put("repeattime", "");
			cv.put("local_id", -1);
			db.update("indications", cv, "id="+IDIntent, null);
			String whereSelectID=IDIntent+"";
			String[] whereSelect=new String[] {whereSelectID, "1"};
			db.delete("occasions", "event_id=? and type=? ", whereSelect);
			int countRepeatTimesDB=element.repeatTimes.size();
			for (int i=0; i<countRepeatTimesDB; i++) {
				DateComponent repeatTimesDB=element.repeatTimes.get(i);
				cv=new ContentValues();
				cv.put("local_id", -1);
				cv.put("uid", 1);
				cv.put("type", 1);
				cv.put("year", repeatTimesDB.getYear());
				cv.put("month", repeatTimesDB.getMonth());
				cv.put("weekday", repeatTimesDB.getWeekday());
				cv.put("day", repeatTimesDB.getDay());
				cv.put("hour", repeatTimesDB.getHour());
				cv.put("minute", repeatTimesDB.getMinute());
				cv.put("event_id", IDIntent);
				db.insertOrThrow("occasions", null, cv);
			}
			db.close();
			// SQLITE-query (end)
			super.onBackPressed();
			super.onBackPressed();
		}
	}
	private void updateStartdate() {
		Locale local=new Locale("en", "EN");
		DateFormat df=DateFormat.getDateInstance(DateFormat.DEFAULT, local);
		Date date=new Date(mYear-1900, mMonth, mDay);
		String dateFormat=df.format(date);
		startdate.setText(dateFormat);
	}
	private void updateEnddate() {
		Locale local=new Locale("en", "EN");
		DateFormat df=DateFormat.getDateInstance(DateFormat.DEFAULT, local);
		Date date=new Date(mYear-1900, mMonth, mDay);
		String dateFormat=df.format(date);
		enddate.setText(dateFormat);
	}
	private DatePickerDialog.OnDateSetListener mDateSetListener=new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			mYear=year;
			mMonth=monthOfYear;
			mDay=dayOfMonth;
			switch (flagChoise) {
				case 1:
					updateStartdate();
					break;
				case 2:
					updateEnddate();
					break;
			}
		}
	};
	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog tmp=null;
		switch (id) {
			case DATE_DIALOG_ID:
				tmp=new DatePickerDialog(getParent(), mDateSetListener, mYear, mMonth, mDay);
				return tmp;
			case REPEAT_DIALOG_ID:
				IndicationsLauncher parentActivity=(IndicationsLauncher) getParent();
				DateComponentRepeat repeatObj=new DateComponentRepeat();
				final ArrayList<String> repeatArray=repeatObj.repeatOutput();
				String[] arrayElements;
				arrayElements=new String[repeatArray.size()];
				for(int i=0; i<repeatArray.size(); i++) {
					arrayElements[i]=repeatArray.get(i);
				}
				final CharSequence[] items=arrayElements;
				AlertDialog.Builder alert=new AlertDialog.Builder(parentActivity);
				alert.setTitle("Select a repeat");
				alert.setSingleChoiceItems(items, repeatIntentDefault, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int item) {
					    switch (item) {
				    		case 0:
				    			repeatTempID=0;
				    			break;
				    		case 1:
				    			repeatTempID=2;
				    			break;
				    		case 2:
				    			repeatTempID=4;
				    			break;
				    		case 3:
				    			repeatTempID=8;
				    			break;
				    		case 4:
				    			repeatTempID=16;
				    			break;
				    	}
						Intent intent=new Intent(getParent(), DateComponentIntentIndication.class);
						Bundle bundle=new Bundle();
						bundle.putInt("defStrIDObjectTimes", identIntent);
						int ident=repeatTempID;
						bundle.putInt("defStrIdent", ident);
						EditText titleForm=(EditText) findViewById(R.id.title);
				    	Editable titleEdit=titleForm.getText();
				    	String title=titleEdit.toString()+"";
						bundle.putString("defStrName", title);
						EditText subtitleForm=(EditText) findViewById(R.id.subtitle);
				    	Editable subtitleEdit=subtitleForm.getText();
				    	String subtitle=subtitleEdit.toString()+"";
				    	bundle.putString("defStrDescription", subtitle);
						EditText startDateForm=(EditText) findViewById(R.id.startdate);
				    	Editable startDateEdit=startDateForm.getText();
				    	String startDate=startDateEdit.toString()+"";
				    	bundle.putString("defStrStarts", startDate);
				    	EditText endDateForm=(EditText) findViewById(R.id.enddate);
				    	Editable endDateEdit=endDateForm.getText();
				    	String endDate=endDateEdit.toString();
				    	bundle.putString("defStrEnds", endDate);
				    	bundle.putInt("defStrRepeat", repeatTempID);
				    	SeekBar severityForm=(SeekBar) findViewById(R.id.severity);
						int severity=severityForm.getProgress()-1;
						bundle.putInt("defStrSeverity", severity);
						intent.putExtras(bundle);
						IndicationsLauncher parentActivity=(IndicationsLauncher) getParent();
				    	parentActivity.startChildActivity("Date_component_intent", intent);
					    dialog.cancel();
					}
				});
				tmp=alert.create();
				return tmp;
		}
		return tmp;
	}
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		// TODO Auto-generated method stub
		String noset=getResources().getString(R.string.severity_noset);
		int valueChange=seekBar.getProgress()-1;
		if (valueChange>=0) {
			mTextSeverity.setText(String.valueOf(valueChange+"%"));
		}
		else {
			mTextSeverity.setText(noset);
		}
	}
	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
	}
	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		String noset=getResources().getString(R.string.severity_noset);
		int valueChange=seekBar.getProgress()-1;
		if (valueChange>=0) {
			mTextSeverity.setText(String.valueOf(valueChange+"%"));
		}
		else {
			mTextSeverity.setText(noset);
		}
	}
    @Override
    public void onBackPressed() {

    }
}