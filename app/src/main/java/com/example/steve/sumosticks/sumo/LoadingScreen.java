package com.example.steve.sumosticks.sumo;

/**
 * Created by Steve on 2015-05-21.
 */
import com.example.steve.sumosticks.Game;
import com.example.steve.sumosticks.Graphics;
import com.example.steve.sumosticks.Screen;
import com.example.steve.sumosticks.Graphics.PixmapFormat;

public class LoadingScreen extends Screen
{
    public LoadingScreen(Game game)
    {
        super(game);
    }

    public void update(float deltaTime)
    {
        Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("background.png", PixmapFormat.RGB565);
        Assets.gamebg = g.newPixmap("gamebg.png", PixmapFormat.ARGB4444);
        Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444);
        Assets.mainMenu = g.newPixmap("mainmenu.png", PixmapFormat.ARGB4444);
        Assets.buttons = g.newPixmap("buttons.png", PixmapFormat.ARGB4444);
        Assets.help1 = g.newPixmap("help1.png", PixmapFormat.ARGB4444);
        Assets.help2 = g.newPixmap("help2.png", PixmapFormat.ARGB4444);
        Assets.help3 = g.newPixmap("help3.png", PixmapFormat.ARGB4444);
        Assets.numbers = g.newPixmap("numbers.png", PixmapFormat.ARGB4444);
        Assets.ready = g.newPixmap("ready.png", PixmapFormat.ARGB4444);
        Assets.pause = g.newPixmap("pause.png", PixmapFormat.ARGB4444);
        Assets.gameOver = g.newPixmap("gameover.png", PixmapFormat.ARGB4444);
        Assets.playersumo = g.newPixmap("playersumo.png", PixmapFormat.ARGB4444);
        Assets.playersumo1 = g.newPixmap("playersumo1.png", PixmapFormat.ARGB4444);
        Assets.playersumo2 = g.newPixmap("playersumo2.png", PixmapFormat.ARGB4444);
        Assets.playersumo3 = g.newPixmap("playersumo3.png", PixmapFormat.ARGB4444);
        Assets.cpusumo = g.newPixmap("cpusumo.png", PixmapFormat.ARGB4444);
        Assets.cpusumo1 = g.newPixmap("cpusumo1.png", PixmapFormat.ARGB4444);
        Assets.cpusumo2 = g.newPixmap("cpusumo2.png", PixmapFormat.ARGB4444);
        Assets.cpusumo3 = g.newPixmap("cpusumo3.png", PixmapFormat.ARGB4444);
        Assets.judge = g.newPixmap("judge.png", PixmapFormat.ARGB4444);
        Assets.arena = g.newPixmap("gamebg.png", PixmapFormat.ARGB4444);
        Assets.click = game.getAudio().newSound("click.ogg");
        Assets.slap = game.getAudio().newSound("slap.ogg");
        Assets.cheer = game.getAudio().newSound("cheer.ogg");
        Assets.Win = game.getAudio().newSound("win.ogg");
        Assets.Lose = game.getAudio().newSound("lose.ogg");
        Assets.grunt = game.getAudio().newSound("grunt.ogg");
        Settings.load(game.getFileIO());
        game.setScreen(new MainMenuScreen(game));
    }

    public void present(float deltaTime)
    {

    }

    public void pause()
    {

    }

    public void resume()
    {

    }

    public void dispose()
    {

    }
}
