package hu.tokingame.dontore.Game;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.tokingame.dontore.Global.Assets;
import hu.tokingame.dontore.MyBaseClasses.InitableInterface;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteStaticActor;

/**
 * Created by M on 1/31/2017.
 */

public class ChooseBuildingBlock extends Group implements InitableInterface {
    OneSpriteStaticActor bg;
    private boolean crateSelected = true;

    public ChooseBuildingBlock() {
        init();
        setSize(5, 2);

        addActor(bg = new OneSpriteStaticActor(Assets.manager.get(Assets.BUTTON_BG)) {
            @Override
            public void init() {
                super.init();
                setSize(2, 2);
                setPosition(0, 0);
            }
        });

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.CHARACTER)) {
            @Override
            public void init() {
                super.init();
                setSize(2, 2);
                setPosition(0, 0);
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        bg.setPosition(0, 0);
                        crateSelected = true;
                    }
                });
            }
        });

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.SPIKE)) {
            @Override
            public void init() {
                super.init();
                setSize(2, 2);
                setPosition(3, 0);
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        bg.setPosition(3, 0);
                        crateSelected = false;
                    }
                });
            }
        });
    }

    public boolean isCrateSelected() {
        return crateSelected;
    }

    @Override
    public void init() {

    }
}
