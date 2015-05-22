package com.example.steve.sumosticks.sumo;

/**
 * Created by Steve on 2015-05-22.
 */
public class CPU
{
    public static final int TYPE_1 = 0;
    public static final int TYPE_2 = 1;
    public static final int TYPE_3 = 2;
    public static final int TYPE_4 = 3;
    public int x, y;
    public int type;

    public CPU(int x, int y, int type)
    {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void slapLeft()
    {
        type = 1;
    }

    public void slapRight()
    {
        type = 2;
    }

    /*
    public void grab()
    {
        type = 3;
    }
    */
}
