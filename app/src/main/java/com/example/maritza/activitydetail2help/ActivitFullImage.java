package com.example.maritza.activitydetail2help;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Maritza on 24/04/2017.
 */

public class ActivitFullImage extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_galery_full_image);

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        AdapterItemGalery adapter = new AdapterItemGalery(this);

        ImageView imageView = (ImageView) findViewById(R.id.item_galery_image);
        imageView.setImageResource(adapter.images[position]);
    }
}
