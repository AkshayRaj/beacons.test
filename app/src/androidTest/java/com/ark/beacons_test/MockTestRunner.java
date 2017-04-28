package com.ark.beacons_test;

import android.app.Application;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.AndroidJUnitRunner;

import com.beaconsinspace.android.beacon.detector.BISDetector;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MockTestRunner extends AndroidJUnitRunner {

    @Test
    public void dummyTest(){
        boolean dummy = true;
        assertTrue (dummy);
    }

}
