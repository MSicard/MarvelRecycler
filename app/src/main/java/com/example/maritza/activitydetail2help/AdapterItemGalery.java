package com.example.maritza.activitydetail2help;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.maritza.activitydetail2help.ItemViewHolder.ItemGaleryViewHolder;
import com.example.maritza.activitydetail2help.ItemViewHolder.ItemSimpleImageViewHolder;
import com.example.maritza.activitydetail2help.R;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemGalery;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemImage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maritza on 19/04/2017.
 */

public class AdapterItemGalery extends RecyclerView.Adapter<AdapterItemGalery.ViewHolder> {


    ArrayList<ItemImage> images = new ArrayList<>();
    private LayoutInflater mInflater;
    Context context;

    // data is passed into the constructor
    public AdapterItemGalery(Context context, ArrayList<ItemImage> images) {
        this.mInflater = LayoutInflater.from(context);
        this.images = images;
        this.context = context;
    }

    // inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_galery_image, parent, false);
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
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.item_galery_image);
            imageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, ActivityFullImage.class);
            intent.putParcelableArrayListExtra("ITEM", images);
            intent.putExtra("POS", getItemId());
            context.startActivity(intent);
        }
    }
}