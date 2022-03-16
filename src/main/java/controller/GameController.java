package controller;

import model.GameLogic;

public class GameController {

    private GameLogic __gameLogic;

    public GameController(GameLogic gameLogic) {
        __gameLogic = gameLogic;
    }

    public void insertFigure(int x, int y){
     __gameLogic.insert(x,y);
    }

    public void startGame() {
        __gameLogic.start();
    }

    public void endGame(){
        __gameLogic.end();
    }
}
