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
public class TreatmentOutput extends Activity {
	Intent intent;
	Bundle bundle;
	int identIntent=0;
	String titleIntent="";
	String subtitleIntent="";
	String startDateIntent="";
	String endDateIntent="";
	int repeatIntent=0;
	int severityIntent=0;
	private int treatmentTypeIntent=0;
	String treatmentStrengthIntent="";
	private int treatmentSystemIntent=0;
	private int IDIntent=0;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.treatment_output);
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
    		treatmentTypeIntent=bundle.getInt("defStrTreatmentType");
    		treatmentStrengthIntent=bundle.getString("defStrTreatmentStrength");
    		treatmentSystemIntent=bundle.getInt("defStrTreatmentSystem");
    		IDIntent=bundle.getInt("defStrID");
    	}
        TextView title=(TextView) findViewById(R.id.title);
        String titleH=getResources().getString(R.string.indication_title);
        title.setText(titleH+": "+titleIntent);
        TextView subtitle=(TextView) findViewById(R.id.subtitle);
        String subtitleH=getResources().getString(R.string.indication_subtitle);
        subtitle.setText(subtitleH+": "+subtitleIntent);
        TextView startDate=(TextView) findViewById(R.id.start_date);
        String startdateH=getResources().getString(R.string.indication_startdate);
        startDate.setText(startdateH+": "+startDateIntent);
        TextView endDate=(TextView) findViewById(R.id.end_date);
        String enddateH=getResources().getString(R.string.indication_enddate);
        endDate.setText(enddateH+": "+endDateIntent);
        TextView repeat=(TextView) findViewById(R.id.repeat);
        String repeatH=getResources().getString(R.string.indication_repeat);
        switch (repeatIntent) {
	    	case 0:
	    		repeat.setText(repeatH+": Once");
	    		break;
	    	case 2:
	    		repeat.setText(repeatH+": Daily");
	    		break;
	    	case 4:
	    		repeat.setText(repeatH+": Weekly");
	    		break;
	    	case 8:
	    		repeat.setText(repeatH+": Monthly");
	    		break;
	    	case 16:
	    		repeat.setText(repeatH+": Yearly");
	    		break;
	    }
        TextView severity=(TextView) findViewById(R.id.severity);
        String severityH=getResources().getString(R.string.indication_severity);
        if (severityIntent>=0) {
        	severity.setText(severityH+": "+severityIntent+"%");
        }
        else {
        	String noset=getResources().getString(R.string.severity_noset);
        	severity.setText(severityH+": "+noset);
        }
        TextView treatmentType=(TextView) findViewById(R.id.treatment_type);
        treatmentType.setText("Treatment Type: "+TreatmentTypeData.treatmentTypeOutput().get(treatmentTypeIntent-1));
        TextView treatmentStrength=(TextView) findViewById(R.id.treatment_strength);
        String treatmentStrengthH=getResources().getString(R.string.treatment_strength);
        treatmentStrength.setText(treatmentStrengthH+": "+treatmentStrengthIntent);
        TextView treatmentSystem=(TextView) findViewById(R.id.treatment_system);
        treatmentSystem.setText("Medical System: "+TreatmentSystemData.treatmentSystemOutput().get(treatmentSystemIntent-1));
	}
    public void edit(View target) {
		Intent intent=new Intent(getParent(), TreatmentEditObj.class);
		Bundle b=new Bundle();
		int itemIdent=identIntent;
		b.putInt("defStrIdent", itemIdent);
		String itemTitle=titleIntent;
		b.putString("defStrTitle", itemTitle);
		String itemSubtitle=subtitleIntent;
		b.putString("defStrSubtitle", itemSubtitle);
		String itemStartDate=startDateIntent;
		b.putString("defStrStartDate", itemStartDate);
		String itemEndDate=endDateIntent;
		b.putString("defStrEndDate", itemEndDate);;
		int itemRepeat=repeatIntent;
		b.putInt("defStrRepeat", itemRepeat);
		int itemSeverity=severityIntent;
		b.putInt("defStrSeverity", itemSeverity);
		b.putInt("defStrTreatmentType", treatmentTypeIntent);
		String itemTreatmentStrength=treatmentStrengthIntent;
		b.putString("defStrTreatmentStrength", itemTreatmentStrength);
		b.putInt("defStrTreatmentSystem", treatmentSystemIntent);
		int itemID=IDIntent;
		b.putInt("defStrID", itemID);
		intent.putExtras(b);
		TreatmentsLauncher parentActivity=(TreatmentsLauncher) getParent();
    	parentActivity.startChildActivity("Treatment_edit_obj", intent);
    }
    public void delete(View target) {
    	TreatmentsLauncher parentActivity=(TreatmentsLauncher) getParent();
    	AlertDialog.Builder alt_bld=new AlertDialog.Builder(parentActivity);
    	alt_bld.setMessage("Are you sure you want to delete the item?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
	    	public void onClick(DialogInterface dialog, int id) {
	    		ArrayList<Item> twotabObject=TwoTabObject.items;
	    		int twotabObjectLength=twotabObject.size();
	    		for (int i=0; i<twotabObjectLength; i++) {
	    			Object element=(Object) twotabObject.get(i);
	    			if (element instanceof TreatmentsItem) {
	    				TreatmentsItem elementItem=(TreatmentsItem) element;
	    				int elementItemID=elementItem.ID;
	    				if (elementItemID==IDIntent) {
	    					twotabObject.remove(i);
	    					break;
	    				}
	    			}
	    		}
				// SQLITE-query (begin)
				TreatmentsLauncher parentActivity=(TreatmentsLauncher) getParent();
				SQLiteHelper dbOpenHelper=new SQLiteHelper(parentActivity);
				SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
				String whereSelect=IDIntent+"";
				db.delete("treatments", "id=? ", new String[] {whereSelect});
				db.delete("occasions", "event_id=? and type=? ", new String[] {whereSelect, "2"});
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