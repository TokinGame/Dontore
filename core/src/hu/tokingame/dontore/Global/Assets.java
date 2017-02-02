package hu.tokingame.dontore.Global;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.g3d.particles.values.GradientColorValue;

import hu.tokingame.dontore.MyBaseClasses.MyStage;

/**
 * Created by M on 10/7/2016.
 */

public class Assets {

    public static AssetManager manager;

    static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
    static {
        fontParameter.fontFileName = "fonts/Anton-Regular.ttf";
        fontParameter.fontParameters.size = 55;
        fontParameter.fontParameters.characters = hu.tokingame.dontore.Global.Globals.CHARS;
        fontParameter.fontParameters.color = Color.WHITE;
    }
    static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter2 = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
    static {
        fontParameter2.fontFileName = "fonts/Anton-Regular.ttf";
        fontParameter2.fontParameters.size = 45;
        fontParameter2.fontParameters.characters = hu.tokingame.dontore.Global.Globals.CHARS;
        fontParameter2.fontParameters.color = Color.BLACK;
    }
    // Fonts
    public static final AssetDescriptor<BitmapFont> ANTON_FONT = new AssetDescriptor<BitmapFont>("Fonts/Anton-Regular.ttf", BitmapFont.class, fontParameter);
    public static final AssetDescriptor<BitmapFont> ANTON_FONT_B = new AssetDescriptor<BitmapFont>("Fonts/Anton-Regular.ttf", BitmapFont.class, fontParameter2);




    //<editor-fold desc="Map Elements">
    public static final AssetDescriptor<Texture> SPIKE = new AssetDescriptor<Texture>("textures/spikes.png", Texture.class);
    public static final AssetDescriptor<Texture> CRATE = new AssetDescriptor<Texture>("textures/wooden-crate.png", Texture.class);
    public static final AssetDescriptor<Texture> CHARACTER = new AssetDescriptor<Texture>("textures/weed.png", Texture.class);
    public static final AssetDescriptor<Texture> BUTTON_BG = new AssetDescriptor<Texture>("textures/buttonbg.png", Texture.class);
    public static final AssetDescriptor<Texture> BUTTON_BG_RED = new AssetDescriptor<Texture>("textures/buttonbg_red.png", Texture.class);
    public static final AssetDescriptor<Texture> GRASS = new AssetDescriptor<Texture>("textures/grass_seamless.png", Texture.class);
    public static final AssetDescriptor<Texture> NEM = new AssetDescriptor<Texture>("textures/zolipls.png", Texture.class);
    public static final AssetDescriptor<TextureAtlas> EXPLOSION_TEXTUREATLAS = new AssetDescriptor<TextureAtlas>("textures/explosion.atlas", TextureAtlas.class);
    public static final AssetDescriptor<TextureAtlas> WALK_ATLAS = new AssetDescriptor<TextureAtlas>("textures/walk.txt", TextureAtlas.class);
    public static final AssetDescriptor<Texture> GRAVE = new AssetDescriptor<Texture>("textures/RIP_grave.png", Texture.class);
    public static final AssetDescriptor<Texture> PAPRIKA = new AssetDescriptor<Texture>("textures/paprika.png", Texture.class);
    public static final AssetDescriptor<Texture> TITLE = new AssetDescriptor<Texture>("textures/title.png", Texture.class);

    public static final AssetDescriptor<Texture> BG1 = new AssetDescriptor<Texture>("textures/background/bg1.png", Texture.class);
    public static final AssetDescriptor<Texture> BG2 = new AssetDescriptor<Texture>("textures/background/bg2.png", Texture.class);
    public static final AssetDescriptor<Texture> BG3 = new AssetDescriptor<Texture>("textures/background/bg3.png", Texture.class);
    public static final AssetDescriptor<Texture> BG4 = new AssetDescriptor<Texture>("textures/background/bg4.png", Texture.class);
    public static final AssetDescriptor<Texture> BG5 = new AssetDescriptor<Texture>("textures/background/bg5.png", Texture.class);
    public static final AssetDescriptor<Texture> BG_BLUR = new AssetDescriptor<Texture>("textures/background/blurbg.png", Texture.class);

    public static final AssetDescriptor<Texture> SPEAKER = new AssetDescriptor<Texture>("textures/speaker_icon.png", Texture.class);
    public static final AssetDescriptor<Texture> SPEAKER_DISABLED = new AssetDescriptor<Texture>("textures/speaker_icon_disabled.png", Texture.class);
    //</editor-fold>

    //<editor-fold desc="Music">
    public static final AssetDescriptor<Music> MAIN_MUSIC = new AssetDescriptor<Music>("music/paul-hartnett_07-160.mp3", Music.class);
    //</editor-fold>




    public static void prepare() {
        manager = new AssetManager();
        Texture.setAssetManager(manager);
    }

    public static void load(){
        FileHandleResolver resolver = new InternalFileHandleResolver();
        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
        manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));

        //<editor-fold desc="Loading">
        manager.load(ANTON_FONT);
        manager.load(ANTON_FONT_B);
        manager.load(SPIKE);
        manager.load(CRATE);
        manager.load(CHARACTER);
        manager.load(BUTTON_BG);
        manager.load(BUTTON_BG_RED);
        manager.load(GRASS);
        manager.load(NEM);
        manager.load(EXPLOSION_TEXTUREATLAS);
        manager.load(GRAVE);
        manager.load(PAPRIKA);
        manager.load(WALK_ATLAS);
        manager.load(TITLE);

        manager.load(BG1);
        manager.load(BG2);
        manager.load(BG3);
        manager.load(BG4);
        manager.load(BG5);
        manager.load(BG_BLUR);

        manager.load(SPEAKER);
        manager.load(SPEAKER_DISABLED);

        manager.load(MAIN_MUSIC);
        //</editor-fold>

    }

    public static void afterLoaded(){
        Assets.manager.get(Assets.MAIN_MUSIC).setLooping(true);
        Assets.manager.get(Assets.MAIN_MUSIC).play();
    }

    public static void unload(){
        manager.dispose();
    }

}
