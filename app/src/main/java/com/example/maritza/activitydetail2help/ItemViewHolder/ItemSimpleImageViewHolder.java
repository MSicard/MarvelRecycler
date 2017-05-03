package com.example.maritza.activitydetail2help.ItemViewHolder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maritza.activitydetail2help.ItemImageRecyclerViewAdapter;
import com.example.maritza.activitydetail2help.R;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemBean;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemSimpleImage;


/**
 * Created by Maritza on 19/03/2017.
 */

public class ItemSimpleImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView image;
    public TextView name;
    public TextView text;
    View view;
    RecyclerView rvImagesTest;

    ItemImageRecyclerViewAdapter adapter;


    public ItemSimpleImageViewHolder(View view){
        super(view);
        image = (ImageView) view.findViewById(R.id.image);
        name = (TextView) view.findViewById(R.id.textView4);
        view.setOnClickListener(this);

        rvImagesTest = (RecyclerView) view.findViewById(R.id.rvImagesTest);

        GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), 4);
        rvImagesTest.setHasFixedSize(false);
        rvImagesTest.setLayoutManager(layoutManager);

    }


  /*  public ItemSimpleImageViewHolder onCreateViewHolder(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_simple_image, parent, false);
        this.view = view;
        return this;
    }*/

    public void bindData(ItemBean data, Context context) {
        ItemSimpleImage item = (ItemSimpleImage) data;
        //image.setImageResource(item.getImage());
        name.setText(item.getTextView());
        //text.setText(item.getTextView());

        adapter = new ItemImageRecyclerViewAdapter(context, item.getImages());
        rvImagesTest.setAdapter(adapter);

    }

    public void bindData(ItemSimpleImage data){
        //image.setImageResource(data.getImage());
        name.setText(data.getTextView());
        //text.setText(data.getTextView());

    }

    @Override
    public void onClick(View v) {
        Log.d("Click - Item", "Clicking on item");
    }
}
