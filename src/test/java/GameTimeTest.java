import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTimeTest {

    private static GameTime time;

    @BeforeAll
    static void beforeAll() {
       time = new GameTime();
        for (int i = 0; i < 100; i++) {
            time.tick();
        }
    }

    @Test
    void tick() {

        assertEquals(time.getSec(), 40);
        assertEquals(time.getMin(), 1);
    }

    @Test
    void getTime() {
        assertEquals("00:01:40", time.getTime());
    }
}