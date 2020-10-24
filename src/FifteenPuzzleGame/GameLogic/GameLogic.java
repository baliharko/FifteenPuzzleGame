package FifteenPuzzleGame.GameLogic;

import javax.swing.*;
import java.util.Random;

import static FifteenPuzzleGame.Constants.*;

/**
 * Created by Oscar Norman & Bali Harko <br>
 * Date: 2020-10-23   <br>
 * Time: 12:02   <br>
 * Project: GameWindow.java <br>
 */

public class GameLogic {
    public static boolean checkWinCon(JButton[][] buttons) {
        // TODO for loop check neighbor is +1
        return false;
    }

    public static boolean checkMovable(JButton[][] buttons, Coordinate position) {
        return buttons[position.getnNorth().getRow()][position.getnNorth().getColumn()].getText().equals(EMPTY_BUTTON_TEXT)
                || buttons[position.getnEast().getRow()][position.getnEast().getColumn()].getText().equals(EMPTY_BUTTON_TEXT)
                || buttons[position.getnSouth().getRow()][position.getnSouth().getColumn()].getText().equals(EMPTY_BUTTON_TEXT)
                || buttons[position.getnWest().getRow()][position.getnWest().getColumn()].getText().equals(EMPTY_BUTTON_TEXT);
    }

    public static JButton[][] move(JButton[][] buttons, Coordinate position) {
        // TODO switch places with empty button if checkMovable == true
        return null;
    }

    public static JButton[][] buttonGridFill(int rows, int columns) {
        boolean[] isUsed = new boolean[ROWS * COLUMNS];
        JButton[][] out = new JButton[ROWS][COLUMNS];
        Random rand = new Random();
        int num;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                num = rand.nextInt(ROWS * COLUMNS);

                while (isUsed[num]) {
                    num = rand.nextInt(ROWS * COLUMNS);
                }
                isUsed[num] = true;

                if (num + 1 == ROWS * COLUMNS) {
                    JButton noButton = new JButton(EMPTY_BUTTON_TEXT);
                    noButton.setVisible(false);
                    out[i][j] = noButton;
                    continue;
                }
                out[i][j] = new JButton("" + (num + 1));
            }
        }
        return out;
        }
    }

