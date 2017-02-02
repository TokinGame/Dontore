package hu.tokingame.dontore.Game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.tokingame.dontore.Bodies.Character;
import hu.tokingame.dontore.Bodies.CrateActor;
import hu.tokingame.dontore.Bodies.GrassActor;
import hu.tokingame.dontore.Bodies.PaprikaActor;
import hu.tokingame.dontore.Bodies.SpikeActor;
import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MyBaseClasses.BackgroundTextButton;
import hu.tokingame.dontore.MyBaseClasses.MyLabel;
import hu.tokingame.dontore.MyGdxGame;

import static hu.tokingame.dontore.Global.Globals.dead;
import static hu.tokingame.dontore.HighScreen.HighStage.highscore;

/**
 * Created by tuskeb on 2017. 01. 30..
 */

abstract public class JumpGameStage extends GameStage {
    ControlStage controlStage;
    public float ripTime;
    PaprikaActor paprika;
    boolean paprikaThere = false;

    public JumpGameStage(MyGdxGame game) {
        super(game);
        controlStage = new ControlStage(game, this);
        inputMultiplexer.addProcessor(0, controlStage);
    }

    @Override
    public void init() {
        super.init();

        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                if (contact.getFixtureA().getUserData() instanceof SpikeActor && contact.getFixtureB().getUserData() instanceof Character ||
                        contact.getFixtureA().getUserData() instanceof Character && contact.getFixtureB().getUserData() instanceof SpikeActor) {
                    System.out.println("collision");
                    death();
                }
                if (contact.getFixtureA().getUserData() instanceof CrateActor && contact.getFixtureB().getUserData() instanceof Character ||
                        contact.getFixtureA().getUserData() instanceof Character && contact.getFixtureB().getUserData() instanceof CrateActor){
                    character.setJumpAvalaible();
                    //character.resumeRuning();
                }
                if (contact.getFixtureA().getUserData() instanceof GrassActor && contact.getFixtureB().getUserData() instanceof Character ||
                        contact.getFixtureA().getUserData() instanceof Character && contact.getFixtureB().getUserData() instanceof GrassActor){
                    character.setJumpAvalaible();
                    //character.resumeRuning();
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
        paprika = new PaprikaActor(world, loader, -10, 4);
        addActor(paprika);

    }

    @Override
    public void dispose() {
        super.dispose();
        controlStage.dispose();

    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(character.alive) {
            character.getBody().setLinearVelocity(phantomActor.getSpeed()*character.getMaxSpeed()/5, character.getBody().getLinearVelocity().y);
            if (character.getX() < phantomActor.getX() - 1) {
                character.getBody().applyForceToCenter(new Vector2((phantomActor.getX() - 1 - character.getX()) * 500 * delta, 0), true);
            }
        }
        controlStage.act(delta);
        if(character.getX() < phantomActor.getX() - 8 && character.alive) death();
        if(dead && !paprikaThere){
            paprika.setPosition(character.getX(), character.getY());
            paprikaThere = true;
        }
    }

    @Override
    public void draw() {
        super.draw();
        controlStage.draw();
        controlStage.updateDisplayedTime();
        box2DDebugRenderer.render(world, getCamera().combined);
    }

    @Override
    public void resize(int screenWidth, int screenHeight) {
        super.resize(screenWidth, screenHeight);
        controlStage.resize(screenWidth, screenHeight);
    }

    public void death(){
        if (!dead) {
            character.die();
            stopTimer();
            ripTime = getTime();
            highscore(ripTime);
            dead=true;
            controlStage.addActor(new MyLabel("You Died", MyLabel.style2) {
                @Override
                public void init() {
                    super.init();
                    setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2, Globals.WORLD_HEIGHT / 2 - this.getHeight() / 2);
                }
            });
            controlStage.addActor(new BackgroundTextButton("Restart", 1) {
                @Override
                public void init() {
                    super.init();
                    setPosition(Globals.WORLD_WIDTH - this.getWidth() - 10, 10);
                    addListener(new ClickListener() {
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            game.setScreen(new GameScreen(game));
                            dead=false;
                        }
                    });
                }
            });
        }

    }
}
