package com.example.maritza.activitydetail2help.ItemViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maritza.activitydetail2help.R;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemBean;


/**
 * Created by Maritza on 19/03/2017.
 */

public class ItemsView {
    public static RecyclerView.ViewHolder getView(ViewGroup parent, String type){
        View view;
        switch(type){
            case("item_simple_image"):
                view = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_simple_image, parent, false);
                return new ItemSimpleImageViewHolder(view);
            case("item_simple_text"):
                view = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_simple_text, parent, false);
                return new ItemSimpleTextViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_simple_image, parent, false);
                return new ItemSimpleImageViewHolder(view);
        }

    }

    public static void getBind(RecyclerView.ViewHolder view, ItemBean item, String type, Context context){
        switch(type){
            case("item_simple_image"):
                ((ItemSimpleImageViewHolder) view).bindData(item, context);
                break;
            case("item_simple_text"):
                ((ItemSimpleTextViewHolder) view).bindData(item);
                break;
            default:
                ((ItemSimpleImageViewHolder) view).bindData(item, context);
                break;
        }

    }

    /*public static void expand(RecyclerView.ViewHolder view, ItemBean item, String type){
        switch(type){
            case("item_simple_image"):
                ((ItemSimpleImageViewHolder) view).bindData(item, context);
                break;
            case("item_simple_text"):
                ((ItemSimpleTextViewHolder) view).bindData(item);
                break;
            default:
                ((ItemSimpleImageViewHolder) view).bindData(item, context);
                break;
        }
    }*/
}