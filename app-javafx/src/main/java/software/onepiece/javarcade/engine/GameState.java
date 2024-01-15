package software.onepiece.javarcade.engine;

import software.onepiece.javarcade.model.Inhabitant;
import software.onepiece.javarcade.model.Spot;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GameState {

    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    private Spot player;
    public final Map<Character, Inhabitant> inhabitants = new LinkedHashMap<>();
    public final List<Spot> state = new LinkedList<>();

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public Spot getPlayer() {
        return player;
    }

    public void setPlayer(Spot player) {
        this.player = player;
    }
}
