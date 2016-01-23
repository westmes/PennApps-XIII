package com.example.grace.location;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    TextView textView1;
    TextView textView2;
    Intent map_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent map_int = getIntent();
        double mLongtitude = map_int.getDoubleExtra("LOCAL1",1);
        double mLatitude = map_int.getDoubleExtra("LOCAL2",0);

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView1.setText(String.valueOf(mLatitude));
        textView2.setText(String.valueOf(mLongtitude));


    }
}
