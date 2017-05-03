package com.example.maritza.activitydetail2help.ItemViewHolder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.maritza.activitydetail2help.AdapterItemGalery;
import com.example.maritza.activitydetail2help.R;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemBean;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemGalery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maritza on 19/04/2017.
 */

public class ItemGaleryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final int DURATION = 250;
    public LinearLayout llCollapse;
    public RelativeLayout expandArea;
    public ImageView imageViewExpand;
    public ImageView icon;
    public TextView title;
    public RecyclerView recyclerView;
    AdapterItemGalery adapterItemGalery;



    public ItemGaleryViewHolder(View itemView) {
        super(itemView);
        llCollapse = (LinearLayout) itemView.findViewById(R.id.item_galery_collapse);
        icon = (ImageView) itemView.findViewById(R.id.item_galery_icon);
        imageViewExpand = (ImageView) itemView.findViewById(R.id.imageViewExpand);
        expandArea = (RelativeLayout) itemView.findViewById(R.id.item_galery_expandArea);
        title = (TextView) itemView.findViewById(R.id.item_galery_title);
        llCollapse.setOnClickListener(this);

        recyclerView =(RecyclerView) itemView.findViewById(R.id.item_galery_recyclerview);
        StaggeredGridLayoutManager layoutManager = new  StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void bindData(ItemBean data, Context context){
        ItemGalery item = (ItemGalery) data;
        title.setText(item.getTextView());

        adapterItemGalery = new AdapterItemGalery(context, item.getImages());
        recyclerView.setAdapter(adapterItemGalery);
    }

    private void rotate(float angle) {
        Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(true);
        animation.setDuration(DURATION);
        imageViewExpand.startAnimation(animation);
    }


    @Override
    public void onClick(View view) {
        if (expandArea.getVisibility() == View.GONE) {
            ExpandAndCollapseViewUtil.expand(expandArea, DURATION);
            imageViewExpand.setImageResource(R.drawable.ico_grey_down);
            rotate(-180.0f);
        } else {
            ExpandAndCollapseViewUtil.collapse(expandArea, DURATION);
            imageViewExpand.setImageResource(R.drawable.ico_grey_up);
            rotate(180.0f);
        }
    }
}
