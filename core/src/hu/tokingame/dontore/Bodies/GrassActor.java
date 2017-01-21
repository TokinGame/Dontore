package hu.tokingame.dontore.Bodies;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.dontore.Global.Assets;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.dontore.MyBaseClasses.WorldActorGroup;
import hu.tokingame.dontore.MyBaseClasses.WorldBodyEditorLoader;

/**
 * Created by davimatyi on 2017. 01. 21..
 */

public class GrassActor extends WorldActorGroup {

    public OneSpriteStaticActor actor;

    public GrassActor(World world, WorldBodyEditorLoader loader, float x, float y) {
        super(world, loader, "grass.png", BodyDef.BodyType.StaticBody, 0, 0.2f, 1, false);

        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.GRASS));
        actor.setSize(8, 1);
        setSize(8, 1);
        addActor(actor);
        addToWorld();
        setPosition(x, y);
    }
}
