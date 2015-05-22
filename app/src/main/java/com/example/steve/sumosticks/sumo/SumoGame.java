package com.example.steve.sumosticks.sumo;

/**
 * Created by Steve on 2015-05-21.
 */
import com.example.steve.sumosticks.Screen;
import com.example.steve.sumosticks.impl.AndroidGame;

public class SumoGame extends AndroidGame
{
    public Screen getStartScreen()
    {
        return new LoadingScreen(this);
    }
}
