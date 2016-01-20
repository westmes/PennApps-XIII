package com.example.imagecure.imagecure;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

public class DisplayInstaImage extends AppCompatActivity {

    String accessTokenString = "2322114889.a81889d.580a2e2389954ec0b632b5bbc2d3d49b";
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        Fresco.initialize(context);
        setContentView(R.layout.activity_display_insta_image);

        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.my_instaimage_view);
        InstagramApp instagramApp =new InstagramApp(context, draweeView);
        instagramApp.execute(accessTokenString);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
