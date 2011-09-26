package com.hospital.activity;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import com.hospital.activity.item.EntryAdapterTreatments;
import com.hospital.activity.item.Item;
import com.hospital.activity.item.SectionItem;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
public class TwoTab extends ListActivity {
	private static ArrayList<Item> items=new ArrayList<Item>();
	int itemSeverity;
	/** called when the activity is first created */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs_listview);
		
		Button profileButton = (Button)findViewById(R.id.profileButton);
		profileButton.getBackground().setColorFilter(0x99676f5d, PorterDuff.Mode.MULTIPLY);
		Button logoutButton = (Button)findViewById(R.id.logoutButton);
		logoutButton.getBackground().setColorFilter(0x99676f5d, PorterDuff.Mode.MULTIPLY);
		
		TwoTabObject.items.clear();
		TwoTabObject.items.add(new SectionItem(TreatmentsItem.outSections(1)));
		TwoTabObject.items.add(new SectionItem(TreatmentsItem.outSections(2)));
		TwoTabObject.items.add(new SectionItem(TreatmentsItem.outSections(3)));
		// SQLITE-query (begin)
		TreatmentsLauncher parentActivity=(TreatmentsLauncher) getParent();
		SQLiteHelper dbOpenHelper=new SQLiteHelper(parentActivity);
		SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
		Cursor objectTreatment=db.query("treatments", null, null, null, null, null, null);
		int dbId;
		int dbSection;
		String dbName;
		String dbDescription;
		String dbStartdate;
		Date dbStartdateConvert=null;
		String dbEnddate;
		Date dbEnddateConvert=null;
		String dbLastupdate;
		Date dbLastupdateConvert=null;
		int dbRepeatdate;
		int dbSeverity;
		int dbType;
		String dbStrength;
		int dbSystem;
		Boolean check=objectTreatment.moveToFirst();
		if (check==true) {
			SimpleDateFormat formatter=new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
			SimpleDateFormat formatterLD=new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.ENGLISH);
			do {
				dbId=objectTreatment.getInt(0);
				dbSection=objectTreatment.getInt(1);
				dbName=objectTreatment.getString(2);
				dbDescription=objectTreatment.getString(3);
				dbStartdate=objectTreatment.getString(4);
				try {
					dbStartdateConvert=formatter.parse(dbStartdate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				dbEnddate=objectTreatment.getString(5);
				try {
					dbEnddateConvert=formatter.parse(dbEnddate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dbLastupdate=objectTreatment.getString(6);
				try {
					dbLastupdateConvert=formatterLD.parse(dbLastupdate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dbRepeatdate=objectTreatment.getInt(7);
				Cursor objectOccasions=db.query("occasions", null, "event_id="+dbId, null, null, null, null);
				ArrayList<DateComponent> repeatTimes=new ArrayList<DateComponent>();
				int dbTypeThis;
				int dbYear;
				int dbMonth;
				int dbDay;
				int dbWeekday;
				int dbHour;
				int dbMinute;
				objectOccasions.moveToFirst();
				do {
					dbTypeThis=objectOccasions.getInt(3);
					if (dbTypeThis==2) {
						dbYear=objectOccasions.getInt(4);
						dbMonth=objectOccasions.getInt(5);
						dbWeekday=objectOccasions.getInt(6);
						dbDay=objectOccasions.getInt(7);
						dbHour=objectOccasions.getInt(8);
						dbMinute=objectOccasions.getInt(9);
						repeatTimes.add(new DateComponent (dbYear, dbMonth, dbDay, dbWeekday, dbHour, dbMinute));
					}
				}
				while (objectOccasions.moveToNext());
				dbSeverity=objectTreatment.getInt(8);
				dbType=objectTreatment.getInt(9);
				dbStrength=objectTreatment.getString(10);
				dbSystem=objectTreatment.getInt(11);
				TwoTabObject.items.add(new TreatmentsItem(dbName, dbDescription, dbStartdateConvert, dbEnddateConvert, dbSection, dbRepeatdate, repeatTimes, dbSeverity, dbLastupdateConvert, dbId, dbType, dbStrength, dbSystem));			
	        }
			while (objectTreatment.moveToNext());
		}
		db.close();
		// SQLITE-query (end)
		items=Main.getItemsObject(2);
		EntryAdapterTreatments adapter=new EntryAdapterTreatments(this, items);
		setListAdapter(adapter);
	}
	public static ArrayList<Item> outputObject() {
		return items;
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		if (!items.get(position).isSection()) {
			Locale local=new Locale("en", "EN");
			DateFormat df=DateFormat.getDateInstance(DateFormat.DEFAULT, local);
			TreatmentsItem item=(TreatmentsItem) items.get(position);
			Intent intent=new Intent(getParent(), TreatmentOutput.class);
			Bundle b=new Bundle();
			int ident=position;
			b.putInt("defStrIdent", ident);
			String itemTitle=item.title;
			b.putString("defStrTitle", itemTitle);
			String itemSubtitle=item.subtitle;
			b.putString("defStrSubtitle", itemSubtitle);
			Date itemStartDateTemp=item.startDate;
			String itemStartDate=df.format(itemStartDateTemp);
			b.putString("defStrStartDate", itemStartDate);
			Date itemEndDateTemp=item.endDate;
			String itemEndDate=df.format(itemEndDateTemp);
			b.putString("defStrEndDate", itemEndDate);
			int itemIdSection=item.idSection;
			b.putInt("defStrIdSection", itemIdSection);
			int itemRepeat=item.repeat;
			b.putInt("defStrRepeat", itemRepeat);
			int itemSeverity=item.severity;
			b.putInt("defStrSeverity", itemSeverity);
			Date itemLastUpdateDateTemp=item.lastUpdateDate;
			String itemLastUpdateDate=df.format(itemLastUpdateDateTemp);
			b.putString("defStrLastUpdateDate", itemLastUpdateDate);
			int itemID=item.ID;
			b.putInt("defStrID", itemID);
			int itemTreatmentType=item.treatmentType;
			b.putInt("defStrTreatmentType", itemTreatmentType);
			String itemTreatmentStrength=item.treatmentStrength;
			b.putString("defStrTreatmentStrength", itemTreatmentStrength);
			int itemTreatmentSystem=item.medicalSystem;
			b.putInt("defStrTreatmentSystem", itemTreatmentSystem);
			intent.putExtras(b);
			TreatmentEditObj.transitionTwotab=true;
			TreatmentsLauncher parentActivity=(TreatmentsLauncher) getParent();
	    	parentActivity.startChildActivity("Treatment_output", intent);
		}
	}
	public void profile_button(View target) {
		Intent intent=new Intent(getParent(), Profile.class);
		Bundle bundle=new Bundle();
		bundle.putInt("defStrIDTab", 2);
		intent.putExtras(bundle);
		TreatmentsLauncher parentActivity=(TreatmentsLauncher) getParent();
    	parentActivity.startChildActivity("Profile", intent);
	}
	public void logout_button(View target) {

	}
	public void add_form(View target) {
		Intent intent=new Intent(getParent(), TreatmentAddForm.class);
		Button b=(Button) target;
		Integer sectionObj=(Integer) b.getTag();
		int section=sectionObj.intValue();
		Bundle bundle=new Bundle();
		int ident=section+1;
		bundle.putInt("defStrIdent", ident);
		intent.putExtras(bundle);
		TreatmentAddForm.transitionTwotab=true;
		TreatmentsLauncher parentActivity=(TreatmentsLauncher) getParent();
    	parentActivity.startChildActivity("Treatment_add_form", intent);
	}
}