package com.example.maritza.activitydetail2help;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemGalery;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemImage;

import java.util.ArrayList;

/**
 * Created by Maritza on 24/04/2017.
 */

public class ActivityFullImage extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<ItemImage> images = new ArrayList();
    private ImageView imageView;
    private ImageView right;
    private ImageView left;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_galery_full_image);

        images = this.getIntent().getParcelableArrayListExtra("ITEM");
        getIntent().getIntExtra("POS", position);

        imageView = (ImageView) findViewById(R.id.item_galery_image);
        right = (ImageView) findViewById(R.id.item_full_image_right_arrow);
        left = (ImageView) findViewById(R.id.item_full_image_left_arrow);
        right.setOnClickListener(this);
        left.setOnClickListener(this);
        changeImage();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.item_full_image_right_arrow:
                position++;
                changeImage();
                break;
            case R.id.item_full_image_left_arrow:
                position--;
                changeImage();
                break;
        }
    }

    private void changeImage(){
        Glide.with(this.getBaseContext())
                .load(images.get(position).getImage())
                .crossFade()
                .into(imageView);
        if(position >= images.size() - 1){
            right.setVisibility(View.INVISIBLE);
            right.setEnabled(false);
        }
        else if(position <= 0){
            left.setVisibility(View.INVISIBLE);
            left.setEnabled(false);
        }
        else{
            right.setVisibility(View.VISIBLE);
            right.setEnabled(true);
            left.setVisibility(View.VISIBLE);
            left.setEnabled(true);
        }
    }
}
