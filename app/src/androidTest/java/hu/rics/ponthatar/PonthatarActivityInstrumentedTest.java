package hu.rics.ponthatar;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.espresso.Espresso;
import android.view.View;
import android.widget.EditText;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PonthatarActivityInstrumentedTest {

    @Rule
    public ActivityTestRule<PonthatarActivity> activityRule = new ActivityTestRule(
            PonthatarActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("hu.rics.ponthatar", appContext.getPackageName());
    }

    @Test
    public void getNumber_validNumber() {
        int testNumber = 23;
        PonthatarActivity ponthatarActivity = activityRule.getActivity();
        onView(withId(R.id.maximumText)).perform(typeText(Integer.toString(testNumber)), closeSoftKeyboard());
        assertEquals(testNumber,ponthatarActivity.getNumber((EditText)ponthatarActivity.findViewById(R.id.maximumText)));
    }
}
