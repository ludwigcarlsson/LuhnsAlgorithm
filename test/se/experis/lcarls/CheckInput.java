package se.experis.lcarls;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckInput {

    @Test
    void checkInput1() {
        assertEquals("Valid", Main.checkInput("4242424242424242"));
    }

    @Test
    void checkInput2() {
        assertEquals(null, Main.checkInput("blabl123a"));
    }

}