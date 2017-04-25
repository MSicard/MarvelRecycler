package com.example.maritza.activitydetail2help;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

/**
 * Created by Maritza on 24/04/2017.
 */

public class ActivityGalery extends Activity{
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery);
        GridView gridView =(GridView) findViewById(R.id.item_galery_gridview);
        gridView.setAdapter(new AdapterItemGalery(this));
    }
}
