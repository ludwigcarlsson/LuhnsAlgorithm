package se.experis.lcarls;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestInputLength {

    @Test
    void checkIfCreditCard() {
        assertEquals("(credit card)", Main.checkCreditCard(16));
    }

    @Test
    void checkIfNotCreditCard() {
        assertEquals("", Main.checkCreditCard(10));
    }
}