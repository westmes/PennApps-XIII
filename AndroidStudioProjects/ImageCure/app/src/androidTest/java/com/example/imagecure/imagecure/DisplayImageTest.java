package com.example.imagecure.imagecure;

import android.content.Intent;
import android.net.Uri;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import com.facebook.drawee.view.SimpleDraweeView;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;

import static org.hamcrest.core.IsNull.notNullValue;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Grace on 12/14/15.
 */
public class DisplayImageTest {

    @Rule
    public IntentsTestRule<DisplayImage> mDisplayRule =
            new IntentsTestRule<>(DisplayImage.class);

    @Test
    /**
     * Test Case #14
     * If the set_wallpaper option respond
     */
    public void wallpaperTest()  {
        onView(withId(R.id.action_setwallpaper)).check(matches(notNullValue()));
        onView(withId(R.id.action_setwallpaper))
                .perform(click());
    }

    @Test
    /**
     * Test Case #15
     * If the share_image option respond
     */
    public void shareTest()  {
        onView(withId(R.id.menu_item_share)).check(matches(notNullValue()));
        onView(withId(R.id.menu_item_share))
                .perform(click());
    }

}
