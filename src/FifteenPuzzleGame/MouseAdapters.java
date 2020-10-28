package FifteenPuzzleGame;

import FifteenPuzzleGame.GameLogic.Coordinate;
import FifteenPuzzleGame.GameLogic.GameLogic;
import FifteenPuzzleGame.SwingGUI.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static FifteenPuzzleGame.Constants.*;


/**
 * Created by Oscar Norman & Bali Harko <br>
 * Date: 2020-10-26   <br>
 * Time: 17:17   <br>
 * Project: GameWindow.java <br>
 */
public class MouseAdapters {

    public MouseAdapters(GameWindow gameWindow) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                int r = i;
                int c = j;
                gameWindow.getButtons()[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if (GameLogic.checkMovable(gameWindow.getButtons(), new Coordinate(r, c))) {
                            gameWindow.getButtons()[r][c].setBackground(Color.cyan);
                            gameWindow.getButtons()[r][c].setOpaque(true);
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        gameWindow.getButtons()[r][c].setOpaque(
                                GameLogic.highlightCorrectMove(gameWindow.getButtons(), r, c));

                        gameWindow.getButtons()[r][c].setBackground(
                                GameLogic.highlightCorrectMove(gameWindow.getButtons(), r, c) ? Color.orange
                                : new JButton().getBackground());
                    }
                });
            }
        }
    }
}

