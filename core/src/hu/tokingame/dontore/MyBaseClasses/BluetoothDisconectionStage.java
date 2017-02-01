package hu.tokingame.dontore.MyBaseClasses;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by tuskeb on 2017. 01. 18..
 */

abstract public class BluetoothDisconectionStage extends BluetoothStage {

    public BluetoothDisconectionStage(MyGdxGame game) {
        super(new ExtendViewport(1280, 720, new OrthographicCamera(1280, 720)), new SpriteBatch(), game);
    }

    @Override
    public void init() {
        addActor(new BackgroundTextButton("Disconnected. Click here to exit.") {
            @Override
            public void init() {
                super.init();
                setPosition(300, 380);
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        end();
                    }
                });
            }
        });
    }

    public abstract void end();

}
