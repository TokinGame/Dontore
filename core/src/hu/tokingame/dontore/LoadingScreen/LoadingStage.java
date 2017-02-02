package hu.tokingame.dontore.LoadingScreen;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.dontore.Global.Assets;
import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteAnimatedActor;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by M on 11/14/2016.
 */

public class LoadingStage extends MyStage {

    private LoadingStage loadingStage;
    private OneSpriteAnimatedActor paprikaLoading;

    public LoadingStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }


    @Override
    public void init() {


        loadingStage = this;
        addActor(paprikaLoading = new OneSpriteAnimatedActor("textures/loading.txt") {
            @Override
            public void init() {
                super.init();
                stop();
                setFrame(0);
                setSize(200, 200);
                setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2, 400);
            }
        });

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        paprikaLoading.setFramePercent(Assets.manager.getProgress());
        System.out.println(Assets.manager.getProgress());
    }
}
