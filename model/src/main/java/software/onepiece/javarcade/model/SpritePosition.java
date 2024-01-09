package software.onepiece.javarcade.model;

public class SpritePosition {
    public static final int MATRIX_WIDTH = 14;
    public static final int MATRIX_HEIGHT = 14;

    private int x;
    private int y;

    public SpritePosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public SpritePosition moveRight() {
        x++;
        if (x >= MATRIX_WIDTH) {
            x = MATRIX_WIDTH - 1;
        }
        return this;
    }

    public SpritePosition moveLeft() {
        x--;
        if (x < 0) {
            x = 0;
        }
        return this;
    }

    public SpritePosition moveDown() {
        y++;
        if (y >= MATRIX_HEIGHT) {
            y = MATRIX_HEIGHT - 1;
        }
        return this;
    }

    public SpritePosition moveUp() {
        y--;
        if (y < 0) {
            y = 0;
        }
        return this;
    }
}
