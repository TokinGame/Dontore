package hu.tokingame.dontore.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Vector;

import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MenuScreen.MenuBackgroundActor;
import hu.tokingame.dontore.MenuScreen.MenuScreen;
import hu.tokingame.dontore.MyBaseClasses.BackgroundTextButton;
import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyBaseClasses.MyTextButton;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by davimatyi on 2017. 01. 18..
 */

public class ChooseBluetoothModeStage extends MyStage {


    MenuBackgroundActor a1, a2, a3;
    Vector<MenuBackgroundActor> actorVector;

    public ChooseBluetoothModeStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }

    @Override
    public void init() {

        actorVector = new Vector<MenuBackgroundActor>();
        a1 = new MenuBackgroundActor(1, 0, 0);
        a2 = new MenuBackgroundActor(2, 720, 0);
        a3 = new MenuBackgroundActor(3, 1440, 0);
        actorVector.add(a1);
        actorVector.add(a2);
        actorVector.add(a3);
        addActor(a1);
        addActor(a2);
        addActor(a3);

        addActor(new BackgroundTextButton("Host Game as runner",1){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 500);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.host = true;
                    }
                });
            }
        });
        addActor(new BackgroundTextButton("Join Game as builder",1){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 420);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.host = true;
                    }
                });
            }
        });
        addActor(new BackgroundTextButton("Back",2){
            @Override
            protected void init() {
                super.init();
                setPosition(10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new MenuScreen(game));
                    }
                });
            }
        });
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        moveBackground();
    }

    @Override
    public void draw() {
        super.draw();
    }


    void moveBackground(){
        if(actorVector.get(0).getX() < -719.9f) actorVector.get(0).setX(1440);
        actorVector.add(actorVector.get(0)); actorVector.remove(0);
        actorVector.get(0).setX(actorVector.get(0).getX()-1f);
        actorVector.get(1).setX(actorVector.get(1).getX()-1f);
        actorVector.get(2).setX(actorVector.get(2).getX()-1f);
    }
}
