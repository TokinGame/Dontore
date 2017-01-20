package hu.tokingame.dontore.Bodies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.dontore.Global.Assets;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteActor;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.dontore.MyBaseClasses.ShapeType;
import hu.tokingame.dontore.MyBaseClasses.WorldActorGroup;

/**
 * Created by davimatyi on 2017. 01. 19..
 */

public class Character extends WorldActorGroup {

    public OneSpriteActor actor;

    public Character(World world, float x, float y) {
        super(world, ShapeType.Rectangle, BodyDef.BodyType.DynamicBody, 100, 0.02f, 10, false);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.CHARACTER));
        actor.setSize(5, 10);
        setSize(5, 10);
        addActor(actor);
        addToWorld();
        setPosition(x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        getBody().setLinearVelocity(getBody().getLinearVelocity().rotateRad(getBody().getAngularVelocity() * delta));
        getBody().applyForceToCenter(new Vector2(100, 0).rotateRad(getBody().getAngle()), true);
    }

    @Override
    public void init() {
        super.init();
    }
}
