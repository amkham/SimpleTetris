package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    private GameLogic __gameLogic;
    private int __step;

    @BeforeEach
    void beforeAll() {
    __gameLogic = new GameLogic();
        __gameLogic.setListener(new GameLogic.ChangeListener() {
            @Override
            public void end(GameResult result) {
                assert (result.count() == __step && result.time() >=0);
            }

            @Override
            public void figureChanged(Figure figure) {

            }

            @Override
            public void gameFieldChanged(int[][] field) {

            }
        });
        __gameLogic.start();

    }

    @Test
    void start() {
        assertEquals(0, __gameLogic.getStep());
        assertEquals(0, __gameLogic.getTime());
        assertNotNull(__gameLogic.getFigure());
        assertNotNull(__gameLogic.getGameField());
    }

    @Test
    void end() {
        __gameLogic.setCount(10);
        __step = 10;
        __gameLogic.end();
    }

    @Test
    void getGameField() {
        assertNotNull(__gameLogic.getGameField());
    }

    @Test
    void getFigure() {
        Figure _figure = Figure.FIGURE2;
        __gameLogic.setFigure(_figure);
        assertEquals(_figure, __gameLogic.getFigure());
    }

    @Test
    void getStep() {
        __gameLogic.setCount(10);
        assertEquals(10, __gameLogic.getStep());
    }


    @Test
    void insert() {
        int[][] _matrix = __gameLogic.getGameField();
        int [][] _figure = __gameLogic.getFigure().getMatrix();
        __gameLogic.insert(3,3);
        for (int i = 0; i < _figure[0].length; i++) {
            for (int j = 0; j < _figure.length; j++) {
                assert _matrix[j+3][i+3] == _figure[j][i];
            }
        }
    }
}