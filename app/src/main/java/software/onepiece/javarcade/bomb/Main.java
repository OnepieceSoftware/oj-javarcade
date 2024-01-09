package software.onepiece.javarcade.bomb;

import com.fasterxml.jackson.jakarta.rs.json.annotation.JSONP;
import jakarta.activation.CommandObject;
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
import software.onepiece.javarcade.model.Character;
import software.onepiece.javarcade.model.SpritePosition;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import static software.onepiece.javarcade.model.SpritePosition.MATRIX_HEIGHT;
import static software.onepiece.javarcade.model.SpritePosition.MATRIX_WIDTH;

public class Main extends Application {
    // Services:
    // - Render engine
    // - Branding/Splash/Background
    // - Character
    // - Wall
    // - Item
    // - Level


    @JSONP
    @Deprecated
    public static void doWork() {
        CommandObject o = null;
        new Lib();
    }

    public static void main(String[] args) {
        Configuration conf = new CombinedConfiguration();
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

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext ctx = canvas.getGraphicsContext2D();
        ctx.setImageSmoothing(false);

        Image leftWall = new Image(getClass().getResourceAsStream("/wall_left.png"), CELL_WIDTH, CELL_HEIGHT, true, false);
        Image rightWall = new Image(getClass().getResourceAsStream("/wall_right.png"), CELL_WIDTH, CELL_HEIGHT, true, false);
        for (int y = 0; y < MATRIX_HEIGHT; y++) {
            drawSprite(leftWall, 0, y, ctx);
            drawSprite(rightWall, 1 + MATRIX_WIDTH, y, ctx);
        }

        ServiceLoader.load(Character.class).forEach(c -> {
            SpritePosition pos = characterStartPositions.removeFirst();
            drawSprite(new Image(c.getImage(), CELL_WIDTH, CELL_HEIGHT, true, false), 1 + pos.getX(), pos.getY(), ctx);
        } );

        StackPane pane = new StackPane(canvas);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);

        new Label("L1");
        stage.setTitle("JavArcade");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    private void drawSprite(Image img, int x, int y, GraphicsContext ctx) {
        ctx.drawImage(img, x * CELL_WIDTH * SCALE, y * CELL_HEIGHT * SCALE, CELL_WIDTH * SCALE, CELL_HEIGHT * SCALE);
    }

    private final List<SpritePosition> characterStartPositions = new ArrayList<>(List.of(
            new SpritePosition(0, 0),
            new SpritePosition(MATRIX_WIDTH - 1, MATRIX_HEIGHT - 1),
            new SpritePosition(0, MATRIX_HEIGHT - 1),
            new SpritePosition(MATRIX_WIDTH - 1, 0)
    ));

}