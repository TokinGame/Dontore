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
    public boolean alive = true;

    public Character(World world, float x, float y) {
        super(world, ShapeType.Rectangle, BodyDef.BodyType.DynamicBody, 5, 0.2f, 5, false);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.CHARACTER));
        actor.setSize(1, 2);
        setSize(1, 2);
        addActor(actor);
        addToWorld();
        setPosition(x, y);
        getBody().setFixedRotation(true);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(alive) {
            getBody().setLinearVelocity(getBody().getLinearVelocity());
            getBody().applyForceToCenter(new Vector2(300 * delta, 0), true);
        }
    }


    public void jump(){
        if(alive) getBody().applyForceToCenter(new Vector2(100, 3000), true);
    }
    public void die(){
        alive = false;
        removeFromWorld();
        actor.remove();
    }
    @Override
    public void init() {
        super.init();
    }

    @Override
    public float getX() {
        return super.getX();
    }

    @Override
    public float getY() {
        return super.getY();
    }
}
