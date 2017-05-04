package hu.rics.ponthatar;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PonthatarActivityInstrumentedTest {
    PonthatarActivity ponthatarActivity;

    @Rule
    public ActivityTestRule<PonthatarActivity> activityRule = new ActivityTestRule(
            PonthatarActivity.class);

    @Before
    public void setup() {
        ponthatarActivity = activityRule.getActivity();
    }

    @Test
    public void useAppContext() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("hu.rics.ponthatar", appContext.getPackageName());
    }

    @Test
    public void getNumber_validNumber() {
        int testNumber = 23;
        onView(withId(R.id.maximumText)).perform(replaceText(Integer.toString(testNumber)), closeSoftKeyboard());
        assertEquals(testNumber,ponthatarActivity.getNumber((EditText)ponthatarActivity.findViewById(R.id.maximumText)));
    }

    @Test
    public void getNumber_invalidNumber() {
        onView(withId(R.id.maximumText)).perform(replaceText("alma"), closeSoftKeyboard());
        assertEquals(0,ponthatarActivity.getNumber((EditText)ponthatarActivity.findViewById(R.id.maximumText)));
    }

    @Test
    public void calcValue_valuesSet() {
        int maxPoint = 55;
        int percent = 85;
        float upperMinValue = (float)maxPoint * percent / 100;
        float lowerMaxValue = (float)maxPoint * percent / 100 - 1;
        DecimalFormat df = new DecimalFormat("###");
        df.setRoundingMode(RoundingMode.HALF_DOWN);
        onView(withId(R.id.maximumText)).perform(replaceText(Integer.toString(maxPoint)), closeSoftKeyboard());
        onView(withId(R.id.min5pText)).perform(replaceText(Integer.toString(percent)), closeSoftKeyboard());
        ponthatarActivity.runOnUiThread(new Runnable() {
                          @Override
                          public void run() {
                              ponthatarActivity.calcValue(
                                      (EditText) ponthatarActivity.findViewById(R.id.maximumText),
                                      (EditText) ponthatarActivity.findViewById(R.id.min5pText),
                                      (TextView) ponthatarActivity.findViewById(R.id.min5vText),
                                      (TextView) ponthatarActivity.findViewById(R.id.max4vText));
                              synchronized (ponthatarActivity) {
                                  ponthatarActivity.notify();
                              }
                          }
                      });
        try {
            synchronized (ponthatarActivity) {
                while( ((TextView) ponthatarActivity.findViewById(R.id.min5vText)).getText().length() == 0 ) {
                    ponthatarActivity.wait();
                }
            }
            onView(withId(R.id.min5vText)).check(matches(withText(df.format(upperMinValue))));
            onView(withId(R.id.max4vText)).check(matches(withText(df.format(lowerMaxValue))));
        } catch(InterruptedException ie) {
            Log.e("PAITest","Cannot run test:" + ie);
        }
    }
}
