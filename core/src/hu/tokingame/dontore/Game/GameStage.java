package hu.tokingame.dontore.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Vector;

import hu.tokingame.dontore.Bodies.BGActor;
import hu.tokingame.dontore.Bodies.Character;
import hu.tokingame.dontore.Bodies.CrateActor;
import hu.tokingame.dontore.Bodies.GrassActor;
import hu.tokingame.dontore.Bodies.PhantomActor;
import hu.tokingame.dontore.Bodies.SpikeActor;
import hu.tokingame.dontore.Bodies.TopActor;
import hu.tokingame.dontore.DarudeSandstorm.ExplosionActor;
import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.Global.Mode;
import hu.tokingame.dontore.MenuScreen.MenuScreen;
import hu.tokingame.dontore.MyBaseClasses.BackgroundTextButton;
import hu.tokingame.dontore.MyBaseClasses.MyLabel;
import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyBaseClasses.WorldBodyEditorLoader;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by tuskeb on 2017. 01. 30..
 */

abstract public class GameStage extends MyStage {

    protected InputMultiplexer inputMultiplexer = new InputMultiplexer();

    World world;
    Box2DDebugRenderer box2DDebugRenderer;
    WorldBodyEditorLoader loader;
    PauseStage pauseStage;
    PhantomActor phantomActor;
    float elapsedtime = 0;

    public Character character;

    private MyLabel time;

    Vector<GrassActor> grassV;
    GrassActor g1, g2, g3;

    Vector<BGActor> bgV;
    BGActor bg1, bg2, bg3, bg4, bg5;

    TopActor top;

    float lastX = 1, currentX = 1;

    int rdm(int a, int b){return (int)(Math.random()*(b-a+1)+a);}


