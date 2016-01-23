package com.example.grace.location;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.sql.Time;
import java.util.GregorianCalendar;
import java.util.List;

public class Response extends AppCompatActivity {

    ParseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        Double latitude = intent.getDoubleExtra("latitude", 0);
        Double longitude = intent.getDoubleExtra("longitude", 0);
        ParseGeoPoint currentLocation = new ParseGeoPoint(latitude,longitude);
        currentUser = ParseUser.getCurrentUser();

        GregorianCalendar currentTime = new GregorianCalendar();
        Time now = new Time(currentTime.getTimeInMillis());

        ParseQuery<ParseObject> currentRequests = ParseQuery.getQuery("UserRequestObject");
        currentRequests.whereEqualTo("Response", false);
        currentRequests.whereGreaterThan("RequestedTime", now);
        //currentRequests.whereWithinMiles("Location", currentLocation, 1);

        currentRequests.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> requestList, com.parse.ParseException e) {
                if (e == null) {
                    Log.d("requests", "Retrieved " + requestList.size() + " requests");
                    if (requestList.size() == 0) {
                        TextView textView = new TextView(getApplicationContext());
                        textView.setTextSize(40);
                        textView.setText("No one posts request yet");

                        RelativeLayout layout = (RelativeLayout) findViewById(R.id.response);
                        layout.addView(textView);
                    }
                    else displayRequestList(requestList);
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }

        });
    }

    private void displayRequestList(final List<ParseObject> requestList) {

        //Log.d("size",requestList.size()+"requests");
        TableLayout table = (TableLayout)findViewById(R.id.table);
        int i=0;
        for (ParseObject request:requestList) {
            String username = request.getString("UserID");
            String food = request.getString("FoodCategory");
            String time = request.getDate("RequestedTime").toString();

            TableRow row = new TableRow(this);
            TextView who = new TextView(this);
            who.setText(username);
            who.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            who.setWidth(200);
            who.setPadding(3, 3, 3, 3);

            TextView when = new TextView(this);
            when.setText(time);
            when.setWidth(100);
            when.setPadding(3,3,3,3);

            TextView what = new TextView(this);
            what.setText(food);
            what.setWidth(200);
            what.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            what.setPadding(3, 3, 3, 3);

            Button respondButton = new Button(this);
            respondButton.setHeight(10);
            respondButton.setWidth(30);
            respondButton.setText("respond");
            respondButton.setId(i);
            respondButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    respond(v.getId(), requestList);
                }
            });

            row.addView(who);
            row.addView(when);
            row.addView(what);
            row.addView(respondButton);
            table.addView(row);
            i++;

        }
    }

    private void respond(int Id, List<ParseObject> requestList) {
        ParseObject chosen = requestList.get(Id);
        Log.d("chosenusername", chosen.getObjectId());
        chosen.put("Response", true);
        chosen.put("Responder", currentUser.getUsername());
        chosen.saveInBackground();

    }

}
