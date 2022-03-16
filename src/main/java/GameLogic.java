import java.util.Random;

public class GameLogic {
    private final Random __random;
    private GameMainForm __form;

    private final int[][] __gameField = new int[9][9];

    private Figure __figure;

    public GameLogic(GameMainForm form) {
        __random = new Random();
        __form = form;
        start();
    }

    public void start(){
         nextStep();
    }

    public void insert(int x, int y) {

        int i = x/50 - 1;
        int j = y/50 - 1;

        int[][] _matrix = __figure.getMatrix();


        try{
            if (check(i,j,_matrix)){
                for (int k = 0; k < _matrix[0].length; k++) {
                    for (int l = 0; l < _matrix.length; l++) {
                        if ( __gameField[l+i][k+j] != 1)
                            __gameField[l+i][k+j] = _matrix[l][k];
                    }
                }
                nextStep();
            }
            else {
                updateView(__figure, __gameField);
            }
        }
        catch (Exception e)
        {
            updateView(__figure, __gameField);
        }

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
        __figure = Figure.getFigure(__random.nextInt(0, Figure.values().length));
        updateView(__figure, __gameField);
    }

    private void updateView(Figure figure, int[][] gameField)
    {
        __form.updateFigure(figure);
        __form.updateGameField(gameField);
    }
}
