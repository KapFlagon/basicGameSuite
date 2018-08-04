package com.jpgd.game.card_games.rule_sets.Solitaire;

import com.jpgd.game.card_games.rule_sets.Solitaire.SolitaireRules;

import java.util.ArrayList;

public class Klondike extends SolitaireRules {
    // Make either a class, an abstract class, or an interface for all solitaire games

    private ArrayList<Tableau> tableaus;
    private ArrayList<Foundation> foundations;

    public Klondike() {
        super(1);

        tableaus = new ArrayList<Tableau>();
        foundations = new ArrayList<Foundation>();
        generateTableaues();
        generateFoundations();
    }

    private void generateTableaues() {
        for (int i = 0; i < 7; i++) {
            tableaus.add(new Tableau());
        }
    }

    private void generateFoundations() {
        for (int i = 0; i < 4; i++) {
            foundations.add(new Foundation());
        }
    }
}
