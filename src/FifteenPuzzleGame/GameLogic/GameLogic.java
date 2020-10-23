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

    ArrayList<JButton> buttonGrid = new ArrayList<>();

    public void fillGrid() {
        boolean[] isUsed = new boolean[16];
        Random rand;

        for (int i = 0; i < 16; i++) {
            rand = new Random();
            int num = rand.nextInt(16);

            while (isUsed[num])
                num = rand.nextInt(16);

            this.buttonGrid.add(new JButton("" + (num + 1)));
            isUsed[num] = true;
        }
    }
}
