package model;

import java.util.Random;

public class LogicManager {
    private int[][] game;
    private Figure figure;
    private Random random;
    private int step;

    public void newGame(){
        random = new Random();
        step =-1;
        game = new int[9][9];
        nextFigure();
    }

    public void addFigureInGameField(int x, int y) {
        try {
            int[][] _matrix = figure.getMatrix();
            int iLength = _matrix[0].length;
            int jLength = _matrix.length;
            if (canInsert(x,y,_matrix)){
                for (int i = 0; i < iLength; i++) {
                    for (int j = 0; j < jLength; j++) {
                        if(game[j+x][i+y] != 1){
                            game[j+x][i+y] = _matrix[j][i];
                        }
                    }
                }
                nextFigure();
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Недопустимый ход");
        }
    }

    private boolean canInsert(int i, int j, int[][] matrix){
        for (int k = 0; k < matrix[0].length; k++) {
            for (int l = 0; l < matrix.length; l++) {
                if (game[l+i][k+j] == 1 && matrix[l][k] == 1) return false;
            }
        }
        return true;
    }

    private void nextFigure() {
        step++;
        figure = Figure.getFigure(random.nextInt(0, Figure.values().length));
    }

    public int[][] getGame() {
        return game;
    }

    public Figure getFigure() {
        return figure;
    }

    public int getStep(){
        return step;
    }

    public void flush() {
        random = null;
        figure = null;
        game = null;
    }
}
