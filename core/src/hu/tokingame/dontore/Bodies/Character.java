package hu.tokingame.dontore.Bodies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.dontore.DarudeSandstorm.ExplosionActor;
import hu.tokingame.dontore.Global.Assets;
import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteActor;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteAnimatedActor;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.dontore.MyBaseClasses.ShapeType;
import hu.tokingame.dontore.MyBaseClasses.WorldActorGroup;

/**
 * Created by davimatyi on 2017. 01. 19..
 */

public class Character extends WorldActorGroup {

    public OneSpriteAnimatedActor actor;
    public boolean alive = true;
    public int maxSpeed = 5;
    float currentSpeed;
    public boolean doubleJumpAvalaible = true;

    public Character(World world, float x, float y) {
        super(world, ShapeType.Rectangle, BodyDef.BodyType.DynamicBody, 0, 0.2f, 5, false);
        actor = new OneSpriteAnimatedActor(Assets.manager.get(Assets.WALK_ATLAS)){
            @Override
            public void init() {
                super.init();
                setFps(10);
            }
        };
        actor.setSize(0.75f, 1);
        setSize(0.75f, 1);
        addActor(actor);
        addToWorld();
        setPosition(x, y);
        getBody().setFixedRotation(true);
        setZIndex(60);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
/*
        if(alive) {
            currentSpeed = (maxSpeed - this.getBody().getLinearVelocity().x) * 500;
            getBody().setLinearVelocity(getBody().getLinearVelocity());
            getBody().applyForceToCenter(new Vector2(currentSpeed * delta, 0), true);
        }*/
    }


    public void jump(){
        if(alive){
            if(getY()<  1.25) {
                getBody().applyForceToCenter(new Vector2(0, 2800), true);
                doubleJumpAvalaible = true;
            }else{
                if(doubleJumpAvalaible){
                    getBody().applyForceToCenter(new Vector2(0, 2800), true);
                    doubleJumpAvalaible = false;
                }
            }

        }
        System.out.println(getY());
    }
    public void die(){
        alive = false;
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.GRAVE)){
            @Override
            public void init() {
                super.init();
                setSize(1, 1.5f);
            }
        });
        setFriction(10);
        //removeFromWorld();
        //actor.remove();

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

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
