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

    private final float sendPositionInterval = 0.05f;
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
        String m;
        while((m = bluetoothConnectedStage.getMessage())!=null){
            String[] strings = m.split(":");
            if (strings.length==2 && strings[0].compareTo("bc")==0){
                CrateActor crateActor;
                crateActor = addCrate(0,0);
                crateActor.fromString(strings[1]);
            }
            if (strings.length==2 && strings[0].compareTo("bs")==0){
                SpikeActor spikeActor;
                spikeActor = addSpike(0,0);
                spikeActor.fromString(strings[1]);
            }
        }
    }

    /*
    void add(float x, float y, int what){
        x = phantomActor.getX() + x + 2;
        switch(what){
            case 1: addActor(new CrateActor(world, loader, x, y)); break;
            case 2: addActor(new SpikeActor(world, loader, x, y)); break;
        }
    }
*/
    abstract public void  disconnect();

}
