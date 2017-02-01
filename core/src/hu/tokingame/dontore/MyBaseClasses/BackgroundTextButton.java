package hu.tokingame.dontore.MyBaseClasses;

import hu.tokingame.dontore.Global.Assets;

/**
 * Created by davim on 2017. 01. 20..
 */


public class BackgroundTextButton extends MyTextButton {

    int color;


    public BackgroundTextButton(String text, int c) {
        super(" "+text+" ");

        color = c;

        setFont(Assets.manager.get(Assets.ANTON_FONT_B));
        //setStyle(new TextButtonStyle(null, null, null,Assets.manager.get(Assets.ANTON_FONT_B) ));

        switch(color){
            case 1: setTexture(Assets.manager.get(Assets.BUTTON_BG)); break;
            case 2: setTexture(Assets.manager.get(Assets.BUTTON_BG_RED)); break;
            default: break;
        }
    }

    public BackgroundTextButton(String text){
        super(" "+text+" ");
        setFont(Assets.manager.get(Assets.ANTON_FONT_B));
        setTexture(Assets.manager.get(Assets.BUTTON_BG));
    }

    @Override
    protected void init() {
        super.init();
    }
}
