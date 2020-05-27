package com.tw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    private final BowlingGame bowlingGame = new BowlingGame();

    @Test
    public void shouldScore0GivenNoThrow() {
        int result = bowlingGame.getScore();
        assertEquals(0, result);
    }

    @Test
    public void shouldScorePinsKnockedDownGivenOneThrow() {
        bowlingGame.addThrow(5);
        int result = bowlingGame.getScore();
        assertEquals(5, result);
    }

    @Test
    public void shouldScoreTotalNumberOfPinsKnockedDownGivenTwoThrows() {
        bowlingGame.addThrow(5);
        bowlingGame.addThrow(4);
        int score = bowlingGame.getScore();
        assertEquals(9, score);
    }

    @Test
    public void shouldScoreTotalNumberOfPinsKnockedDownGivenTenFramesWithoutSpareOrStrike() {
        int i = 0;
        while (i < 10) {
            bowlingGame.addThrow(5);
            bowlingGame.addThrow(4);
            i++;
        }
        int score = bowlingGame.getScore();
        assertEquals(90, score);
    }

    @Test
    public void shouldScoreCorrectlyWhenOnlyFirstFrameIsSpare() {
        bowlingGame.addThrow(6);
        bowlingGame.addThrow(4);
        int i = 1;
        while (i < 10) {
            bowlingGame.addThrow(5);
            bowlingGame.addThrow(4);
            i++;
        }
        int score = bowlingGame.getScore();
        assertEquals(96, score);
    }

    @Test
    public void shouldScoreCorrectlyWhenFirstNineFramesAreSpare() {
        int i = 0;
        while (i < 9) {
            bowlingGame.addThrow(6);
            bowlingGame.addThrow(4);
            i++;
        }
        bowlingGame.addThrow(6);
        bowlingGame.addThrow(3);
        int score = bowlingGame.getScore();
        assertEquals(153, score);
    }

    @Test
    public void shouldScoreCorrectlyWhenLastFrameIsSpare() {
        int i = 0;
        while (i < 9) {
            bowlingGame.addThrow(6);
            bowlingGame.addThrow(3);
            i++;
        }
        bowlingGame.addThrow(6);
        bowlingGame.addThrow(4);
        bowlingGame.addThrow(6);
        int score = bowlingGame.getScore();
        assertEquals(97, score);
    }

    @Test
    public void shouldScoreCorrectlyWhenAllFramesAreSpare() {
        int i = 0;
        while (i < 10) {
            bowlingGame.addThrow(6);
            bowlingGame.addThrow(4);
            i++;
        }
        bowlingGame.addThrow(6);
        int score = bowlingGame.getScore();
        assertEquals(160, score);
    }

    @Test
    public void shouldScoreCorrectlyWhenFirstFrameIsStrike() {
        bowlingGame.addThrow(10);
        int i = 1;
        while (i < 10) {
            bowlingGame.addThrow(6);
            bowlingGame.addThrow(3);
            i++;
        }
        int score = bowlingGame.getScore();
        assertEquals(100, score);
    }

}
