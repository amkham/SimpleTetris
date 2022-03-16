package model;

import java.util.Random;
public class GameLogic {

    public interface ChangeListener{
        void end(GameResult result);
        void figureChanged(Figure figure);
        void gameFieldChanged(int[][] field);
    }

    private ChangeListener __listener;

    private Random __random;
    private int __count;
    private int[][] __gameField;
    private Figure __figure;
    private AppTimer __timer;

    public void start(){
        initGameParam();
        nextStep();
        updateView();
    }

    public void end(){

        __listener.end(new GameResult(__timer.end(), __count));
    }

    public void setListener(ChangeListener listener) {
        __listener = listener;
    }

    public int[][] getGameField() {
        return __gameField;
    }

    public Figure getFigure() {
        return __figure;
    }

    public int getStep(){
        return __count;
    }

    public int getTime(){
        return __timer.getTime();
    }

    protected void setCount(int count) {
        __count = count;
    }

    protected void setFigure(Figure figure) {
        __figure = figure;
    }

    public void insert(int i, int j) {
        try {
            int[][] _matrix = __figure.getMatrix();
            if (check(i,j,_matrix)){
                for (int k = 0; k < _matrix[0].length; k++) {
                    for (int l = 0; l < _matrix.length; l++) {
                        if ( __gameField[l+i][k+j] != 1)
                            __gameField[l+i][k+j] = _matrix[l][k];
                    }
                }
                nextStep();
                updateView();
            }
        }
        catch (ArrayIndexOutOfBoundsException _ignored) {
            updateView();
            System.out.println("non");
        }

    }

    private void initGameParam(){
        __count =-1;
        __gameField = new int[9][9];
        __random = new Random();
        __timer = new AppTimer();
        __timer.go();
    }

    private boolean check(int i, int j, int[][] matrix){
        for (int k = 0; k < matrix[0].length; k++) {
            for (int l = 0; l < matrix.length; l++) {
                if (__gameField[l+i][k+j] == 1 && matrix[l][k] == 1) return false;
            }
        }
        return true;
    }

    private void nextStep() {
        __count++;
        __figure = Figure.getFigure(__random.nextInt(0, Figure.values().length));
    }

    private void updateView() {
        __listener.figureChanged(__figure);
        __listener.gameFieldChanged(__gameField);
    }

}
