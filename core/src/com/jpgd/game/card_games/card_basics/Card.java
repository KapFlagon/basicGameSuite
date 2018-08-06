package com.jpgd.game.card_games.card_basics;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Card {

    /*
    Variables
     */
    private String suit, face, faceDigit, textureRegionName;
    private int value;
    private TextureRegion faceTexRegion, backTexRegion;
    private Image faceImg, backImg;


    /*
    Constructors
     */
    public Card(String suit, String face, String faceDigit, int value, TextureAtlas atlas) {
        this.suit = suit;
        this.face = face;
        this.faceDigit = faceDigit;
        this.value = value;
        textureRegionName = buildTextureRegionName();
        faceTexRegion = atlas.findRegion(textureRegionName);
        faceImg = new Image(faceTexRegion);
        //faceImg.setScale(1.5f);
        backTexRegion = atlas.findRegion("z_back");
        backImg = new Image(backTexRegion);
        backImg.setScale(1.5f);
        //setBounds(faceImg.getRegionX(), faceImg.getRegionY(), faceImg.getRegionWidth(), faceImg.getRegionHeight());
    }
    public Card(Card card) {
        this.suit = card.getSuit();
        this.face = card.getFace();
        this.faceDigit = card.getFaceDigit();
        this.value = card.getValue();
        textureRegionName = buildTextureRegionName();
        faceTexRegion = card.getFaceTexRegion();
        faceImg = card.getFaceImg();
        //faceImg.setScale(1.5f);
        backTexRegion = card.getBackTexRegion();
        backImg = card.getBackImg();
        backImg.setScale(1.5f);
    }

    /*
    Getters
     */
    public String getSuit() {
        return suit;
    }
    public String getFace() {
        return face;
    }
    public String getFaceDigit() {
        return faceDigit;
    }
    public int getValue() {
        return value;
    }
    public TextureRegion getFaceTexRegion() {
        return faceTexRegion;
    }
    public TextureRegion getBackTexRegion() {
        return backTexRegion;
    }
    public Image getFaceImg() {
        return faceImg;
    }
    public Image getBackImg() {
        return backImg;
    }

    /*
    Setters
     */
    public void setSuit(String passedSuit) {
        this.suit = passedSuit;
    }
    public void setFace(String passedFace) {
        this.face = passedFace;
    }
    public void setFaceDigit(String passedFaceDigit) {
        this.faceDigit = passedFaceDigit;
    }
    public void setValue(int passedValue) {
        this.value = passedValue;
    }

    /*
    Other methods
     */
    // Print string for the card
    public void printCard() {
        System.out.println("This card: " + face + " of " + suit);
    }

    private String buildTextureRegionName() {
        String output = suit.toLowerCase() + "_" + faceDigit + "_" + face.toLowerCase();
        return output;
    }

    public void dispose() {
        faceTexRegion.getTexture().dispose();
        backTexRegion.getTexture().dispose();
    }

    public void printSize() {
        System.out.println("Card size: " + this.getFaceImg().getWidth() + " " + this.getFaceImg().getHeight());
    }

}
