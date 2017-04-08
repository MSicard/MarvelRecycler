package com.example.maritza.activitydetail2help.ItemViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maritza.activitydetail2help.R;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemBean;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemSimpleImage;


/**
 * Created by Maritza on 19/03/2017.
 */

public class ItemSimpleImageViewHolder extends RecyclerView.ViewHolder {
    public ImageView image;
    public TextView name;
    public TextView text;
    View view;

    public ItemSimpleImageViewHolder(View view){
        super(view);
        image = (ImageView) view.findViewById(R.id.image);
        name = (TextView) view.findViewById(R.id.textView4);
        text = (TextView) view.findViewById(R.id.text);
    }


  /*  public ItemSimpleImageViewHolder onCreateViewHolder(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_simple_image, parent, false);
        this.view = view;
        return this;
    }*/

    public void bindData(ItemBean data) {
        ItemSimpleImage item = (ItemSimpleImage) data;
        image.setImageResource(item.getImage());
        name.setText(item.getText());
        text.setText(item.getTextView());
    }

    public void bindData(ItemSimpleImage data){
        image.setImageResource(data.getImage());
        name.setText(data.getText());
        text.setText(data.getTextView());

    }
}
