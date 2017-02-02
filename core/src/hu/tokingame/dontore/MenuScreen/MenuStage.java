package hu.tokingame.dontore.MenuScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokingame.dontore.CreditsScreen.CreditsScreen;
import hu.tokingame.dontore.CreditsScreen.HowToPlayScreen;
import hu.tokingame.dontore.Game.GameScreen;
import hu.tokingame.dontore.Game.MultiGameScreen;
import hu.tokingame.dontore.Global.Assets;
import hu.tokingame.dontore.Global.Globals;
import hu.tokingame.dontore.Global.Mode;
import hu.tokingame.dontore.HighScreen.HighScreen;
import hu.tokingame.dontore.MyBaseClasses.BackgroundTextButton;
import hu.tokingame.dontore.MyBaseClasses.MyTextButton;
import hu.tokingame.dontore.MyBaseClasses.OneSpriteStaticActor;
import hu.tokingame.dontore.MyGdxGame;

import static hu.tokingame.dontore.Global.Globals.dead;

/**
 * Created by M on 11/14/2016.
 */

public class MenuStage extends BGStage {

    MyTextButton button;

    public static boolean musicToggle = true;

    public MenuStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
        Gdx.input.setCatchBackKey(true);
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.BACK) {
            game.setScreen(new ExitScreen(game));
        }
        return false;
    }

    @Override
    public void init() {
        super.init();

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.TITLE)) {
            @Override
            public void init() {
                super.init();
                setOriginCenter();
                setSize(580, 240);
                setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2, 430);
            }

            float elapsedTime = 0;
            float maxWidth = 580, maxHeight = 240;

            @Override
            public void act(float delta) {
                elapsedTime += delta;
                setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2, 430);
                super.act(delta);
                setRotation((float) Math.sin(elapsedTime * 1.2f) * 15);
                setWidth((float) Math.abs(Math.sin(elapsedTime * 1.2f) * maxWidth / 2) + maxWidth / 2);
                setHeight((float) Math.abs(Math.sin(elapsedTime * 1.2f) * maxHeight / 2) + maxHeight / 2);
            }
        });

        // Csókólom ági van?

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.PAPRIKA)) {
            @Override
            public void init() {
                super.init();
                setSize(200, 200);
                setPosition(1000, 400);
            }

            float elapsedTime = 0;

            @Override
            public void act(float delta) {
                elapsedTime += delta;
                super.act(delta);
                setRotation((float) Math.sin(elapsedTime * 5.5f) * 15);
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.PAPRIKA)) {
            @Override
            public void init() {
                super.init();
                setSize(200, 200);
                setPosition(80, 400);

            }

            float elapsedTime = 0;

            @Override
            public void act(float delta) {
                elapsedTime += delta;
                super.act(delta);
                setRotation(-(float) Math.sin(elapsedTime * 5.5f) * 15);
            }
        });

        addActor(new BackgroundTextButton("How To Play", 1) {
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH / 3 * 2 - this.getWidth() / 3, 10);
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new HowToPlayScreen(game));
                    }
                });
            }
        });

        addActor(new BackgroundTextButton("Play singleplayer", 1) {
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2, 310);
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.multiPlayer = false;
                        Globals.gameMode = Mode.SinglePlayer;
                        game.setScreen(new GameScreen(game));
                        dead = false;
                    }
                });
            }

        });
        addActor(new BackgroundTextButton("Play bluetooth multiplayer", 1) {
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2, 210);
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.multiPlayer = true;
                        game.setScreen(new MultiGameScreen(game));

                    }
                });
            }

        });

        addActor(new BackgroundTextButton("Exit", 2) {
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH - this.getWidth() - 10, 10);
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new ExitScreen(game));
                    }
                });
            }
        });
        addActor(new BackgroundTextButton("Credits", 1) {
            @Override
            protected void init() {
                super.init();
                setPosition(10, 10);
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new CreditsScreen(game));
                    }
                });
            }
        });
        addActor(new BackgroundTextButton("High Scores", 1) {
            @Override
            protected void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH / 3 - this.getWidth() / 2, 10);
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new HighScreen(game));
                    }
                });
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.SPEAKER)) {
            @Override
            public void init() {
                super.init();
                setSize(100, 100);
                setPosition(10, Globals.WORLD_HEIGHT - this.getWidth() - 10);
                this.setPosition(10, Globals.WORLD_HEIGHT - this.getHeight() - 10);
                if (!Globals.music) setTexture(Assets.manager.get(Assets.SPEAKER_DISABLED));
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        musicToggle = !musicToggle;
                        Globals.music = !Globals.music;

                        if (musicToggle) {
                            setTexture(Assets.manager.get(Assets.SPEAKER));
                            Assets.manager.get(Assets.MAIN_MUSIC).play();
                        } else {
                            setTexture(Assets.manager.get(Assets.SPEAKER_DISABLED));
                            Assets.manager.get(Assets.MAIN_MUSIC).pause();
                        }
                    }
                });
            }
        });


    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

}

