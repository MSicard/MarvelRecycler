package com.example.maritza.activitydetail2help.beans.ItemBeans;


public class ItemImage {
    private String text;
    private String image;


    public ItemImage(String text,  String image) {
        this.text = text;
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
