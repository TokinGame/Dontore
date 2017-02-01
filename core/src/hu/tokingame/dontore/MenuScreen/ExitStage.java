package hu.tokingame.dontore.MenuScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MyBaseClasses.BackgroundTextButton;
import hu.tokingame.dontore.MyBaseClasses.MyLabel;
import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyBaseClasses.MyTextButton;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by davimatyi on 2016. 12. 06..
 */

public class ExitStage extends BGStage {
    public ExitStage(Viewport viewport, Batch batch, MyGdxGame game) {
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
        super.init();
        addActor(new MyLabel("Are you sure want to exit?", MyLabel.style1){
            @Override
            public void init() {
                super.init();
                this.setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 500);
            }
        });

        addActor(new BackgroundTextButton("Yes", 2){
            @Override
            protected void init() {
                super.init();
                this.setPosition(Globals.WORLD_WIDTH/3-this.getWidth()/2, 350);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Gdx.app.exit();
                    }
                });
            }
        });
        addActor(new BackgroundTextButton("No", 1){
            @Override
            protected void init() {
                super.init();
                this.setPosition(Globals.WORLD_WIDTH/3*2-this.getWidth()/2, 350);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreenBackByStackPop();
                    }
                });
            }
        });

    }
}

