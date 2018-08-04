package com.jpgd.game.card_games.card_basics;

import java.util.ArrayList;

public class Player {
    /*
    Variables
     */
    ArrayList<Card> playerHand;
    String playerName;

    /*
    Constructors
     */
    public Player() {
        playerHand = new ArrayList<Card>();
        playerName = "New Player";
    }

    public Player(String playerNameInput) {
        playerHand = new ArrayList<Card>();
        this.playerName = playerNameInput;
    }

    /*
    Setters
     */
    public void setPlayerName(String playerNameInput) {
        this.playerName = playerNameInput;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    /*
    Getters
     */
    public String getPlayerName() {
        return playerName;
    }

    /*
    Other methods
     */
    public void addCardToHand(Card cardToAdd) {
        playerHand.add(cardToAdd);
    }

    public Card discardCard(Card cardToDiscard) {
        Card tempCard = cardToDiscard;
        playerHand.remove(cardToDiscard);
        return tempCard;
    }

    public void discardHand() {
        for (Card card : playerHand) {
            playerHand.remove(card);
        }
    }

    public void printHand() {
        for (Card card : playerHand) {
            card.printCard();
        }
    }

    public void printPlayer() {
        System.out.println("\nPlayer name: " + getPlayerName() + "\nPlayer Hand: \n");
        printHand();
    }
}
