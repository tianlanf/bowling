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
}
