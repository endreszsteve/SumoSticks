package com.example.steve.sumosticks.impl;

import android.graphics.Bitmap;

import com.example.steve.sumosticks.Graphics.PixmapFormat;
import com.example.steve.sumosticks.Pixmap;

public class AndroidPixMap implements Pixmap
{
    Bitmap bitmap;
    PixmapFormat format;

    public AndroidPixMap(Bitmap bitmap, PixmapFormat format)
    {
        this.bitmap = bitmap;
        this.format = format;
    }

    public int getWidth()
    {
        return bitmap.getWidth();
    }

    public int getHeight()
    {
        return bitmap.getHeight();
    }

    public PixmapFormat getFormat()
    {
        return format;
    }

    public  void dispose()
    {
        bitmap.recycle();
    }
}
