package com.hospital.activity;
import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;
public class ProfileEdit extends Activity {
	private Intent intent;
	private Bundle bundle;
	private int IDTab;
	private static final int HEIGHT_DIALOG_ID=1;
	private static final int WEIGHT_DIALOG_ID=2;
	private static final int DATEOFBIRTH_DIALOG_ID=3;
	private static final int GENDER_DIALOG_ID=4;
	private static final int TOBACCO_DIALOG_ID=5;
	private static final int ALCOHOL_DIALOG_ID=6;
	private static final int ALERT_DIALOG_ID=7;
	private ArrayAdapter<String> adapter;
	private AlertDialog.Builder dialog;
	String[] arrayThis;
	CharSequence[] items;
	private AutoCompleteTextView city;
	private EditText email;
	private EditText height;
	private EditText weight;
	private EditText dateOfBirth;
	private EditText gender;
	private EditText tobacco;
	private EditText alcohol;
	private EditText alert;
	private int changeHeight=0;
	private int changeWeight=0;
	private int changeDateOfBirth=0;
	private int changeGender=0;
	private int changeTobacco=0;
	private int changeAlcohol=0;
	private int changeAlert=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edit);
        intent=getIntent();
    	bundle=intent.getExtras();
    	if (bundle!=null) {
    		IDTab=bundle.getInt("defStrIDTab");
    	}
        // output information (begin)
        city=(AutoCompleteTextView) findViewById(R.id.city);
        city.setText(ProfileObject.profile.getCity());
        switch (IDTab) {
        	case 1:
        		IndicationsLauncher parentActivity1=(IndicationsLauncher) getParent();
        		adapter=new ArrayAdapter<String> (parentActivity1, R.layout.list_item, CityDB.getCity());
        		break;
        	case 2:
        		TreatmentsLauncher parentActivity2=(TreatmentsLauncher) getParent();
        		adapter=new ArrayAdapter<String> (parentActivity2, R.layout.list_item, CityDB.getCity());
        		break;
        	case 3:
        		ProvidersLauncher parentActivity3=(ProvidersLauncher) getParent();
        		adapter=new ArrayAdapter<String> (parentActivity3, R.layout.list_item, CityDB.getCity());
        		break;
        }
		city.setAdapter(adapter);
        email=(EditText) findViewById(R.id.email);
        email.setText(ProfileObject.profile.getEmail());
        height=(EditText) findViewById(R.id.height);
        height.setText(ProfileComponentHeight.getHeight().get(ProfileObject.profile.getHeight()-1));
		height.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				showDialog(HEIGHT_DIALOG_ID);
				return false;
			}
		});
		weight=(EditText) findViewById(R.id.weight);
        weight.setText(ProfileComponentWeight.getWeight().get(ProfileObject.profile.getWeight()-1));
        weight.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				showDialog(WEIGHT_DIALOG_ID);
				return false;
			}
		});
        dateOfBirth=(EditText) findViewById(R.id.date_of_birth);
        dateOfBirth.setText(ProfileComponentDateOfBirth.getDateOfBirth().get(ProfileObject.profile.getDateOfBirth()-1));
        dateOfBirth.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				showDialog(DATEOFBIRTH_DIALOG_ID);
				return false;
			}
		});
        gender=(EditText) findViewById(R.id.gender);
        gender.setText(ProfileComponentGender.getGender().get(ProfileObject.profile.getGender()-1));
        gender.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				showDialog(GENDER_DIALOG_ID);
				return false;
			}
		});
        tobacco=(EditText) findViewById(R.id.tobacco);
        tobacco.setText(ProfileComponentTobacco.getTobacco().get(ProfileObject.profile.getTobacco()-1));
        tobacco.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				showDialog(TOBACCO_DIALOG_ID);
				return false;
			}
		});
        alcohol=(EditText) findViewById(R.id.alcohol);
        alcohol.setText(ProfileComponentAlcohol.getAlcohol().get(ProfileObject.profile.getAlcohol()-1));
        alcohol.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				showDialog(ALCOHOL_DIALOG_ID);
				return false;
			}
		});
        alert=(EditText) findViewById(R.id.alert);
        alert.setText(ProfileComponentAlert.getAlert().get(ProfileObject.profile.getAlert()-1));
        alert.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				showDialog(ALERT_DIALOG_ID);
				return false;
			}
		});
        // output information (end)
    }
	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog tmp=null;
		switch (id) {
			case HEIGHT_DIALOG_ID:
		        final ArrayList<String> heightArray=ProfileComponentHeight.getHeight();
				arrayThis=new String[heightArray.size()];
				for(int i=0; i<heightArray.size(); i++) {
					arrayThis[i]=heightArray.get(i);
				}
				items=arrayThis;
				switch (IDTab) {
					case 1:
						IndicationsLauncher parentActivity1=(IndicationsLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity1);
						break;
					case 2:
						TreatmentsLauncher parentActivity2=(TreatmentsLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity2);
						break;
					case 3:
						ProvidersLauncher parentActivity3=(ProvidersLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity3);
						break;
				}
				dialog.setTitle("Select a Height");
				dialog.setItems(items, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface alert, int item) {
				        final ArrayList<String> heightArray=ProfileComponentHeight.getHeight();
						arrayThis=new String[heightArray.size()];
						for(int i=0; i<heightArray.size(); i++) {
							arrayThis[i]=heightArray.get(i);
						}
						items=arrayThis;
						switch (IDTab) {
							case 1:
								IndicationsLauncher parentActivity1=(IndicationsLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity1);
								break;
							case 2:
								TreatmentsLauncher parentActivity2=(TreatmentsLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity2);
								break;
							case 3:
								ProvidersLauncher parentActivity3=(ProvidersLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity3);
								break;
						}
				    	height.setText(items[item]);
				    	changeHeight=item+1;
				    }
				});
				tmp=dialog.create();
				return tmp;
			case WEIGHT_DIALOG_ID:
		        final ArrayList<String> weightArray=ProfileComponentWeight.getWeight();
				arrayThis=new String[weightArray.size()];
				for(int i=0; i<weightArray.size(); i++) {
					arrayThis[i]=weightArray.get(i);
				}
				items=arrayThis;
				switch (IDTab) {
					case 1:
						IndicationsLauncher parentActivity1=(IndicationsLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity1);
						break;
					case 2:
						TreatmentsLauncher parentActivity2=(TreatmentsLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity2);
						break;
					case 3:
						ProvidersLauncher parentActivity3=(ProvidersLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity3);
						break;
				}
				dialog.setTitle("Select a Weight");
				dialog.setItems(items, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface alert, int item) {
				        final ArrayList<String> weightArray=ProfileComponentWeight.getWeight();
						arrayThis=new String[weightArray.size()];
						for(int i=0; i<weightArray.size(); i++) {
							arrayThis[i]=weightArray.get(i);
						}
						items=arrayThis;
						switch (IDTab) {
							case 1:
								IndicationsLauncher parentActivity1=(IndicationsLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity1);
								break;
							case 2:
								TreatmentsLauncher parentActivity2=(TreatmentsLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity2);
								break;
							case 3:
								ProvidersLauncher parentActivity3=(ProvidersLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity3);
								break;
						}
				    	weight.setText(items[item]);
				    	changeWeight=item+1;
				    }
				});
				tmp=dialog.create();
				return tmp;
			case DATEOFBIRTH_DIALOG_ID:
		        final ArrayList<String> dateOfBirthArray=ProfileComponentDateOfBirth.getDateOfBirth();
				arrayThis=new String[dateOfBirthArray.size()];
				for(int i=0; i<dateOfBirthArray.size(); i++) {
					arrayThis[i]=dateOfBirthArray.get(i);
				}
				items=arrayThis;
				switch (IDTab) {
					case 1:
						IndicationsLauncher parentActivity1=(IndicationsLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity1);
						break;
					case 2:
						TreatmentsLauncher parentActivity2=(TreatmentsLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity2);
						break;
					case 3:
						ProvidersLauncher parentActivity3=(ProvidersLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity3);
						break;
				}
				dialog.setTitle("Select a Date of Birth");
				dialog.setItems(items, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface alert, int item) {
				        final ArrayList<String> dateOfBirthArray=ProfileComponentDateOfBirth.getDateOfBirth();
						arrayThis=new String[dateOfBirthArray.size()];
						for(int i=0; i<dateOfBirthArray.size(); i++) {
							arrayThis[i]=dateOfBirthArray.get(i);
						}
						items=arrayThis;
						switch (IDTab) {
							case 1:
								IndicationsLauncher parentActivity1=(IndicationsLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity1);
								break;
							case 2:
								TreatmentsLauncher parentActivity2=(TreatmentsLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity2);
								break;
							case 3:
								ProvidersLauncher parentActivity3=(ProvidersLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity3);
								break;
						}
				    	dateOfBirth.setText(items[item]);
				    	changeDateOfBirth=item+1;
				    }
				});
				tmp=dialog.create();
				return tmp;
			case GENDER_DIALOG_ID:
		        final ArrayList<String> genderArray=ProfileComponentGender.getGender();
				arrayThis=new String[genderArray.size()];
				for(int i=0; i<genderArray.size(); i++) {
					arrayThis[i]=genderArray.get(i);
				}
				items=arrayThis;
				switch (IDTab) {
					case 1:
						IndicationsLauncher parentActivity1=(IndicationsLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity1);
						break;
					case 2:
						TreatmentsLauncher parentActivity2=(TreatmentsLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity2);
						break;
					case 3:
						ProvidersLauncher parentActivity3=(ProvidersLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity3);
						break;
				}
				dialog.setTitle("Select a Gender");
				dialog.setItems(items, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface alert, int item) {
				        final ArrayList<String> genderArray=ProfileComponentGender.getGender();
						arrayThis=new String[genderArray.size()];
						for(int i=0; i<genderArray.size(); i++) {
							arrayThis[i]=genderArray.get(i);
						}
						items=arrayThis;
						switch (IDTab) {
							case 1:
								IndicationsLauncher parentActivity1=(IndicationsLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity1);
								break;
							case 2:
								TreatmentsLauncher parentActivity2=(TreatmentsLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity2);
								break;
							case 3:
								ProvidersLauncher parentActivity3=(ProvidersLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity3);
								break;
						}
				    	gender.setText(items[item]);
				    	changeGender=item+1;
				    }
				});
				tmp=dialog.create();
				return tmp;
			case TOBACCO_DIALOG_ID:
		        final ArrayList<String> tobaccoArray=ProfileComponentTobacco.getTobacco();
				arrayThis=new String[tobaccoArray.size()];
				for(int i=0; i<tobaccoArray.size(); i++) {
					arrayThis[i]=tobaccoArray.get(i);
				}
				items=arrayThis;
				switch (IDTab) {
					case 1:
						IndicationsLauncher parentActivity1=(IndicationsLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity1);
						break;
					case 2:
						TreatmentsLauncher parentActivity2=(TreatmentsLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity2);
						break;
					case 3:
						ProvidersLauncher parentActivity3=(ProvidersLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity3);
						break;
				}
				dialog.setTitle("Select a Tobacco");
				dialog.setItems(items, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface alert, int item) {
				        final ArrayList<String> tobaccoArray=ProfileComponentTobacco.getTobacco();
						arrayThis=new String[tobaccoArray.size()];
						for(int i=0; i<tobaccoArray.size(); i++) {
							arrayThis[i]=tobaccoArray.get(i);
						}
						items=arrayThis;
						switch (IDTab) {
							case 1:
								IndicationsLauncher parentActivity1=(IndicationsLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity1);
								break;
							case 2:
								TreatmentsLauncher parentActivity2=(TreatmentsLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity2);
								break;
							case 3:
								ProvidersLauncher parentActivity3=(ProvidersLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity3);
								break;
						}
				    	tobacco.setText(items[item]);
				    	changeTobacco=item+1;
				    }
				});
				tmp=dialog.create();
				return tmp;
			case ALCOHOL_DIALOG_ID:
		        final ArrayList<String> alcoholArray=ProfileComponentAlcohol.getAlcohol();
				arrayThis=new String[alcoholArray.size()];
				for(int i=0; i<alcoholArray.size(); i++) {
					arrayThis[i]=alcoholArray.get(i);
				}
				items=arrayThis;
				switch (IDTab) {
					case 1:
						IndicationsLauncher parentActivity1=(IndicationsLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity1);
						break;
					case 2:
						TreatmentsLauncher parentActivity2=(TreatmentsLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity2);
						break;
					case 3:
						ProvidersLauncher parentActivity3=(ProvidersLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity3);
						break;
				}
				dialog.setTitle("Select a Alcohol");
				dialog.setItems(items, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface alert, int item) {
				        final ArrayList<String> alcoholArray=ProfileComponentAlcohol.getAlcohol();
						arrayThis=new String[alcoholArray.size()];
						for(int i=0; i<alcoholArray.size(); i++) {
							arrayThis[i]=alcoholArray.get(i);
						}
						items=arrayThis;
						switch (IDTab) {
							case 1:
								IndicationsLauncher parentActivity1=(IndicationsLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity1);
								break;
							case 2:
								TreatmentsLauncher parentActivity2=(TreatmentsLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity2);
								break;
							case 3:
								ProvidersLauncher parentActivity3=(ProvidersLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity3);
								break;
						}
				    	alcohol.setText(items[item]);
				    	changeAlcohol=item+1;
				    }
				});
				tmp=dialog.create();
				return tmp;
			case ALERT_DIALOG_ID:
		        final ArrayList<String> alertArray=ProfileComponentAlert.getAlert();
				arrayThis=new String[alertArray.size()];
				for(int i=0; i<alertArray.size(); i++) {
					arrayThis[i]=alertArray.get(i);
				}
				items=arrayThis;
				switch (IDTab) {
					case 1:
						IndicationsLauncher parentActivity1=(IndicationsLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity1);
						break;
					case 2:
						TreatmentsLauncher parentActivity2=(TreatmentsLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity2);
						break;
					case 3:
						ProvidersLauncher parentActivity3=(ProvidersLauncher) getParent();
						dialog=new AlertDialog.Builder(parentActivity3);
						break;
				}
				dialog.setTitle("Select a Alert");
				dialog.setItems(items, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface alertDialog, int item) {
				        final ArrayList<String> alertArray=ProfileComponentAlert.getAlert();
						arrayThis=new String[alertArray.size()];
						for(int i=0; i<alertArray.size(); i++) {
							arrayThis[i]=alertArray.get(i);
						}
						items=arrayThis;
						switch (IDTab) {
							case 1:
								IndicationsLauncher parentActivity1=(IndicationsLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity1);
								break;
							case 2:
								TreatmentsLauncher parentActivity2=(TreatmentsLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity2);
								break;
							case 3:
								ProvidersLauncher parentActivity3=(ProvidersLauncher) getParent();
								dialog=new AlertDialog.Builder(parentActivity3);
								break;
						}
				    	alert.setText(items[item]);
				    	changeAlert=item+1;
				    }
				});
				tmp=dialog.create();
				return tmp;
		}
		return tmp;
	}
    public void submit(View target) {
    	ProfileComponent object=ProfileObject.profile;
    	String formCity=city.getText().toString()+"";
    	String formEmail=email.getText().toString()+"";
    	if (formCity=="" || formEmail=="") {
    		Toast.makeText(getApplicationContext(), "You do not fill in all fields!", Toast.LENGTH_SHORT).show();
    	}
    	else {
    		object.setCity(formCity);
    		object.setEmail(formEmail);
    		if (changeHeight!=0) {
    			object.setHeight(changeHeight);
    		}
    		if (changeWeight!=0) {
    			object.setWeight(changeWeight);
    		}
    		if (changeDateOfBirth!=0) {
    			object.setDateOfBirth(changeDateOfBirth);
    		}
    		if (changeGender!=0) {
    			object.setGender(changeGender);
    		}
    		if (changeTobacco!=0) {
    			object.setTobacco(changeTobacco);
    		}
    		if (changeAlcohol!=0) {
    			object.setAlcohol(changeAlcohol);
    		}
    		if (changeAlert!=0) {
    			object.setAlert(changeAlert);
    		}
    		super.onBackPressed();
    	}
    }
    @Override
    public void onBackPressed() {

    }
}