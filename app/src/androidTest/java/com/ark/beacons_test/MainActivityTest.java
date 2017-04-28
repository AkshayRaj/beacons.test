package com.ark.beacons_test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import com.beaconsinspace.android.beacon.detector.BISDetector;
import com.beaconsinspace.android.beacon.detector.RestartServiceReceiver;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by Akshayraj on 4/28/17.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    public static final String BIS_API_KEY = "C64002135D824406B84EA06FBEEC54105897F167EF4CF652285528";

    Context mContext = InstrumentationRegistry.getTargetContext();
    @Rule
    public ActivityTestRule<MainActivity> rule  = new  ActivityTestRule<>(MainActivity.class);
    private RestartServiceReceiver mReceiver;

    @Before
    public void setup(){
        mContext = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void uiWidgetTest() throws Exception {
        MainActivity activity = rule.getActivity();
        TextView viewById = (TextView) activity.findViewById(R.id.textview1);
        assertThat(viewById,notNullValue());
        assertThat(viewById, instanceOf(TextView.class));
    }

    @Test
    public void testRestartReceiver() {
        //prepare data for onReceive and call it
        Intent intent = new Intent("BootstrapBeaconsInSpace");
        mReceiver = new RestartServiceReceiver();
        mReceiver.onReceive(mContext, intent);

        assertEquals("RestartBroadcastReceiver.onReceive() did not start BISDetector.", mContext.getApplicationContext(), BISDetector.getContext().getApplicationContext());
    }

    @After
    public void tearDown(){
        mContext = null;
    }
}
