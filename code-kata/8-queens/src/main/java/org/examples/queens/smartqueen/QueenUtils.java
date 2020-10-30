package org.examples.queens.smartqueen;

import java.util.List;

public final class QueenUtils {

    private QueenUtils() {
    }

    public static boolean canHit(Queen queen, int x, int y) {
        if ((queen.getX() == x) || queen.getY() == y) {
            return true;
        }

        int directionX = Integer.compare(x, queen.getX());
        int directionY = Integer.compare(y, queen.getY());

        int loopCounter = 1;
        while (true) {
            int testedX = queen.getX() + loopCounter * directionX;
            int testedY = queen.getY() + loopCounter * directionY;

            if ((testedX == x) && (testedY == y)) {
                return true;
            }

            if ((testedX == x) || (testedY == y)) {
                break;
            }

            loopCounter++;
        }

        return false;
    }

    public static boolean canPlace(List<Queen> queens, int x, int y) {
        return queens.stream()
            .filter(queen -> canHit(queen, x, y))
            .findAny()
            .isEmpty();
    }

}
