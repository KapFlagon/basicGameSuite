package com.jpgd.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.jpgd.game.BasicGameSuite;

import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class NameInputState extends State {

    // Variables
    private TextField textField_Name;
    private Button submitButton;
    private String playerName;
    private int textField_Width;
    private int textField_Height;


    public NameInputState(BasicGameSuite basicGameSuite) {
        super(basicGameSuite);

        playerName = "";
        textField_Width = 380;
        textField_Height = 110;


        // Set the scale of the font in the text field (double it)
        // Set before initializing text box to avoid bug where text becomes offset
        this.getSkin().getFont("default-font").getData().setScale(2.5f);

        // Initialize the text field
        textField_Name = new TextField("", basicGameSuite.getSkin());
        textField_Name.setMessageText("What is your name?");
        textField_Name.setAlignment(Align.center);
        textField_Name.setBounds(this.getBasicGameSuite().WIDTH/2 - (textField_Width/2), this.getBasicGameSuite().HEIGHT/2 -(textField_Height/2), textField_Width, textField_Height);
        textField_Name.setScale(3f);

        // initialize the button
        submitButton = new TextButton("Submit", this.getSkin());
        submitButton.setSize(this.getBasicGameSuite().WIDTH/4,this.getBasicGameSuite().HEIGHT/5);
        submitButton.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Submit Button pushed");
                System.out.println("field text: " + textField_Name.getText());
                System.out.println("playerinput variable: " + playerName);
                if (textField_Name.getText().equals("")) {
                    playerName = "Player 1";

                    System.out.println("here 1");
                } else {
                    playerName = textField_Name.getText();
                    System.out.println("here 2");
                }
                System.out.println("Name input: " + playerName);
            }

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });

        // Update the table for layout
        getTableLayout().setFillParent(true);

        getTableLayout().add(textField_Name).width(textField_Width).height(textField_Height).pad(25);
        getTableLayout().row();
        getTableLayout().add(submitButton).width(submitButton.getWidth()).height(submitButton.getHeight());
        getTableLayout().top();
        this.getStage().addActor(getTableLayout());
    }

    // Getters
    public TextField getTextField_Name() {
        return textField_Name;
    }
    public String getPlayerName() {
        return playerName;
    }

    // Setters
    // public void setTextField_Name()
    public void setPlayerName(String passedPlayerName) {
        this.playerName = passedPlayerName;
    }


    // Other methods
    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.getStage());
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
    public void render(float delta) {
        // Clear screen of previous contents
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        this.getStage().act();
        this.getStage().draw();
    }

}
