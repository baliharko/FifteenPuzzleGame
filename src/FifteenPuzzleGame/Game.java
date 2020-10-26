package FifteenPuzzleGame;

import FifteenPuzzleGame.GameLogic.Coordinate;
import FifteenPuzzleGame.GameLogic.GameLogic;
import FifteenPuzzleGame.SwingGUI.GameWindow;

import static FifteenPuzzleGame.Constants.*;

/**
 * FifteenPuzzleGame <br>
 * Created by Oscar Norman & Bali Harko <br>
 * 2020-10-23 <br>
 * 15:43
 */

public class Game {

    GameWindow gameWindow;
    ActionListeners listeners;

    public void init() {
        gameWindow = new GameWindow();
        listeners = new ActionListeners(gameWindow);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.init();
    }
}
