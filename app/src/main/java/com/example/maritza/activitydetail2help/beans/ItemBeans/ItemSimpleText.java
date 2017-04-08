package com.example.maritza.activitydetail2help.beans.ItemBeans;

import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemBean;

/**
 * Created by Maritza on 15/03/2017.
 */

public class ItemSimpleText extends ItemBean {
    private String text;

    public ItemSimpleText(String imageViewIcon, String textView,  String text) {
        super(imageViewIcon, textView, "item_simple_text");
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
