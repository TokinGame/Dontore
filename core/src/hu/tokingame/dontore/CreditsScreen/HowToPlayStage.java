package hu.tokingame.dontore.CreditsScreen;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by davimatyi on 2016. 12. 09..
 */

public class HowToPlayStage extends MyStage {
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

    }
}
