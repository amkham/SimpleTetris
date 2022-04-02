/**
 * Вспомогательный класс для связывания интерфейса и логики
 */
public class GameService  {

    private  Game game;
    private  GameLogic gameLogic;

    /**
     * Конструктор
     * @param game Класс интерфейса
     * @param gameLogic Класс логики
     */
    public GameService(Game game, GameLogic gameLogic) {
        this.game = game;
        this.gameLogic = gameLogic;
        this.game.setGameService(this);
    }


    /**
     * Вставить фигуру по индексам х и у
     * @param w
     * @param h
     */
    public void insertFigure(int w, int h) {
        this.gameLogic.addFigureInGameField(w, h);
        this.game.updateFigure(gameLogic.getFigure());
        this.game.updateGameField(gameLogic.getGame());
        this.game.updateGameStep(gameLogic.getStep());

    }

    /**
     * Запустить игру
     */
    public void start() {
        this.gameLogic.newGame();
        this.game.updateFigure(gameLogic.getFigure());
        this.game.updateGameField(gameLogic.getGame());
        this.game.updateGameStep(gameLogic.getStep());
    }


    /**
     * Завершить игру
     */
    public void end() {
        this.game.end(gameLogic.getStep());
    }

}
