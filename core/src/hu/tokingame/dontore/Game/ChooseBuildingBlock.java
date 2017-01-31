package hu.tokingame.dontore.Game;

import com.badlogic.gdx.scenes.scene2d.Group;

import hu.tokingame.dontore.Global.Assets;
import hu.tokingame.dontore.MyBaseClasses.InitableInterface;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteStaticActor;

/**
 * Created by M on 1/31/2017.
 */

public class ChooseBuildingBlock extends Group implements InitableInterface{
    public ChooseBuildingBlock() {
        init();

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BUTTON_BG)){
            @Override
            public void init() {
                super.init();
                setSize(100,30);
                setPosition(0,0);
            }
        });

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.CHARACTER)){
            @Override
            public void init() {
                super.init();
                setSize(20,20);
                setPosition(15,5);
            }
        });

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.SPIKE)){
            @Override
            public void init() {
                super.init();
                setSize(20,20);
                setPosition(65,5);
            }
        });
    }

    @Override
    public void init() {

    }
}
