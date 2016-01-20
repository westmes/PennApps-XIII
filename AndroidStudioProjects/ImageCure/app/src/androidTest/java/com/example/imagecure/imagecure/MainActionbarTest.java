package com.example.imagecure.imagecure;

import android.support.test.espresso.intent.rule.IntentsTestRule;

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
public class MainActionbarTest {

    @Rule
    public IntentsTestRule<MainActivity> mMainActivity =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    /**
     * Test Case #12
     * If the cat button can respond
     */
    public void catTest()  {
        onView(withId(R.id.action_cat)).check(matches(notNullValue()));
        onView(withId(R.id.action_cat))
                .perform(click());
    }

    @Test
    /**
     * Test Case #13
     * If the dog button can respond
     */
    public void dogTest()  {
        onView(withId(R.id.action_dog)).check(matches(notNullValue()));
        onView(withId(R.id.action_dog))
                .perform(click());
    }

}
