package com.example.helloandroid;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.EditText;
import android.widget.Toast;


public class HelloAndroid extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        LocationManager mlocManager =
        		(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        		LocationListener mlocListener = new MyLocationListener();
        		mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);

        final Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            	EditText nameText = (EditText) findViewById(R.id.nameText);
            	String name = nameText.getText().toString();
            	Spinner classSpinner = (Spinner) findViewById(R.id.classSpinner);
            	String classText = classSpinner.getSelectedItem().toString();
            	Spinner houseSpinner = (Spinner) findViewById(R.id.houseSpinner);
            	String houseText = houseSpinner.getSelectedItem().toString();
            	
            	
            	setContentView(R.layout.game);
            	TextView text1 = (TextView) findViewById(R.id.textGame);
            	TextView text2 = (TextView) findViewById(R.id.textWelcome);
            	text1.setText("Yer a " + classText + ", " + name + "!");
            	text2.setText("Welcome to the " + houseText + " house!");
            }
        });
    }
    
	/* Class My Location Listener */
	public class MyLocationListener implements LocationListener
	{
		@Override
		public void onLocationChanged(Location loc)
		{
			loc.getLatitude();
			loc.getLongitude();
			String Text = "My current location is: " +
					"Lat = " + loc.getLatitude() +
					", Long = " + loc.getLongitude();

			Toast.makeText( getApplicationContext(),
					Text,
					Toast.LENGTH_SHORT).show();
		}
		@Override
		public void onProviderDisabled(String provider)
		{
			Toast.makeText( getApplicationContext(),
					"Gps Disabled",
					Toast.LENGTH_SHORT ).show();
		}
		@Override
		public void onProviderEnabled(String provider)
		{
			Toast.makeText( getApplicationContext(),
					"Gps Enabled",
					Toast.LENGTH_SHORT).show();
		}
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras)
		{
		}
	}
}