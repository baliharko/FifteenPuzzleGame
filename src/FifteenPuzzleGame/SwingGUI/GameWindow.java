package FifteenPuzzleGame.SwingGUI;

import FifteenPuzzleGame.GameLogic.GameLogic;

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

    private JPanel mainPanel;
    private GridLayout layout;
    private JButton[][] buttons;

    public GameWindow() {

        this.mainPanel = new JPanel();
        this.layout = new GridLayout(ROWS, COLUMNS);

        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle(TITLE);
        
        buttons = GameLogic.buttonGridFill(ROWS, COLUMNS);

        layout.setHgap(5);
        layout.setVgap(5);
        mainPanel.setLayout(layout);
        mainPanel.setBackground(Color.gray);

        this.updateGUI();

        this.add(mainPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

//     TODO
//    this.buttons = GameLogic.move(this.buttons);

    public void updateGUI() {
        for(int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++){
                JButton button1 = buttons[i][j];
                mainPanel.add(button1);
            }
        }
    }
}
