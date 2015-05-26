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
        world = new World();
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
            state = GameState.Running;
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
                    world.player.slapLeft();
                    Assets.slap.play(1);
                }
                if(event.x < 256 && event.y > 416)
                {
                    world.player.slapRight();
                    Assets.slap.play(1);
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
            Assets.cheer.play(1);
            }
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
        if(state == GameState.Ready)
            drawReadyUI();
        if(state == GameState.Running)
            drawRunningUI();
        if(state == GameState.Paused)
            drawPausedUI();
        if(state == GameState.GameOver)
            drawGameOverUI();

        drawText(g, score, g.getWidth() / 2 - score.length() * 20 / 2, g.getHeight() - 42 );
    }

    private void drawWorld(World world)
    {
        Graphics g = game.getGraphics();
        g.drawPixMap(Assets.gamebg, 0, 0);
        Player player = world.player;
        CPU cpu = world.cpu;

        Pixmap cpuPixmap = null;
        if(cpu.type == CPU.TYPE_1)
            cpuPixmap = Assets.cpusumo;
        if(cpu.type == CPU.TYPE_2)
            cpuPixmap = Assets.cpusumo1;
        if(cpu.type == CPU.TYPE_3)
            cpuPixmap = Assets.cpusumo2;
        if(cpu.type == CPU.TYPE_4)
            cpuPixmap = Assets.cpusumo3;
        int x = cpu.x;
        int y = cpu.y;
        g.drawPixMap(cpuPixmap, x, y);

        Pixmap playerPixmap = null;
        if(player.type == Player.TYPE_1)
            playerPixmap = Assets.playersumo;
        if(player.type == Player.TYPE_2)
            playerPixmap = Assets.playersumo1;
        if(player.type == Player.TYPE_3)
            playerPixmap = Assets.playersumo2;
        if(player.type == Player.TYPE_4)
            playerPixmap = Assets.playersumo3;
         x = player.x;
         y = player.y;
        g.drawPixMap(playerPixmap, x, y);
    }

    private void drawReadyUI()
    {
        Graphics g = game.getGraphics();

        g.drawPixMap(Assets.ready, 47, 100);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }

    private void drawRunningUI()
    {
        Graphics g = game.getGraphics();

        g.drawPixMap(Assets.buttons, 0, 0, 64, 128, 64, 64);
        //g.drawLine(0, 416, 480, 416, Color.BLACK);
        g.drawPixMap(Assets.buttons, 0, 416, 64, 64, 64, 64);
        g.drawPixMap(Assets.buttons, 128, 416,128, 128, 64, 64);
        g.drawPixMap(Assets.buttons, 256, 416, 0, 64, 64, 64);
    }

    private void drawPausedUI()
    {
        Graphics g = game.getGraphics();

        g.drawPixMap(Assets.pause, 80, 100);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }

    private void drawGameOverUI()
    {
        Graphics g = game.getGraphics();

        g.drawPixMap(Assets.gameOver, 62, 100);
        g.drawPixMap(Assets.buttons, 128, 200, 0, 128, 64, 64);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }

    public void drawText(Graphics g, String line, int x, int y)
    {
        int len = line.length();
        for(int i = 0; i < len; i++)
        {
            char character = line.charAt(i);

            if(character == ' ')
            {
                x += 20;
                continue;
            }

            int srcX = 0;
            int srcWidth = 0;
            if(character == '.')
            {
                srcX = 200;
                srcWidth = 10;
            }
            else
            {
                srcX = (character - '0') * 20;
                srcWidth = 20;
            }

            g.drawPixMap(Assets.numbers, x, y, srcX, 0, srcWidth, 32);
            x += srcWidth;
        }
    }

    @Override
    public void pause()
    {
        if(state == GameState.Running)
            state = GameState.Paused;

        if(world.gameOver)
        {
            Settings.addScore(world.score);
            Settings.save(game.getFileIO());
        }
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
