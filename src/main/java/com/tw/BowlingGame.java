package com.tw;

public class BowlingGame {
    private int score = 0;
    public int getScore() {
        return score;
    }

    public void addThrow(int pins) {
        score += pins;
    }
}
