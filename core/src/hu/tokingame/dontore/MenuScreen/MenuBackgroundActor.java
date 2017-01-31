package hu.tokingame.dontore.MenuScreen;

import com.badlogic.gdx.graphics.Texture;

import hu.tokingame.dontore.Global.Assets;
import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteStaticActor;

/**
 * Created by davimatyi on 2017. 01. 22..
 */

public class MenuBackgroundActor extends OneSpriteStaticActor {
    public MenuBackgroundActor(int nr, float x, float y) {
        super(Assets.manager.get(Assets.BG_BLUR));
        setTexture(Assets.manager.get(Assets.BG_BLUR));
        setSize(2760, 720);
        setPosition(x, y);
    }

}
