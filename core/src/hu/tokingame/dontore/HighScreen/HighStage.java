package hu.tokingame.dontore.HighScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Collections;
import java.util.Vector;

import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MenuScreen.MenuBackgroundActor;
import hu.tokingame.dontore.MenuScreen.MenuScreen;
import hu.tokingame.dontore.MyBaseClasses.BackgroundTextButton;
import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyBaseClasses.MyTextButton;
import hu.tokingame.dontore.MyGdxGame;

import static hu.tokingame.dontore.Global.Globals.MaxScores;

/**
 * Created by Zoli on 2017.01.30..
 */

public class HighStage extends MyStage {
    String s;

    MenuBackgroundActor a1, a2, a3;
    Vector<MenuBackgroundActor> actorVector;

    public HighStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);
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

        actorVector = new Vector<MenuBackgroundActor>();
        a1 = new MenuBackgroundActor(1, 0, 0);
        a2 = new MenuBackgroundActor(2, 2760, 0);
        a3 = new MenuBackgroundActor(3, 2760*2, 0);
        actorVector.add(a1);
        actorVector.add(a2);
        actorVector.add(a3);
        addActor(a1);
        addActor(a2);
        addActor(a3);

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

    public static void highscore(float score){
        if (MaxScores.size() >= 5) {
            if (MaxScores.get(MaxScores.size()-1)<score){
                Collections.sort(MaxScores);
                Collections.reverse(MaxScores);
                MaxScores.set(MaxScores.size()-1,score);
            }
        } else {
            MaxScores.add(score);
            Collections.sort(MaxScores);
            Collections.reverse(MaxScores);
        }
        Collections.sort(MaxScores);
        Collections.reverse(MaxScores);
        System.out.println(MaxScores);
    }

    void moveBackground(){
        if(actorVector.get(0).getX() < -2759.9f) actorVector.get(0).setX(2760*2);
        actorVector.add(actorVector.get(0)); actorVector.remove(0);
        actorVector.get(0).setX(actorVector.get(0).getX()-1f);
        actorVector.get(1).setX(actorVector.get(1).getX()-1f);
        actorVector.get(2).setX(actorVector.get(2).getX()-1f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        moveBackground();
    }

}
