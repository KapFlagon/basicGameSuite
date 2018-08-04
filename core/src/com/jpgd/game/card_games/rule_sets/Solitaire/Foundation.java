package com.jpgd.game.card_games.rule_sets.Solitaire;

import com.jpgd.game.card_games.card_basics.Card;

import java.util.ArrayList;
import java.util.Stack;

public class Foundation {

    // Stack or arraylist??????
    private Stack<Card> foundation;

    public Foundation() {
        foundation = new Stack<Card>();
    }

    public void addToFoundation(Card card) {
        // examine if card being added conforms to rules
            // 1. matches suit
            // 2. has greater face value than current top card


    }

    public void removeFromFoundation() {
        foundation.pop();
    }

    public Card peekFoundation() {
        return foundation.peek();
    }
}
