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
public class IndicationAddForm extends Activity implements SeekBar.OnSeekBarChangeListener {
	Intent intent;
	Bundle bundle;
	int identIntent=0;
	String titleIntent="";
	String subtitleIntent="";
	String startDateIntent="";
	String endDateIntent="";
	int repeatIntent=-1;
	private int repeatIntentDefault=0;
	private int repeatTempID=0;
	int severityIntent=-1;
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
	/** called when the activity is first created */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.indication_add_form);
        intent=getIntent();
		bundle=intent.getExtras();
		if (bundle!=null) {
			identIntent=bundle.getInt("defStrIdent");
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
			// set default values (end);
		}
		// get data from class DateComponentIntent (end)
		final Calendar c=Calendar.getInstance();
		mYear=c.get(Calendar.YEAR);
		mMonth=c.get(Calendar.MONTH);
		mDay=c.get(Calendar.DAY_OF_MONTH);
		startdate=(EditText) findViewById(R.id.startdate);
		startdate.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				showDialog(DATE_DIALOG_ID);
				flagChoise=1;
				return false;
			}
		});
		enddate=(EditText) findViewById(R.id.enddate);
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
			default:
				repeat.setText("None");
				repeatIntentDefault=-1;
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
        if (severityIntent==-1) {
	        String noset=getResources().getString(R.string.severity_noset);
	        mTextSeverity.setText(noset);
        }
	}
	public void submit(View target) throws ParseException {
		ArrayList<Item> onetabObject=OneTabObject.items;
		SimpleDateFormat formatter=new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
		Date lastUpdateDate=new Date();
		int idSection=identIntent;
		int lengthItems=onetabObject.size();
		int maxID=0;
		for (int i=0; i<lengthItems; i++) {
			Object item=(Object) onetabObject.get(i);
			if (item instanceof IndicationsItem) {
				IndicationsItem itemObj=(IndicationsItem) item;
				if (itemObj.ID>maxID) {
					maxID=itemObj.ID;
				}
			}
		}
		int ID=maxID+1;
		EditText titleForm=(EditText) findViewById(R.id.title);
    	Editable titleEdit=titleForm.getText();
    	String title=titleEdit.toString();
		EditText subtitleForm=(EditText) findViewById(R.id.subtitle);
    	Editable subtitleEdit=subtitleForm.getText();
    	String subtitle=subtitleEdit.toString();
		EditText startDateForm=(EditText) findViewById(R.id.startdate);
    	Editable startDateEdit=startDateForm.getText();
    	String startDateTemp=startDateEdit.toString()+"";
    	Date startDate=null;
    	if (startDateTemp!="") {
    		startDate=formatter.parse(startDateTemp);
    	}
		EditText endDateForm=(EditText) findViewById(R.id.enddate);
    	Editable endDateEdit=endDateForm.getText();
    	String endDateTemp=endDateEdit.toString()+"";
    	Date endDate=null;
    	if (endDateTemp!="") {
    		endDate=formatter.parse(endDateTemp);
    	}
    	int repeat=repeatIntent;
		SeekBar severityForm=(SeekBar) findViewById(R.id.severity);
		int severity=severityForm.getProgress()-1;
		long numStartdate;
		if (startDate!=null) numStartdate=startDate.getTime(); else numStartdate = -1;
		long numEnddate;
		
		if (endDate!=null) numEnddate=endDate.getTime(); else numEnddate = -1;
		if (title=="" || subtitle=="" || startDate==null || endDate==null || repeatIntent==-1 || numStartdate>numEnddate) {
			Toast.makeText(getApplicationContext(), "You do not fill in all fields!", Toast.LENGTH_SHORT).show();
		}
		else {
			DateComponentIntentIndication repeatThis=new DateComponentIntentIndication();
			ArrayList<DateComponent> repeatObject=repeatThis.getObjRepeat();
			ArrayList<DateComponent> repeatTimes=new ArrayList<DateComponent> (repeatObject);
			repeatThis.setObjRepeatClear();
			repeatThis.setObjIntentClear();
			onetabObject.add(new IndicationsItem(title, subtitle, startDate, endDate, idSection, repeat, repeatTimes, severity, lastUpdateDate, ID));
			// SQLITE-query (begin)
			IndicationsLauncher parentActivity=(IndicationsLauncher) getParent();
			SQLiteHelper dbOpenHelper=new SQLiteHelper(parentActivity);
			SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
			ContentValues cv=new ContentValues();
			cv.put("id", ID);
			cv.put("section", idSection);
			cv.put("name", title);
			cv.put("description", subtitle);
			cv.put("startdate", startDateTemp);
			cv.put("enddate", endDateTemp);
			SimpleDateFormat formatterLD=new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.ENGLISH);
			String lastUpdateDateDB=formatterLD.format(lastUpdateDate);
			cv.put("lastupdate", lastUpdateDateDB);
			cv.put("repeatdate", repeat);
			cv.put("severity", severity);
			cv.put("repeattime", "");
			cv.put("uid", 1);
			cv.put("local_id", -1);
			db.insertOrThrow("indications", null, cv);
			int countRepeatTimesDB=repeatTimes.size();
			for (int i=0; i<countRepeatTimesDB; i++) {
				DateComponent repeatTimesDB=repeatTimes.get(i);
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
				cv.put("event_id", ID);  
				db.insertOrThrow("occasions", null, cv);
			}
			db.close();
			// SQLITE-query (end)
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
				    	bundle.putInt("defStrRepeat", ident);
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
}