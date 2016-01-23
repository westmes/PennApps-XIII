package com.example.grace.location;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends FragmentActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, OnMapReadyCallback {

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    protected static final String TAG = "Your Current Location";
    private double mLatitude;
    private double mLongitude;
    private Location mLastLocation;
    private Date date;
    private ArrayAdapter<CharSequence> adapter;
    private Spinner spinner;
    String food;

    DateFormat fmtDateAndTime= DateFormat.getDateTimeInstance();
    TextView dateAndTimeLabel;
    Calendar dateAndTime = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };
    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay,
                              int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            updateLabel();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        buildGoogleApiClient();

        Button btn=(Button)findViewById(R.id.time);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this,
                        d,
                        dateAndTime.get(Calendar.YEAR),
                        dateAndTime.get(Calendar.MONTH),
                        dateAndTime.get(Calendar.DAY_OF_MONTH)).show();

                new TimePickerDialog(MainActivity.this,
                        t, dateAndTime.get(Calendar.HOUR_OF_DAY),
                        dateAndTime.get(Calendar.MINUTE), true).show();
            }
        });

////        btn=(Button)findViewById(R.id.time);
//        btn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                new TimePickerDialog(MainActivity.this, t, dateAndTime.get(Calendar.HOUR_OF_DAY), dateAndTime.get(Calendar.MINUTE), true).show();
//            }
//        });

        dateAndTimeLabel=(TextView)findViewById(R.id.dateAndTime);
        updateLabel();
        Log.d("time", String.valueOf(date));

//        spinner = (Spinner) findViewById(R.id.food);
//        adapter = ArrayAdapter.createFromResource(this,
//                R.array.food, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
            // do stuff with the user
            Log.i("username", currentUser.getUsername());
            //currentUser.logOut();
        } else {
            // show the signup or login screen
            Intent intent = new Intent(this, SignupLogin.class);
            startActivity(intent);
        }
    }

    private void updateLabel() {
        dateAndTimeLabel.setText(fmtDateAndTime.format(dateAndTime.getTime()));
    }

    private synchronized void buildGoogleApiClient(){
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {

        Log.d("abc", "abc");

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

            Log.d("MLOCATION",String.valueOf(mLastLocation));

            if (mLastLocation != null) {
                mLatitude = mLastLocation.getLatitude();
                mLongitude = mLastLocation.getLongitude();

                LatLng your_location = new LatLng(mLongitude, mLatitude);
                mMap.getUiSettings().setZoomControlsEnabled(true);
                mMap.addMarker(new MarkerOptions().position(your_location).title(TAG).draggable(true));

                Log.d("edf","edf");
                Log.d("La", String.valueOf(mLatitude));
            }
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.i(TAG, "Connection suspended");
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {

        if(result.hasResolution()){
            try{
                result.startResolutionForResult(this,0);
            }catch (IntentSender.SendIntentException e) {

            }
        } else
         Log.d("FAILED", "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    public void sendRequest(View view) {
        Log.d("sendRequestToDatabase","first line");
        ParseUser currentUser = ParseUser.getCurrentUser();
        Date date = dateAndTime.getTime();
        ParseGeoPoint currentLocation = new ParseGeoPoint(mLatitude, mLongitude);
        ParseObject userRequestObject = new ParseObject("UserRequestObject");
        userRequestObject.put("RequestedTime", date);
        // Remember to change msg and category to user input
        EditText et = (EditText) findViewById(R.id.message);
        String msg = et.getText().toString();

        EditText et2 = (EditText) findViewById(R.id.food);
        String msg2 = et2.getText().toString();

        userRequestObject.put("Message",msg);
        userRequestObject.put("FoodCategory",msg2);
        userRequestObject.put("UserID",currentUser.getUsername());
        userRequestObject.put("Response", false);
        userRequestObject.put("Location", currentLocation);

        userRequestObject.saveInBackground();

    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String food = adapter.getItem(position).toString();
//        Log.d("food",food);
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
}


