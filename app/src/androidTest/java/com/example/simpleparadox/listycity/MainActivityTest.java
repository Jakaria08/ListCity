package com.example.simpleparadox.listycity;

import android.app.Activity;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends ActivityTestRule<MainActivity> {

    private Solo solo;

    public MainActivityTest(){
        super(MainActivity.class, false, true);
    }

    @Rule
    public ActivityTestRule<MainActivity> rule =
            new ActivityTestRule<>(MainActivity.class, false, true);

    @Before
    public void setUp() throws Exception{

        solo = new Solo(InstrumentationRegistry.getInstrumentation(),rule.getActivity());
    }
    @Test
    public void start() throws Exception{
        Activity activity = rule.getActivity();
    }
    @Test
    public void checkEmptyList(){
        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);

        solo.clickOnButton("ADD CITY");

        solo.enterText((EditText) solo.getView(R.id.editText_name), "Edmonton");

        solo.clickOnButton("CONFIRM");

        solo.clearEditText((EditText) solo.getView(R.id.editText_name));

        assertTrue(solo.waitForText("Edmonton", 1, 2000));

        solo.clickOnButton("ClEAR ALL");

        assertFalse(solo.searchText("Edmonton"));
    }
    @Test
    public void clickCiyList(){
        MainActivity activity = (MainActivity) solo.getCurrentActivity();

        solo.assertCurrentActivity("Wrong Activity", MainActivity.class);

        solo.clickOnButton("ADD CITY");

        solo.enterText((EditText) solo.getView(R.id.editText_name), "Edmonton");

        solo.clickOnButton("CONFIRM");

        solo.waitForText("Edmonton", 1, 2000);

        final ListView cityList = activity.getCityList();
        String city = (String) cityList.getItemAtPosition(0);
        assertEquals("Edmonton", city);
    }

    @After
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}