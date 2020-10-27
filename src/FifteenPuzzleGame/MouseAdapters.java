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
                int finalI = i;
                int finalJ = j;
                gameWindow.getButtons()[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        super.mouseEntered(e);
                        if (GameLogic.checkMovable(gameWindow.getButtons(), new Coordinate(finalI, finalJ))) {
                            gameWindow.getButtons()[finalI][finalJ].setBackground(Color.cyan);
                            gameWindow.getButtons()[finalI][finalJ].setOpaque(true);
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        super.mouseExited(e);
                        gameWindow.getButtons()[finalI][finalJ].setBackground(new JButton().getBackground());
                        gameWindow.getButtons()[finalI][finalJ].setOpaque(false);
                    }
                });
            }
        }
    }
}

