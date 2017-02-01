package hu.tokingame.dontore.Game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.dontore.Bodies.CrateActor;
import hu.tokingame.dontore.Global.Assets;
import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MyBaseClasses.MyLabel;
import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyBaseClasses.MyTextButton;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteActor;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by davimatyi on 2017. 01. 26..
 */

public class AdderStage extends MyStage {

    GameStage gameStage;

    public AdderStage(MyGdxGame game, GameStage g) {
        super(new ExtendViewport(16,9,new OrthographicCamera(16,9)),new SpriteBatch(), game);
        gameStage = g;
    }

    @Override
    public void init() {
        final OneSpriteStaticActor a;

        addActor(a = new OneSpriteStaticActor(Assets.manager.get(Assets.NEM)));
        a.setColor(1,1,1,0.2f);
        a.setPosition(14,0);
        a.setSize(2, 6);
        a.addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        gameStage.addCrate(x + gameStage.phantomActor.getX()+(a.getX()) / 2f-1f + gameStage.getCameaOffset(),y-1f);
                    }
        });

        addActor(new ChooseBuildingBlock(){
            @Override
            public void init() {
                super.init();
                setPosition(5,5);
            }
        });
        /*addActor(new MyTextButton("doboz"){
            @Override
            protected void init() {
                super.init();
                setPosition(100, 100);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        gameStage.add(0,1, 1);
                        System.out.println("k");
                    }
                });
            }
        });*/
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
