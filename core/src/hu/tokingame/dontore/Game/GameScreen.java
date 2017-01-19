package hu.tokingame.dontore.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.ConeShapeBuilder;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.MenuScreen.MenuScreen;
import hu.tokingame.dontore.MyBaseClasses.MyScreen;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by davimatyi on 2017. 01. 18..
 */

public class GameScreen extends MyScreen {

    SinglePlayerStage singlestage;
    BluetoothChooseServerStage chooseServerStage;
    BluetoothServerStartedStage serverStartedStage;
    ChooseBluetoothModeStage chooseModeStage;
    ClientGameStage clientGameStage;
    HostedGameStage hostedGameStage;
    public enum BluetoothState{
        Choose, Listening, Discovering, Connected, Disconnected
    }




    BluetoothState bluetoothState = BluetoothState.Choose;

    public GameScreen(MyGdxGame game) {
        super(game);
        if(Globals.multiPlayer){
            chooseServerStage = new BluetoothChooseServerStage(new ExtendViewport(16, 16, Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), new SpriteBatch(), game);
            serverStartedStage = new BluetoothServerStartedStage(new ExtendViewport(16, 16, Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), new SpriteBatch(), game);
            chooseModeStage = new ChooseBluetoothModeStage(new ExtendViewport(16, 16, Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), new SpriteBatch(), game);
            clientGameStage = new ClientGameStage(new ExtendViewport(16, 16, Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), new SpriteBatch(), game);
            hostedGameStage = new HostedGameStage(new ExtendViewport(16, 16, Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), new SpriteBatch(), game);
        }else{
            singlestage = new SinglePlayerStage(new ExtendViewport(16, 16, Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), new SpriteBatch(), game);
        }




    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        if(!Globals.multiPlayer) {
            singlestage.act(delta);
            singlestage.draw();
        }
        else{
            switch(bluetoothState){
                case Choose:
                    chooseModeStage.act(delta);
                    chooseModeStage.draw();
                    break;
                case Listening:
                    serverStartedStage.act(delta);
                    serverStartedStage.draw();
                    break;
                case Discovering:
                    chooseServerStage.act(delta);
                    chooseServerStage.draw();
                    break;
                case Connected:
                    if(Globals.host){
                        hostedGameStage.act(delta);
                        hostedGameStage.draw();
                    }else{
                        clientGameStage.act(delta);
                        clientGameStage.draw();
                    }
                    break;
                case Disconnected:
                    game.setScreen(new MenuScreen(game));
                    break;
            }
        }
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void resume() {
        super.resume();
    }

}
