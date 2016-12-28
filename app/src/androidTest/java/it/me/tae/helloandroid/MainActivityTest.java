package it.me.tae.helloandroid;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(Parameterized.class)
public class MainActivityTest {
    private String value;

    @Parameterized.Parameters
    public static Iterable<Object> data() {
        return Arrays.asList(new Object[]{"20", "30", "40"});
    }

    public MainActivityTest(String value) {
        this.value = value;
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        onView(withId(R.id.edtValue)).perform(replaceText("test " + value), closeSoftKeyboard());
        onView(withId(R.id.btnVaule)).perform(click());

        onView(withId(R.id.tvValue)).check(matches(withText("value : test " + value)));
    }
}
