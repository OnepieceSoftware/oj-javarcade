package software.onepiece.javarcade.javafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.onepiece.javarcade.logic.GameLoop;
import software.onepiece.javarcade.logic.GameState;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

import static software.onepiece.javarcade.logic.GameParameters.CELL_HEIGHT;
import static software.onepiece.javarcade.logic.GameParameters.CELL_HEIGHT_IN_PIXEL;
import static software.onepiece.javarcade.logic.GameParameters.CELL_WIDTH;
import static software.onepiece.javarcade.logic.GameParameters.CELL_WIDTH_IN_PIXEL;
import static software.onepiece.javarcade.logic.GameParameters.HEIGHT_IN_PIXEL;
import static software.onepiece.javarcade.logic.GameParameters.WIDTH_IN_PIXEL;

public class Main extends Application {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    private final GameState gameState = new GameState();
    private final Map<Character, Image> images = new HashMap<>();

    public static void main(String[] args) {
        LOG.info("App running [" + Main.class.getModule().getName() + "]");
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(WIDTH_IN_PIXEL, HEIGHT_IN_PIXEL);
        GraphicsContext ctx = canvas.getGraphicsContext2D();
        ctx.setImageSmoothing(false);
        StackPane pane = new StackPane(canvas);

        Scene scene = initScene(pane);
        initStage(stage, scene);

        gameState.getImages().forEach((symbol, content) -> {
            images.put(symbol, new Image(new ByteArrayInputStream(content), CELL_WIDTH, CELL_HEIGHT, true, false));
        });

        new GameLoop().run(gameState);
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                draw(ctx);
            }
        }.start();
    }

    private Scene initScene(StackPane pane) {
        Scene scene = new Scene(pane, WIDTH_IN_PIXEL, HEIGHT_IN_PIXEL);
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
        return scene;
    }

    private void initStage(Stage stage, Scene scene) {
        stage.setTitle("JavArcade");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void draw(GraphicsContext ctx) {
        ctx.clearRect(0, 0, WIDTH_IN_PIXEL, HEIGHT_IN_PIXEL);
        gameState.getSpots().forEach(s -> drawSprite(ctx, images.get(s.getInhabitantRef()),
                s.getPixelPositionX(CELL_WIDTH_IN_PIXEL),
                s.getPixelPositionY(CELL_HEIGHT_IN_PIXEL)
        ));
    }


    private void drawSprite(GraphicsContext ctx, Image img, double x, double y) {
        if (img == null) { return; }
        ctx.drawImage(img, x, y, CELL_WIDTH_IN_PIXEL, CELL_HEIGHT_IN_PIXEL);
    }
}