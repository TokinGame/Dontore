package hu.tokingame.dontore.Game;

import com.badlogic.gdx.Gdx;

import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.Global.Mode;
import hu.tokingame.dontore.MyBaseClasses.BluetoothChooseServerClientStage;
import hu.tokingame.dontore.MyBaseClasses.BluetoothClientConnectionStage;
import hu.tokingame.dontore.MyBaseClasses.BluetoothDisconectionStage;
import hu.tokingame.dontore.MyBaseClasses.BluetoothServerListenStage;
import hu.tokingame.dontore.MyBaseClasses.MyScreen;
import hu.tokingame.dontore.MyGdxGame;

/**
 * Created by tuskeb on 2017. 01. 27..
 */

public class MultiGameScreen extends MyScreen {
    public enum BluetoothState {
        Choose, Listening, Discovering, Connected, Disconnected
    }

    BluetoothChooseServerClientStage bluetoothChooseServerClientStage;
    BluetoothServerListenStage bluetoothServerListenStage;
    BluetoothClientConnectionStage bluetoothClientConnectionStage;
    BluetoothDisconectionStage bluetoothDisconectionStage;

    BTJumpGameStage btJumpGameStage;
    BTBuilderGameStage btBuilderGameStage;

    BluetoothState bluetoothState = BluetoothState.Choose;


    public MultiGameScreen(MyGdxGame game) {
        super(game);
    }

    @Override
    public void init() {
        super.init();


        bluetoothChooseServerClientStage = new BluetoothChooseServerClientStage(game) {
            @Override
            public void init() {
                super.init();
                addBackEventStackListener();
            }


            @Override
            public void startServer() {
                bluetoothState = BluetoothState.Listening;
                Globals.gameMode = Mode.Host;
                bluetoothServerListenStage = new BluetoothServerListenStage(game) {
                    @Override
                    public void init() {
                        super.init();
                        addBackEventStackListener();
                    }

                    @Override
                    public void acceptConnection() {
                        bluetoothState = BluetoothState.Connected;
                        btJumpGameStage = new BTJumpGameStage(game) {
                            @Override
                            public void disconnect() {
                                bluetoothDisconectionStage = new BluetoothDisconectionStage(game) {

                                    @Override
                                    public void end() {
                                        game.setScreenBackByStackPop();
                                    }
                                };
                                Gdx.input.setInputProcessor(bluetoothDisconectionStage);
                                bluetoothState = BluetoothState.Disconnected;
                            }
                        };
                        //Gdx.input.setInputProcessor(btJumpGameStage);
                    }
                };
                Gdx.input.setInputProcessor(bluetoothServerListenStage);
            }

            @Override
            public void startClient() {
                bluetoothState = BluetoothState.Discovering;
                Globals.gameMode = Mode.Client;
                bluetoothClientConnectionStage = new BluetoothClientConnectionStage(game) {
                    @Override
                    public void init() {
                        super.init();
                        addBackEventStackListener();
                    }

                    @Override
                    public void startConnection() {
                        bluetoothState = BluetoothState.Connected;
                        btBuilderGameStage = new BTBuilderGameStage(game) {
                            @Override
                            public void disconnect() {
                                bluetoothDisconectionStage = new BluetoothDisconectionStage(game) {

                                    @Override
                                    public void end() {
                                        game.setScreenBackByStackPop();
                                    }
                                };
                                Gdx.input.setInputProcessor(bluetoothDisconectionStage);
                                bluetoothState = BluetoothState.Disconnected;
                            }

                        };
                        //Gdx.input.setInputProcessor(btBuilderGameStage);
                    }
                };
                Gdx.input.setInputProcessor(bluetoothClientConnectionStage);
            }
        };


        Gdx.input.setInputProcessor(bluetoothChooseServerClientStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        switch (bluetoothState) {
            case Choose:
                bluetoothChooseServerClientStage.act(delta);
                bluetoothChooseServerClientStage.draw();
                break;
            case Listening:
                bluetoothServerListenStage.act(delta);
                bluetoothServerListenStage.draw();
                break;
            case Discovering:
                bluetoothClientConnectionStage.act(delta);
                bluetoothClientConnectionStage.draw();
                break;
            case Connected:
                if (btBuilderGameStage == null) {
                    btJumpGameStage.act(delta);
                    btJumpGameStage.draw();
                } else {
                    btBuilderGameStage.act(delta);
                    btBuilderGameStage.draw();
                }
                break;
            case Disconnected:
                bluetoothDisconectionStage.act(delta);
                bluetoothDisconectionStage.draw();
                break;
        }
    }

    @Override
    public void dispose() {
        bluetoothChooseServerClientStage.dispose();
        super.dispose();
    }

}
