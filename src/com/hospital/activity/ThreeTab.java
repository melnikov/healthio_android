package com.hospital.activity;
import java.util.ArrayList;
import com.hospital.activity.item.EntryAdapterProviders;
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
public class ThreeTab extends ListActivity {
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
		
		ThreeTabObject.items.clear();
		ThreeTabObject.items.add(new SectionItem(ProvidersItem.outSections(1)));
		ThreeTabObject.items.add(new SectionItem(ProvidersItem.outSections(2)));
		ThreeTabObject.items.add(new SectionItem(ProvidersItem.outSections(3)));
		// SQLITE-query (begin)
		ProvidersLauncher parentActivity=(ProvidersLauncher) getParent();
		SQLiteHelper dbOpenHelper=new SQLiteHelper(parentActivity);
		SQLiteDatabase db=dbOpenHelper.getReadableDatabase();
		Cursor objectProvider=db.query("providers", null, null, null, null, null, null);
		int dbId;
		int dbSection;
		String dbName;
		int dbSpecialty;
		String dbAffiliation;
		String dbCityname;
		String dbPhone;
		String dbFax;
		String dbEmail;
		int dbRating;
		Boolean check=objectProvider.moveToFirst();
		if (check==true) {
			do {
				dbId=objectProvider.getInt(0);
				dbSection=objectProvider.getInt(1);
				dbName=objectProvider.getString(2);
				dbSpecialty=objectProvider.getInt(3);
				dbAffiliation=objectProvider.getString(4);
				dbCityname=objectProvider.getString(5);
				dbPhone=objectProvider.getString(6);
				dbFax=objectProvider.getString(7);
				dbEmail=objectProvider.getString(8);
				dbRating=objectProvider.getInt(9);
				ThreeTabObject.items.add(new ProvidersItem(dbName, dbSection, dbSpecialty, dbAffiliation, dbCityname, dbPhone, dbFax, dbEmail, dbRating, dbId));			
	        }
			while (objectProvider.moveToNext());
		}
		db.close();
		// SQLITE-query (end)
		items=Main.getItemsObject(3);
		EntryAdapterProviders adapter=new EntryAdapterProviders(this, items);
		setListAdapter(adapter);
	}
	public static ArrayList<Item> outputObject() {
		return items;
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		if (!items.get(position).isSection()) {			
			ProvidersItem item=(ProvidersItem) items.get(position);
			Intent intent=new Intent(getParent(), ProviderOutput.class);
			Bundle b=new Bundle();
			int ident=position;
			b.putInt("defStrIdent", ident);
			String itemTitle=item.title;
			b.putString("defStrTitle", itemTitle);
			int itemSpecialty=item.specialty;
			b.putInt("defStrSpecialty", itemSpecialty);
			String itemAffiliation=item.affiliation;
			b.putString("defStrAffiliation", itemAffiliation);
			String itemCityName=item.cityName;
			b.putString("defStrCityName", itemCityName);
			String itemPhone=item.phone;
			b.putString("defStrPhone", itemPhone);
			String itemFax=item.fax;
			b.putString("defStrFax", itemFax);
			String itemEmail=item.email;
			b.putString("defStrEmail", itemEmail);
			float itemRating=item.rating;
			b.putFloat("defStrRating", itemRating);
			int itemID=item.ID;
			b.putInt("defStrID", itemID);
			intent.putExtras(b);
			ProvidersLauncher parentActivity=(ProvidersLauncher) getParent();
	    	parentActivity.startChildActivity("Provider_output", intent);
		}
	}
	public void profile_button(View target) {
		Intent intent=new Intent(getParent(), Profile.class);
		Bundle bundle=new Bundle();
		bundle.putInt("defStrIDTab", 3);
		intent.putExtras(bundle);
		ProvidersLauncher parentActivity=(ProvidersLauncher) getParent();
    	parentActivity.startChildActivity("Profile", intent);
	}
	public void logout_button(View target) {

	}
	public void add_form(View target) {
		Intent intent=new Intent(getParent(), ProviderAddForm.class);
		Button b=(Button) target;
		Integer sectionObj=(Integer) b.getTag();
		int section=sectionObj.intValue();
		Bundle bundle=new Bundle();
		int ident=section+1;
		bundle.putInt("defStrIdent", ident);
		intent.putExtras(bundle);
		ProvidersLauncher parentActivity=(ProvidersLauncher) getParent();
    	parentActivity.startChildActivity("Provider_add_form", intent);
	}
}