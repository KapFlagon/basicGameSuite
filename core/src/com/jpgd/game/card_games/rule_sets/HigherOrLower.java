package com.jpgd.game.card_games.rule_sets;

import com.jpgd.game.card_games.card_basics.Card;

public class HigherOrLower extends CardGames {

    /*
    Variables
     */
    private Card lastCard, currentCard;
    private int score;

    /*
    Constructor
     */
    public HigherOrLower() {
        super(1, 1, 1, false, 0);
        //dealCardsToPlayers();
    }

    /*
    Getters
     */
    public Card getLastCard() {
        return lastCard;
    }
    public Card getCurrentCard() {
        return currentCard;
    }
    public int getScore() {
        return score;
    }

    /*
    Setters
     */
    public void setLastCard(Card passedCard) {
        this.lastCard = passedCard;
    }
    public void setCurrentsCard(Card passedCard) {
        this.currentCard = passedCard;
    }
    public void setScore(int passedScore) {
        this.score = passedScore;
    }


    //Other methods

    @Override
    public void dealCardsToPlayers() {
        if (getDeckManager().getDeck().size() <= 51) {     // if currentCard is an object already, move it to last card
            lastCard = currentCard;
            currentCard = getDeckManager().dealCard();
            System.out.println("here 51 or less");
        }
        if (getDeckManager().getDeck().size() == 52) {         // if last card is not already created
            currentCard = getDeckManager().dealCard();
            System.out.println("here 52");
        }
        if (getDeckManager().getDeck().size() == 0) {
            System.out.println("End of Deck");
        }
    }

    public Boolean compareCards(String guessedValue) {
        Boolean correctGuess;
        String checkValue = "";
        if (currentCard.getValue() > lastCard.getValue()) {
            checkValue = "higher";
        }
        if (currentCard.getValue() <= lastCard.getValue()) {
            checkValue = "lower";
        }

        if (checkValue == guessedValue) {
            correctGuess = true;
        } else {
            correctGuess = false;
        }
        return correctGuess;
    }

}
