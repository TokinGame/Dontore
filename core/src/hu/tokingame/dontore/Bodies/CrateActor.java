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
        super(world, loader, "wooden-crate.png", BodyDef.BodyType.StaticBody, 1000, 0.02f, 10, false);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.CRATE));
        actor.setSize(0.5f, 0.5f);
        setSize(getWidth() / 4, getHeight() / 4);
        addActor(actor);
        addToWorld();
    }
    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
