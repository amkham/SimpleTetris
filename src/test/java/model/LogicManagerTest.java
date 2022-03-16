package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicManagerTest {

    private LogicManager logicManager;

    @BeforeEach
    void beforeAll() {
        logicManager = new LogicManager();
        logicManager.newGame();
    }


    @Test
    void getStep() {
        logicManager.addFigureInGameField(0,0);
        logicManager.addFigureInGameField(0,4);
        logicManager.addFigureInGameField(4,4);
        assertEquals(3, logicManager.getStep());
    }

    @Test
    void newGame() {
        assertEquals(0, logicManager.getStep());
        assertNotNull(logicManager.getFigure());
        assertNotNull(logicManager.getGame());
    }

    @Test
    void addFigureInGameField() {
        int[][] _matrix = logicManager.getGame();
        int [][] _figure = logicManager.getFigure().getMatrix();
        logicManager.addFigureInGameField(3,3);
        for (int i = 0; i < _figure[0].length; i++) {
            for (int j = 0; j < _figure.length; j++) {
                assert _matrix[j+3][i+3] == _figure[j][i];
            }
        }
    }

    @Test
    void end() {
        logicManager.flush();
        assertNull(logicManager.getGame());
        assertNull(logicManager.getFigure());
    }
}