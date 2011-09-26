package com.hospital.activity;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import com.hospital.activity.item.EntryAdapterIndications;
import com.hospital.activity.item.Item;
import com.hospital.activity.item.SectionItem;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.graphics.*;
import com.cleardb.app.ClearDBQueryException;
import com.cleardb.app.Client;
import org.json.JSONObject;
import org.json.JSONArray;

public class OneTab extends ListActivity {
	private static ArrayList<Item> items=new ArrayList<Item>();
	/** called when the activity is first created */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs_listview);
		Button profileButton = (Button)findViewById(R.id.profileButton);
		profileButton.getBackground().setColorFilter(0x99676f5d, PorterDuff.Mode.MULTIPLY);
		Button logoutButton = (Button)findViewById(R.id.logoutButton);
		logoutButton.getBackground().setColorFilter(0x99676f5d, PorterDuff.Mode.MULTIPLY);
		

		OneTabObject.items.clear();
		OneTabObject.items.add(new SectionItem(IndicationsItem.outSections(1)));
		OneTabObject.items.add(new SectionItem(IndicationsItem.outSections(2)));
		OneTabObject.items.add(new SectionItem(IndicationsItem.outSections(3)));
		// SQLITE-query (begin)
		IndicationsLauncher parentActivity=(IndicationsLauncher) getParent();
		
		final String APP_ID = "75da3799f73fefd792878edeeaab99b2"; // replace with your App ID.
		final String API_KEY = "0261d80eb8a87724fdccca700d9bd01472ad6dcd"; // replace with your API Key.
		
		com.cleardb.app.Client cleardbClient = new com.cleardb.app.Client(API_KEY, APP_ID);
		
		try {
			JSONObject payload = cleardbClient.query("SELECT * FROM indications where uid = 46");
			JSONArray response = payload.getJSONArray("response");
			for (int i=0;i<response.length();i++){   
				JSONObject user = response.getJSONObject(i);
				
				int dbId = user.getInt("local_id");
				int dbSection = user.getInt("section");
				String dbName = user.getString("name");
				String dbDescription = user.getString("description");
				String dbStartdate = user.getString("startdate").replace("*", "+");
				
				SimpleDateFormat curFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
	        	
				Date dbStartdateConvert=curFormater.parse(dbStartdate);
				String dbEnddate = user.getString("enddate").replace("*", "+");
				Date dbEnddateConvert= (dbEnddate!="null")?curFormater.parse(dbEnddate):null;
				String dbLastupdate= user.getString("lastupdate").replace("*", "+");
				Date dbLastupdateConvert=(dbLastupdate!="null")?curFormater.parse(dbLastupdate):new Date();
				int dbRepeatdate = user.getInt("repeatdate");
				int dbSeverity = user.getInt("severity");
				ArrayList<DateComponent> repeatTimes = new ArrayList<DateComponent>();
				IndicationsItem item = new IndicationsItem(dbName, dbDescription, dbStartdateConvert, dbEnddateConvert, dbSection, dbRepeatdate, repeatTimes, dbSeverity, dbLastupdateConvert, dbId);
				OneTabObject.items.add(item);
			}
		} catch (ClearDBQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		SQLiteHelper dbOpenHelper=new SQLiteHelper(parentActivity);
		SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
		Cursor objectIndication=db.query("indications", null, null, null, null, null, null);
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
		Boolean check=objectIndication.moveToFirst();
		if (check==true) {
			SimpleDateFormat formatter=new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
			SimpleDateFormat formatterLD=new SimpleDateFormat("MMM dd, yyyy HH:mm", Locale.ENGLISH);
			do {
				dbId=objectIndication.getInt(0);
				dbSection=objectIndication.getInt(1);
				dbName=objectIndication.getString(2);
				dbDescription=objectIndication.getString(3);
				dbStartdate=objectIndication.getString(4);
				try {
					dbStartdateConvert=formatter.parse(dbStartdate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				dbEnddate=objectIndication.getString(5);
				try {
					dbEnddateConvert=formatter.parse(dbEnddate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dbLastupdate=objectIndication.getString(6);
				try {
					dbLastupdateConvert=formatterLD.parse(dbLastupdate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dbRepeatdate=objectIndication.getInt(7);
				Cursor objectOccasions=db.query("occasions", null, "event_id="+dbId, null, null, null, null);
				ArrayList<DateComponent> repeatTimes=new ArrayList<DateComponent>();
				int dbType;
				int dbYear;
				int dbMonth;
				int dbDay;
				int dbWeekday;
				int dbHour;
				int dbMinute;
				objectOccasions.moveToFirst();
				do {
					dbType=objectOccasions.getInt(3);
					if (dbType==1) {
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
				dbSeverity=objectIndication.getInt(8);
				OneTabObject.items.add(new IndicationsItem(dbName, dbDescription, dbStartdateConvert, dbEnddateConvert, dbSection, dbRepeatdate, repeatTimes, dbSeverity, dbLastupdateConvert, dbId));			
	        }
			while (objectIndication.moveToNext());
		}
		db.close();*/
		// SQLITE-query (end)
		items=Main.getItemsObject(1);
		EntryAdapterIndications adapter=new EntryAdapterIndications(this, items);
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
			IndicationsItem item=(IndicationsItem) items.get(position);
			Intent intent=new Intent(getParent(), IndicationOutput.class);
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
			intent.putExtras(b);
			IndicationEditObj.transitionOnetab=true;
			IndicationsLauncher parentActivity=(IndicationsLauncher) getParent();
	    	parentActivity.startChildActivity("Indication_output", intent);
		}
	}
	public void profile_button(View target) {
		Intent intent=new Intent(getParent(), Profile.class);
		Bundle bundle=new Bundle();
		bundle.putInt("defStrIDTab", 1);
		intent.putExtras(bundle);
		IndicationsLauncher parentActivity=(IndicationsLauncher) getParent();
    	parentActivity.startChildActivity("Profile", intent);
	}
	public void logout_button(View target) {

	}
	public void add_form(View target) {
		Intent intent=new Intent(getParent(), IndicationAddForm.class);
		Button b=(Button) target;
		Integer sectionObj=(Integer) b.getTag();
		int section=sectionObj.intValue();
		Bundle bundle=new Bundle();
		int ident=section+1;
		bundle.putInt("defStrIdent", ident);
		intent.putExtras(bundle);
		IndicationAddForm.transitionOnetab=true;
		IndicationsLauncher parentActivity=(IndicationsLauncher) getParent();
    	parentActivity.startChildActivity("Indication_add_form", intent);
	}
}