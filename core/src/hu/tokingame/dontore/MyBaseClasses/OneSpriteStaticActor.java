package hu.tokingame.dontore.MyBaseClasses;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by davimatyi on 2017. 01. 10..
 */
public class OneSpriteStaticActor extends OneSpriteActor {

    public OneSpriteStaticActor(String file) {
        super(new Sprite(new Texture(file)));
    }

    public OneSpriteStaticActor(Texture texture) {
        super(new Sprite(texture));
    }

    public Texture getTexture() {
        return sprite.getTexture();
    }

    public void setTexture(Texture texture) {
        sprite.setTexture(texture);
    }

    public void setOriginCenter() {
        setOrigin(this.getWidth() / 2, this.getHeight() / 2);
    }
}
