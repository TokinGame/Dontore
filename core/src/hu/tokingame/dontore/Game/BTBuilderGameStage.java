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
        //character.getBody().setType(BodyDef.BodyType.StaticBody);
    }

    void add(float x, float y, int what){
        //x = phantomActor.getX() + x + 2;
        switch(what){
            case 1:
                CrateActor crateActor;
                addActor(crateActor = new CrateActor(world, loader, x, y));
                bluetoothConnectedStage.sendMessage("bc:" + crateActor.toString());
                break;
            case 2:
                SpikeActor spikeActor;
                addActor(spikeActor = new SpikeActor(world, loader, x, y));
                bluetoothConnectedStage.sendMessage("bs:" + spikeActor.toString());
                break;
        }
        //bluetoothConnectedStage.sendMessage("b:"+x+";"+y+";"+what);
    }

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

    }

    abstract public void  disconnect();

}
