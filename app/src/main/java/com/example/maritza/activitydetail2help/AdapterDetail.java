package com.example.maritza.activitydetail2help;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.maritza.activitydetail2help.ItemViewHolder.ItemsView;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemBean;

import java.util.List;

/**
 * Created by Maritza on 14/03/2017.
 */

public class AdapterDetail extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemBean> items;
    private int expandedPosition = -1;
    Context context;


    public AdapterDetail(Context context, List<ItemBean> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        String type = getItemType(i);
       return  ItemsView.getView(viewGroup, type);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String type = getItemType(position);
        ItemsView.getBind(holder, items.get(position), type, context);
        int i = 0;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public String getItemType(int position){
        return items.get(position).getTypeAbstract();
    }

}
