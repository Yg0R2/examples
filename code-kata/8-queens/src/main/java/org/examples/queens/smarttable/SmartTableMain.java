package org.examples.queens.smarttable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SmartTableMain {

    private final int size;
    private final List<boolean[][]> solutions;

    public SmartTableMain(int size) {
        this.size = size;
        solutions = new ArrayList<>();
    }

    public List<boolean[][]> execute() {
        execute(new boolean[size][size], 0);

        return solutions;
    }

    private void execute(boolean[][] board, int row) {
        for (int column = 0; column < size; column++) {
            if (TableUtils.canPlace(board, row, column)) {
                board[row][column] = true;

                if (row + 1 < size) {
                    execute(board, row + 1);
                }
                else {
                    boolean[][] solution = Arrays.stream(board)
                        .map(boolean[]::clone)
                        .toArray(boolean[][]::new);

                    solutions.add(solution);
                }

                board[row][column] = false;
            }
        }
    }

    public static void main(String[] args) {
        SmartTableMain instance = new SmartTableMain(8);

        List<boolean[][]> solutions = instance.execute();

        solutions
            .forEach(SmartTableMain::printBoard);

        System.out.printf("Found solutions: %s", solutions.size());
    }

    private static void printBoard(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            final int index = i;

            String line = IntStream.range(0, board[i].length)
                .mapToObj(j -> board[index][j] ? "1" : "0")
                .collect(Collectors.joining(", "));

            System.out.println(line);
        }

        System.out.println();
    }

}
