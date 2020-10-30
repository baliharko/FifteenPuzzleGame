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
    private JTextField gridResolutionInput;

    public Prompt(GameWindow gameWindow) {

            JFrame mainFrame = new JFrame(); // Popup frame
            JPanel mainPanel = new JPanel();

            //TextFields -> textPanel
            gridResolutionInput = new JTextField("Enter grid-resolution");

            this.applyDifficultyButton = new JButton("Apply"); // Button -> buttonPanel

            JPanel centerPanel = new JPanel();
            JPanel textPanel = new JPanel();
            JPanel buttonPanel = new JPanel();

            mainFrame.setLocationRelativeTo(null);
            mainFrame.setResizable(false);

            mainPanel.setLayout(new BorderLayout());
            textPanel.setLayout(new GridLayout(1, 1));

//            gridResolutionInput.setPreferredSize(new Dimension(150, 30));
            gridResolutionInput.setForeground(Color.gray);

            buttonPanel.add(applyDifficultyButton);
            textPanel.add(gridResolutionInput);

            centerPanel.add(textPanel);
            mainPanel.add(centerPanel, BorderLayout.CENTER);
            mainPanel.add(buttonPanel, BorderLayout.SOUTH);

            mainFrame.add(mainPanel);
            mainFrame.pack();
            applyDifficultyButton.requestFocusInWindow();
            mainFrame.setVisible(true);
            mainFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            gridResolutionInput.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (gridResolutionInput.getText().equalsIgnoreCase("Enter grid-resolution")) {
                        gridResolutionInput.setText("");
                    }
                    gridResolutionInput.setForeground(Color.BLACK);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (gridResolutionInput.getText().equalsIgnoreCase("Enter grid-resolution")
                            || gridResolutionInput.getText().isBlank()) {
                        gridResolutionInput.setForeground(Color.gray);
                        gridResolutionInput.setText("Enter grid-resolution");
                    }
                }
            });

            applyDifficultyButton.addActionListener(l -> {
                try {
                    Constants.setROWS(Integer.parseInt(this.gridResolutionInput.getText()));
                    Constants.setCOLUMNS(Integer.parseInt(this.gridResolutionInput.getText()));
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
