package se.experis.lcarls;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckValid {

    @Test
    void isValid() {
        assertEquals("Valid", Main.checkLuhn(10));
    }

    @Test
    void isNotValid() {
        assertEquals("Invalid", Main.checkLuhn(12));
    }
}