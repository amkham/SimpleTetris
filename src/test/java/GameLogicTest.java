import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    private GameLogic game;

    @BeforeEach
    void beforeAll() {
        game = new GameLogic();
        game.newGame();
    }




    @Test
    void newGame() {
        assertEquals(0, game.getStep());
        assertNotNull(game.getFigure());
        assertNotNull(game.getGame());
    }

    @Test
    void addFigureInGameField() {
        int[][] _matrix = game.getGame();
        int [][] _figure = game.getFigure().getShapeStructure();
        game.addFigureInGameField(5,5);
        for (int i = 0; i < _figure[0].length; i++) {
            for (int j = 0; j < _figure.length; j++) {
                assert _matrix[j+5][i+5] == _figure[j][i];
            }
        }
    }
    @Test
    void getStep() {
        game.addFigureInGameField(0,0);
        game.addFigureInGameField(0,4);
        game.addFigureInGameField(4,4);
        game.addFigureInGameField(3,2);
        assertEquals(4, game.getStep());
    }

}