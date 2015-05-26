package com.example.steve.sumosticks;

/**
 * Created by Steve on 2015-05-25.
 */
import com.example.steve.sumosticks.math.Circle;
import com.example.steve.sumosticks.math.Vector2;

public class GameObject
{
    public final Vector2 position;
    public final Circle bounds;

    public GameObject(float x, float y, float radius)
    {
        this.position = new Vector2(x,y);
        this.bounds = new Circle(x, y, radius);
    }
}
