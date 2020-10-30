package org.examples.queens.smartqueen;

import java.util.ArrayList;
import java.util.List;

public class SmartQueenMain {

    public List<Queen> execute(int size) {
        return execute(new ArrayList<>(size), size, 0, 0);
    }

    private List<Queen> execute(List<Queen> queens, int size, int x, int y) {
        for (int i = y; i < size; i++) {
            if (QueenUtils.canPlace(queens, x, i)) {
                queens.add(new Queen(x, i));

                return execute(queens, size, x + 1, 0);
            }
        }

        if (queens.size() < size) {
            Queen lastQueen = queens.remove(queens.size() - 1);

            return execute(queens, size, lastQueen.getX(), lastQueen.getY() + 1);
        }

        return queens;
    }

    public static void main(String[] args) {
        SmartQueenMain instance = new SmartQueenMain();

        System.out.println(instance.execute(8));
    }

}
