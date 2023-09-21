package com.webgeoservices.geofencingsizetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;

import com.webgeoservices.woosmapgeofencing.PositionsManager;
import com.webgeoservices.woosmapgeofencing.Woosmap;
import com.webgeoservices.woosmapgeofencing.WoosmapSettings;
import com.webgeoservices.woosmapgeofencingcore.database.WoosmapDb;


public class MainActivity extends AppCompatActivity {
    Woosmap woosmap;
    PositionsManager positionsManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},101);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        initWoosmap();
    }

    private void initWoosmap(){
        WoosmapSettings.privateKeyWoosmapAPI = "";
        woosmap = Woosmap.getInstance().initializeWoosmap(this);
        woosmap.startTracking(Woosmap.ConfigurationProfile.liveTracking);
        positionsManager = new PositionsManager(getApplicationContext(), WoosmapDb.getInstance( getApplicationContext() ));
    }
}