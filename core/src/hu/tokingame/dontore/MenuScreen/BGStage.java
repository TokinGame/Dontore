package hu.tokingame.dontore.MenuScreen;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.Vector;

import hu.tokingame.dontore.MyBaseClasses.MyStage;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by M on 2/1/2017.
 */

public class BGStage extends MyStage {

    MenuBackgroundActor a1, a2, a3;
    Vector<MenuBackgroundActor> actorVector;

    public BGStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);

    }

    @Override
    public void init() {
        actorVector = new Vector<MenuBackgroundActor>();
        a1 = new MenuBackgroundActor(1, 0, 0);
        a2 = new MenuBackgroundActor(2, 2760, 0);
        a3 = new MenuBackgroundActor(3, 2760 * 2, 0);
        actorVector.add(a1);
        actorVector.add(a2);
        actorVector.add(a3);
        addActor(a1);
        addActor(a2);
        addActor(a3);
        a1.setZIndex(0);
        a2.setZIndex(0);
        a3.setZIndex(0);
    }

    @Override
    public void draw() {
        super.draw();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        moveBackground();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    void moveBackground() {
        if (actorVector == null) return;
        if (actorVector.get(0).getX() < -2759.9f) actorVector.get(0).setX(2760 * 2);
        actorVector.add(actorVector.get(0));
        actorVector.remove(0);
        actorVector.get(0).setX(actorVector.get(0).getX() - 1f);
        actorVector.get(1).setX(actorVector.get(1).getX() - 1f);
        actorVector.get(2).setX(actorVector.get(2).getX() - 1f);
    }

}
