package com.jpgd.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.jpgd.game.BasicGameSuite;
import com.jpgd.game.card_games.rule_sets.HigherOrLower;

public class EndGameState extends State {

    private Button playAgainButton, quitButton;

    public EndGameState(BasicGameSuite basicGameSuite, int score) {
        super(basicGameSuite);
        this.getLabel().setText("End score: " + score);
        // setting the size of the label, not the text font
        this.getLabel().setSize(this.getBasicGameSuite().WIDTH, this.getBasicGameSuite().HEIGHT);
        // Setting the scale of the font text itself
        this.getLabel().setFontScale(3);
        this.getLabel().setAlignment(Align.center);


        Gdx.input.setInputProcessor(this.getStage());
        // initialize the "play again" button and set position
        playAgainButton = new TextButton("Play again?", this.getSkin());
        playAgainButton.setSize(this.getBasicGameSuite().WIDTH/5,this.getBasicGameSuite().HEIGHT/6);
        playAgainButton.setPosition((this.getBasicGameSuite().WIDTH/5)*1, (this.getBasicGameSuite().HEIGHT/6)*1);
        playAgainButton.addListener(new InputListener() {
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                getBasicGameSuite().setScreen(new PlayState(getBasicGameSuite(), new HigherOrLower()));
                dispose();
                //getGsm().set(new PlayState(getBasicGameSuite(), new HigherOrLower()));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });

        // initialize the "quit" button and set position
        quitButton = new TextButton("Quit?", this.getSkin());
        quitButton .setSize(this.getBasicGameSuite().WIDTH/5,this.getBasicGameSuite().HEIGHT/6);
        quitButton .setPosition((this.getBasicGameSuite().WIDTH/5)*3, (this.getBasicGameSuite().HEIGHT/6)*1);
        quitButton .addListener(new InputListener() {
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

                dispose();
                Gdx.app.exit();
                //getGsm().set(new PlayState(getBasicGameSuite(), new HigherOrLower()));
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });

/*
        this.getStage().addActor(this.getLabel());
        this.getStage().addActor(playAgainButton);
        this.getStage().addActor(quitButton);
*/
        Table buttonTable = new Table();
        //getTableLayout().setDebug(true);
        getTableLayout().setFillParent(true);
        getTableLayout().add(getLabel()).pad(10,20,10,20);
        getTableLayout().row();
        buttonTable.add(playAgainButton).width(playAgainButton.getWidth()).height(playAgainButton.getHeight()).pad(20,30,20,30);
        buttonTable.add(quitButton).width(quitButton.getWidth()).height(quitButton.getHeight()).pad(20,30,20,30);
        getTableLayout().add(buttonTable);

        getStage().addActor(getTableLayout());

        System.out.println("In EndGameState");

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.getStage().act(delta);
        this.getStage().draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
}
