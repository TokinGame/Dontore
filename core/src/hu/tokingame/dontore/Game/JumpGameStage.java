package hu.tokingame.dontore.Game;

import com.badlogic.gdx.math.Vector2;

import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by tuskeb on 2017. 01. 30..
 */

abstract public class JumpGameStage extends GameStage {
    ControlStage controlStage;

    public JumpGameStage(MyGdxGame game) {
        super(game);
        controlStage = new ControlStage(game, this);
        inputMultiplexer.addProcessor(0, controlStage);
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
            character.getBody().setLinearVelocity(phantomActor.getSpeed(), character.getBody().getLinearVelocity().y);
            /*if (character.getX() < phantomActor.getX() - 1) {
                character.getBody().applyForceToCenter(new Vector2((phantomActor.getX() - 1 - character.getX()) * 500 * delta, 0), true);
            }*/
        }
        controlStage.act(delta);
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
}
