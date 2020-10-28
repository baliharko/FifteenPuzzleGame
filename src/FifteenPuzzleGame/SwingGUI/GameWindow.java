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
    private JLabel creators;
    private GridLayout gameLayout;
    private BorderLayout mainLayout;
    private JButton[][] buttons;

    private JButton reset = new JButton(BUTTONTEXT_RESET);
    private JButton win = new JButton(BUTTONTEXT_WIN);
    private JButton quit = new JButton(BUTTONTEXT_QUIT);
    private JButton setDifficultyButton = new JButton("Set difficulty");

    // Prompt variables
    private JButton applyDifficultyButton;
    JTextField difficultyRowsInput;
    JTextField difficultyColumnsInput;

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

        buttons = GameLogic.buttonGridFill();

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
                gamePanel.add(button1);
            }
        }
        gamePanel.revalidate();
        gamePanel.repaint();
    }

    // Difficulty popup
    public void showDifficultyPrompt() {
        JFrame mainFrame = new JFrame(); // Popup frame
        JPanel mainPanel = new JPanel();

        //TextFields -> textPanel
        difficultyRowsInput = new JTextField("Rows");
        difficultyColumnsInput = new JTextField("Columns");

        this.applyDifficultyButton = new JButton("Apply"); // Button -> buttonPanel

        JPanel centerPanel = new JPanel();
        JPanel textPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);

        mainPanel.setLayout(new BorderLayout());
        textPanel.setLayout(new GridLayout(2, 1));

        difficultyRowsInput.setPreferredSize(new Dimension(100, 30));
        difficultyColumnsInput.setForeground(Color.gray);
        difficultyRowsInput.setForeground(Color.gray);

        buttonPanel.add(applyDifficultyButton);
        textPanel.add(difficultyRowsInput);
        textPanel.add(difficultyColumnsInput);

        centerPanel.add(textPanel);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainFrame.add(mainPanel);
        mainFrame.pack();
        applyDifficultyButton.requestFocusInWindow();
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        difficultyRowsInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (difficultyRowsInput.getText().equalsIgnoreCase("Rows")) {
                    difficultyRowsInput.setText("");
                }
                    difficultyRowsInput.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (difficultyRowsInput.getText().equalsIgnoreCase("Rows")
                        || difficultyRowsInput.getText().isBlank()) {
                    difficultyRowsInput.setForeground(Color.gray);
                    difficultyRowsInput.setText("Rows");
                }
            }
        });

        difficultyColumnsInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

                if (difficultyColumnsInput.getText().equalsIgnoreCase("Columns")) {
                    difficultyColumnsInput.setText("");
                }
                    difficultyColumnsInput.setForeground(Color.BLACK);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (difficultyColumnsInput.getText().equalsIgnoreCase("Columns")
                        || difficultyColumnsInput.getText().isBlank()) {
                    difficultyColumnsInput.setForeground(Color.gray);
                    difficultyColumnsInput.setText("Columns");
                }
            }
        });

        applyDifficultyButton.addActionListener(l -> {
            try {
                Constants.setROWS(Integer.parseInt(this.difficultyRowsInput.getText()));
                Constants.setCOLUMNS(Integer.parseInt(this.difficultyColumnsInput.getText()));
                this.dispose();
                mainFrame.dispose();
                new Game();
            } catch (Exception e) {
                System.out.println("Only numbers please");
                e.printStackTrace();
            }
        });
    }
}
