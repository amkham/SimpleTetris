import service.GameService;
import model.GameLogic;
import view.Game;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        GameLogic gameLogic = new GameLogic();
        GameService gameService = new GameService(game, gameLogic);
        gameService.start();
    }
}
