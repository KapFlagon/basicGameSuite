package com.jpgd.game.card_games.card_basics;

public enum Suits {
    CLUBS("Clubs"),
    DIAMONDS("Diamonds"),
    HEARTS("Hearts"),
    SPADES("Spades");

    private final String suit;

    Suits(String suitName) {
        this.suit = suitName;
    }

    public String getSuit() {
        return suit;
    }
}





