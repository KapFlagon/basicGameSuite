package com.jpgd.game.overlays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.jpgd.game.BasicGameSuite;

public class OverlayOptions extends Overlay{

    /*
    Variables
     */
    private ImageButton optionsButton;

    /*
    Constructors
     */
    public OverlayOptions(BasicGameSuite basicGameSuite) {
        super(basicGameSuite);
        Gdx.input.setInputProcessor(getStage());
        getTable().right().bottom();
        optionsButton = new ImageButton(getSkin());

        optionsButton.getStyle().imageUp = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("OptionsSymbol.png"))));
        optionsButton.addListener(new InputListener(){
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Button no longer pushed!");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Button pushed!");
                return true;
            }
        });
        getTable().add(optionsButton);
    }


    @Override
    public void dispose() {
        super.dispose();

    }
}
