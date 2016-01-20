package com.example.imagecure.imagecure;

import android.app.Application;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ApplicationTestCase;
import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imagecure.imagecure.DisplayInstaImage;
import com.example.imagecure.imagecure.LaunchActivity;
import com.example.imagecure.imagecure.MainActivity;
import com.example.imagecure.imagecure.R;

import junit.framework.TestCase;

import org.junit.runner.RunWith;
import com.example.imagecure.imagecure.LaunchActivity;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class LaunchActivityTest extends ActivityInstrumentationTestCase2 {

    private LaunchActivity mLaunchActivity;
    private MainActivity mMainActivity;
    private TextView greeting;
    private ImageView greetingImage;

    public LaunchActivityTest() {
        super(LaunchActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mLaunchActivity = (LaunchActivity)getActivity();
        greeting = (TextView) mLaunchActivity.findViewById(R.id.greeting);

    }


    /**
     * Test Case #1
     * Test whether launcher can show greeting message
     */
    public void testGreetingTextView() {
        final String actual = greeting.getText().toString();
        assertNotNull(actual);
    }

    /**
     *  Test Case #2
     * Test if the sound effect is played
     */
    public void testShouldStartPlayingSound() {

        MediaPlayer mPlayer = MediaPlayer.create(mLaunchActivity.getApplicationContext(), R.raw.sound);
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mPlayer.start();
        assertTrue(mPlayer.isPlaying());
    }

}