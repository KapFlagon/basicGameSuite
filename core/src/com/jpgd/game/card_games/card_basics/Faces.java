package com.jpgd.game.card_games.card_basics;

public enum Faces {
    ACE("Ace", "01", 1),
    TWO("Two", "02", 2),
    THREE("Three", "03", 3),
    FOUR("Four", "04", 4),
    FIVE("Five", "05", 5),
    SIX("Six", "06", 6),
    SEVEN("Seven", "07", 7),
    EIGHT("Eight", "08", 8),
    NINE("Nine", "09", 9),
    TEN("Ten", "10", 10),
    JACK("Jack", "11", 11),
    QUEEN("Queen", "12", 12),
    KING("King", "13", 13);

    private final String face, faceDigit;
    private final int value;

    Faces(String faceName, String faceDigit, int value) {
        this.face = faceName;
        this.faceDigit = faceDigit;
        this.value = value;
    }

    public String getFace() {
        return face;
    }
    public String getFaceDigit() { return faceDigit; }
    public int getValue() { return value; }

}
