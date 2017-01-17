package hu.tokingame.dontore.MyBaseClasses;


import com.badlogic.gdx.scenes.scene2d.ui.Label;

/**
 * Created by davimatyi on 2017. 01. 13..
 */

public class SerialLabel extends MyLabel {

    float delta = 0;

    public SerialLabel(CharSequence text, Label.LabelStyle style) {
        super(text, style);
    }

    @Override
    public void init() {
        super.init();
    }
}
