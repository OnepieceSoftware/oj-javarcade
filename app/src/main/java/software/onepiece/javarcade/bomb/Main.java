package software.onepiece.javarcade.bomb;

import com.fasterxml.jackson.jakarta.rs.json.annotation.JSONP;
import jakarta.activation.CommandObject;
import jakarta.activation.DataHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.commons.configuration2.CombinedConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.example.lib.Lib;
import org.slf4j.LoggerFactory;
import software.onepiece.javarcade.model.Inhabitant;
import software.onepiece.javarcade.model.Level;
import software.onepiece.javarcade.model.Spot;

import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;

import static java.util.Objects.requireNonNull;
import static software.onepiece.javarcade.model.Spot.MATRIX_HEIGHT;
import static software.onepiece.javarcade.model.Spot.MATRIX_WIDTH;

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

    private final Map<Character, Inhabitant> inhabitants = new LinkedHashMap<>();
    private final List<Spot> state = new LinkedList<>();
    private Spot player;

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext ctx = canvas.getGraphicsContext2D();
        ctx.setImageSmoothing(false);

        ServiceLoader.load(Inhabitant.class).forEach(inhabitant -> inhabitants.put(inhabitant.getRef(), inhabitant));
        ServiceLoader.load(Level.class).forEach(level -> level.render().forEach(spot -> {
            Inhabitant inhabitant = inhabitants.get(spot.getInhabitantRef());
            images.put(spot.getInhabitantRef(), imageFor(inhabitant.getImage()));
            if (inhabitant.controllable()) {
                player = spot;
                state.addLast(spot);
            } else {
                state.addFirst(spot);
            }
        }));

        draw(ctx);

        StackPane pane = new StackPane(canvas);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP  -> player.moveUp(state, inhabitants);
                case DOWN  -> player.moveDown(state, inhabitants);
                case LEFT  -> player.moveLeft(state, inhabitants);
                case RIGHT -> player.moveRight(state, inhabitants);
                case X -> System.out.println("Boom!");
            }
            draw(ctx);
        });

        new Label("L1");
        stage.setTitle("JavArcade");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }


    private final Image leftWall = new Image(requireNonNull(getClass().getResourceAsStream("/wall_left.png")), CELL_WIDTH, CELL_HEIGHT, true, false);
    private final Image rightWall = new Image(requireNonNull(getClass().getResourceAsStream("/wall_right.png")), CELL_WIDTH, CELL_HEIGHT, true, false);
    private final Map<Character, Image> images = new HashMap<>();

    private void draw(GraphicsContext ctx) {
        ctx.clearRect(CELL_WIDTH * SCALE, 0, WIDTH, HEIGHT);

        for (int y = 0; y < MATRIX_HEIGHT; y++) {
            drawSprite(leftWall, 0, y, ctx);
            drawSprite(rightWall, 1 + MATRIX_WIDTH, y, ctx);
        }
        state.forEach(s -> drawSprite(images.get(s.getInhabitantRef()), s.getX() + 1, s.getY(), ctx));
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
        ctx.drawImage(img, x * CELL_WIDTH * SCALE, y * CELL_HEIGHT * SCALE, CELL_WIDTH * SCALE, CELL_HEIGHT * SCALE);
    }

    @JSONP
    @Deprecated
    public static void doWork() {
        Configuration conf = new CombinedConfiguration();
        CommandObject o = (s, dataHandler) -> { };
        if (o.toString().equals(conf.toString())) {
            return;
        }
        new Lib();
    }
}