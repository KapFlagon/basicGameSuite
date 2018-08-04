package com.jpgd.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GSM {
    // Game State Manager Class

    private Stack<State> states;

    public GSM() {
        states = new Stack<State>();
    }

    public void push(State s) {
        states.push(s);
    }

    public void pop() {
        states.pop().dispose();
    }

    public void set(State s) {
        states.pop().dispose();
        states.push(s);
    }

    /*public void update (float dt) {
        states.peek().update(dt);
    }*/

    public void render(float dt) { states.peek().render(dt); }
}
