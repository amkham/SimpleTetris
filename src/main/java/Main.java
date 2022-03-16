import controller.GameController;
import model.GameLogic;
import view.GameMainForm;

public class Main {

    public static void main(String[] args) {
        GameLogic _gameLogic = new GameLogic();
        GameController _gameController = new GameController(_gameLogic);
        new GameMainForm(_gameController, _gameLogic);
    }
}
