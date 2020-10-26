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

    public void init() {
        gameWindow = new GameWindow();
        this.addActionListenersToArray();
    }

    // Adding actionListeners to every button in array
    private void addActionListenersToArray() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                int r = i;
                int c = j;
                gameWindow.getButtons()[i][j].addActionListener(l -> {
                    if (GameLogic.checkMovable(gameWindow.getButtons(), new Coordinate(r, c))) {
                        gameWindow.setButtons(
                                GameLogic.move(gameWindow.getButtons(), new Coordinate(r, c)));
                        gameWindow.updateGUI();
                    }
                });
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.init();
    }
}
