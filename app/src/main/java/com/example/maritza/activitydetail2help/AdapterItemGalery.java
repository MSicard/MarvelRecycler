package com.example.maritza.activitydetail2help;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.maritza.activitydetail2help.R;

import java.util.List;

/**
 * Created by Maritza on 19/04/2017.
 */

public class AdapterItemGalery extends BaseAdapter {

    public Integer[] images = {
            R.drawable.detail_antman,
            R.drawable.detail_deapool,
            R.drawable.detail_strange,
            R.drawable.detail_thor,
            R.drawable.detail_wolverine
    };        //aqui van los R.drawable


    Context context;

    public AdapterItemGalery(Context c){
        this.context = c;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(images[i]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(240,240));
        return null;
        /*getHttpObservable().setServerAddress(background);
        getHttpObservable().requestImageByUrl(background,imageToolbar);*/
    }
}