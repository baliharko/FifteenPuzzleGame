package FifteenPuzzleGame.SwingGUI;

import FifteenPuzzleGame.GameLogic.GameLogic;
import FifteenPuzzleGame.*;

import javax.swing.*;
import java.awt.*;

import static FifteenPuzzleGame.Constants.*;


/**
 * FifteenPuzzleGame <br>
 * Created by Oscar Norman & Bali Harko <br>
 * 2020-10-23 <br>
 * 12:20
 */

public class GameWindow extends JFrame {

    private JPanel mainPanel; // Whole window
    private JPanel gamePanel; // Game window
    private JPanel menuPanel; // Menu window
    private GridLayout gameLayout;
    private BorderLayout mainLayout;
    private JButton[][] buttons;

    private JButton reset = new JButton("Reset");
    private JButton win = new JButton("Win!");

    public JButton getReset() {
        return reset;
    }

    public JButton getWin() {
        return win;
    }

    public JButton getQuit() {
        return quit;
    }

    private JButton quit = new JButton("Quit");

    public GameWindow() {

        this.mainPanel = new JPanel();
        this.gamePanel = new JPanel();
        this.menuPanel = new JPanel();

        this.mainLayout = new BorderLayout();
        this.gameLayout = new GridLayout(ROWS, COLUMNS);

        this.setSize(Constants.SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle(Constants.TITLE);

        buttons = GameLogic.buttonGridFill(ROWS, COLUMNS);

        gameLayout.setHgap(5);
        gameLayout.setVgap(5);

        gamePanel.setLayout(gameLayout);
        gamePanel.setBackground(Color.gray);

        menuPanel.add(reset);
        menuPanel.add(win);
        menuPanel.add(quit);

        mainPanel.setLayout(mainLayout);
        mainPanel.add(gamePanel, BorderLayout.CENTER);
        mainPanel.add(menuPanel, BorderLayout.SOUTH);

        this.updateGUI();

        this.add(mainPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    public void setButtons(JButton[][] buttons) {
        this.buttons = buttons;
    }
//     TODO
//    this.buttons = GameLogic.move(this.buttons);

    public void updateGUI() {
        for(int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++){
                JButton button1 = buttons[i][j];
                gamePanel.add(button1);
            }
        }
        gamePanel.repaint();
    }
}
