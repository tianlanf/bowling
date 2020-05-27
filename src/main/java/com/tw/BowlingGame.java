package com.tw;

import java.util.Arrays;

public class BowlingGame {
    private static final int TEN_TURNS = 10;
    private static final int TEN_PINS = 10;

    private int[] pinsOfThrows = new int[21];
    private int currentThrow = 0;
    private int[] scoresOfFrame = new int[10];

    int getScore() {
        return Arrays.stream(scoresOfFrame).sum();
    }

    void addThrow(int pins) {
        int ball = 0;
        pinsOfThrows[currentThrow++] = pins;

        for (int frameId = 0; frameId < TEN_TURNS; frameId++) {
            if (isStrike(ball)) {
                scoresOfFrame[frameId] = TEN_PINS + spikeBonus(ball);
                ball += 1;
            }
            else if (isSpare(ball)) {
                scoresOfFrame[frameId] = TEN_PINS + spareBonus(ball);
                ball += 2;
            } else {
                scoresOfFrame[frameId] = pinsOfThrows[ball] + pinsOfThrows[ball + 1];
                ball += 2;
            }
        }
    }

    private int spikeBonus(int ball) {
        return pinsOfThrows[ball + 1] + pinsOfThrows[ball + 2];
    }

    private boolean isStrike(int ball) {
        return pinsOfThrows[ball] == TEN_PINS;
    }

    private int spareBonus(int ball) {
        return pinsOfThrows[ball + 2];
    }

    private boolean isSpare(int ball) {
        return pinsOfThrows[ball] + pinsOfThrows[ball + 1] == TEN_PINS;
    }
}
