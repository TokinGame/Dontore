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
        super(Assets.manager.get(Assets.CRATE));
        setTexture(getBG(nr));
        setSize(Globals.WORLD_HEIGHT, Globals.WORLD_HEIGHT);
        setPosition(x, y);
    }
    Texture getBG(int n){
        switch(n){
            case 1: return Assets.manager.get(Assets.CRATE);
            case 2: return Assets.manager.get(Assets.CRATE);
            case 3: return Assets.manager.get(Assets.CRATE);

        }
        return Assets.manager.get(Assets.CRATE);
    }
}
