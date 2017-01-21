package hu.tokingame.dontore.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.dontore.MyBaseClasses.MyLabel;
import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by M on 1/21/2017.
 */

public class BackGroundStage extends MyStage {
    public BackGroundStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }

    @Override
    public void init() {
        addActor(new MyLabel("Succ", game.getLabelStyle()));
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
