package FifteenPuzzleGame.SwingGUI;

import FifteenPuzzleGame.Constants;
import FifteenPuzzleGame.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by Oscar Norman <br>
 * Date: 2020-10-28   <br>
 * Time: 16:12   <br>
 * Project: GameWindow.java <br>
 */
public class Prompt extends JFrame {
    private JButton applyDifficultyButton;
    private JTextField difficultyRowsInput;
    private JTextField difficultyColumnsInput;

    public Prompt(GameWindow gameWindow) {

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
                    gameWindow.dispose();
                    mainFrame.dispose();
                    new Game();
                } catch (Exception e) {
                    System.out.println("Only numbers please");
                    e.printStackTrace();
                }
            });
        }
    }
