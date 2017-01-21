package hu.tokingame.dontore.Bodies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.dontore.Global.Assets;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.dontore.MyBaseClasses.WorldActorGroup;
import hu.tokingame.dontore.MyBaseClasses.WorldBodyEditorLoader;

/**
 * Created by davimatyi on 2017. 01. 21..
 */

public class PhantomActor extends WorldActorGroup {


    OneSpriteStaticActor actor;
    public int maxSpeed = 5;
    float currentSpeed;

    public PhantomActor(World world, WorldBodyEditorLoader loader, float x, float y) {
        super(world, loader, "bg.png", BodyDef.BodyType.DynamicBody, 0, 0, 0, false);
        setSize(1, 1);
        setPosition(x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.NEM));
        actor.setSize(1, 1);
        addActor(actor);
        currentSpeed = (maxSpeed - getBody().getLinearVelocity().x) * 500;
        getBody().setLinearVelocity(getBody().getLinearVelocity());
        getBody().applyForceToCenter(new Vector2(currentSpeed * delta, 0), true);
    }
}
