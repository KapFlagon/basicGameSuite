package com.jpgd.game.states;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.utils.Align;
import com.jpgd.game.BasicGameSuite;
import com.jpgd.game.card_games.card_basics.Card;
import com.jpgd.game.card_games.rule_sets.CardGames;
import com.jpgd.game.card_games.rule_sets.HigherOrLower;
import com.jpgd.game.card_games.rule_sets.RuleSet;

public class PlayState extends State {

    private HigherOrLower gameSelection;
    //private RuleSet gameSelection;

    private TextureAtlas atlas;
    private int score;
    private Button higherButton, equalButton, lowerButton;

    VerticalGroup verticalGroup;
    HorizontalGroup horizontalGroup;
    private Table buttonTable;

    public PlayState(final BasicGameSuite basicGameSuite, final HigherOrLower gameSelection) {
    //public PlayState(BasicGameSuite basicGameSuite, RuleSet gameSelection) {
        super(basicGameSuite);

        verticalGroup = new VerticalGroup();
        horizontalGroup = new HorizontalGroup();
        buttonTable = new Table();

        score = 0;
        this.gameSelection = gameSelection;
        Gdx.input.setInputProcessor(this.getStage());

        this.getLabel().setText("What will the next card be?\nCards left: " + (gameSelection.getDeckManager().getDeck().size()) +  "   Score: " + score);
        // setting the size of the label, not the text font
        //this.getLabel().setSize(this.getBasicGameSuite().WIDTH, this.getBasicGameSuite().HEIGHT/4);
        // Setting the scale of the font text itself
        this.getLabel().setFontScale(3);
        this.getLabel().setAlignment(Align.top);


        //this.getStage().addActor(this.getLabel());

        gameSelection.dealCardsToPlayers();

        // initialize the "higher" button and set position
        higherButton = new TextButton("Higher?", this.getSkin());
        higherButton.setSize((this.getBasicGameSuite().WIDTH/5),(this.getBasicGameSuite().HEIGHT/6));


        //higherButton.setPosition((this.getBasicGameSuite().WIDTH/5)*1, (this.getBasicGameSuite().HEIGHT/6)*1);
        higherButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Higher Button pushed");
                if(gameSelection.getDeckManager().getDeck().size() > 1) {
                    gameSelection.dealCardsToPlayers();
                    if (gameSelection.compareCards("higher") == true) {
                        score++;
                    }
                    buildTableLayout();
                } else {
                    dispose();
                    basicGameSuite.getScreen().dispose();
                    basicGameSuite.setScreen(new EndGameState(basicGameSuite, score));
                    //dispose();
                }
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        //this.getStage().addActor(higherButton);

        // initialize the "equal" button and set position
        equalButton = new TextButton("Equal?", this.getSkin());
        equalButton.setSize((this.getBasicGameSuite().WIDTH/5),(this.getBasicGameSuite().HEIGHT/6));
        //equalButton.setPosition((this.getBasicGameSuite().WIDTH/5)*2, (this.getBasicGameSuite().HEIGHT/6)*1);
        equalButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Equal Button pushed");
                if(gameSelection.getDeckManager().getDeck().size() > 1) {
                    gameSelection.dealCardsToPlayers();
                    if (gameSelection.compareCards("equal") == true) {
                        score++;
                    }
                    buildTableLayout();
                } else {
                    basicGameSuite.getScreen().dispose();
                    basicGameSuite.setScreen(new EndGameState(basicGameSuite, score));
                    //dispose();
                }
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        //this.getStage().addActor(equalButton);

        // initialize the "lower" button and set position
        lowerButton = new TextButton("Lower?", this.getSkin());
        lowerButton.setSize((this.getBasicGameSuite().WIDTH/5),(this.getBasicGameSuite().HEIGHT/6));
        //lowerButton.setPosition((this.getBasicGameSuite().WIDTH/5)*3, (this.getBasicGameSuite().HEIGHT/6)*1);
        lowerButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Lower Button pushed");
                if(gameSelection.getDeckManager().getDeck().size() > 1) {
                    gameSelection.dealCardsToPlayers();
                    if (gameSelection.compareCards("lower") == true) {
                        score++;
                    }
                    buildTableLayout();
                } else {
                    basicGameSuite.getScreen().dispose();
                    basicGameSuite.setScreen(new EndGameState(basicGameSuite, score));
                    //dispose();
                }
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        //this.getStage().addActor(lowerButton);

        /*
        // Update the table for layout
        getTableLayout().setFillParent(true);

        getTableLayout().setDebug(true);
        //getTableLayout().align(Align.center);
        getTableLayout().add(this.getLabel());
        getTableLayout().row();

        getTableLayout().add(gameSelection.getCurrentCard().getFaceImg()).width(gameSelection.getCurrentCard().getFaceImg().getWidth()*1.5f).height(gameSelection.getCurrentCard().getFaceImg().getHeight()*1.5f).pad(10);
        getTableLayout().row();


        tableB.add(higherButton).width(higherButton.getWidth()).height(higherButton.getHeight()).pad(10,20,10,20);
        tableB.add(equalButton).width(equalButton.getWidth()).height(equalButton.getHeight()).pad(10,20,10,20);
        tableB.add(lowerButton).width(lowerButton.getWidth()).height(lowerButton.getHeight()).pad(10,20,10,20);




        getTableLayout().add(tableB);

        */

        getTableLayout().setFillParent(true);
        //getTableLayout().setDebug(true);
        buildTableLayout();

        this.getStage().addActor(this.getTableLayout());

        System.out.println("In PlayState");
    }

