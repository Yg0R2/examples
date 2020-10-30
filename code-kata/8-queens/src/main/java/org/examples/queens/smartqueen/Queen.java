package org.examples.queens.smartqueen;

public final class Queen {

    private final int x;
    private final int y;

    public Queen(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Queen{x=" + x + ", y=" + y + '}';
    }
}