package com.example.grace.location;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
<<<<<<< HEAD
import android.widget.EditText;

import com.parse.ParseObject;
=======

import com.parse.ParseUser;
>>>>>>> 1a4e1e340157ec336848a53b3d0f8519629b5afb

import java.util.GregorianCalendar;

public class RequestPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

<<<<<<< HEAD
    public void sendRequest(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        if (!message.isEmpty()){
            ParseObject userRequestObject = new ParseObject("UserRequestObject");
            userRequestObject.put("RequestedTime", message);
            userRequestObject.saveInBackground();
=======
        /*ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();*/

        ParseUser currentUser = ParseUser.getCurrentUser();

        if (currentUser != null) {
            // do stuff with the user
            Log.i("username", currentUser.getUsername());
            //currentUser.logOut();
        } else {
            // show the signup or login screen
            Intent intent = new Intent(this, SignupLogin.class);
            startActivity(intent);
            /*EditText editText = (EditText) findViewById(R.id.edit_message);
            String message = editText.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);*/
>>>>>>> 1a4e1e340157ec336848a53b3d0f8519629b5afb
        }
    }

    public void queryRequest(View view) {
        GregorianCalendar queryTime = 
    }
}
