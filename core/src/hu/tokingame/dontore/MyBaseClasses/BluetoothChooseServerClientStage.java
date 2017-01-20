package hu.tokingame.dontore.MyBaseClasses;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by tuskeb on 2017. 01. 16..
 */

abstract public class BluetoothChooseServerClientStage extends MyStage {

    public BluetoothChooseServerClientStage(MyGdxGame game) {
        super(new ExtendViewport(1280, 720, new OrthographicCamera(1280, 720)), new SpriteBatch(), game);
    }

    abstract public void startServer();
    abstract public void startClient();

    @Override
    public void init() {
        addBackEventStackListener();
        addActor(new MyButton("Start server", game.getTextButtonStyle()) {
            @Override
            public void init() {
                super.init();
                setPosition(200, 380);
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        startServer();
                    }
                });
            }
        });
        addActor(new MyButton("Start client", game.getTextButtonStyle()) {
            @Override
            public void init() {
                super.init();
                setPosition(700, 380);
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        startClient();
                    }
                });
            }
        });
    }
}



