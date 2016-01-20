package com.example.imagecure.imagecure;

import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.GridView;
import android.widget.ImageButton;

import com.facebook.drawee.view.SimpleDraweeView;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by anniland on 12/14/15.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2 {

    private MainActivity mMainActivity;
    ImageButton mClickButton;
    GridView mGridView;
    DisplayImage nextActivity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mMainActivity = (MainActivity)getActivity();
        setActivityInitialTouchMode(true);
        mClickButton = (ImageButton) mMainActivity.findViewById(R.id.insta_button);
        mGridView = (GridView) mMainActivity.findViewById(R.id.gridview);
    }

    /**
     * Test Case #3
     * If the image @ Row1, Col2 is associated with the right name - "Stressed"
     */
    public void testImageItemTitle() {
        ImageItem item = (ImageItem) mGridView.getItemAtPosition(1);
        assertEquals("Stressed", item.getTitle());
    }

    /**
     *Test Case #4
     *Test Instagram Button in the MainActivity to see if it starts DisplayInstaImage Activity
     */
    @MediumTest
    public void testClickInstaButton() {
        TouchUtils.clickView(this, mClickButton);
        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // click button and open next activity.
                mClickButton.performClick();
            }
        });

        //Watch for the timeout, example values 5000 in ms;
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(DisplayInstaImage.class.getName(), null, false);
        DisplayInstaImage nextActivity = (DisplayInstaImage) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    /**
     * Test Case #5
     *Test whether Click at "Happy" can start DisplayImage Activity
     */
    public void testClickHappy() {

        GridItemClick_StartNextActivity(0);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    /**
     * Test Case #6
     *Test whether Click at "Angry" can start DisplayImage Activity
     */
    public void testClickAngry() {

        GridItemClick_StartNextActivity(2);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    /**
     * Test Case #7
     *Test whether click at "Nervous" can start DisplayImage Activity
     */
    public void testClickNervous() {

        GridItemClick_StartNextActivity (4);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    /**
     * Test Case #8
     * Test whether Click at "Happy" can correctly show image from the "Happy" Set.
     */
    public void testClickGrid_Happy_RightImage() {

        GridItemClick_StartNextActivity (0);

        SimpleDraweeView draweeView = (SimpleDraweeView) nextActivity.findViewById(R.id.my_image_view);
        String url = (String)draweeView.getTag();

        //Default animal set is dog
        ImageSet_dog imageSetDog = new ImageSet_dog();
        assertTrue(imageSetDog.getEmotionSet(0).contains(url));

        nextActivity.finish();
    }

    /**
     * Test Case #9
     * Test whether Click at "Nervous" can correctly show image from the "Nervous" Set.
     */
    public void testClickGrid_Nervous_RightImage() {

        GridItemClick_StartNextActivity (2);

        SimpleDraweeView draweeView = (SimpleDraweeView) nextActivity.findViewById(R.id.my_image_view);
        String url = (String)draweeView.getTag();

        //Default animal set is dog
        ImageSet_dog imageSetDog = new ImageSet_dog();
        assertTrue(imageSetDog.getEmotionSet(2).contains(url));

        nextActivity.finish();
    }

    /**
     * Test Case #10
     * Test whether Click at "Angry" can correctly show image from the "Nervous" Set.
     */
    public void testClickGrid_Angry_RightImage() {

        GridItemClick_StartNextActivity (4);

        SimpleDraweeView draweeView = (SimpleDraweeView) nextActivity.findViewById(R.id.my_image_view);
        String url = (String)draweeView.getTag();

        //Default animal set is dog
        ImageSet_dog imageSetDog = new ImageSet_dog();
        assertTrue(imageSetDog.getEmotionSet(4).contains(url));

        nextActivity.finish();
    }

    /**
     * Test Case #11
     * Test whether choose the cat option, the image set can change to cat.
     *
     */
    public void testCat()  {
        onView(withId(R.id.action_cat)).perform(click());

        GridItemClick_StartNextActivity(0);

        SimpleDraweeView draweeView = (SimpleDraweeView) nextActivity.findViewById(R.id.my_image_view);
        String url = (String)draweeView.getTag();
        ImageSet_cat imageSetCat = new ImageSet_cat();

        assertTrue(imageSetCat.getEmotionSet(0).contains(url));

        nextActivity.finish();
    }

    /**
     * Click on a positioned image in the grid, and start DisplayImage Acitivty
     * @param i is the position in the grid
     */
    private void GridItemClick_StartNextActivity (int i) {
        final int position = i;
        TouchUtils.clickView(this, mGridView);
        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mGridView.performItemClick(
                        mGridView.getAdapter().getView(position, null, null),
                        position,
                        mGridView.getAdapter().getItemId(position));
            }
        });

        //Watch for the timeout, example values 5000 in ms;
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(DisplayImage.class.getName(), null, false);
        nextActivity = (DisplayImage) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
    }


}