package com.example.steve.sumosticks.sumo;

import com.example.steve.sumosticks.impl.DynamicGameObject;
import com.example.steve.sumosticks.impl.AccelerometerHandler;

/**
 * Created by Steve on 2015-05-22.
 */

public class Player extends DynamicGameObject
{
    public static int TYPE_1 = 0;
    public static int TYPE_2 = 1;
    public static int TYPE_3 = 2;
    public static int TYPE_4 = 3;
    public int x, y;
    public int type;
    public final int MAX_VEL = 1;

    public AccelerometerHandler accelerometerHandler;

    public Player(int x, int y, int radius, int type)
    {
        super(x, y, radius);
        this.x = x;
        this.y = y;
        this.type = type;
        accel.set(0,0);
        velocity.set(1,1);

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
