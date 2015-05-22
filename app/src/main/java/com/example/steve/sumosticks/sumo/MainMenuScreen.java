package com.example.steve.sumosticks.sumo;

/**
 * Created by Steve on 2015-05-21.
 */
import java.util.List;

import com.example.steve.sumosticks.Game;
import com.example.steve.sumosticks.Graphics;
import com.example.steve.sumosticks.Input.TouchEvent;
import com.example.steve.sumosticks.Screen;

public class MainMenuScreen extends Screen
{
    public MainMenuScreen(Game game)
    {
        super(game);
    }

    public void update(float deltaTime)
    {
        Graphics g = game.getGraphics();
        List <TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        int len = touchEvents.size();
        for(int i = 0; i < len; i++)
        {
            TouchEvent event = touchEvents.get(i);

            if (event.type == TouchEvent.TOUCH_UP)
            {
                if(inBounds(event, 0, g.getHeight() - 64, 64, 64))
                {
                    Settings.soundenabled = !Settings.soundenabled;

                    if (Settings.soundenabled)
                        Assets.click.play(1);
                    return;
                }

                if(inBounds(event, 64, 220, 192, 42))
                {
                    game.setScreen(new GameScreen(game));



                }

                if (inBounds(event, 64, 220 + 42, 192, 42))
                {

                }
            }
        }
    }

}
