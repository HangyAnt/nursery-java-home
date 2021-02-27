package com.codecool.nursery.children;

public class ConvenientChild extends Child {

    private static final int BALL_EFFECT = -2;
    private static final int DANCE_EFFECT = -1;
    private static final int SING_EFFECT = 0;
    private static final int DRAW_EFFECT = 4;

    public ConvenientChild(String name) {
        super(name, BALL_EFFECT, DANCE_EFFECT, SING_EFFECT, DRAW_EFFECT);
    }

    @Override
    public void draw() {
        complacency = DRAW_EFFECT;
    }

}
