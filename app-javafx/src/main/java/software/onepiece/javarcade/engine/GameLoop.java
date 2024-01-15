package software.onepiece.javarcade.engine;

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
            gameState.getPlayer().moveUp(gameState.state, gameState.inhabitants);
        }
        if (gameState.isDown()) {
            gameState.getPlayer().moveDown(gameState.state, gameState.inhabitants);
        }
        if (gameState.isLeft()) {
            gameState.getPlayer().moveLeft(gameState.state, gameState.inhabitants);
        }
        if (gameState.isRight()) {
            gameState.getPlayer().moveRight(gameState.state, gameState.inhabitants);
        }
    }

    public void stop() {
        exec.shutdown();
    }
}
