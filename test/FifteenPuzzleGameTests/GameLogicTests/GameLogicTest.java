package FifteenPuzzleGameTests.GameLogicTests;

import FifteenPuzzleGame.GameLogic.GameLogic;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static FifteenPuzzleGame.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

public class GameLogicTest {

    JButton[][] test1 = new JButton[ROWS][COLUMNS]; // Solvable
    JButton[][] test2 = new JButton[ROWS][COLUMNS]; // Solvable
    JButton[][] test3 = new JButton[ROWS][COLUMNS]; // NOT solvable

    {

        // test1
        test1[0][0] = new JButton("" + 13);
        test1[0][1] = new JButton("" + 2);
        test1[0][2] = new JButton("" + 10);
        test1[0][3] = new JButton("" + 3);

        test1[1][0] = new JButton("" + 1);
        test1[1][1] = new JButton("" + 12);
        test1[1][2] = new JButton("" + 8);
        test1[1][3] = new JButton("" + 4);

        test1[2][0] = new JButton("" + 5);
        test1[2][1] = new JButton(EMPTY_BUTTON_TEXT);
        test1[2][2] = new JButton("" + 9);
        test1[2][3] = new JButton("" + 6);

        test1[3][0] = new JButton("" + 15);
        test1[3][1] = new JButton("" + 14);
        test1[3][2] = new JButton("" + 11);
        test1[3][3] = new JButton("" + 7);

        // test2
        test2[0][0] = new JButton("" + 6);
        test2[0][1] = new JButton("" + 13);
        test2[0][2] = new JButton("" + 7);
        test2[0][3] = new JButton("" + 10);

        test2[1][0] = new JButton("" + 8);
        test2[1][1] = new JButton("" + 9);
        test2[1][2] = new JButton("" + 11);
        test2[1][3] = new JButton(EMPTY_BUTTON_TEXT);

        test2[2][0] = new JButton("" + 15);
        test2[2][1] = new JButton("" + 2);
        test2[2][2] = new JButton("" + 12);
        test2[2][3] = new JButton("" + 5);

        test2[3][0] = new JButton("" + 14);
        test2[3][1] = new JButton("" + 3);
        test2[3][2] = new JButton("" + 1);
        test2[3][3] = new JButton("" + 4);

        // test3
        test3[0][0] = new JButton("" + 3);
        test3[0][1] = new JButton("" + 9);
        test3[0][2] = new JButton("" + 1);
        test3[0][3] = new JButton("" + 15);

        test3[1][0] = new JButton("" + 14);
        test3[1][1] = new JButton("" + 11);
        test3[1][2] = new JButton("" + 4);
        test3[1][3] = new JButton("" + 6);

        test3[2][0] = new JButton("" + 13);
        test3[2][1] = new JButton(EMPTY_BUTTON_TEXT);
        test3[2][2] = new JButton("" + 10);
        test3[2][3] = new JButton("" + 12);

        test3[3][0] = new JButton("" + 2);
        test3[3][1] = new JButton("" + 7);
        test3[3][2] = new JButton("" + 8);
        test3[3][3] = new JButton("" + 5);
    }

    @Test
    public final void isSolvableTest() {
        assertTrue(GameLogic.isSolvable(test1));
        assertTrue(GameLogic.isSolvable(test2));
        assertFalse(GameLogic.isSolvable(test3));
    }

    @Test
    public final void getInversionsTest() {
        assertEquals(41, GameLogic.getInversions(GameLogic.flattenArray(test1)));
        assertEquals(62, GameLogic.getInversions(GameLogic.flattenArray(test2)));
        assertEquals(56, GameLogic.getInversions(GameLogic.flattenArray(test3)));
    }

    @Test
    public final void getBlankButtonRowTest() {
        assertEquals(2, GameLogic.getBlankButtonRow(GameLogic.flattenArray(test1)));
        assertEquals(3, GameLogic.getBlankButtonRow(GameLogic.flattenArray(test2)));
        assertEquals(2, GameLogic.getBlankButtonRow(GameLogic.flattenArray(test3)));
    }

}
