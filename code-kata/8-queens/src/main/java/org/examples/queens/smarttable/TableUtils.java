package org.examples.queens.smarttable;

import java.util.List;
import java.util.Objects;

public final class TableUtils {

    private TableUtils() {
    }

    public static boolean canPlace(boolean[][] board, int row, int column) {
        for (int i = 0; i < board.length; i++) {
            if (isOccupied(board, row - i, column - i)
                || isOccupied(board, row - i, column)
                || isOccupied(board, row - i, column + i)
                || isOccupied(board, row, column + i)
                || isOccupied(board, row + i, column + i)
                || isOccupied(board, row + i, column)
                || isOccupied(board, row + i, column - i)
                || isOccupied(board, row, column - i)) {

                return false;
            }
        }

        return true;
    }

    private static boolean isOccupied(boolean[][] board, int row, int column) {
        if ((row >= 0) && (row < board.length) && (column >= 0) && (column < board.length)) {
            return board[row][column];
        }

        return false;
    }

}
