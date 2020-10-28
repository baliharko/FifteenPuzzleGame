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
    private JPanel creditPanel; //Credits panel
    private JLabel creators;
    private GridLayout gameLayout;
    private BorderLayout mainLayout;
    private JButton[][] buttons;

    private JButton reset = new JButton(BUTTONTEXT_RESET);
    private JButton win = new JButton(BUTTONTEXT_WIN);
    private JButton quit = new JButton(BUTTONTEXT_QUIT);


    public JButton getReset() {
        return reset;
    }

    public JButton getWin() {
        return win;
    }

    public JButton getQuit() {
        return quit;
    }


    public GameWindow() {

        this.mainPanel = new JPanel();
        this.gamePanel = new JPanel();
        this.menuPanel = new JPanel();
        this.creditPanel = new JPanel();

        this.creators = new JLabel(CREDITS);

        this.mainLayout = new BorderLayout();
        this.gameLayout = new GridLayout(ROWS, COLUMNS);

        this.setSize(Constants.SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle(Constants.TITLE);

        buttons = GameLogic.buttonGridFill();

        gameLayout.setHgap(5);
        gameLayout.setVgap(5);

        gamePanel.setLayout(gameLayout);
        gamePanel.setBackground(Color.gray);

        menuPanel.add(reset);
        menuPanel.add(win);
        menuPanel.add(quit);

        creators.setFont(new Font(CREDITS_FONT, Font.BOLD, 20));
        creditPanel.add(creators);

        mainPanel.setLayout(mainLayout);
        mainPanel.add(creditPanel, BorderLayout.NORTH);
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

    public void updateGUI() {
        gamePanel.removeAll();
        for(int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++){
                JButton button1 = buttons[i][j];
                if (GameLogic.highlightCorrectMove(this.buttons, i, j)) {
                    button1.setBackground(Color.orange);
                    button1.setOpaque(true);
                }
                gamePanel.add(button1);

            }
        }
        gamePanel.revalidate();
        gamePanel.repaint();
    }
}