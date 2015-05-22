package com.example.steve.sumosticks.sumo;

/**
 * Created by Steve on 2015-05-22.
 */
import com.example.steve.sumosticks.Pixmap;

public class World
{
    static final int WORLD_WIDTH = 13;
    static final int WORLD_HEIGHT = 10;
    static final int SCORE_INCREMENTAL = 10;
    static final float TICK_INITIAL = 0.5f;
    static final float TICK_DECREMENTAL = 0.05f;

    public Player player;
    public CPU cpu;
    public boolean gameOver = false;
    public int score = 0;

    float tickTime = 0;
    float tick = TICK_INITIAL;

    public World()
    {
        player = new Player(145, 189, 0);
        cpu = new CPU(149, 66, 0);
    }

    public void update(float deltaTime)
    {
        if(gameOver)
            return;

        tickTime += deltaTime;

        while(tickTime > tick)
        {
            tickTime -= tick;
            return;
        }
    }
}

