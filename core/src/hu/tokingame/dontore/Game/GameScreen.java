package hu.tokingame.dontore.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.ConeShapeBuilder;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MyBaseClasses.MyScreen;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by davimatyi on 2017. 01. 18..
 */

public class GameScreen extends MyScreen {

    SinglePlayerStage stage;


    public GameScreen(MyGdxGame game) {
        super(game);
        stage = new SinglePlayerStage(new ExtendViewport(16, 16, Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), new SpriteBatch(), game);




    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void resume() {
        super.resume();
    }
}
