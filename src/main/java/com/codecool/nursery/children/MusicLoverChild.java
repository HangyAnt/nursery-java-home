package com.codecool.nursery.children;

public class MusicLoverChild extends Child {

    private static final int BALL_EFFECT = -1;
    private static final int DANCE_EFFECT = 0;
    private static final int SING_EFFECT = 4;
    private static final int DRAW_EFFECT = -1;

    public MusicLoverChild(String name) {
        super(name, BALL_EFFECT, DANCE_EFFECT, SING_EFFECT, DRAW_EFFECT);
    }

    @Override
    public void sing() {
        complacency = SING_EFFECT;
    }

}
