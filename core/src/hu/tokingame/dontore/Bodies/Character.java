package hu.tokingame.dontore.Bodies;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.dontore.Global.Assets;
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


    private int jumpCount = 2;
    private float lastJumpTime = 0;
    private float elapsedTime = 0;

    public void setJumpAvalaible() {
        jumpCount = 2;
    }

    // Neve Pisti
    public Character(World world, float x, float y) {
        super(world, ShapeType.Rectangle, BodyDef.BodyType.DynamicBody, 0, 0.2f, 5, false);
        actor = new OneSpriteAnimatedActor(Assets.manager.get(Assets.WALK_ATLAS)) {
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


    private float lastVelocityX = 0;

    @Override
    public void act(float delta) {
        elapsedTime += delta;
        if (lastVelocityX == 0) {
            lastVelocityX = getX();
        }
        super.act(delta);
        if (Math.abs(getBody().getLinearVelocity().y) < 0.4f) {
            resumeRuning();
            //actor.setFps(Math.round(Math.abs((lastVelocityX-getX()))/delta/2)*2+1);
            //System.out.println(actor.getFps());
        } else {
            pauseRuning();
        }
        lastVelocityX = getX();

        //System.out.println(getBody().getLinearVelocity().x + " : " + getBody().getLinearVelocity().y);
/*
        if(alive) {
            currentSpeed = (maxSpeed - this.getBody().getLinearVelocity().x) * 500;
            getBody().setLinearVelocity(getBody().getLinearVelocity());
            getBody().applyForceToCenter(new Vector2(currentSpeed * delta, 0), true);
        }*/
    }


    public void jump() {
        if (alive) {
            if (jumpCount > 0 && elapsedTime - lastJumpTime > 0.2) {
                System.out.println("JUMP " + jumpCount + " - " + elapsedTime);
                //getBody().applyForceToCenter(new Vector2(0, 1500), true);
                getBody().setLinearVelocity(getBody().getLinearVelocity().x, getBody().getLinearVelocity().y + 10);
                jumpCount--;
            }
            /*
            if(getY()<  1.25) {
                getBody().applyForceToCenter(new Vector2(0, 2800), true);
                doubleJumpAvalaible = true;
            }else{
                if(doubleJumpAvalaible){
                    getBody().applyForceToCenter(new Vector2(0, 2800), true);
                    doubleJumpAvalaible = false;
                }
            }
            */
            //pauseRuning();
        }
        System.out.println(getY());
    }

    public void pauseRuning() {
        actor.stop();
    }

    public void resumeRuning() {
        actor.start();
    }

    public void die() {
        alive = false;
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.GRAVE)) {
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
