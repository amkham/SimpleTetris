import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class GameLogic {

    /**
     * Массив содержащий поле игры
     */
    private int[][] game;


    /**
     * Сгенерированная фигура
     */
    private Shape shape;

    /**
     * Класс для получения рандомных чисел
     */
    private Random random;


    /**
     * Ход игры
     */
    private int step;


    /**
     * Начать игру
     */
    public void newGame(){
        random = new Random();
        step =-1;
        game = new int[9][9];
        nextGameStep();
    }


    /**
     * Функция для вставки фигуры в массив @game
     * @param x Индекс верхнего левого угла фигуры
     * @param y Индекс верхнего левого угла фигуры
     */
    public void addFigureInGameField(int x, int y) {
        try {
            int[][] _matrix = shape.getShapeStructure();
            int iLength = _matrix[0].length;
            int jLength = _matrix.length;
            if (checkStepValid(x,y,_matrix))
            {
                for (int i = 0; i < iLength; i++)
                {
                    for (int j = 0; j < jLength; j++)
                    {
                        if(game[j+x][i+y] != 1)
                        {
                            game[j+x][i+y] = _matrix[j][i];
                        }
                    }
                }
                nextGameStep();
            }
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error!!!");
        }
    }


    /**
     * Проверяет возможность втавки фигуры
     * @param i x Индекс верхнего левого угла фигуры
     * @param j x Индекс верхнего левого угла фигуры
     * @param matrix Матрица структуры фигуры
     * @return Возвращает логическое значение
     */
    @Contract(pure = true)
    private boolean checkStepValid(int i, int j, int[] @NotNull [] matrix)
    {
        int k = 0;
        int l = 0;
        while (k < matrix[0].length){
            while (l < matrix.length){
                if (game[l+i][k+j] == 1 && matrix[l][k] == 1) return false;
                l++;
            }

            k++;
        }

        return true;
    }

    /**
     * Следующий ход игры. Генерирует новую фигуру и увеличивает счетчик игры на 1
     */
    private void nextGameStep()
    {

        step++;
        shape = Shape.getFigure(random.nextInt(0, Shape.values().length));
    }

    /**
     * Getter
     * @return Возвращает массив хранящий положение фигур в игре
     */
    public int[][] getGame()
    {
        return game;
    }

    /**
     * Getter
     * @return Возвращает текущую фигуру
     */
    public Shape getFigure()
    {
        return shape;
    }


    /**
     * Getter
     * @return Возвращает ход игры
     */
    public int getStep()
    {
        return step;
    }

}
