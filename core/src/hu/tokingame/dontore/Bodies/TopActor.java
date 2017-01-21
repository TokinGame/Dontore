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

public class TopActor extends WorldActorGroup {

    public OneSpriteStaticActor actor;

    public TopActor(World world, WorldBodyEditorLoader loader, float x, float y) {
        super(world, loader, "maptop.png", BodyDef.BodyType.StaticBody, 0, 0.2f, 1, false);

        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.NEM));
        actor.setSize(1, 1);
        setSize(1, 1);
        addActor(actor);
        addToWorld();
        setPosition(x, y);
    }



}
