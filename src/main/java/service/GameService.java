package service;

import model.GameLogic;
import view.Game;

public record GameService(Game game, GameLogic gameLogic)  {

    public GameService(Game game, GameLogic gameLogic) {
        this.game = game;
        this.gameLogic = gameLogic;
        this.game.setGameService(this);
    }


    public void insertFigure(int w, int h) {
        gameLogic.addFigureInGameField(w, h);
        updateView();

    }

    public void start() {
        gameLogic.newGame();
        updateView();
    }


    public void end() {
        gameLogic.flush();
        game.end(gameLogic.getStep());
    }



    private void updateView() {
        game.updateFigure(gameLogic.getFigure());
        game.updateGameField(gameLogic.getGame());
        game.updateGameStep(gameLogic.getStep());
    }
}
