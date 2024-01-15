package software.onepiece.javarcade.model;

import java.util.List;
import java.util.Map;

public class Spot {
    public static final int PRECISION = 1000;

    public static final int MATRIX_WIDTH = 14;
    public static final int MATRIX_HEIGHT = 14;

    private final char inhabitantRef;

    private int x;
    private int y;

    private int speed = 150;

    public Spot(char inhabitantRef, int x, int y) {
        this.inhabitantRef = inhabitantRef;
        this.x = PRECISION * x;
        this.y = PRECISION * y;
    }

    public Spot(char inhabitantRef, int posInStream) {
        this(inhabitantRef,
                posInStream - (posInStream / MATRIX_HEIGHT) * MATRIX_WIDTH,
                posInStream / MATRIX_WIDTH);
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

    public void moveRight(List<Spot> state, Map<Character, Inhabitant> inhabitants) {
        if (state.stream().anyMatch(s -> s.getX()/PRECISION == x/PRECISION + 1 && s.getY()/PRECISION == y/PRECISION && inhabitants.get(s.getInhabitantRef()).blocks())) {
            return;
        }
        x += speed;
        if (x >= (MATRIX_WIDTH - 1) * PRECISION) {
            x = (MATRIX_WIDTH - 1) * PRECISION;
        }
    }

    public void moveLeft(List<Spot> state, Map<Character, Inhabitant> inhabitants) {
        if (state.stream().anyMatch(s -> s.getX()/PRECISION == x/PRECISION - 1 && s.getY()/PRECISION == y/PRECISION && inhabitants.get(s.getInhabitantRef()).blocks())) {
            return;
        }
        x -= speed;
        if (x < 0) {
            x = 0;
        }
    }

    public void moveDown(List<Spot> state, Map<Character, Inhabitant> inhabitants) {
        if (state.stream().anyMatch(s -> s.getX()/PRECISION == x/PRECISION && s.getY()/PRECISION == y/PRECISION + 1 && inhabitants.get(s.getInhabitantRef()).blocks())) {
            return;
        }
        y += speed;
        if (y >= (MATRIX_HEIGHT - 1) * PRECISION) {
            y = (MATRIX_HEIGHT - 1) * PRECISION;
        }
    }

    public void moveUp(List<Spot> state, Map<Character, Inhabitant> inhabitants) {
        if (state.stream().anyMatch(s -> s.getX()/PRECISION == x/PRECISION && s.getY()/PRECISION == y/PRECISION - 1 && inhabitants.get(s.getInhabitantRef()).blocks())) {
            return;
        }
        y -= speed;
        if (y < 0) {
            y = 0;
        }
    }
}
