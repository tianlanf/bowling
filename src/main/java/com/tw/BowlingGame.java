package com.tw;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private int singleFrameScore;
    private List<Integer> frameScore = new ArrayList<>();
    private boolean firstThrow = true;
    private boolean isSpare = false;

    public int getScore() {
        int total = frameScore.stream().mapToInt(Integer::intValue).sum();
        if (!firstThrow) {
            total += singleFrameScore;
        }
        return total;
    }

    public void addThrow(int pins) {
        if (firstThrow) {
            singleFrameScore = 0;
        }
        addSpareBonus(pins);
        singleFrameScore += pins;
        if (!firstThrow) {
            isSpare = singleFrameScore == 10;
            frameScore.add(singleFrameScore);
        }
        firstThrow = !firstThrow;
    }

    private void addSpareBonus(int pins) {
        if (isSpare) {
            Integer lastFrameScore = frameScore.get(frameScore.size() - 1);
            lastFrameScore += pins;
            frameScore.remove(frameScore.size() - 1);
            frameScore.add(lastFrameScore);
            isSpare = false;
        }
    }
}
