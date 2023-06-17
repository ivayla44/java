package test.java;

import main.java.Vector2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static main.java.Vector2.left;
import static org.junit.jupiter.api.Assertions.*;

class Vector2Test {
    private Vector2 vector2;

    @BeforeEach
    void setUp() {
        vector2 = new Vector2(2, 2);
    }

    @Test
    void addDirection() {
        vector2.addDirection(left);
        assertEquals(vector2, new Vector2(1, 2));
    }

    @Test
    void add() {
        boolean res = vector2.add(10);
        assertFalse(res);
    }

    @Test
    void remove() {
        boolean res = vector2.remove(vector2.get(0));
        assertFalse(res);
    }

    @AfterEach
    void tearDown() {
        vector2 = null;
    }
}