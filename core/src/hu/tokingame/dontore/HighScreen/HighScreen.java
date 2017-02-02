package hu.tokingame.dontore.HighScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MyBaseClasses.MyScreen;
import hu.tokingame.dontore.MyGdxGame;
import hu.tokingame.dontore.HighScreen.HighStage;

import static hu.tokingame.dontore.Global.Globals.PREFS;

/**
 * Created by Zoli on 2017.01.30..
 */

public class HighScreen extends MyScreen {
    private HighStage stage;
    //https://github.com/libgdx/libgdx/wiki/Preferences


    public HighScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void init() {
        super.init();
        stage = new HighStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT,new OrthographicCamera(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT)),new SpriteBatch(),game);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        stage.resize(width, height);
    }

    @Override
    public void dispose() {
        stage.dispose();
        super.dispose();
    }
}
