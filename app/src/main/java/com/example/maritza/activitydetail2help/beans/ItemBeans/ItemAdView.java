package com.example.maritza.activitydetail2help.beans.ItemBeans;

/**
 * Created by Maritza on 30/04/2017.
 */

public class ItemAdView extends ItemBean {

    String idDevice;

    public ItemAdView(String url_json, String idUnit, String idDevice) {
        super(url_json, idUnit, "item_adview");
        this.idDevice = idDevice;
    }

    public String getIdDevice() {
        return idDevice;
    }

    public void setIdDevice(String idDevice) {
        this.idDevice = idDevice;
    }
}
