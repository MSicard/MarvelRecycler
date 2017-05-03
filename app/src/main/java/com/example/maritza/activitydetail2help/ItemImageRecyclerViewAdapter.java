package com.example.maritza.activitydetail2help;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemImage;

import java.util.ArrayList;
import java.util.List;

public class ItemImageRecyclerViewAdapter extends RecyclerView.Adapter<ItemImageRecyclerViewAdapter.ViewHolder> {

    List<ItemImage> images = new ArrayList<>();
    private LayoutInflater mInflater;
    Context context;

    // data is passed into the constructor
    public ItemImageRecyclerViewAdapter(Context context, List image) {
        this.mInflater = LayoutInflater.from(context);
        this.images = image;
        this.context = context;
    }

    // inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_image, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemImage image = images.get(position);
        //holder.myTextView.setText(image.getText());

        Glide.with(context)
                .load(image.getImage())
                .crossFade()
                .into(holder.imageView);
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return images.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder{
       // public TextView myTextView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            //myTextView = (TextView) itemView.findViewById(R.id.text);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }


}