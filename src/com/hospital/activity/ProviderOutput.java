package com.hospital.activity;
import java.util.ArrayList;
import com.hospital.activity.item.Item;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class ProviderOutput extends Activity {
	Intent intent;
	Bundle bundle;
	int identIntent=0;
	String titleIntent="";
	int specialtyIntent=0;
	String affiliationIntent="";
	String cityNameIntent="";
	String phoneIntent="";
	String faxIntent="";
	String emailIntent="";
	float ratingIntent=0;
	private int IDIntent=0;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.provider_output);
        intent=getIntent();
    	bundle=intent.getExtras();
    	if (bundle!=null) {
    		identIntent=bundle.getInt("defStrIdent");
    		titleIntent=bundle.getString("defStrTitle");
    		specialtyIntent=bundle.getInt("defStrSpecialty");
    		affiliationIntent=bundle.getString("defStrAffiliation");
    		cityNameIntent=bundle.getString("defStrCityName");
    		phoneIntent=bundle.getString("defStrPhone");
    		faxIntent=bundle.getString("defStrFax");
    		emailIntent=bundle.getString("defStrEmail");
    		ratingIntent=bundle.getFloat("defStrRating");
    		IDIntent=bundle.getInt("defStrID");
    	}
        TextView title=(TextView) findViewById(R.id.title);
        title.setText("Name: "+titleIntent);
        TextView specialty=(TextView) findViewById(R.id.specialty);
        SpecialityData specialityObj=new SpecialityData();
        ArrayList<String> specialityArray=specialityObj.specialityOutput();
        String specialityElement=specialityArray.get(specialtyIntent);
        specialty.setText("Specialty: "+specialityElement);
        TextView affiliation=(TextView) findViewById(R.id.affiliation);
        affiliation.setText("Affiliation: "+affiliationIntent);
        TextView cityName=(TextView) findViewById(R.id.city_name);
        cityName.setText("City Name: "+cityNameIntent);
        TextView phone=(TextView) findViewById(R.id.phone);
        phone.setText("Phone: "+phoneIntent);
        TextView fax=(TextView) findViewById(R.id.fax);
        fax.setText("Fax: "+faxIntent);
        TextView email=(TextView) findViewById(R.id.email);
        email.setText("Email: "+emailIntent);
        TextView rating=(TextView) findViewById(R.id.rating);
        if (ratingIntent>=0) {
        	rating.setText("Rating: "+ratingIntent);
        }
        else {
        	String noset=getResources().getString(R.string.severity_noset);
        	rating.setText("Rating: "+noset);
        }
	}
    public void edit(View target) {
		Intent intent=new Intent(getParent(), ProviderEditObj.class);
		Bundle b=new Bundle();
		int itemIdent=identIntent;
		b.putInt("defStrIdent", itemIdent);
		String itemTitle=titleIntent;
		b.putString("defStrTitle", itemTitle);
		int itemSpecialty=specialtyIntent;
		b.putInt("defStrSpecialty", itemSpecialty);
		String itemAffiliation=affiliationIntent;
		b.putString("defStrAffiliation", itemAffiliation);
		String itemCityName=cityNameIntent;
		b.putString("defStrCityName", itemCityName);
		String itemPhone=phoneIntent;
		b.putString("defStrPhone", itemPhone);
		String itemFax=faxIntent;
		b.putString("defStrFax", itemFax);
		String itemEmail=emailIntent;
		b.putString("defStrEmail", itemEmail);
		float itemRating=ratingIntent;
		b.putFloat("defStrRating", itemRating);
		int itemID=IDIntent;
		b.putInt("defStrID", itemID);
		intent.putExtras(b);
		ProvidersLauncher parentActivity=(ProvidersLauncher) getParent();
    	parentActivity.startChildActivity("Provider_edit_obj", intent);
    }
    public void delete(View target) {
    	ProvidersLauncher parentActivity=(ProvidersLauncher) getParent();
    	AlertDialog.Builder alt_bld=new AlertDialog.Builder(parentActivity);
    	alt_bld.setMessage("Are you sure you want to delete the item?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	    	public void onClick(DialogInterface dialog, int id) {
	    		ArrayList<Item> threetabObject=ThreeTabObject.items;
	    		int threetabObjectLength=threetabObject.size();
	    		for (int i=0; i<threetabObjectLength; i++) {
	    			Object element=(Object) threetabObject.get(i);
	    			if (element instanceof ProvidersItem) {
	    				ProvidersItem elementItem=(ProvidersItem) element;
	    				int elementItemID=elementItem.ID;
	    				if (elementItemID==IDIntent) {
	    					threetabObject.remove(i);
	    					break;
	    				}
	    			}
	    		}
				// SQLITE-query (begin)
				ProvidersLauncher parentActivity=(ProvidersLauncher) getParent();
				SQLiteHelper dbOpenHelper=new SQLiteHelper(parentActivity);
				SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
				String whereSelect=IDIntent+"";
				db.delete("providers", "id=? ", new String[] {whereSelect});
				db.close();
				// SQLITE-query (end)
	    		onBackPressed();
	    	}
    	}).setNegativeButton("No", new DialogInterface.OnClickListener() {
	    	public void onClick(DialogInterface dialog, int id) {
	    		dialog.cancel();
	    	}
    	});
    	AlertDialog alert=alt_bld.create();
    	alert.setTitle("Delete");
    	alert.setIcon(R.drawable.icon);
    	alert.show();
    }
}