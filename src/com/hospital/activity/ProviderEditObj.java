package com.hospital.activity;
import java.util.ArrayList;
import com.hospital.activity.item.Item;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
public class ProviderEditObj extends Activity implements SeekBar.OnSeekBarChangeListener {
	Intent intent;
	Bundle bundle;
	int identIntent=0;
	String titleIntent="";
	int specialtyIntent=0;
	int specialtyNumber;
	String affiliationIntent="";
	String cityNameIntent="";
	String phoneIntent="";
	String faxIntent="";
	String emailIntent="";
	float ratingIntent=0;
	int IDIntent=0;
	TextView mTextRating;
	private static final int SPECIALITY_DIALOG_ID=0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.provider_edit_object);
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
		EditText title=(EditText) findViewById(R.id.title);
		title.setText(titleIntent);
		final EditText specialty=(EditText) findViewById(R.id.specialty);
		SpecialityData specialityObj=new SpecialityData();
        final ArrayList<String> specialityArray=specialityObj.specialityOutput();
        String specialityElement=specialityArray.get(specialtyIntent);
		specialty.setText(specialityElement);
		specialty.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				showDialog(SPECIALITY_DIALOG_ID);
				return false;
			}
		});
		EditText affiliation=(EditText) findViewById(R.id.affiliation);
		affiliation.setText(affiliationIntent);
		ProvidersLauncher parentActivity=(ProvidersLauncher) getParent();
		AutoCompleteTextView cityName=(AutoCompleteTextView) findViewById(R.id.city_name);
		ArrayAdapter<String> adapter=new ArrayAdapter<String> (parentActivity, R.layout.list_item, CityDB.getCity());
		cityName.setAdapter(adapter);
		cityName.setText(cityNameIntent+"");
		EditText phone=(EditText) findViewById(R.id.phone);
		phone.setText(phoneIntent);
		EditText fax=(EditText) findViewById(R.id.fax);
		fax.setText(faxIntent);
		EditText email=(EditText) findViewById(R.id.email);
		email.setText(emailIntent);
		mTextRating=(TextView) findViewById(R.id.rating_out);
		final SeekBar seekbar=(SeekBar) findViewById(R.id.rating);
        seekbar.setOnSeekBarChangeListener(this);
        seekbar.setMax(6);
        int progress=(int) ratingIntent;
        seekbar.setProgress(progress);
        if (ratingIntent>=0) {
        	mTextRating.setText(ratingIntent+"");
        }
        else {
        	String noset=getResources().getString(R.string.severity_noset);
        	mTextRating.setText(noset);
        }
	}
	public void submit(View target) {
		ArrayList<Item> threetabObject=ThreeTab.outputObject();
		ProvidersItem element=(ProvidersItem) threetabObject.get(identIntent);
		EditText titleForm=(EditText) findViewById(R.id.title);
    	Editable titleEdit=titleForm.getText();
    	String title=titleEdit.toString();
		element.title=title;
		element.specialty=specialtyNumber;
		EditText affiliationForm=(EditText) findViewById(R.id.affiliation);
    	Editable affiliationEdit=affiliationForm.getText();
    	String affiliation=affiliationEdit.toString();
		element.affiliation=affiliation;
		AutoCompleteTextView cityNameForm=(AutoCompleteTextView) findViewById(R.id.city_name);
    	Editable cityNameEdit=cityNameForm.getText();
    	String cityName=cityNameEdit.toString();
		element.cityName=cityName;
		EditText phoneForm=(EditText) findViewById(R.id.phone);
    	Editable phoneEdit=phoneForm.getText();
    	String phone=phoneEdit.toString();
		element.phone=phone;
		EditText faxForm=(EditText) findViewById(R.id.fax);
    	Editable faxEdit=faxForm.getText();
    	String fax=faxEdit.toString();
		element.fax=fax;
		EditText emailForm=(EditText) findViewById(R.id.email);
    	Editable emailEdit=emailForm.getText();
    	String email=emailEdit.toString();
		element.email=email;
		SeekBar ratingForm=(SeekBar) findViewById(R.id.rating);
		int rating=ratingForm.getProgress()-1;
		element.rating=rating;
		threetabObject.set(identIntent, element);
		// SQLITE-query (begin)
		ProvidersLauncher parentActivity=(ProvidersLauncher) getParent();
		SQLiteHelper dbOpenHelper=new SQLiteHelper(parentActivity);
		SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
		ContentValues cv=new ContentValues();
		cv.put("name", title);
		cv.put("specialty", specialtyNumber);
		cv.put("affiliation", affiliation);
		cv.put("cityname", cityName);
		cv.put("phone", phone);
		cv.put("fax", fax);
		cv.put("email", email);
		cv.put("rating", rating);
		cv.put("uid", 1);
		cv.put("local_id", -1);
		db.update("providers", cv, "id="+IDIntent, null);
		db.close();
		// SQLITE-query (end)
		super.onBackPressed();
		super.onBackPressed();
	}
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		// TODO Auto-generated method stub
		String noset=getResources().getString(R.string.severity_noset);
		int valueChange=seekBar.getProgress()-1;
		if (valueChange>=0) {
			mTextRating.setText(String.valueOf(valueChange+".0"));
		}
		else {
			mTextRating.setText(noset);
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
			mTextRating.setText(String.valueOf(valueChange+".0"));
		}
		else {
			mTextRating.setText(noset);
		}
	}
    @Override
    public void onBackPressed() {

    }
	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog tmp=null;
		switch (id) {
			case SPECIALITY_DIALOG_ID:
				ProvidersLauncher parentActivity=(ProvidersLauncher) getParent();
				final EditText specialty=(EditText) findViewById(R.id.specialty);
				SpecialityData specialityObj=new SpecialityData();
		        final ArrayList<String> specialityArray=specialityObj.specialityOutput();
				String[] arrayElements;
				arrayElements=new String[specialityArray.size()];
				for(int i=0; i<specialityArray.size(); i++) {
					arrayElements[i]=specialityArray.get(i);
				}
				final CharSequence[] items=arrayElements;
				AlertDialog.Builder alert=new AlertDialog.Builder(parentActivity);
				alert.setTitle("Select a specialty");
				alert.setItems(items, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface alert, int item) {
				    	specialty.setText(items[item]);
				    	specialtyNumber=item;
				    }
				});
				tmp=alert.create();
				return tmp;
		}
		return tmp;
	}
}