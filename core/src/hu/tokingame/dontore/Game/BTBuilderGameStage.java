package hu.tokingame.dontore.Game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.dontore.Bodies.CrateActor;
import hu.tokingame.dontore.Bodies.SpikeActor;
import hu.tokingame.dontore.MyBaseClasses.BluetoothConnectedStage;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by tuskeb on 2017. 01. 30..
 */

abstract public class BTBuilderGameStage extends GameStage {
    BluetoothConnectedStage bluetoothConnectedStage;
    AdderStage adderStage;

    public BTBuilderGameStage(MyGdxGame game) {
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
        adderStage = new AdderStage(game, this);
        inputMultiplexer.addProcessor(0, adderStage);
        setCameraOffset(4);
        //character.getBody().setType(BodyDef.BodyType.StaticBody);
    }


    @Override
    public CrateActor addCrate(float x, float y) {
        CrateActor crateActor = super.addCrate(x, y);
        bluetoothConnectedStage.sendMessage("bc:" + crateActor.toString());
        return crateActor;
    }

    @Override
    public SpikeActor addSpike(float x, float y) {
        SpikeActor spikeActor = super.addSpike(x, y);
        bluetoothConnectedStage.sendMessage("bs:" + spikeActor.toString());
        return spikeActor;
    }
/*
    void add(float x, float y, int what){
        //x = phantomActor.getX() + x + 2;
        switch(what){
            case 1:
                bluetoothConnectedStage.sendMessage("bc:" + addCrate(x,y).toString());
                break;
            case 2:
                bluetoothConnectedStage.sendMessage("bs:" + addSpike(x,y).toString());
                break;
        }
        //bluetoothConnectedStage.sendMessage("b:"+x+";"+y+";"+what);
    }
*/
    @Override
    public void act(float delta) {
        super.act(delta);
        bluetoothConnectedStage.act();
        String m;
        while ((m = bluetoothConnectedStage.getMessage())!=null){
            String[] strings = m.split(":");
            if (strings.length==2 && strings[0].compareTo("c")==0){
                character.fromString(strings[1]);
            }
        }
        adderStage.act(delta);
    }

    @Override
    public void draw() {
        super.draw();
        adderStage.draw();
    }

    @Override
    public void dispose() {
        adderStage.dispose();
        super.dispose();
    }

    abstract public void  disconnect();

}
