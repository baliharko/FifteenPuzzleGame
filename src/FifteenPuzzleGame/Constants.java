package FifteenPuzzleGame;

import java.awt.*;

/**
 * FifteenPuzzleGame <br>
 * Created by Oscar Norman & Bali Harko <br>
 * 2020-10-23 <br>
 * 13:36
 */

public class Constants {

    public static Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    public static int ROWS = 4;
    public static int COLUMNS = 4;

    public static void setROWS(int ROWS) {
        Constants.ROWS = ROWS;
    }

    public static void setCOLUMNS(int COLUMNS) {
        Constants.COLUMNS = COLUMNS;
    }

    public static final int SCREEN_WIDTH = SCREEN_SIZE.width / 2;
    public static final int SCREEN_HEIGHT = SCREEN_WIDTH;

    public static final String TITLE = "Fifteen Puzzle Game";
    public static final String EMPTY_BUTTON_TEXT = "TOM_KNAPP";
    public static final String CREDITS = "Made by Oscar Norman & Balazs Harko";
    public static final String CREDITS_FONT = "Serif";
    public static final String BUTTONTEXT_RESET = "Reset";
    public static final String BUTTONTEXT_WIN = "Win!";
    public static final String BUTTONTEXT_QUIT = "Quit";

}
