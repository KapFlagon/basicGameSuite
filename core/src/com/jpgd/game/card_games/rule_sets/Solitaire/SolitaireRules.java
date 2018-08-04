package com.jpgd.game.card_games.rule_sets.Solitaire;

import com.jpgd.game.card_games.card_basics.Card;
import com.jpgd.game.card_games.rule_sets.CardGames;

import java.util.ArrayList;

public abstract class SolitaireRules extends CardGames {

    protected ArrayList<Card> stock, waste;

    public SolitaireRules(int numOfDecks) {
        super(numOfDecks, 1, 1, false, 0);

        this.stock = new ArrayList<Card>();
        this.waste = new ArrayList<Card>();

    }

    public void addToStock(ArrayList<Card> cards) {
        for(Card card : cards) {
            stock.add(card);
        }
    }

    public void addToWaste(ArrayList<Card> cards) {
        for (Card card : cards) {
            waste.add(card);
        }
    }

    // Move a max of 3 cards to the Waste pile
    public void stockToWaste() {
        // Check if there are at least 3 cards in the stock
        if (stock.size() >= 3) {
            for(int i = 0; i < 3; i++) {    // loop 3 times
                waste.add(stock.get(i));    // and add to waste
                stock.remove(i);            // remove from stock
            }
        } else {
            for (Card card : stock) {       // loop through remaining cards in stock
                waste.add(card);            // add to waste
                stock.remove(card);         // remove from stock
            }
        }
    }
}
