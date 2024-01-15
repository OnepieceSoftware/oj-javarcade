package software.onepiece.javarcade.javafx;

import com.fasterxml.jackson.jakarta.rs.json.annotation.JSONP;
import jakarta.activation.CommandObject;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.example.lib.Lib;
import org.slf4j.LoggerFactory;
import software.onepiece.javarcade.engine.GameLoop;
import software.onepiece.javarcade.engine.GameState;
import software.onepiece.javarcade.model.Inhabitant;
import software.onepiece.javarcade.model.Level;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import static java.util.Objects.requireNonNull;
import static software.onepiece.javarcade.model.Spot.MATRIX_HEIGHT;
import static software.onepiece.javarcade.model.Spot.MATRIX_WIDTH;
import static software.onepiece.javarcade.model.Spot.PRECISION;

public class Main extends Application {
    // Services:
    // - Render engine
    // - Branding/Splash/Background
    // - Character
    // - Wall
    // - Item
    // - Level

    public static void main(String[] args) {
        LoggerFactory.getLogger(Main.class).info("App running...");
        System.out.println("Module Name: " + Main.class.getModule().getName());
        doWork();

        launch(args);
    }


    private static final int CELL_WIDTH = 16;
    private static final int CELL_HEIGHT = 16;
    private static final int GAME_WIDTH = MATRIX_WIDTH * CELL_WIDTH;
    private static final int GAME_HEIGHT = MATRIX_HEIGHT * CELL_HEIGHT;

    private static final int SCALE = 4;

    private static final int WIDTH = SCALE * (GAME_WIDTH + CELL_WIDTH * 2);
    private static final int HEIGHT = SCALE * GAME_HEIGHT;


    private final GameState gameState = new GameState();

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext ctx = canvas.getGraphicsContext2D();
        ctx.setImageSmoothing(false);

        ServiceLoader.load(Inhabitant.class).forEach(inhabitant -> gameState.inhabitants.put(inhabitant.getRef(), inhabitant));
        ServiceLoader.load(Level.class).forEach(level -> level.render().forEach(spot -> {
            Inhabitant inhabitant = gameState.inhabitants.get(spot.getInhabitantRef());
            images.put(spot.getInhabitantRef(), imageFor(inhabitant.getImage()));
            if (inhabitant.controllable()) {
                gameState.setPlayer(spot);
                gameState.state.addLast(spot);
            } else {
                gameState.state.addFirst(spot);
            }
        }));

        StackPane pane = new StackPane(canvas);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP    -> gameState.setUp(true);
                case DOWN  -> gameState.setDown(true);
                case LEFT  -> gameState.setLeft(true);
                case RIGHT -> gameState.setRight(true);
                case X -> System.out.println("Boom!");
            }
        });
        scene.setOnKeyReleased(e -> {
            switch (e.getCode()) {
                case UP    -> gameState.setUp(false);
                case DOWN  -> gameState.setDown(false);
                case LEFT  -> gameState.setLeft(false);
                case RIGHT -> gameState.setRight(false);
                case X -> System.out.println("Boom!");
            }
        });


        new Label("L1");
        stage.setTitle("JavArcade");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

        new GameLoop().run(gameState);
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                draw(ctx);
            }
        }.start();
    }


    private final Image leftWall = new Image(requireNonNull(getClass().getResourceAsStream("/wall_left.png")), CELL_WIDTH, CELL_HEIGHT, true, false);
    private final Image rightWall = new Image(requireNonNull(getClass().getResourceAsStream("/wall_right.png")), CELL_WIDTH, CELL_HEIGHT, true, false);
    private final Map<Character, Image> images = new HashMap<>();

    private void draw(GraphicsContext ctx) {
        ctx.clearRect(CELL_WIDTH * SCALE, 0, WIDTH, HEIGHT);

        for (int y = 0; y < MATRIX_HEIGHT; y++) {
            drawSprite(leftWall, 0, y * PRECISION, ctx);
            drawSprite(rightWall, (1 + MATRIX_WIDTH) * PRECISION, y * PRECISION, ctx);
        }
        gameState.state.forEach(s -> drawSprite(images.get(s.getInhabitantRef()), s.getX() + PRECISION, s.getY(), ctx));
    }

    private Image imageFor(InputStream stream) {
        if (stream == null) {
            return null;
        }
        return new Image(stream, CELL_WIDTH, CELL_HEIGHT, true, false);
    }

    private void drawSprite(Image img, int x, int y, GraphicsContext ctx) {
        if (img == null) {
            return;
        }
        ctx.drawImage(img,
                (x * CELL_WIDTH * SCALE) * 1f / PRECISION,
                (y * CELL_HEIGHT * SCALE) * 1f / PRECISION,
                CELL_WIDTH * SCALE, CELL_HEIGHT * SCALE);
    }

    @JSONP
    @Deprecated
    public static void doWork() {
        CommandObject o = (s, dataHandler) -> { };
        if (o.toString().equals("conf")) {
            return;
        }
        new Lib();
    }
}