package FifteenPuzzleGame;

import FifteenPuzzleGame.GameLogic.Coordinate;
import FifteenPuzzleGame.GameLogic.GameLogic;
import FifteenPuzzleGame.SwingGUI.GameWindow;

import javax.swing.*;

import static FifteenPuzzleGame.Constants.COLUMNS;
import static FifteenPuzzleGame.Constants.ROWS;

/**
 * GameWindow.java <br>
 * baliharko <br>
 * 2020-10-26 <br>
 * 14:15
 */

public class ActionListeners {

    GameWindow gameWindow;

    public ActionListeners(GameWindow gameWindow) {
        this.addActionListenersToArray(gameWindow);

        gameWindow.getQuit().addActionListener(l -> {
            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "Quit?", JOptionPane.YES_NO_OPTION)
             == JOptionPane.YES_OPTION)
                System.exit(0);
        });

        gameWindow.getReset().addActionListener(l -> {
            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "Reset?", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                gameWindow.setButtons(GameLogic.buttonGridFill(ROWS, COLUMNS));
//                    gameWindow.updateGUI();
            }
        });
    }

    // Adding actionListeners to every button in array
    private void addActionListenersToArray(GameWindow gameWindow) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                int r = i;
                int c = j;
                gameWindow.getButtons()[i][j].addActionListener(l -> {
                    if (GameLogic.checkMovable(gameWindow.getButtons(), new Coordinate(r, c))) {
                        System.out.println("Movable!");
                        // TODO call GameLogic.move()
                        // TODO call gameWindow.update()
                    }
                });
            }
        }
    }

}
