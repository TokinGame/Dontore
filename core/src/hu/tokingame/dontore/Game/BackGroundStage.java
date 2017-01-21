package hu.tokingame.dontore.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.dontore.Global.Assets;
import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MyBaseClasses.MyLabel;
import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by M on 1/21/2017.
 */

public class BackgroundStage extends MyStage {



    public BackgroundStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
    }

    @Override
    public void init() {
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.CRATE)){
            @Override
            public void init() {
                super.init();
                setPosition(0,0);
                this.setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if(character.getX() > grassV.get(2).getX()){
            grassV.get(0).setX(grassV.get(2).getX()+8);
            grassV.add(grassV.get(0));
            grassV.remove(0);
        }

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
