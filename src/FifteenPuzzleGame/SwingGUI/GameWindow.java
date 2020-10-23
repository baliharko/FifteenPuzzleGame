package FifteenPuzzleGame.SwingGUI;

import static FifteenPuzzleGame.Constants.*;

import javax.swing.*;
import java.awt.*;

/**
 * FifteenPuzzleGame <br>
 * baliharko och Oscar Norman <br>
 * 2020-10-23 <br>
 * 12:20
 */

public class GameWindow extends JFrame {

    private JPanel mainPanel = new JPanel();
    private JButton[] buttons;

    public GameWindow() {
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle(TITLE);

        buttons = new JButton[ROWS * COLUMNS];

        mainPanel.setLayout(new GridLayout(ROWS, COLUMNS));

        // Temporary
        int i = 1;
        for (JButton b : buttons) {

            JButton temp = new JButton("" + i++);

            mainPanel.add(temp);
        }

        this.add(mainPanel);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        GameWindow w = new GameWindow();
    }
}
