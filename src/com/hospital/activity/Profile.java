package com.hospital.activity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
public class Profile extends Activity {
	private Intent intent;
	private Bundle bundle;
	private int IDTab;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        intent=getIntent();
    	bundle=intent.getExtras();
    	if (bundle!=null) {
    		IDTab=bundle.getInt("defStrIDTab");
    	}
        // output information (begin)
        TextView city=(TextView) findViewById(R.id.city);
        city.setText("City: "+ProfileObject.profile.getCity());
        TextView email=(TextView) findViewById(R.id.email);
        email.setText("Email: "+ProfileObject.profile.getEmail());
        TextView height=(TextView) findViewById(R.id.height);
        height.setText("Height: "+ProfileComponentHeight.getHeight().get(ProfileObject.profile.getHeight()-1));
        TextView weight=(TextView) findViewById(R.id.weight);
        weight.setText("Weight: "+ProfileComponentWeight.getWeight().get(ProfileObject.profile.getWeight()-1));
        TextView dateOfBirth=(TextView) findViewById(R.id.date_of_birth);
        dateOfBirth.setText("Date of Birth: "+ProfileComponentDateOfBirth.getDateOfBirth().get(ProfileObject.profile.getDateOfBirth()-1));
        TextView gender=(TextView) findViewById(R.id.gender);
        gender.setText("Gender: "+ProfileComponentGender.getGender().get(ProfileObject.profile.getGender()-1));
        TextView tobacco=(TextView) findViewById(R.id.tobacco);
        tobacco.setText("Tobacco: "+ProfileComponentTobacco.getTobacco().get(ProfileObject.profile.getTobacco()-1));
        TextView alcohol=(TextView) findViewById(R.id.alcohol);
        alcohol.setText("Alcohol: "+ProfileComponentAlcohol.getAlcohol().get(ProfileObject.profile.getAlcohol()-1));
        TextView alert=(TextView) findViewById(R.id.alert);
        alert.setText("Alert: "+ProfileComponentAlert.getAlert().get(ProfileObject.profile.getAlert()-1));
        // output information (end)
    }
	public void submit(View target) {
		Intent intent=new Intent(getParent(), ProfileEdit.class);
		Bundle bundle=new Bundle();
		switch (IDTab) {
			case 1:
				IndicationsLauncher parentActivity1=(IndicationsLauncher) getParent();
				bundle.putInt("defStrIDTab", IDTab);
				intent.putExtras(bundle);
				parentActivity1.startChildActivity("Profile_edit", intent);
				break;
			case 2:
				TreatmentsLauncher parentActivity2=(TreatmentsLauncher) getParent();
				bundle.putInt("defStrIDTab", IDTab);
				intent.putExtras(bundle);
				parentActivity2.startChildActivity("Profile_edit", intent);
				break;
			case 3:
				ProvidersLauncher parentActivity3=(ProvidersLauncher) getParent();
				bundle.putInt("defStrIDTab", IDTab);
				intent.putExtras(bundle);
				parentActivity3.startChildActivity("Profile_edit", intent);
				break;
		}
	}
}