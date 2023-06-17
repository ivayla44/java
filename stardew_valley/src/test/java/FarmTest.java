package test.java;

import main.java.Vector2;
import main.java.farm.Farm;
import main.java.farm.Tile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FarmTest {
    private Farm farm;
    private Tile tile;
    private Vector2 position;

    // marioooooo spi mi se ne mi se pishat testoveeee :(( to i teb sigurno ne ti se proverqvat, zashto trqbva da se muchim vzaimno
    @BeforeEach
    void setUp() {
        farm = new Farm();
        tile = new Tile();
        position = new Vector2();
    }

    @Test
    void getInvalidCell() throws Exception {
        position = new Vector2(11, 11);
        tile = farm.getCell(position);
        assertNull(tile);
    }

    @Test
    void getValidCell() throws Exception {
        position = new Vector2(3, 3);
        tile = farm.getCell(position);
        assertTrue(tile.isFree());
    }
}