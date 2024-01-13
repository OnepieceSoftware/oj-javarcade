package software.onepiece.javarcade.model;

import java.util.List;
import java.util.Map;

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

    public void moveRight(List<Spot> state, Map<Character, Inhabitant> inhabitants) {
        if (state.stream().anyMatch(s -> s.getX() == x + 1 && s.getY() == y && inhabitants.get(s.getInhabitantRef()).blocks())) {
            return;
        }
        x++;
        if (x >= MATRIX_WIDTH) {
            x = MATRIX_WIDTH - 1;
        }
    }

    public void moveLeft(List<Spot> state, Map<Character, Inhabitant> inhabitants) {
        if (state.stream().anyMatch(s -> s.getX() == x - 1 && s.getY() == y && inhabitants.get(s.getInhabitantRef()).blocks())) {
            return;
        }
        x--;
        if (x < 0) {
            x = 0;
        }
    }

    public void moveDown(List<Spot> state, Map<Character, Inhabitant> inhabitants) {
        if (state.stream().anyMatch(s -> s.getX() == x && s.getY() == y + 1 && inhabitants.get(s.getInhabitantRef()).blocks())) {
            return;
        }
        y++;
        if (y >= MATRIX_HEIGHT) {
            y = MATRIX_HEIGHT - 1;
        }
    }

    public void moveUp(List<Spot> state, Map<Character, Inhabitant> inhabitants) {
        if (state.stream().anyMatch(s -> s.getX() == x && s.getY() == y - 1 && inhabitants.get(s.getInhabitantRef()).blocks())) {
            return;
        }
        y--;
        if (y < 0) {
            y = 0;
        }
    }
}
