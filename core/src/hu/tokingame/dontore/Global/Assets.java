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

/**
 * Created by M on 10/7/2016.
 */

public class Assets {

    public static AssetManager manager;

    static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
    static {
        fontParameter.fontFileName = "fonts/Anton-Regular.ttf";
        fontParameter.fontParameters.size = 50;
        fontParameter.fontParameters.characters = hu.tokingame.dontore.Global.Globals.CHARS;
        fontParameter.fontParameters.color = Color.WHITE;
    }
    // Fonts
    public static final AssetDescriptor<BitmapFont> ANTON_FONT = new AssetDescriptor<BitmapFont>("Fonts/Anton-Regular.ttf", BitmapFont.class, fontParameter);


    //<editor-fold desc="Map Elements">
    public static final AssetDescriptor<Texture>  SPIKE = new AssetDescriptor<Texture>("textures/spikes.png", Texture.class);
    public static final AssetDescriptor<Texture>  CRATE = new AssetDescriptor<Texture>("textures/wooden-crate.png", Texture.class);
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
        manager.load(SPIKE);
        manager.load(CRATE);
        //</editor-fold>

    }

    public static void afterLoaded(){

    }

    public static void unload(){
        manager.dispose();
    }

}
