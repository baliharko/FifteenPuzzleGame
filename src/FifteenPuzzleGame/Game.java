package FifteenPuzzleGame;

import FifteenPuzzleGame.SwingGUI.GameWindow;

/**
 * FifteenPuzzleGame <br>
 * Oscar Norman & baliharko <br>
 * 2020-10-23 <br>
 * 15:43
 */

public class Game {

    GameWindow gameWindow;

    public void init() {
        gameWindow = new GameWindow();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.init();
    }
}
