package FifteenPuzzleGame.GameLogic;

import static FifteenPuzzleGame.Constants.*;

/**
 * GameWindow.java <br>
 * Created by Oscar Norman & Bali Harko <br>
 * 2020-10-24 <br>
 * 09:35
 */

public class Coordinate {

    private boolean isNeighbor;
    private int row;
    private int column;

    // Surrounding(neighbour) coordinates
    private Coordinate nNorth;
    private Coordinate nEast;
    private Coordinate nSouth;
    private Coordinate nWest;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;

        // creating neighbour Coordinates
        this.nNorth = new Coordinate(this.row - 1, this.column, true);
        this.nEast = new Coordinate(this.row, this.column + 1, true);
        this.nSouth = new Coordinate(this.row + 1, this.column, true);
        this.nWest = new Coordinate(this.row, this.column - 1, true);
    }

    // Creates neighbour coordinate and takes array bounds into consideration
    private Coordinate(int row, int column, boolean isNeighbor) {
        this.isNeighbor = isNeighbor;
        this.row = row < 0 ? 0 : Math.min(row, ROWS - 1);
        this.column = column < 0 ? 0 : Math.min(column, COLUMNS - 1);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Coordinate getnNorth() {
        return nNorth;
    }

    public Coordinate getnEast() {
        return nEast;
    }

    public Coordinate getnSouth() {
        return nSouth;
    }

    public Coordinate getnWest() {
        return nWest;
    }
}
