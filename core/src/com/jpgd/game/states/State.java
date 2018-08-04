package com.jpgd.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jpgd.game.BasicGameSuite;

public abstract class State implements Screen{

    // Variables
    private BasicGameSuite basicGameSuite;
    private OrthographicCamera orthoCam;
    private Viewport viewport;
    private Stage stage;
    private Table tableLayout;
    private BitmapFont font;
    private Label label;
    private Skin skin;
    private Texture texture_bg;
    private Image bg;


    protected State(BasicGameSuite basicGameSuite) {
        this.basicGameSuite = basicGameSuite;
        this.orthoCam = basicGameSuite.getOrthoCam();
        this.viewport = basicGameSuite.getViewport();
        this.stage = new Stage(viewport, this.basicGameSuite.getSpriteBatch());
        this.tableLayout = new Table();
        this.font = new BitmapFont();
        this.label = new Label("Default Label!", new Label.LabelStyle(font, Color.WHITE));
        this.skin = basicGameSuite.getSkin();

        texture_bg = new Texture("greytable.jpg");
        bg = new Image(texture_bg);
        bg.setPosition(0, 0);
        setBgColour("BLUE");

        stage.addActor(bg);
    }


    // Getters
    public BasicGameSuite getBasicGameSuite() {
        return basicGameSuite;
    }
    public OrthographicCamera getOrthoCam() {
        return orthoCam;
    }
    public Viewport getViewport() {
        return viewport;
    }
    public Stage getStage() {
        return stage;
    }
    public Table getTableLayout() {
        return tableLayout;
    }
    public BitmapFont getFont() {
        return font;
    }
    public Label getLabel() {
        return label;
    }
    public Skin getSkin() {
        return skin;
    }
    public Texture getTexture_bg() {
        return texture_bg;
    }
    public Image getBg() {
        return bg;
    }


    // Setters


    // Other methods

    public void setBgColour(String colour) {
        if (colour == "GREEN") {
            bg.setColor(0.2f,0.8f,0.2f,1);  // Dark green color
        } else if (colour == "RED") {
            bg.setColor(0.8f,0.2f,0.2f,1);  // Red color
        } else if (colour == "BLUE") {
            bg.setColor(0.1f,0.5f,0.8f,1);  // Blue color
        } else if (colour == "ORANGE") {
            bg.setColor(0.7f,0.4f,0.1f,1);  // Dark orange color
        }
        else {
            bg.setColor(0.2f,0.8f,0.2f,1);  // Dark green color
        }
    }

    @Override
    public void resize(int width, int height) {
        //resize cam viewport

        this.stage.getViewport().update(width, height, true);
        this.getBg().setFillParent(true);

    }

    public abstract void render(float delta);

    public void dispose(){
        this.font.dispose();;
        this.stage.dispose();
        this.texture_bg.dispose();

        System.out.println("State disposed");
    }
}
