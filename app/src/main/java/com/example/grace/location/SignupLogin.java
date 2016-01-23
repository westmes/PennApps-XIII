package com.example.grace.location;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupLogin extends AppCompatActivity {

    private EditText mUserView;
    private EditText mPasswordView;
    private EditText mEmailView;
    private View mProgressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        mUserView = (EditText) findViewById(R.id.username);
        mPasswordView = (EditText) findViewById(R.id.password);
        mEmailView = (EditText) findViewById(R.id.email);

        Button SignUpButton = (Button) findViewById(R.id.sign_up_button);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
            }
        });

        Button LogInButton = (Button) findViewById(R.id.log_in_button);
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

    }

    private void attemptLogin() {
        String username = mUserView.getText().toString();
        String password = mPasswordView.getText().toString();
        //String email = mEmailView.getText().toString();

        ParseUser.logInInBackground(username, password, new LogInCallback() {
            //boolean cancel = false;
            //View focusView = null;
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                     Intent intent = new Intent(SignupLogin.this, RequestPage.class);
                     startActivity(intent);
                } else {
                    mUserView.setError(e.toString());
                }
            }
        });

    }

    private void signUp() {
        String username = mUserView.getText().toString();
        String password = mPasswordView.getText().toString();
        String email = mEmailView.getText().toString();

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        boolean cancel = false;
        View focusView = null;

        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                //boolean cancel = false;
                //View focusView = null;

                if (e == null) {

                    //Toaster: sign up successful! Now log in.
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    //to figure out what went wrong
                    mUserView.setError(e.toString());
                    //focusView = mUserView;
                    //cancel = true;
                }
            }
        });
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 5;
    }

}
