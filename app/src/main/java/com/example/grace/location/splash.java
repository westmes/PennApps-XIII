package com.example.grace.location;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class splash extends AppCompatActivity {

    private Uri uri;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        context = getApplicationContext();
//        String str;
//
//
//
//        ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig
//                .newBuilder(context)
//                .setDownsampleEnabled(true)
//                .build();
//
//        Fresco.initialize(context);

        ImageView img = (ImageView) findViewById(R.id.splash_pic);
        img.setImageResource(R.drawable.img_1);

        TextView text = (TextView) findViewById(R.id.splash_text);
        text.setText("Eat alone? why not find a U-Foodie!");

        Handler x = new Handler();
        x.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splash.this, MainActivity.class));
                finish();
            }
        }, 2000);
    }
}

