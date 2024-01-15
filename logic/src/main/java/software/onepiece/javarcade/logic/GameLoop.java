package software.onepiece.javarcade.logic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameLoop {

    private ScheduledExecutorService exec;
    private GameState gameState;


    public void run(GameState gameState) {
        this.gameState = gameState;
        exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(this::update, 0, 20, TimeUnit.MILLISECONDS);
    }

    private void update() {
        if (gameState.isUp()) {
            gameState.getPlayer().moveUp(gameState.getSpots(), gameState.getInhabitants());
        }
        if (gameState.isDown()) {
            gameState.getPlayer().moveDown(gameState.getSpots(), gameState.getInhabitants());
        }
        if (gameState.isLeft()) {
            gameState.getPlayer().moveLeft(gameState.getSpots(), gameState.getInhabitants());
        }
        if (gameState.isRight()) {
            gameState.getPlayer().moveRight(gameState.getSpots(), gameState.getInhabitants());
        }
    }

    public void stop() {
        exec.shutdown();
    }
}
