package hu.tokingame.dontore.CreditsScreen;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Vector;

import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MenuScreen.BGStage;
import hu.tokingame.dontore.MenuScreen.MenuBackgroundActor;
import hu.tokingame.dontore.MyBaseClasses.BackgroundTextButton;
import hu.tokingame.dontore.MyBaseClasses.MyLabel;
import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by davimatyi on 2016. 12. 09..
 */

public class HowToPlayStage extends BGStage {
    String s;

    public HowToPlayStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
            game.setScreenBackByStackPop();
        }
        return false;
    }

    @Override
    public void init() {
        super.init();
        s = "How to play:\n" +
                "- Singleplayer: you only have to jump,\n  by pressing on the screen.\n" +
                "- Multiplayer: the client has to build\n  obstacles for the other player,\n" +
                "\t  and the host has to survive the map\n  built by the client";

        addActor(new MyLabel(s, MyLabel.style2){
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 50);
            }
        });

        addActor(new BackgroundTextButton("Back", 2){
            @Override
            protected void init() {
                super.init();
                this.setPosition(getViewport().getWorldWidth()-this.getWidth(),0);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreenBackByStackPop();
                    }
                });
            }
        });

    }


    @Override
    public void act(float delta) {
        super.act(delta);
    }

}
