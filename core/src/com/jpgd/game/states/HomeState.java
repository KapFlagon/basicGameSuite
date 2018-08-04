package com.jpgd.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.jpgd.game.BasicGameSuite;
import com.jpgd.game.card_games.rule_sets.HigherOrLower;

public class HomeState extends State {

    private Button playButton;


    public HomeState(BasicGameSuite basicGameSuite) {
        super(basicGameSuite);

        this.getLabel().setText("Start playing Higher or Lower?");
        // setting the size of the label, not the text font
        this.getLabel().setSize(this.getBasicGameSuite().WIDTH, this.getBasicGameSuite().HEIGHT);
        // Setting the scale of the font text itself
        this.getLabel().setFontScale(3);
        this.getLabel().setAlignment(Align.center);


        Gdx.input.setInputProcessor(this.getStage());
        // initialize the "play" button and set position
        playButton = new TextButton("Play!", this.getSkin());
        playButton.setSize((this.getBasicGameSuite().WIDTH/5),(this.getBasicGameSuite().HEIGHT/6));
        playButton.setPosition(((this.getBasicGameSuite().WIDTH/5)*2), ((this.getBasicGameSuite().HEIGHT/6)*1));
        playButton.addListener(new InputListener() {
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                getBasicGameSuite().setScreen(new PlayState(getBasicGameSuite(), new HigherOrLower()));
                dispose();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });


        //getTableLayout().setDebug(true);
        getTableLayout().setFillParent(true);
        getTableLayout().add(getLabel()).pad(4);
        getTableLayout().row();
        getTableLayout().add(playButton).width(playButton.getWidth()).height(playButton.getHeight()).pad(4);

        getStage().addActor(getTableLayout());
        System.out.println("In HomeState");
    }



    @Override
    public void show() {

        Gdx.input.setInputProcessor(this.getStage());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.getStage().act();
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

    @Override
    public void dispose() {
        super.dispose();
        System.out.println("HomeState disposed");
    }
}
