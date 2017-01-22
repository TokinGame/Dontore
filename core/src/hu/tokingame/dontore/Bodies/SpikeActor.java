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

public class SpikeActor extends WorldActorGroup {

    public OneSpriteStaticActor actor;

    public SpikeActor(World world, WorldBodyEditorLoader loader, float X, float Y) {
        super(world, loader, "spikes.png", BodyDef.BodyType.DynamicBody, 100, 0.02f, 10000, false);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.SPIKE));
        actor.setSize(1, 1);
        setSize(1, 1);
        addActor(actor);
        addToWorld();
        setPosition(X, Y);
    }
}
