package hu.tokingame.dontore.Global;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;
import com.badlogic.gdx.graphics.g3d.particles.values.GradientColorValue;

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
        fontParameter2.fontParameters.color = new Color(0.05098f, 0.05098f, 0.05098f, 1);
    }
    // Fonts
    public static final AssetDescriptor<BitmapFont> ANTON_FONT = new AssetDescriptor<BitmapFont>("Fonts/Anton-Regular.ttf", BitmapFont.class, fontParameter);
    public static final AssetDescriptor<BitmapFont> ANTON_FONT_B = new AssetDescriptor<BitmapFont>("Fonts/Anton-Regular.ttf", BitmapFont.class, fontParameter2);



    //<editor-fold desc="Map Elements">
    public static final AssetDescriptor<Texture>  SPIKE = new AssetDescriptor<Texture>("textures/spikes.png", Texture.class);
    public static final AssetDescriptor<Texture>  CRATE = new AssetDescriptor<Texture>("textures/wooden-crate.png", Texture.class);
    public static final AssetDescriptor<Texture> CHARACTER = new AssetDescriptor<Texture>("textures/weed.png", Texture.class);
    public static final AssetDescriptor<Texture> BUTTON_BG = new AssetDescriptor<Texture>("textures/buttonbg.png", Texture.class);
    public static final AssetDescriptor<Texture> BUTTON_BG_RED = new AssetDescriptor<Texture>("textures/buttonbg_red.png", Texture.class);
    //</editor-fold>

    //<editor-fold desc="Music">

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
        //</editor-fold>

    }

    public static void afterLoaded(){

    }

    public static void unload(){
        manager.dispose();
    }

}
