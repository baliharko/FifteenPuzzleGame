package FifteenPuzzleGame;

import FifteenPuzzleGame.GameLogic.GameLogic;
import FifteenPuzzleGame.SwingGUI.GameWindow;

import java.util.Arrays;

/**
 * FifteenPuzzleGame <br>
 * Created by Oscar Norman & Bali Harko <br>
 * 2020-10-23 <br>
 * 15:43
 */

public class Game {
    GameWindow gameWindow;
    ActionListeners listeners;
    MouseAdapters mouseAdapters;

    public Game() {
        this.init();
    }

    public void init() {
        gameWindow = new GameWindow();
        listeners = new ActionListeners(gameWindow);
        mouseAdapters = new MouseAdapters(gameWindow);
    }

    public static void main(String[] args) {
        new Game();
    }
}