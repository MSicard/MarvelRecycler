package com.example.maritza.activitydetail2help.ItemViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.maritza.activitydetail2help.R;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemBean;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemSimpleText;


/**
 * Created by Maritza on 19/03/2017.
 */

public class ItemSimpleTextViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView text;
    TextView name;
    LinearLayout expandArea;
    ImageView imageViewExpand;
    public LinearLayout llCollapse;
    private static final int DURATION = 250;

    public ItemSimpleTextViewHolder(View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.textView4);
        text = (TextView) itemView.findViewById(R.id.text);
        imageViewExpand = (ImageView) itemView.findViewById(R.id.imageViewExpand);
        expandArea = (LinearLayout) itemView.findViewById(R.id.expandArea);
        llCollapse = (LinearLayout) itemView.findViewById(R.id.llCollapse);
        llCollapse.setOnClickListener(this);
    }

    /*public ItemSimpleTextViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_simple_text, parent, false);
        return this;
    }*/

    public void bindData(ItemBean data) {
        ItemSimpleText item = (ItemSimpleText) data;
        text.setText(item.getText());
        name.setText(item.getTextView());
    }


    public void bindData(ItemSimpleText data){
        text.setText(data.getText());
        name.setText(data.getTextView());
        /*if (position == expandedPosition) {
            expandArea.setVisibility(View.VISIBLE);
        } else {
            expandArea.setVisibility(View.GONE);
        }*/
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
