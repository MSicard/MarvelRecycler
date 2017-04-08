package com.example.maritza.activitydetail2help.beans.ItemBeans;

/**
 * Created by Maritza on 15/03/2017.
 */

abstract public class ItemBean {

    private String imageViewIcon;
    private String textView;
    private String typeAbstract;

    public String getImageViewIcon() {
        return imageViewIcon;
    }

    public void setImageViewIcon(String imageViewIcon) {
        this.imageViewIcon = imageViewIcon;
    }

    public String getTypeAbstract() {
        return typeAbstract;
    }

    public void setTypeAbstract(String typeAbstract) {
        this.typeAbstract = typeAbstract;
    }

    public String getTextView() {
        return textView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }


    public ItemBean(String imageViewIcon, String textView, String type) {
        this.imageViewIcon = imageViewIcon;
        this.textView = textView;
        this.typeAbstract = type;
    }
}

