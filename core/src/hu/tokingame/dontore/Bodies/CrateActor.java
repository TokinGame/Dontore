package hu.tokingame.dontore.Bodies;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.dontore.Global.Assets;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.dontore.MyBaseClasses.WorldActorGroup;
import hu.tokingame.dontore.MyBaseClasses.WorldBodyEditorLoader;

/**
 * Created by M on 1/18/2017.
 */

public class CrateActor extends WorldActorGroup {
    public OneSpriteStaticActor actor;

    public CrateActor(World world, WorldBodyEditorLoader loader, float X, float Y) {
        super(world, loader, "wooden-crate.png", BodyDef.BodyType.StaticBody, 0, 0.2f, 5, false);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.CRATE));
        actor.setSize(1, 1);
        setSize(1, 1);
        addActor(actor);
        addToWorld();
        setPosition(X, Y);
        setZIndex(50);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