    public GameStage(MyGdxGame game) {
        super(new ExtendViewport(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT,new OrthographicCamera(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT)), new SpriteBatch(), game);
        inputMultiplexer.addProcessor(this);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
            game.setScreen(new MenuScreen(game));
        }
        return false;
    }
    @Override
    public void init() {
        world = new World(new Vector2(0, -20), false);
        box2DDebugRenderer = new Box2DDebugRenderer();
        loader = new WorldBodyEditorLoader(Gdx.files.internal("phys.json"));

        //pauseStage = new PauseStage(new ExtendViewport(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT,new OrthographicCamera(Globals.WORLD_WIDTH,Globals.WORLD_HEIGHT)),new SpriteBatch(),game);

        character = new Character(world, 1, 1);
        phantomActor = new PhantomActor(world, loader, 1, 1);
        phantomActor.setSpeed(5);
        grassV = new Vector();
        bgV = new Vector();
        top = new TopActor(world, loader, character.getX(),2);




        setCameraMoveToXY(1, 4, 0.01f, 10000);

        bg1 = new BGActor(world, loader, -20, 0, 1);
        bg2 = new BGActor(world, loader, 0, 0, 2);
        bg3 = new BGActor(world, loader, 20, 0, 3);
        bg4 = new BGActor(world, loader, 40, 0, 4);
        bg5 = new BGActor(world, loader, 60, 0, 5);
        bgV.add(bg1);
        bgV.add(bg2);
        bgV.add(bg3);
        bgV.add(bg4);
        bgV.add(bg5);
        addActor(bg1);
        addActor(bg2);
        addActor(bg3);
        addActor(bg4);
        addActor(bg5);


        addActor(character);
        addActor(phantomActor);
        addActor(top);


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


        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                if (contact.getFixtureA().getUserData() instanceof SpikeActor && contact.getFixtureB().getUserData() instanceof Character ||
                        contact.getFixtureA().getUserData() instanceof Character && contact.getFixtureB().getUserData() instanceof SpikeActor) {
                    System.out.println("collision");
//                    death();
                }
                if (contact.getFixtureA().getUserData() instanceof CrateActor && contact.getFixtureB().getUserData() instanceof Character ||
                        contact.getFixtureA().getUserData() instanceof Character && contact.getFixtureB().getUserData() instanceof CrateActor){
                    character.doubleJumpAvalaible = true;
                }
                if (contact.getFixtureA().getUserData() instanceof GrassActor && contact.getFixtureB().getUserData() instanceof Character ||
                        contact.getFixtureA().getUserData() instanceof Character && contact.getFixtureB().getUserData() instanceof GrassActor){
                    character.doubleJumpAvalaible = true;
                }
            }

            @Override
            public void endContact(Contact contact) {

            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });
        startTimer();
    }


    @Override
    public void act(float delta) {
        super.act(delta);
        world.step(delta, 5, 5);
        elapsedtime += delta;
        if(character.alive) {
            setCameraMoveToXY(phantomActor.getX(), 4, 0.01f, 10000);

            top.setPosition(character.getX(), 7.5f);

            currentX = (phantomActor.getX() - lastX) / 2;
            bg1.setX(bg1.getX() + currentX);
            bg2.setX(bg2.getX() + currentX);
            bg3.setX(bg3.getX() + currentX);
            bg4.setX(bg4.getX() + currentX);
            bg5.setX(bg5.getX() + currentX);
            lastX = phantomActor.getX();

            if (phantomActor.getX() > bgV.get(2).getX()) {
                bgV.get(0).setX(bgV.get(4).getX() + 20);
                bgV.add(bgV.get(0));
                bgV.remove(0);
            }

            if (phantomActor.getX() > grassV.get(2).getX()) {
                grassV.get(0).setX(grassV.get(2).getX() + 8);
                grassV.add(grassV.get(0));
                grassV.remove(0);
                if(Globals.gameMode == Mode.SinglePlayer) generateMap();
            }
            if(elapsedtime % 20 == 0){
                character.maxSpeed += 1;
                phantomActor.maxSpeed += 1;
            }
        }
        //if(character.getX() < phantomActor.getX() - 7 && character.alive) death();
    }

    @Override
    public void draw() {
        updateFrustum(1.25f);
        super.draw();
    }


    @Override
    public void resize(int screenWidth, int screenHeight) {
        super.resize(screenWidth, screenHeight);
    }



    public PhantomActor getPhantomActor() {
        return phantomActor;
    }

    void generateMap(){
        int ref = (int)grassV.get(2).getX();
        int nr = rdm(1, 2);
        switch(nr){
            case 1:{
                if(rdm(1,5) != 1){
                    switch(rdm(1,3)){
                        case 1: addActor(new CrateActor(world, loader, ref + 4, 1)); break;
                        case 2: addActor(new CrateActor(world, loader, ref + 4, 1));
                            addActor(new CrateActor(world, loader, ref + 4, 2)); break;
                        case 3: addActor(new CrateActor(world, loader, ref + 4, 1));
                            addActor(new CrateActor(world, loader, ref + 4, 2));
                            addActor(new CrateActor(world, loader, ref + 4, 3)); break;
                    }
                }else addActor(new SpikeActor(world, loader, ref + 4, 1));
                break;
            }
            case 2:{
                if(rdm(1,5) != 1){
                    switch(rdm(1,3)){
                        case 1: addActor(new CrateActor(world, loader, ref + 2, 1)); break;
                        case 2: addActor(new CrateActor(world, loader, ref + 2, 1));
                            addActor(new CrateActor(world, loader, ref + 2, 2)); break;
                        case 3: addActor(new CrateActor(world, loader, ref + 2, 1));
                            addActor(new CrateActor(world, loader, ref + 2, 2));
                            addActor(new CrateActor(world, loader, ref + 2, 3)); break;
                    }
                    switch(rdm(1,3)){
                        case 1: addActor(new CrateActor(world, loader, ref + 5, 1)); break;
                        case 2: addActor(new CrateActor(world, loader, ref + 5, 1));
                            addActor(new CrateActor(world, loader, ref + 5, 2)); break;
                        case 3: addActor(new CrateActor(world, loader, ref + 5, 1));
                            addActor(new CrateActor(world, loader, ref + 5, 2));
                            addActor(new CrateActor(world, loader, ref + 5, 3)); break;
                    }
                }else {
                    addActor(new SpikeActor(world, loader, ref + 2, 1));
                    addActor(new SpikeActor(world, loader, ref + 5, 1));
                }
                break;
            }
        }
    }
}
