package hu.tokingame.dontore.Game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.dontore.Bodies.CrateActor;
import hu.tokingame.dontore.Bodies.SpikeActor;
import hu.tokingame.dontore.MyBaseClasses.BluetoothConnectedStage;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by tuskeb on 2017. 01. 30..
 */

abstract public class BTJumpGameStage extends JumpGameStage {
    BluetoothConnectedStage bluetoothConnectedStage;

    private final float sendPositionInterval = 0.1f;
    private float lastSendPosition = 0f;
    private float time = 0f;

    public BTJumpGameStage(MyGdxGame game) {
        super(game);
        bluetoothConnectedStage = new BluetoothConnectedStage(new ExtendViewport(1,1,new OrthographicCamera(1,1)), new SpriteBatch(),game) {
            @Override
            public void disconnected() {
                disconnect();
            }

            @Override
            public void init() {

            }
        };
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        time+=delta;
        bluetoothConnectedStage.act();
        if (lastSendPosition+sendPositionInterval<time) {
            lastSendPosition = time;
            bluetoothConnectedStage.sendMessage("c:" + character.toString());
        }
        String m = bluetoothConnectedStage.getMessage();
        if(m.charAt(0) == 'b'){
            m = m.substring(1);
            String[] k = m.split(";");
            add(Integer.parseInt(k[0]), Integer.parseInt(k[1]), Integer.parseInt(k[2]));
        }
    }
    void add(float x, float y, int what){
        x = phantomActor.getX() + x + 2;
        switch(what){
            case 1: addActor(new CrateActor(world, loader, x, y)); break;
            case 2: addActor(new SpikeActor(world, loader, x, y)); break;
        }
    }

    abstract public void  disconnect();

}
