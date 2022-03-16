package presenter;

import model.LogicManager;
import view.IViewContract;

public record MainViewPresenter(IViewContract viewContract,
                                LogicManager logicManager) implements IMainViewPresenter {

    public MainViewPresenter(IViewContract viewContract, LogicManager logicManager) {
        this.viewContract = viewContract;
        this.logicManager = logicManager;
        this.viewContract.setPresenter(this);
    }

    @Override
    public void startGame() {
        logicManager.newGame();
        updateView();
    }

    @Override
    public void endGame() {
        logicManager.flush();
        viewContract.end(logicManager.getStep());
    }

    @Override
    public void setFigure(int x, int y) {
        logicManager.addFigureInGameField(x, y);
        updateView();

    }

    private void updateView() {
        viewContract.updateFigure(logicManager.getFigure());
        viewContract.updateGameField(logicManager.getGame());
        viewContract.updateGameStep(logicManager.getStep());
    }
}
