package com.example.imagecure.imagecure;

import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Random rd = new Random();

        ImageView img = (ImageView) findViewById(R.id.launch_logo);
        String str = "img_" + (rd.nextInt(2) + 1);
        int id = getResources().getIdentifier(str, "drawable", getPackageName());
        img.setImageResource(id);

        TextView text = (TextView) findViewById(R.id.greeting);
        Resources res = getResources();
        String[] greeting = res.getStringArray(R.array.greeting);
        int text_id = rd.nextInt(10);
        text.setText(greeting[text_id]);

        MediaPlayer mPlayer = MediaPlayer.create(getApplicationContext(),R.raw.sound);
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mPlayer.start();

        Handler x = new Handler();
        x.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LaunchActivity.this, MainActivity.class));
                finish();
            }
        },2500);
    }

    public ImageView getImageView(LaunchActivity init) {
        return ImageView;
    }
}
