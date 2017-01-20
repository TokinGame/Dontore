package hu.tokingame.dontore.SettingsScreen;

import hu.tokingame.dontore.MyBaseClasses.MyStage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import java.lang.String;

import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MenuScreen.MenuScreen;
import hu.tokingame.dontore.MyBaseClasses.MyLabel;
import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyBaseClasses.MyTextButton;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteAnimatedActor;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by Zoli on 2017.01.20..
 */

public class SettingsStage extends MyStage {
    public static boolean cameraRotation = true;
    final private static String camText = "Camera rotation: ";

    public static boolean onScreenMode = false;
    final private static String onScreen = "Controls: ";

    public SettingsStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
            game.setScreenBackByStackPop();
        }
        return false;
    }

    @Override
    public void init() {
        addActor(new MyTextButton("I Don't Know"){
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);

            }
        });

        addActor(new MyTextButton("Back"){
            @Override
            protected void init() {
                super.init();
                this.setPosition(getViewport().getWorldWidth()-this.getWidth(),0);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreenBackByStackPop();
                    }
                });
            }
        });

        addActor(new MyTextButton(camText){
            @Override
            protected void init() {
                this.setPosition(120,40);
                super.init();
                final MyTextButton button = this;
                if(cameraRotation)
                    this.setText(camText + "enabled");
                else
                    this.setText(camText + "disabled");
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        cameraRotation = !cameraRotation;
                        if(cameraRotation)
                            button.setText(camText + "enabled");
                        else
                            button.setText(camText + "disabled");
                    }
                });
            }
        });
    }
}
