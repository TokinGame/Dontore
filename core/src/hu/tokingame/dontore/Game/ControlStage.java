package hu.tokingame.dontore.Game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.dontore.Global.Assets;
import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MenuScreen.MenuScreen;
import hu.tokingame.dontore.MyBaseClasses.MyLabel;
import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyBaseClasses.MyTextButton;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by davimatyi on 2017. 01. 18..
 */

public class ControlStage extends MyStage {

    MyLabel time;
    GameStage gameStage;

    public ControlStage(MyGdxGame game, GameStage sg) {
        super(new ExtendViewport(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT,new OrthographicCamera(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT)),new SpriteBatch(), game);
        gameStage = sg;
        addActor(time = new MyLabel(Math.rint(gameStage.getTime()*10)/10+"",MyLabel.style1));
    }

    public void updateDisplayedTime(){
        time.setText(Math.rint(gameStage.getTime()*10)/10+"");
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void init() {
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.NEM)){
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
                addListener(new ClickListener(){

                    @Override
                    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                        gameStage.character.jump();
                        return super.touchDown(event, x, y, pointer, button);
                    }
                });
            }
        });
        addActor(new MyTextButton("Quit"){
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-this.getWidth(), Globals.WORLD_HEIGHT-this.getHeight());
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new MenuScreen(game));
                    }
                });
            }
        });
    }
}
