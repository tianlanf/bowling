package com.tw;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    private int singleFrameScore;
    private List<Integer> frameScore = new ArrayList<>();
    private boolean firstThrow = true;
    private boolean lastFrameIsSpare = false;
    private boolean lastFrameIsStrike = false;
    private int strikeBonusIndex = 0;

    public int getScore() {
        int total = frameScore.stream().mapToInt(Integer::intValue).sum();
        if (!firstThrow && frameScore.size() < 10) {
            total += singleFrameScore;
        }
        return total;
    }

    public void addThrow(int pins) {
        if (firstThrow) {
            singleFrameScore = 0;
        }
        addSpareBonus(pins);
        addStrikeBonus(pins);
        singleFrameScore += pins;
        if (isStrike()) {
            frameScore.add(singleFrameScore);
            lastFrameIsStrike = true;
            return;
        }
        if (!firstThrow) {
            lastFrameIsSpare = singleFrameScore == 10;
            frameScore.add(singleFrameScore);
        }
        firstThrow = !firstThrow;
    }

    private boolean isStrike() {
        return firstThrow && singleFrameScore == 10;
    }

    private void addSpareBonus(int pins) {
        if (lastFrameIsSpare) {
            Integer lastFrameScore = frameScore.get(frameScore.size() - 1);
            lastFrameScore += pins;
            frameScore.remove(frameScore.size() - 1);
            frameScore.add(lastFrameScore);
            lastFrameIsSpare = false;
        }
    }

    private void addStrikeBonus(int pins) {
        if (lastFrameIsStrike && strikeBonusIndex < 2) {
            Integer lastFrameScore = frameScore.get(frameScore.size() - 1);
            lastFrameScore += pins;
            frameScore.remove(frameScore.size() - 1);
            frameScore.add(lastFrameScore);
            strikeBonusIndex++;
        }
        if (strikeBonusIndex > 1) {
            strikeBonusIndex = 0;
            lastFrameIsStrike = false;
        }
    }
}
