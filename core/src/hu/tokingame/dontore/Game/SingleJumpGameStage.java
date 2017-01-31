package hu.tokingame.dontore.Game;

import hu.tokingame.dontore.Bodies.CrateActor;
import hu.tokingame.dontore.Bodies.SpikeActor;
import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.Global.Mode;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by tuskeb on 2017. 01. 30..
 */

public class SingleJumpGameStage extends JumpGameStage {
    public SingleJumpGameStage(MyGdxGame game) {
        super(game);
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

    @Override
    public void act(float delta) {
        super.act(delta);
        //world.step(delta, 1, 1);
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
                generateMap();
            }
            if(elapsedtime % 20 == 0){
                character.maxSpeed += 1;
                phantomActor.maxSpeed += 1;
            }
        }

    }

    public void generate(){
        generateMap();
    }
}
