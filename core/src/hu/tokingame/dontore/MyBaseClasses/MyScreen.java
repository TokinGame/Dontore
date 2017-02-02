package hu.tokingame.dontore.MyBaseClasses;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by davimatyi on 2017. 01. 10..
 */
abstract public class MyScreen implements Screen, InitableInterface {

    public float r = 0, g = 0, b = 0;

    public final MyGdxGame game;


    public MyScreen(MyGdxGame game) {
        this.game = game;
        init();
    }

    @Override
    public void dispose() {
        //spriteBatch.dispose();
    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(r, g, b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //spriteBatch.setProjectionMatrix(camera.combined);
    }


    @Override
    public void resize(int width, int height) {
        //setCameraReset(viewport, width, height);
    }

    @Override
    public void resume() {

    }

    @Override
    public void show() {

    }

    public Game getGame() {
        return game;
    }

    public void setBackGroundColor(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    @Override
    public void init() {

    }
}
