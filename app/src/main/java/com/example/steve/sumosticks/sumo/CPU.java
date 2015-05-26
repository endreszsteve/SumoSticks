package com.example.steve.sumosticks.sumo;

import com.example.steve.sumosticks.impl.DynamicGameObject;

/**
 * Created by Steve on 2015-05-22.
 */
public class CPU extends DynamicGameObject
{
    public static final int TYPE_1 = 0;
    public static final int TYPE_2 = 1;
    public static final int TYPE_3 = 2;
    public static final int TYPE_4 = 3;
    public int x, y;
    public int type;

    public CPU(int x, int y, int radius, int type)
    {
        super(x, y, radius);
        this.x = x;
        this.y = y;
        this.type = type;
        accel.set(0,0);
        velocity.set(0,0);
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
