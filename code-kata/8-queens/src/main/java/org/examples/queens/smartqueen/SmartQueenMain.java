package org.examples.queens.smartqueen;

import java.util.ArrayList;
import java.util.List;

public class SmartQueenMain {

    private final int size;
    private final List<List<Queen>> solutions;

    public SmartQueenMain(int size) {
        this.size = size;
        solutions = new ArrayList<>();
    }

    public List<List<Queen>> execute() {
        execute(new ArrayList<>(size), 0);

        return solutions;
    }

    private void execute(List<Queen> queens, int x) {
        for (int y = 0; y < size; y++) {
            if (QueenUtils.canPlace(queens, x, y)) {
                queens.add(new Queen(x, y));

                if (x + 1 < size) {
                    execute(queens, x + 1);
                }
                else {
                    solutions.add(List.copyOf(queens));
                }

                queens.remove(x);
            }
        }
    }

    public static void main(String[] args) {
        SmartQueenMain instance = new SmartQueenMain(8);

        List<List<Queen>> solutions = instance.execute();
        solutions
            .forEach(System.out::println);

        System.out.printf("Found solutions: %s", solutions.size());
    }

}
