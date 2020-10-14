package se.experis.lcarls;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class checkCalculation {

    @Test
    void checkPositive() {
        assertTrue(Main.calculateDigits("4242424242424242") > 0);
    }

    @Test
    void checkNegative() {
        assertFalse(Main.calculateDigits("0000000000000000") > 0);
    }
}