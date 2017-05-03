package com.example.maritza.activitydetail2help.beans.ItemBeans;


import android.os.Parcel;
import android.os.Parcelable;

public class ItemImage implements Parcelable{
    private String text;
    private String image;


    public ItemImage(String text, String image) {
        this.text = text;
        this.image = image;
    }

    public static final Creator<ItemImage> CREATOR = new Creator<ItemImage>() {
        @Override
        public ItemImage createFromParcel(Parcel in) {
            return new ItemImage(in);
        }

        @Override
        public ItemImage[] newArray(int size) {
            return new ItemImage[size];
        }
    };

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

    public ItemImage(Parcel in){
        text = in.readString();
        image = in.readString();
    }
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeString(image);
    }
    @Override
    public int describeContents() {
        return 0;
    }

}
