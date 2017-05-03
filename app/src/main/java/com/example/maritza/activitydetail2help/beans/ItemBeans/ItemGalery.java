package com.example.maritza.activitydetail2help.beans.ItemBeans;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by Maritza on 19/04/2017.
 */

public class ItemGalery extends ItemBean implements Parcelable {
   private ArrayList<ItemImage> images = new ArrayList();
    private ItemGalery galery;

    public ItemGalery(String imageViewIcon, String textView, ArrayList<ItemImage>image) {
        super(imageViewIcon, textView, "item_galery");
        this.images = image;
    }


    protected ItemGalery(Parcel in) {
        super(in.readString(), in.readString(), "item_galery");
        in.readTypedList(images, ItemImage.CREATOR);
    }

    public static final Creator<ItemGalery> CREATOR = new Creator<ItemGalery>() {
        @Override
        public ItemGalery createFromParcel(Parcel in) {
            return new ItemGalery(in);
        }

        @Override
        public ItemGalery[] newArray(int size) {
            return new ItemGalery[size];
        }
    };

    public ArrayList getImages() {
        return images;
    }

    public void setImages(ArrayList images) {
        this.images = images;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(getImageViewIcon());
        dest.writeString(getTextView());
        dest.writeString(getTypeAbstract());
        dest.writeList(images);
    }
}
