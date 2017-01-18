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
        super(world, loader, "spikes.png", BodyDef.BodyType.DynamicBody, 1000, 0.02f, 10, false);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.SPIKE));
        actor.setSize(0.61f, 0.13f);
        setSize(getWidth() / 4, getHeight() / 4);
        addActor(actor);
        addToWorld();
    }
}
