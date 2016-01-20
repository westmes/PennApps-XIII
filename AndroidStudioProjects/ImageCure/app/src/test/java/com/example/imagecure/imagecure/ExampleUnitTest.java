import org.junit.Test;
import java.util.regex.Pattern;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.widget.ImageView;

import com.example.imagecure.imagecure.LaunchActivity;

import org.junit.Test;

import java.lang.Exception;
import java.util.Random;

import static org.junit.Assert.*;

import android.support.test.runner.AndroidJUnit4;
import android.util.Pair;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
<<<<<<< HEAD
public class ExampleUnitTest {
//    @Test
//    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);
//    }
=======
@RunWith(AndroidJUnit4.class)
public class MainActivityUnitTest extends ActivityInstrumentationTestCase2 {

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);
        mMainActivity = getActivity();
        mClickButton = (Button) mMainActivity.findViewById(R.id.insta_button);
    }


    @MediumTest
    public void testClickInstaButton() {
        // String expectedInfoText = mClickFunActivity.getString(R.string.info_text);
        //TouchUtils.clickView(this, mClickButton);
        mMainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // click button and open next activity.
                mClickbutton.performClick();
            }
        });

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        NextActivity nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
        //assertTrue(View.VISIBLE == mInfoTextView.getVisibility());
        //assertEquals(expectedInfoText, mInfoTextView.getText());
    }

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
>>>>>>> 7f8828d0b75c446cb54bff52546969bbde70f8eb

    @Test
    public void testLaunchPicRandom() throws Exception {
        LaunchActivity launchActivity = new LaunchActivity();
        ImageView imageView = launchActivity.getImageView(launchActivity);


        assert(imageView.setImageResource();

    }
}