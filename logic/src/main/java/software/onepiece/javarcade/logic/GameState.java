package software.onepiece.javarcade.logic;

import software.onepiece.javarcade.model.Inhabitant;
import software.onepiece.javarcade.model.Level;
import software.onepiece.javarcade.model.Spot;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

public class GameState {

    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    private Spot player;
    private final Map<Character, Inhabitant> inhabitants = new LinkedHashMap<>();
    private final List<Spot> spots = new LinkedList<>();
    private final Map<Character, byte[]> images = new HashMap<>();

    public GameState() {
        init();
    }

    private void init() {
        ServiceLoader.load(Inhabitant.class).forEach(inhabitant -> inhabitants.put(inhabitant.getRef(), inhabitant));
        ServiceLoader.load(Level.class).forEach(level -> level.render().forEach(spot -> {
            Inhabitant inhabitant = inhabitants.get(spot.getInhabitantRef());
            if (inhabitant == null) {
                return; // TODO log a message
            }
            try {
                images.put(spot.getInhabitantRef(), inhabitant.getImage().readAllBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (inhabitant.controllable()) {
                player = spot;
                spots.addLast(spot);
            } else {
                spots.addFirst(spot);
            }
        }));
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public Map<Character, Inhabitant> getInhabitants() {
        return inhabitants;
    }

    public Map<Character, byte[]> getImages() {
        return images;
    }

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
