package com.example.imagecure.imagecure;

import android.graphics.Bitmap;

/**
 * Created by hilarydeng on 12/7/15.
 */
public class ImageItem {

    private Bitmap image;
    private String title;

    /**
     * This imageitem class creates an object with image and title to be displayed in the gridview
     * @param image
     * @param title
     */
    public ImageItem(Bitmap image, String title) {
        super();
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}




