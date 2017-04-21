package com.example.maritza.activitydetail2help.beans.ItemBeans;

import java.util.List;
import java.util.Vector;

/**
 * Created by Maritza on 19/04/2017.
 */

public class ItemGalery extends ItemBean {
    Vector<String> url_image;

    public ItemGalery(String imageViewIcon, String textView, Vector<String> url_image) {
        super(imageViewIcon, textView, "item_galery");
        this.url_image = url_image;
    }

    public Vector<String> getUrl_image() {
        return url_image;
    }

    public void setUrl_image(Vector<String> url_image) {
        this.url_image = url_image;
    }
}
