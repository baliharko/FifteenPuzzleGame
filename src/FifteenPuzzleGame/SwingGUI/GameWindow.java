package FifteenPuzzleGame.SwingGUI;

import FifteenPuzzleGame.GameLogic.GameLogic;

import static FifteenPuzzleGame.Constants.*;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * FifteenPuzzleGame <br>
 * baliharko och Oscar Norman <br>
 * 2020-10-23 <br>
 * 12:20
 */

public class GameWindow extends JFrame {

    private JPanel mainPanel = new JPanel();
    private JButton[][] buttons;

    public GameWindow() {
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle(TITLE);

        buttons = GameLogic.buttonGridFill(ROWS, COLUMNS);

        mainPanel.setLayout(new GridLayout(ROWS, COLUMNS));

        for(int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++){
                JButton button1 = buttons[i][j];
                mainPanel.add(button1);
            }

        }


        this.add(mainPanel);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GameWindow w = new GameWindow();
    }
}
