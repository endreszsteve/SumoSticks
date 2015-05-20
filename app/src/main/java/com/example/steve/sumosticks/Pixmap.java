package com.example.steve.sumosticks;

import com.example.steve.sumosticks.Graphics.PixmapFormat;

public interface Pixmap
{
    public int getWidth();

    public int getHeight();

    public PixmapFormat getFormat();

    public void dispose();
}
