package com.example.steve.sumosticks.sumo;

/**
 * Created by Steve on 2015-05-21.
 */
import java.util.List;
import java.util.Set;

import android.graphics.Color;

import com.example.steve.sumosticks.Game;
import com.example.steve.sumosticks.Graphics;
import com.example.steve.sumosticks.Input.TouchEvent;
import com.example.steve.sumosticks.Pixmap;
import com.example.steve.sumosticks.Screen;
import com.example.steve.sumosticks.impl.MultiTouchHandler;

public class GameScreen extends Screen
{
    enum GameState{
        Ready,
        Running,
        Paused,
        GameOver
    }

    GameState state = GameState.Ready;
    World world;
    int oldScore = 0;
    String score = "0";

    public GameScreen(Game game)
    {
        super(game);
        world = new world();
    }

    @Override
    public void update(float deltaTime)
    {
        List<TouchEvent>touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();

        if(state == GameState.Ready)
            updateReady(touchEvents);
        if(state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if(state == GameState.Paused)
            updatePaused(touchEvents);
        if(state == GameState.GameOver)
            updateGameOver(touchEvents);
    }

    private void updateReady(List<TouchEvent> touchEvents)
    {
        if(touchEvents.size() > 0)
            state = GameState.Running
    }

    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime)
    {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++)
        {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP)
            {
                if(event.x < 64 && event.y < 64)
                {
                    if(Settings.soundenabled)
                        Assets.click.play(1);
                    state = GameState.Paused;
                    return;
                }
            }
            if (event.type == TouchEvent.TOUCH_DOWN)
            {
                if(event.x < 64 && event.y > 416)
                {
                    // slap left
                }
                if(event.x < 256 && event.y > 416)
                {
                    // slap right
                }
                if(event.x < 00 && event.y > 00)
                {
                    // grab
                }
            }
        }
    }

    world.update(deltaTime);
    if(world.gameOver)
    {
        Assets.Lose.play(1);
        state = GameState.GameOver;
    }
    if (oldScore != world.score)
    {
        oldScore = world.score;
        score = "" + oldScore;
        if(Settings.soundenabled)
        {
            Assets.slap.play(1);
        }
    }

    private void updatePaused(List<TouchEvent> touchEvents)
    {
        int len = touchEvents.size();
        for (int i = 0; i < len; i++)
        {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP)
            {
                if(event.x > 80 && event.x <= 240)
                {
                    if(event.y > 100 && event.y <= 148)
                    {
                        if(Settings.soundenabled)
                            Assets.click.play(1);
                        state = GameState.Running;
                        return;
                    }
                    if(event.y > 148 && event.y < 196)
                    {
                        if(Settings.soundenabled)
                            Assets.click.play(1);
                        game.setScreen(new MainMenuScreen(game));
                        return;
                    }
                }
            }
        }
    }

    private void updateGameOver(List<TouchEvent> touchEvents)
    {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++)
        {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP)
            {
                if(event.x >= 128 && event.x <= 192 && event.y >= 200 && event.y <= 264)
                {
                    if(Settings.soundenabled)
                        Assets.click.play(1);
                    game.setScreen(new MainMenuScreen(game));
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
        drawWorld(world);
        if(GameState.Ready)
            drawReadyUI();
        if(GameState.Running)
            drawRunningUI();
        if(GameState.Paused)
            drawPausedUI();
        if(GameState.GameOver)
            drawGameOverUI();

        drawText(g, score, g.getWidth() / 2 - score.length() * 20 / 2, g.getHeight() - 42 );
    }
}
