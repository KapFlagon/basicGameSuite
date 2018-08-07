package com.jpgd.game.overlays;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.jpgd.game.BasicGameSuite;

public abstract class Overlay implements Disposable{

    /*
     * Variables
     */
    private BasicGameSuite basicGameSuite;
    private Stage stage;
    private Table table;
    private Viewport viewport;
    private BitmapFont font;
    private Skin skin;

    /*
     Constructors
     */
    public Overlay(BasicGameSuite basicGameSuite) {
        this.basicGameSuite = basicGameSuite;
        viewport = new FitViewport(BasicGameSuite.WIDTH, BasicGameSuite.HEIGHT, new OrthographicCamera());

        stage = new Stage(viewport, basicGameSuite.getSpriteBatch());

        table = new Table();
        table.setFillParent(true);
        this.font = basicGameSuite.getFont();
        this.skin = basicGameSuite.getSkin();
        stage.addActor(table);
    }

    /*
     Getters
     */
    public Stage getStage(){
        return stage;
    }
    public Table getTable() {
        return table;
    }
    public Skin getSkin() {
        return skin;
    }

    /*
    Other methods
     */
    @Override
    public void dispose() {
        stage.dispose();
    }
}
