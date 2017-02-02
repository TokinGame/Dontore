package hu.tokingame.dontore.CreditsScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Vector;

import hu.tokingame.dontore.Global.Assets;
import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MenuScreen.MenuBackgroundActor;
import hu.tokingame.dontore.MyBaseClasses.BackgroundTextButton;
import hu.tokingame.dontore.MyBaseClasses.MyLabel;
import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by davimatyi on 2016. 11. 15..
 */

public class CreditsStage extends MyStage {

    MenuBackgroundActor a1, a2, a3;
    Vector<MenuBackgroundActor> actorVector;

    String s;

    public CreditsStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.BACK) {
            game.setScreenBackByStackPop();
        }
        return false;
    }

    @Override
    public void init() {

        actorVector = new Vector<MenuBackgroundActor>();
        a1 = new MenuBackgroundActor(1, 0, 0);
        a2 = new MenuBackgroundActor(2, 2760, 0);
        a3 = new MenuBackgroundActor(3, 2760 * 2, 0);
        actorVector.add(a1);
        actorVector.add(a2);
        actorVector.add(a3);
        addActor(a1);
        addActor(a2);
        addActor(a3);

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.PAPRIKA)) {
            @Override
            public void init() {
                super.init();
                setSize(200, 200);
                setPosition(1000, 500);
                setOriginCenter();
            }

            float elapsedTime = 0;

            @Override
            public void act(float delta) {
                super.act(delta);
                elapsedTime += delta;
                setRotation(elapsedTime * 50);
            }
        });
        addActor(new BackgroundTextButton("Back", 2) {
            @Override
            protected void init() {
                super.init();
                this.setPosition(getViewport().getWorldWidth() - this.getWidth() - 10, 10);
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreenBackByStackPop();
                    }
                });

            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.TOKIN)) {
            @Override
            public void init() {
                super.init();
                setSize(100, 100);
                setPosition(200, 500);
            }
        });
        addActor(new MyLabel("Created by Tökin Game", MyLabel.style2) {
            @Override
            public void init() {
                super.init();
                setPosition(350, 500);
            }
        });
        String s = "Bálint Dániel - Graphics\n" +
                "Dávid Mátyás - Code\n" +
                "Kovács Zoltán - Code\n" +
                "Schuh Marcell - Code";

        addActor(new MyLabel(s, MyLabel.style2) {
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2, 150);
            }
        });
        addActor(new MyLabel("Music used: paul-hartnett_07-160 from sampleswap.org", MyLabel.style2){
            @Override
            public void init() {
                super.init();
                setPosition(10, 80);
            }
        });

    }

    void moveBackground() {
        if (actorVector.get(0).getX() < -2759.9f) actorVector.get(0).setX(2760 * 2);
        actorVector.add(actorVector.get(0));
        actorVector.remove(0);
        actorVector.get(0).setX(actorVector.get(0).getX() - 1f);
        actorVector.get(1).setX(actorVector.get(1).getX() - 1f);
        actorVector.get(2).setX(actorVector.get(2).getX() - 1f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        moveBackground();
    }

}