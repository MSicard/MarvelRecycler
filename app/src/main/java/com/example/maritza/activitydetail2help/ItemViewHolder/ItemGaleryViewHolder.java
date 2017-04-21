package com.example.maritza.activitydetail2help.ItemViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.maritza.activitydetail2help.ActivityDetail;
import com.example.maritza.activitydetail2help.AdapterItemGalery;
import com.example.maritza.activitydetail2help.R;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemBean;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemGalery;

import static com.example.maritza.activitydetail2help.R.id.imageViewExpand;

/**
 * Created by Maritza on 19/04/2017.
 */

public class ItemGaleryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private static final int DURATION = 250;
    RelativeLayout expandArea;
    ImageView imageViewExpand;
    ImageView icon;
    TextView title;
    GridView gridView;
    Context context;
    AdapterItemGalery adapterItemGalery;


    public ItemGaleryViewHolder(View itemView, Context context) {
        super(itemView);
        expandArea = (RelativeLayout) itemView.findViewById(R.id.item_galery_expandArea);
        title = (TextView) itemView.findViewById(R.id.item_galery_title);
        gridView =(GridView) itemView.findViewById(R.id.item_galery_gridview);
        this.context = context;
    }

    public void bindData(ItemBean data){
        ItemGalery item = (ItemGalery) data;
        title.setText(item.getTextView());
        adapterItemGalery = new AdapterItemGalery(context);
        gridView.setAdapter(adapterItemGalery);
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
