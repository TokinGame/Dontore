package hu.tokingame.dontore.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyBaseClasses.WorldBodyEditorLoader;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by davimatyi on 2017. 01. 18..
 */

public class SinglePlayerStage extends MyStage {

    World world;
    Box2DDebugRenderer box2DDebugRenderer;
    WorldBodyEditorLoader loader;
    ControlStage controlStage;
    PauseStage pauseStage;

    public SinglePlayerStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);

        world = new World(new Vector2(1, 0), false);
        box2DDebugRenderer = new Box2DDebugRenderer();
        loader = new WorldBodyEditorLoader(Gdx.files.internal("phys.json"));
        controlStage = new ControlStage(new ExtendViewport(16, 16, Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), new SpriteBatch(), game);
        pauseStage = new PauseStage(new ExtendViewport(16, 16, Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), new SpriteBatch(), game);

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(this);
        inputMultiplexer.addProcessor(controlStage);
        inputMultiplexer.addProcessor(pauseStage);
        Gdx.input.setInputProcessor(inputMultiplexer);

    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void init() {

    }
}
