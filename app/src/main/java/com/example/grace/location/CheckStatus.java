package com.example.grace.location;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class CheckStatus extends AppCompatActivity {

    ParseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_status);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        currentUser = ParseUser.getCurrentUser();
        ParseQuery<ParseObject> responses = ParseQuery.getQuery("UserRequestObject");
        responses.whereEqualTo("UserID", currentUser.getUsername());
        responses.whereEqualTo("Response", true);
        responses.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> responseList, com.parse.ParseException e) {
                if (e == null) {
                    Log.d("requests", "Retrieved " + responseList.size() + " requests");
                    if (responseList.size() == 0) {
                        TextView textView = new TextView(getApplicationContext());
                        textView.setTextSize(40);
                        textView.setText("No one responds");

                        RelativeLayout layout = (RelativeLayout) findViewById(R.id.checkStatus);
                        layout.addView(textView);
                    } else displayResponseList(responseList);
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }


        });

    }

    private void displayResponseList(final List<ParseObject> responseList) {

        //Log.d("size",requestList.size()+"requests");
        TableLayout table = (TableLayout)findViewById(R.id.stats_table);
        int i=0;
        for (ParseObject response:responseList) {
            String username = response.getString("UserID");
            String food = response.getString("FoodCategory");
            String time = response.getDate("RequestedTime").toString();
            String responder = response.getString("Responder");
            String message = response.getString("Message");

            TableRow row = new TableRow(this);
            TableRow messageRow = new TableRow(this);

            TextView who = new TextView(this);
            who.setText(username);
            who.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            who.setWidth(200);
            who.setPadding(3, 3, 3, 3);

            TextView when = new TextView(this);
            when.setText(time);
            when.setWidth(100);
            when.setPadding(3, 3, 3, 3);

            TextView what = new TextView(this);
            what.setText(food);
            what.setWidth(200);
            what.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            what.setPadding(3, 3, 3, 3);

            TextView with = new TextView(this);
            with.setText(responder);
            with.setWidth(200);
            with.setPadding(3, 3, 3, 3);

            row.addView(who);
            row.addView(when);
            row.addView(what);
            row.addView(with);

            TextView info = new TextView(this);
            info.setText(message);
            info.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            messageRow.addView(info);

            table.addView(row);
            table.addView(messageRow);

        }
    }
}
