package com.example.maritza.activitydetail2help.beans.ItemBeans;

import com.example.maritza.activitydetail2help.beans.ItemBeans.ItemBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maritza on 14/03/2017.
 */

public class ItemSimpleImage extends ItemBean {

    private String text;
    private int image;
    private List images = new ArrayList<>();


    public ItemSimpleImage(String imageViewIcon, String textView, String text, int image, List<ItemImage> images ) {
        super(imageViewIcon, textView, "item_simple_image");
        this.text = text;
        this.image = image;
        this.images = images;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public List getImages() {
        return images;
    }

    public void setImages(List images) {
        this.images = images;
    }
}
