package com.codecool.nursery.children;

public abstract class Child {

    private final String NAME;
    protected int complacency = 2;
    private final int BALL_EFFECT;
    private final int DANCE_EFFECT;
    private final int SING_EFFECT;
    private final int DRAW_EFFECT;

    public Child(String name, int ballEffect, int danceEffect, int singEffect, int drawEffect) {
        this.NAME = name;
        BALL_EFFECT = ballEffect;
        DANCE_EFFECT = danceEffect;
        SING_EFFECT = singEffect;
        DRAW_EFFECT = drawEffect;
    }

    public void playBall() {
        complacency += BALL_EFFECT;
    }

    public void dance() {
        complacency += DANCE_EFFECT;
    }

    public void sing() {
        complacency += SING_EFFECT;
    }

    public void draw() {
        complacency += DRAW_EFFECT;
    }

    public boolean isWhimpering() {
        return complacency <= 0;
    }

    public int getComplacency() {
        return complacency;
    }

    @Override
    public String toString() {
        return NAME + " (" + this.getClass().getSimpleName() + ')';
    }

}
