package com.example.maritza.activitydetail2help.ItemViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.maritza.activitydetail2help.R;
import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemBean;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by Maritza on 30/04/2017.
 */

public class ItemAdViewViewHolder extends RecyclerView.ViewHolder {

    AdView mAdView;

    public ItemAdViewViewHolder(View itemView) {
        super(itemView);
        mAdView = (AdView) itemView.findViewById(R.id.adView);
    }

    public void bindData(ItemBean data){
        AdRequest request = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
                .addTestDevice("AC98C820A50B4AD8A2106EDE96FB87D4")  // An example device ID
                .build();
        mAdView.loadAd(request);
    }
}
