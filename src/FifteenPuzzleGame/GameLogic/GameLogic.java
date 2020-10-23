package FifteenPuzzleGame.GameLogic;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Oscar Norman & Bali Harko <br>
 * Date: 2020-10-23   <br>
 * Time: 12:02   <br>
 * Project: GameWindow.java <br>
 */
public class GameLogic {


    public static JButton[][] buttonGridFill(int rows, int collums) {
        boolean[] isUsed = new boolean[16];
        JButton[][] out = new JButton[4][4];
        Random rand = new Random();
        int num = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < collums; j++) {

                num = rand.nextInt(16);

                while (isUsed[num]) {
                    num = rand.nextInt(16);
                }
                isUsed[num] = true;

                if (num +1 == 16) {
                    JButton noButton = new JButton(" ");
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

