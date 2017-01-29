package hu.tokingame.dontore.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.dontore.Bodies.CrateActor;
import hu.tokingame.dontore.Global.Assets;
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

    ClientGameStage gameStage;

    public AdderStage(Viewport viewport, Batch batch, MyGdxGame game, ClientGameStage g) {
        super(viewport, batch, game);
        gameStage = g;
    }

    @Override
    public void init() {

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.NEM)) {
            @Override
            public void init() {
                super.init();
                setPosition(0,0);
                setSize(1280, 720);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        System.out.println((float)Math.rint(x/128)+";"+(float)Math.rint(y/128));
                        gameStage.add((float)Math.rint(x/128), (float)Math.rint(y/128), 1);
                    }

                });
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
