package com.jpgd.game.card_games.card_basics;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DeckManager {

    private ArrayList<Card> deck, discards;
    private Random random;
    private TextureAtlas atlas;

    /*
    Constructors
     */
    // Generate at least 1 deck
    public DeckManager() {
        // instantiate the arraylists
        deck = new ArrayList<Card>();
        discards = new ArrayList<Card>();
        atlas = new TextureAtlas("CardStyle_01.atlas");

        generateDeck(1);
        shuffleDeck_Slow();

    }

    // Generate the passed amount of decks
    public DeckManager(int amountOfDecks) {
        // instantiate the arraylists
        deck = new ArrayList<Card>();
        discards = new ArrayList<Card>();
        atlas = new TextureAtlas("CardStyle_01.pack");

        generateDeck(amountOfDecks);
        shuffleDeck_Slow();
    }

    // Generate the passed amount of decks, using a different TextureAtlas
    public DeckManager(int amountOfDecks, String otherAtlasPackFile) {
        // instantiate the arraylists
        deck = new ArrayList<Card>();
        discards = new ArrayList<Card>();
        atlas = new TextureAtlas(otherAtlasPackFile);

        generateDeck(amountOfDecks);
        shuffleDeck_Slow();
    }


    /*
    Getters
     */
    public ArrayList<Card> getDeck() {
        return this.deck;
    }
    public ArrayList<Card> getDiscards() {
        return this.discards;
    }

    public TextureAtlas getAtlas() {
        return atlas;
    }

    /*
        Other methods
         */
    // Generate amount of decks based on passed parameters
    private void generateDeck(int amountOfDecks) {
        /*
        This will always generate multiples of 52 cards
         */
        // for loop to iterate through enum for Suits
        for(Suits suits : Suits.values()) {
            // for loop to iterate through enum for Faces
            for (Faces faces : Faces.values()) {
                for (int i = 0; i < amountOfDecks; i++) {
                    // Add new Card to the deck
                    deck.add(new Card(suits.getSuit(), faces.getFace(), faces.getFaceDigit(), faces.getValue(), this.atlas));
                    // If the total deck contains multiples of 52, card is entered "amountOfDecks" times
                }
            }
        }
    }

    // Print all cards in deck for debugging
    public void printCardsInDeck() {
        for (Card card : deck) {
            card.printCard();
        }
    }

    // Shuffle the deck, using the random util
    public void shuffleDeck_Slow() {
        if (deck.size() > 1) {
            for (int i = 0; i < 7; i++) {
                random = new Random();
                Collections.shuffle(deck, random);
            }
        } else {
            // Do nothing, a single card cannot be shuffled
        }
    }
    public void shuffleDeck_Quick() {
        if (deck.size() > 1) {
            for (int i = 0; i < 4; i++) {
                random = new Random();
                Collections.shuffle(deck, random);
            }
        } else {
            // Do nothing, a single card cannot be shuffled
        }
    }
    public void shuffleDeck_Quickest() {
        if (deck.size() > 1) {
            random = new Random();
            Collections.shuffle(deck, random);
        } else {
            // Do nothing, a single card cannot be shuffled
        }
    }

    // Deal card from top of the decks
    public Card dealCard() {
        Card tempCard = deck.get(0);
        deck.remove(0);
        return tempCard;
    }

    public void addCardToDeck(Card cardToAdd) {
        if (deck.size() < 52) {
            deck.add(cardToAdd);
            this.shuffleDeck_Quickest();
        }
    }

    public void addCardToDiscards(Card cardToAdd) {
        discards.add(cardToAdd);
    }

    // Put all cards in discardedCards back into decksOfCards
    public void refillDeck() {
        for (Card card : discards) {
            deck.add(card);
            discards.remove(card);
        }
    }

    public void dispose() {
        for(Card card : deck) {
            card.dispose();
        }
        for (Card card : discards) {
            card.dispose();
        }
        atlas.dispose();
    }
}
