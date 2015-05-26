package com.example.steve.sumosticks.impl;

/**
 * Created by Steve on 2015-05-25.
 */
import com.example.steve.sumosticks.GameObject;
import com.example.steve.sumosticks.math.Vector2;

public class DynamicGameObject extends GameObject
{
    public final Vector2 velocity;
    public final Vector2 accel;

    public DynamicGameObject(int x, int y, int radius)
    {
        super(x, y, radius);
        velocity = new Vector2();
        accel = new Vector2();
    }
}
