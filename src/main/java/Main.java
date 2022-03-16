import presenter.MainViewPresenter;
import model.LogicManager;
import view.Game;

public class Main {

    public static void main(String[] args) {
        new MainViewPresenter(new Game(), new LogicManager()).startGame();
    }
}
