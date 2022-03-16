import model.Figure;
import model.GameLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    private GameLogic __gameLogic;

    @BeforeEach
    void setUp() {

        __gameLogic = new GameLogic();
        __gameLogic.start();
    }

    @Test
    void start() {

        assertEquals(0, __gameLogic.getStep());

    }



    @Test
    void getGameField() {
        assertNotNull(__gameLogic.getGameField());
    }

    @Test
    void getFigure() {
        assertNotNull(__gameLogic.getFigure());
    }

    @Test
    void insert() {
        Figure _figure = __gameLogic.getFigure();
        int [][] _matrix = _figure.getMatrix();
        __gameLogic.insert(3,6);
        int [][] _gameField = __gameLogic.getGameField();

        for (int k = 0; k < _matrix[0].length; k++) {
            for (int l = 0; l < _matrix.length; l++) {
                assert _gameField[l+3][k+6]  == _matrix[l][k];
            }
        }

    }

    @Test
    void end() {


    }
}