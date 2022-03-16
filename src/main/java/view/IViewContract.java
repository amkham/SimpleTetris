package view;

import model.Figure;
import presenter.IMainViewPresenter;

public interface IViewContract {

    void updateFigure(Figure figure);
    void updateGameField(int[][] field);
    void updateGameStep(int step);
    void end(int steps);
    void setPresenter(IMainViewPresenter presenter);
}
