package FifteenPuzzleGame.SwingGUI;
import FifteenPuzzleGame.GameLogic.GameLogic;
import FifteenPuzzleGame.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

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

    private JLabel creators; // Credits

    private GridLayout gameLayout;
    private BorderLayout mainLayout;

    private JButton[][] buttons; // The main array of buttons

    // Menu-buttons
    private JButton reset = new JButton(BUTTONTEXT_RESET);
    private JButton win = new JButton(BUTTONTEXT_WIN);
    private JButton quit = new JButton(BUTTONTEXT_QUIT);
    private JButton setDifficultyButton = new JButton(BUTTONTEXT_SET_DIFFICULTY);

    // Getting called first
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

        buttons = GameLogic.buttonGridFill(); // Filling array with buttons

        gameLayout.setHgap(5);
        gameLayout.setVgap(5);

        gamePanel.setLayout(gameLayout);
        gamePanel.setBackground(Color.gray);

        menuPanel.add(reset);
        menuPanel.add(setDifficultyButton);
        menuPanel.add(win);
        menuPanel.add(quit);

        creators.setFont(new Font(CREDITS_FONT, Font.BOLD, 20));
        creditPanel.add(creators);

        mainPanel.setLayout(mainLayout);
        mainPanel.add(creditPanel, BorderLayout.NORTH);
        mainPanel.add(gamePanel, BorderLayout.CENTER);
        mainPanel.add(menuPanel, BorderLayout.SOUTH);

        this.updateGUI(); // Paints the buttons array to the GridLayout

        this.add(mainPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void updateGUI() {
        gamePanel.removeAll();
        for(int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++){
                JButton button1 = buttons[i][j];
                if (GameLogic.isCorrect(this.buttons, i, j)) {
                    button1.setBackground(Color.orange);
                    button1.setOpaque(true);
                }
                if (GameLogic.isCorrect(buttons, i, j) && !(i == ROWS -1 && j == COLUMNS -1)) {
                    buttons[i][j].setBackground(Color.orange);
                    buttons[i][j].setOpaque(true);
                }
                gamePanel.add(button1);
            }
        }

        buttons[ROWS-1][COLUMNS-1].setBackground(new JButton().getBackground());
        if (!buttons[ROWS-1][COLUMNS-1].getText().equalsIgnoreCase(EMPTY_BUTTON_TEXT))
            buttons[ROWS-1][COLUMNS-1].setOpaque(false);

        gamePanel.revalidate();
        gamePanel.repaint();
    }

    public JButton[][] getButtons() {
        return buttons;
    }

    public void setButtons(JButton[][] buttons) {
        this.buttons = buttons;
    }

    public JButton getReset() {
        return reset;
    }

    public JButton getWin() {
        return win;
    }

    public JButton getQuit() {
        return quit;
    }

    public JButton getSetDifficultyButton() {
        return setDifficultyButton;
    }
}
