package com.example.steve.sumosticks;

import android.graphics.Bitmap;

public interface Graphics
{
    public static enum PixmapFormat
    {
        ARGB8888, ARGB4444, RGB565
    }

    public Pixmap newPixmap(String filename, PixmapFormat format);

    public void clear(int color);

    public void drawPixel(int x, int y, int color);

    public void drawLine(int x, int y, int x2, int y2, int color);

    public void drawRect(int x, int y, int width, int height, int color);

    public void drawPixMap(Pixmap pixmap, int x, int y, int srcX, int srcY, int srcWidth, int srcHeight);

    public void drawPixMap(Pixmap pixmap, int x, int y);

    public int getWidth();

    public int getHeight();

    public Bitmap getFrameBuffer();
}
