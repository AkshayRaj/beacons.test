package com.ark.beacons_test;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.beaconsinspace.android.beacon.detector.BISDetector;
import com.beaconsinspace.android.beacon.detector.BISProcessManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
@MediumTest
public class BISDetectorTest {

    Context mContext;
    @Rule
    public final ServiceTestRule mServiceRule = new ServiceTestRule();

    @Before
    public void setup(){
        mContext = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void testBISDetectorService() {
        try {
            mServiceRule.startService(new Intent(mContext, BISDetector.class));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        // testing if service has started
        assertEquals("Context in SDK not equal to instrumentation context.", mContext.getApplicationContext(), BISDetector.getContext().getApplicationContext());
        //testing if BISProcessManager has been initialized
        assertNotNull("BISProcessManager is null.", BISProcessManager.getInstance());
    }

    @After
    public void tearDown(){
        mContext = null;
    }
}
