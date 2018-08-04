package com.jpgd.game.card_games.rule_sets;

import com.jpgd.game.card_games.card_basics.Card;
import com.jpgd.game.card_games.card_basics.DeckManager;
import com.jpgd.game.card_games.card_basics.Player;

import java.util.ArrayList;

public abstract class CardGames extends RuleSet{

    /*
    Variables
     */
    private DeckManager deckManager;
    private ArrayList<Player> players;

    private int cardsPerPlayer;
    private boolean dealWholeDeck;

    /*
    Constructors
     */
    public CardGames(int amountOfDecks, int minNumOfPlayers, int maxNumOfPlayers, boolean dealWholeDeck, int cardsPerPlayer) {
        deckManager = new DeckManager(amountOfDecks);
        createPlayerList(minNumOfPlayers, maxNumOfPlayers);

        this.dealWholeDeck = dealWholeDeck;
        this.cardsPerPlayer = cardsPerPlayer;
    }

    /*.
    Getters
     */

    public ArrayList<Player> getPlayers() {
        return players;
    }
    public DeckManager getDeckManager() {
        return deckManager;
    }

    /*
    Other methods
     */
    protected void createPlayerList(int minNumOfPlayers, int maxNumOfPlayers) {
        players = new ArrayList<Player>();
        for (int i = 0; ((i < minNumOfPlayers) && (i < maxNumOfPlayers)); i++) {
            players.add(new Player("Player " + Integer.toString(i+1)));
        }
    }

    protected void dealCardsToPlayers() {
        /*
        each player is dealt a single card until either
          a) all players have minimum number of cards
          b) all cards have been dealt out of deck
         */
        if (dealWholeDeck == true) {
            for (Card card: deckManager.getDeck()) {
                for (Player player : players) {
                    player.addCardToHand(deckManager.dealCard());
                }
            }
        } else {
            for (int i = 0; i < cardsPerPlayer; i++) {
                for (Player player : players) {
                    player.addCardToHand(deckManager.dealCard());
                }
            }
        }

    }

}
