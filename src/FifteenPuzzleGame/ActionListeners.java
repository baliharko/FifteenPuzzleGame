package FifteenPuzzleGame;

import FifteenPuzzleGame.GameLogic.Coordinate;
import FifteenPuzzleGame.GameLogic.GameLogic;
import FifteenPuzzleGame.SwingGUI.GameWindow;

import javax.swing.*;

import static FifteenPuzzleGame.Constants.*;

/**
 * GameWindow.java <br>
 * baliharko <br>
 * 2020-10-26 <br>
 * 14:15
 */

public class ActionListeners {

    public ActionListeners(GameWindow gameWindow) {
        addActionListenersToArray(gameWindow);

        gameWindow.getQuit().addActionListener(l -> {
            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "Quit?", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION)
                System.exit(0);
        });

        gameWindow.getReset().addActionListener(l -> {
            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "Reset?", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                newGame(gameWindow);
            }
        });

        gameWindow.getWin().addActionListener(l -> {
            gameWindow.setButtons(GameLogic.createWinArray());
            gameWindow.updateGUI();
            addActionListenersToArray(gameWindow);
        });
    }

    public void newGame(GameWindow gameWindow) {
        gameWindow.setButtons(GameLogic.buttonGridFill());
        gameWindow.updateGUI();
        addActionListenersToArray(gameWindow);
    }

    // Adding actionListeners to every button in array
    private void addActionListenersToArray(GameWindow gameWindow) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                int r = i;
                int c = j;
                gameWindow.getButtons()[i][j].addActionListener(l -> {
                    if (GameLogic.checkMovable(gameWindow.getButtons(), new Coordinate(r, c))) {
                        gameWindow.setButtons(
                                GameLogic.move(gameWindow.getButtons(), new Coordinate(r, c)));
                        gameWindow.updateGUI();
                        if (GameLogic.checkWinCon(gameWindow.getButtons()))
                            if (JOptionPane.showConfirmDialog(null, "You won!!!\nPlay again?"
                                    ,"Win!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                newGame(gameWindow);
                            } else
                                System.exit(0);
                    }
                });
            }
        }
    }
}


