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
import android.widget.Toast;
public class ProviderAddForm extends Activity implements SeekBar.OnSeekBarChangeListener {
	Intent intent;
	Bundle bundle;
	int identIntent=0;
	TextView mTextRating;
	int specialtyNumber=0;
	private static final int SPECIALITY_DIALOG_ID=0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.provider_add_form);
		final EditText specialty=(EditText) findViewById(R.id.specialty);
		specialty.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				showDialog(SPECIALITY_DIALOG_ID);
				return false;
			}
		});
		mTextRating=(TextView) findViewById(R.id.rating_out);
		final SeekBar seekbar=(SeekBar) findViewById(R.id.rating);
        seekbar.setOnSeekBarChangeListener(this);
        seekbar.setMax(6);
    	String noset=getResources().getString(R.string.severity_noset);
    	mTextRating.setText(noset);
    	intent=getIntent();
		bundle=intent.getExtras();
		if (bundle!=null) {
			identIntent=bundle.getInt("defStrIdent");
		}
		ProvidersLauncher parentActivity=(ProvidersLauncher) getParent();
		AutoCompleteTextView cityName=(AutoCompleteTextView) findViewById(R.id.city_name);
		ArrayAdapter<String> adapter=new ArrayAdapter<String> (parentActivity, R.layout.list_item, CityDB.getCity());
		cityName.setAdapter(adapter);
	}
	public void submit(View target) {
		ArrayList<Item> threetabObject=ThreeTabObject.items;
		int idSection=identIntent;
		int lengthItems=threetabObject.size();
		int maxID=0;
		for (int i=0; i<lengthItems; i++) {
			Object item=(Object) threetabObject.get(i);
			if (item instanceof ProvidersItem) {
				ProvidersItem itemObj=(ProvidersItem) item;
				if (itemObj.ID>maxID) {
					maxID=itemObj.ID;
				}
			}
		}
		int ID=maxID+1;
		EditText titleForm=(EditText) findViewById(R.id.title);
    	Editable titleEdit=titleForm.getText();
    	String title=titleEdit.toString();
		int specialty=specialtyNumber;
		EditText affiliationForm=(EditText) findViewById(R.id.affiliation);
    	Editable affiliationEdit=affiliationForm.getText();
    	String affiliation=affiliationEdit.toString();
    	AutoCompleteTextView cityNameForm=(AutoCompleteTextView) findViewById(R.id.city_name);
    	Editable cityNameEdit=cityNameForm.getText();
    	String cityName=cityNameEdit.toString();
		EditText phoneForm=(EditText) findViewById(R.id.phone);
    	Editable phoneEdit=phoneForm.getText();
    	String phone=phoneEdit.toString();
		EditText faxForm=(EditText) findViewById(R.id.fax);
    	Editable faxEdit=faxForm.getText();
    	String fax=faxEdit.toString();
		EditText emailForm=(EditText) findViewById(R.id.email);
    	Editable emailEdit=emailForm.getText();
    	String email=emailEdit.toString();
		SeekBar ratingForm=(SeekBar) findViewById(R.id.rating);
		int rating=ratingForm.getProgress()-1;
		if (title=="" || specialty==0 || affiliation=="" || cityName=="" || phone=="" || fax=="" || email=="") {
			Toast.makeText(getApplicationContext(), "You do not fill in all fields!", Toast.LENGTH_SHORT).show();
		}
		else {
			threetabObject.add(new ProvidersItem(title, idSection, specialty, affiliation, cityName, phone, fax, email, rating, ID));
			// SQLITE-query (begin)
			ProvidersLauncher parentActivity=(ProvidersLauncher) getParent();
			SQLiteHelper dbOpenHelper=new SQLiteHelper(parentActivity);
			SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
			ContentValues cv=new ContentValues();
			cv.put("id", ID);
			cv.put("section", idSection);
			cv.put("name", title);
			cv.put("specialty", specialty);
			cv.put("affiliation", affiliation);
			cv.put("cityname", cityName);
			cv.put("phone", phone);
			cv.put("fax", fax);
			cv.put("email", email);
			cv.put("rating", rating);
			cv.put("uid", 1);
			cv.put("local_id", -1);
			db.insertOrThrow("providers", null, cv);
			db.close();
			// SQLITE-query (end)
			super.onBackPressed();
		}
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
				    	specialtyNumber=item+1;
				    }
				});
				tmp=alert.create();
				return tmp;
		}
		return tmp;
	}
}