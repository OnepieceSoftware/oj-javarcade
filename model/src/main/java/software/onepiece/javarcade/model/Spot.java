package software.onepiece.javarcade.model;

public class Spot {
    public static final int MATRIX_WIDTH = 14;
    public static final int MATRIX_HEIGHT = 14;

    private final char inhabitantRef;

    private int x;
    private int y;

    public Spot(char inhabitantRef, int x, int y) {
        this.inhabitantRef = inhabitantRef;
        this.x = x;
        this.y = y;
    }

    public Spot(char inhabitantRef, int posInStream) {
        this.inhabitantRef = inhabitantRef;
        this.y = posInStream / MATRIX_HEIGHT;
        this.x = posInStream - y * MATRIX_WIDTH;
    }

    public char getInhabitantRef() {
        return inhabitantRef;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Spot moveRight() {
        x++;
        if (x >= MATRIX_WIDTH) {
            x = MATRIX_WIDTH - 1;
        }
        return this;
    }

    public Spot moveLeft() {
        x--;
        if (x < 0) {
            x = 0;
        }
        return this;
    }

    public Spot moveDown() {
        y++;
        if (y >= MATRIX_HEIGHT) {
            y = MATRIX_HEIGHT - 1;
        }
        return this;
    }

    public Spot moveUp() {
        y--;
        if (y < 0) {
            y = 0;
        }
        return this;
    }
}
