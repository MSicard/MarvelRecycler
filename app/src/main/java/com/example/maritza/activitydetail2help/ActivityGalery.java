package com.example.maritza.activitydetail2help;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by Maritza on 24/04/2017.
 */

public class ActivityGalery extends Activity{
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery);
        //GridView gridView =(GridView) findViewById(R.id.item_galery_gridview);
        //gridView.setAdapter(new AdapterItemGalery(this));

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest request = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
                .addTestDevice("AC98C820A50B4AD8A2106EDE96FB87D4")  // An example device ID
                .build();
        mAdView.loadAd(request);
    }
}
