package hu.tokingame.dontore.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sun.corba.se.impl.protocol.SpecialMethod;

import java.util.Vector;

import hu.tokingame.dontore.Bodies.BGActor;
import hu.tokingame.dontore.Bodies.Character;
import hu.tokingame.dontore.Bodies.CrateActor;
import hu.tokingame.dontore.Bodies.GrassActor;
import hu.tokingame.dontore.Bodies.PhantomActor;
import hu.tokingame.dontore.Bodies.SpikeActor;
import hu.tokingame.dontore.Bodies.TopActor;
import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MenuScreen.MenuBackgroundActor;
import hu.tokingame.dontore.MyBaseClasses.BluetoothConnectedStage;
import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyBaseClasses.WorldBodyEditorLoader;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by davimatyi on 2017. 01. 18..
 */

abstract public class ClientGameStage extends BluetoothConnectedStage {

    World world;
    Box2DDebugRenderer box2DDebugRenderer;
    WorldBodyEditorLoader loader;
    //ControlStage controlStage;
    AdderStage adderStage;
    PauseStage pauseStage;
    PhantomActor phantomActor;
    float elapsedtime = 0;

    Vector<GrassActor> grassV;
    GrassActor g1, g2, g3;

    Vector<BGActor> bgV;
    BGActor bg1, bg2, bg3;

    public Character character;

    float lastX = 1, currentX = 1;


    public ClientGameStage(MyGdxGame game) {
        super(new ExtendViewport(1280,720,new OrthographicCamera(1280,720)), new SpriteBatch(), game);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.BACK) {
            game.setScreenBackByStackPop();
        }
        return false;
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void draw() {
        updateFrustum(1.25f);
        super.draw();
        //controlStage.draw();
        adderStage.draw();
        box2DDebugRenderer.render(world, getCamera().combined);
    }

    @Override
    public void init() {

        world = new World(new Vector2(0, -20), false);
        box2DDebugRenderer = new Box2DDebugRenderer();
        loader = new WorldBodyEditorLoader(Gdx.files.internal("phys.json"));
        //controlStage = new ControlStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT, new OrthographicCamera(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT)), new SpriteBatch(), game);
        adderStage = new AdderStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT, new OrthographicCamera(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT)), new SpriteBatch(), game, this);
        //pauseStage = new PauseStage(new ExtendViewport(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT,new OrthographicCamera(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT)),new SpriteBatch(),game);

        phantomActor = new PhantomActor(world, loader, 1, 1);
        grassV = new Vector();
        bgV = new Vector();

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(this);
        inputMultiplexer.addProcessor(adderStage);
        //inputMultiplexer.addProcessor(controlStage);
        //inputMultiplexer.addProcessor(pauseStage);
        Gdx.input.setInputProcessor(inputMultiplexer);
        //addActor(new CrateActor(world, loader, 0, 0));
        //addActor(new SpikeActor(world, loader, 2, 0));


        setCameraMoveToXY(1, 4, 0.01f, 10000);

        bg1 = new BGActor(world, loader, -8, 0);
        bg2 = new BGActor(world, loader, 0, 0);
        bg3 = new BGActor(world, loader, 8, 0);
        bgV.add(bg1);
        bgV.add(bg2);
        bgV.add(bg3);
        addActor(bg1);
        addActor(bg2);
        addActor(bg3);


        addActor(phantomActor);

        character = new Character(world, 1, 1);
        //character.removeFromWorld();
        addActor(character);

        g1 = new GrassActor(world, loader, -8, 0);
        g2 = new GrassActor(world, loader, 0, 0);
        g3 = new GrassActor(world, loader, 8, 0);
        grassV.add(g1);
        grassV.add(g2);
        grassV.add(g3);
        addActor(g1);
        addActor(g2);
        addActor(g3);
        g1.setZIndex(10000);
        g2.setZIndex(10000);
        g3.setZIndex(10000);




    }

    @Override
    public void act(float delta) {
        super.act(delta);
        elapsedtime += delta;
        //world.step(delta, 1, 1);
        //controlStage.act(delta);
        adderStage.act();
        setCameraMoveToXY(phantomActor.getX(), 4, 0.01f, 10000);


        currentX = (phantomActor.getX() - lastX) / 2;
        bg1.setX(bg1.getX() + currentX);
        bg2.setX(bg2.getX() + currentX);
        bg3.setX(bg3.getX() + currentX);
        lastX = phantomActor.getX();

        if (phantomActor.getX() > bgV.get(2).getX()) {
            bgV.get(0).setX(bgV.get(2).getX() + 8);
            bgV.add(bgV.get(0));
            bgV.remove(0);
        }

        if (phantomActor.getX() > grassV.get(2).getX()) {
            grassV.get(0).setX(grassV.get(2).getX() + 8);
            grassV.add(grassV.get(0));
            grassV.remove(0);
        }

        if (elapsedtime > 20) {
            phantomActor.maxSpeed += 1;
            elapsedtime = 0;
        }
        String m;
        if ((m = getMessage())!=null){
            String[] strings = m.split(";");
            if (strings.length==3){
                if (strings[0].compareTo("c")==0){
                    character.setPosition(Float.valueOf(strings[1]), Float.valueOf(strings[2]));
                }
            }
        }
    }
    void add(float x, float y, int what){
        x = phantomActor.getX() + x - 3;
        switch(what){
            case 1: addActor(new CrateActor(world, loader, x, y)); break;
            case 2: addActor(new SpikeActor(world, loader, x, y)); break;
        }
    }
}
