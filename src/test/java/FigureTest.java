import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigureTest {

    private int[][] __matrix = {
            {1,0},
            {1,0},
            {1,1}
    };

    private int[][] __matrix45 = {
            {1,1,1},
            {1,0,0}
    };

    @BeforeEach
    void setUp() {

    }

    @Test
    void lengthTest() {
       // assertEquals(2, __matrix.length);
    }

}