    public void buildTableLayout() {
        getTableLayout().clearChildren();
        buttonTable.clearChildren();
        //getTableLayout().setFillParent(true);

        //getTableLayout().align(Align.center);
        getTableLayout().add(this.getLabel());
        getTableLayout().row();

        getTableLayout().add(gameSelection.getCurrentCard().getFaceImg()).width(gameSelection.getCurrentCard().getFaceImg().getWidth()*1.5f).height(gameSelection.getCurrentCard().getFaceImg().getHeight()*1.5f).pad(10);
        getTableLayout().row();


        buttonTable.add(higherButton).width(higherButton.getWidth()).height(higherButton.getHeight()).pad(10,20,10,20);
        buttonTable.add(equalButton).width(equalButton.getWidth()).height(equalButton.getHeight()).pad(10,20,10,20);
        buttonTable.add(lowerButton).width(lowerButton.getWidth()).height(lowerButton.getHeight()).pad(10,20,10,20);

        getTableLayout().add(buttonTable);
    }


    //@Override
    public void handleInput() {

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //System.out.println("gameSelection.getCurrentCard().getFaceImg().getWidth(): " + gameSelection.getCurrentCard().getFaceImg().getWidth());

        this.getLabel().setText("What will the next card be?\nCards left: " + (gameSelection.getDeckManager().getDeck().size()) +  "   Score: " + score);
        //buildTableLayout();

        this.getStage().act();
        this.getStage().draw();
  /*      this.getBasicGameSuite().getSpriteBatch().begin();

        this.getBasicGameSuite().getSpriteBatch().draw(
                gameSelection.getCurrentCard().getFaceImg(),
                (this.getBasicGameSuite().WIDTH/2) - ((gameSelection.getCurrentCard().getFaceImg().getRegionWidth()*1.5f)/2),  // 1.5f scales teh image
                (this.getBasicGameSuite().HEIGHT/2) - ((gameSelection.getCurrentCard().getFaceImg().getRegionHeight()*1.5f)/2)+25, // 25 is to offset
                gameSelection.getCurrentCard().getFaceImg().getRegionWidth()*1.5f,
                gameSelection.getCurrentCard().getFaceImg().getRegionHeight()*1.5f);
        this.getBasicGameSuite().getSpriteBatch().end();
*/
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

        gameSelection.getDeckManager().dispose();
        System.out.println("PlayState disposed");
    }

}
