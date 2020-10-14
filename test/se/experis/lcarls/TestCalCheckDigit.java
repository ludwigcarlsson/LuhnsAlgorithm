package se.experis.lcarls;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestCalCheckDigit {

    @Test
    void calCheckValidDigit() {
        assertEquals("2Valid", Main.calCheckDigit("424242424242424", '2'));

    }

    @Test
    void calCheckInvalidDigit() {
        assertNotEquals("2Valid", Main.calCheckDigit("424242424242424", '0'));
    }
}