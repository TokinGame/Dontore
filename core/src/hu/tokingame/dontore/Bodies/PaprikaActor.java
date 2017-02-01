package hu.tokingame.dontore.Bodies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokingame.dontore.Global.Assets;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.dontore.MyBaseClasses.WorldActorGroup;
import hu.tokingame.dontore.MyBaseClasses.WorldBodyEditorLoader;

/**
 * Created by davimatyi on 2017. 01. 31..
 */

public class PaprikaActor extends WorldActorGroup {
        public OneSpriteStaticActor actor;

    public PaprikaActor(World world, WorldBodyEditorLoader loader, float x, float y) {
        super(world, loader, "bg.png", BodyDef.BodyType.DynamicBody, 1, 0.2f, 10, false);
        actor = new OneSpriteStaticActor(Assets.manager.get(Assets.PAPRIKA));
        actor.setSize(1,1);
        addActor(actor);
        addToWorld();
        setPosition(x, y);
        setSize(1,1);
        getBody().setFixedRotation(true);


    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        //setY(getY()+0.2f);
        //getBody().setLinearVelocity(getBody().getLinearVelocity());
        getBody().applyForceToCenter(new Vector2(0, 1200*delta), true);
    }

    @Override
    public void setPosition(float x, float y) {
        super.setPosition(x, y);
        //System.out.println("paprika:"+x+";"+y);
    }
}
