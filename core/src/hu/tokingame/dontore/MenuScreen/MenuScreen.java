package hu.tokingame.dontore.MenuScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MyBaseClasses.MyScreen;
import hu.tokingame.dontore.MyGdxGame;

import static hu.tokingame.dontore.Global.Globals.PREFS;

/**
 * Created by M on 11/14/2016.
 */

public class MenuScreen extends MyScreen {
    private MenuStage stage;
    private static boolean firstLoad = true;
    private Preferences preferences;

    public MenuScreen(MyGdxGame game) {
        super(game);
        //init();
    }

    @Override
    public void init() {
        super.init();
        preferences = Gdx.app.getPreferences(PREFS);
        stage = new MenuStage(new ExtendViewport(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT,new OrthographicCamera(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT)),new SpriteBatch(),game);
        if(firstLoad){
            for (int i = 0; i < preferences.getInteger("size",0); i++) {
                Globals.MaxScores.add(preferences.getFloat(i+"",0));
            }
            firstLoad = false;
        }else{
            preferences.putInteger("size",Globals.MaxScores.size());
            for (int i = 0; i < Globals.MaxScores.size(); i++) {
                preferences.putFloat(i+"",Globals.MaxScores.get(i));
            }
        }

        preferences.flush();
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        stage.resize(width, height);
    }

    @Override
    public void dispose() {
        stage.dispose();
        super.dispose();
    }
}
