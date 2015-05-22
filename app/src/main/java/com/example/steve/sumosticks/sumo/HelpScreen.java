package com.example.steve.sumosticks.sumo;

/**
 * Created by Steve on 2015-05-21.
 */
import java.util.List;

import com.example.steve.sumosticks.Game;
import com.example.steve.sumosticks.Graphics;
import com.example.steve.sumosticks.Input.TouchEvent;
import com.example.steve.sumosticks.Screen;

public class HelpScreen extends Screen
{
    public HelpScreen(Game game)
    {
        super(game);
    }

    @Override
    public void update(float deltaTime)
    {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();

        int len = touchEvents.size();
        for (int i = 0; i < len; i++)
        {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP)
            {
                if(event.x > 256 && event.y > 416)
                {
                    game.setScreen(new HelpScreen2(game));
                    if(Settings.soundenabled)
                        Assets.click.play(1);
                    return;
                }
            }
        }
    }

    @Override
    public void present(float deltaTime)
    {
        Graphics g = game.getGraphics();
        g.drawPixMap(Assets.background, 0, 0);
        g.drawPixMap(Assets.help1, 64, 100);
        g.drawPixMap(Assets.buttons, 256, 416, 0, 64, 64, 64);
    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void dispose()
    {

    }
}
