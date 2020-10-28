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

                Coordinate position = new Coordinate(i, j);
                int r = position.getRow();
                int c = position.getColumn();

                gameWindow.getButtons()[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if (GameLogic.checkMovable(gameWindow.getButtons(), position)) {
                            gameWindow.getButtons()[r][c].setBackground(Color.cyan);
                            gameWindow.getButtons()[r][c].setOpaque(true);
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        if (GameLogic.isCorrect(gameWindow.getButtons(), position)){
                            gameWindow.getButtons()[r][c].setBackground(Color.orange);
                            gameWindow.getButtons()[r][c].setOpaque(true);
                        } else {
                            gameWindow.getButtons()[r][c].setBackground(new JButton().getBackground());
                            gameWindow.getButtons()[r][c].setOpaque(false);
                        }
                    }
                });
            }
        }
    }
}

