package hu.tokingame.dontore.Bodies;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
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


    public BGActor(World world, WorldBodyEditorLoader loader, float X, float Y, int t) {
        super(world, loader, "bg.png", BodyDef.BodyType.StaticBody, 0, 0.2f, 5, false);
        actor = new OneSpriteStaticActor(tex(t));
        actor.setSize(20, 7.6f);
        setSize(20, 7.6f);
        setZIndex(0);
        addActor(actor);
        addToWorld();
        setPosition(X, Y);
        debug();
        setZIndex(0);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }
    Texture tex(int t){
        switch(t){
            case 1: return Assets.manager.get(Assets.BG1);
            case 2: return Assets.manager.get(Assets.BG2);
            case 3: return Assets.manager.get(Assets.BG3);
            case 4: return Assets.manager.get(Assets.BG4);
            case 5: return Assets.manager.get(Assets.BG5);
            default: return null;
        }

    }
}
