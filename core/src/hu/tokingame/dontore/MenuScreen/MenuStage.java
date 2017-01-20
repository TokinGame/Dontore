package hu.tokingame.dontore.MenuScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.dontore.CreditsScreen.CreditsScreen;
import hu.tokingame.dontore.CreditsScreen.HowToPlayScreen;
import hu.tokingame.dontore.Game.GameScreen;
import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MyBaseClasses.BackgroundTextButton;
import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyBaseClasses.MyTextButton;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by M on 11/14/2016.
 */

public class MenuStage extends MyStage {

    MyTextButton button;

    public static boolean musicToggle = true;

    public MenuStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
            game.setScreen(new ExitScreen(game));
        }
        return false;
    }

    @Override
    public void init() {

        addActor(new BackgroundTextButton("How To Play",1){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 100);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new HowToPlayScreen(game));
                    }
                });
            }
        });

        addActor(new BackgroundTextButton("Play singleplayer",1){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 400);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.multiPlayer = false;
                        game.setScreen(new GameScreen(game));
                    }
                });
            }

        });
        addActor(new BackgroundTextButton("Play bluetooth multiplayer",1){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 320);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.multiPlayer = true;
                        game.setScreen(new GameScreen(game));

                    }
                });
            }

        });
        addActor(new BackgroundTextButton("Credits",1){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new CreditsScreen(game));
                    }
                });
            }
        });
        addActor(new BackgroundTextButton("Exit",2){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-this.getWidth()-10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new ExitScreen(game));
                    }
                });
            }
        });
        addActor(new BackgroundTextButton("Settings",1){
            @Override
            protected void init() {
                super.init();
                setPosition(10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                    }
                });
            }
        });


    }

}

