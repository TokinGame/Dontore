package hu.tokingame.dontore.Bodies;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.dontore.Global.Assets;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.dontore.MyBaseClasses.WorldActorGroup;
import hu.tokingame.dontore.MyBaseClasses.WorldBodyEditorLoader;

/**
 * Created by M on 1/21/2017.
 */

public class BGActor extends WorldActorGroup {
    public OneSpriteStaticActor actor;

    public BGActor(World world, WorldBodyEditorLoader loader, float X, float Y) {
        super(world, loader, "bg.png", BodyDef.BodyType.StaticBody, 0, 0.2f, 5, false);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.CRATE));
        actor.setSize(16, 9);
        setSize(16, 9);
        addActor(actor);
        addToWorld();
        setPosition(X, Y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
