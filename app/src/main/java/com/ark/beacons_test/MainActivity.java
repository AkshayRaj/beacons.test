package com.ark.beacons_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//BIS
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

import com.beaconsinspace.android.beacon.detector.BISDetector;

public class MainActivity extends AppCompatActivity {

    public static final String BIS_API_KEY = "C64002135D824406B84EA06FBEEC54105897F167EF4CF652285528";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            // Android M permission check
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            {
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
            }
        }

        BISDetector.configure( BIS_API_KEY, getApplicationContext(), null );
    }
}
