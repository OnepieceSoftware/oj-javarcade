package software.onepiece.javarcade.bomb;

import com.fasterxml.jackson.jakarta.rs.json.annotation.JSONP;
import jakarta.activation.CommandObject;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.apache.commons.configuration2.CombinedConfiguration;
import org.apache.commons.configuration2.Configuration;
import org.example.lib.Lib;
import org.slf4j.LoggerFactory;

public class Main extends Application {

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

    private static final int MATRIX_WIDTH = 10;
    private static final int MATRIX_HEIGHT = 20;
    private static final double CELL_WIDTH = 24;
    private static final double CELL_HEIGHT = 24;
    private static final double GAME_WIDTH = MATRIX_WIDTH * CELL_WIDTH;
    private static final double GAME_HEIGHT = MATRIX_HEIGHT * CELL_HEIGHT;
    private static final double WIDTH = GAME_WIDTH + 50;
    private static final double HEIGHT = GAME_HEIGHT + 50;

    @Override
    public void start(Stage stage) {
        StackPane gamePane = new StackPane(new Canvas(WIDTH, HEIGHT), new Canvas(WIDTH, HEIGHT));
        final HBox gameBox  = new HBox(10, gamePane);

        StackPane pane = new StackPane(gameBox);
        Scene scene = new Scene(pane, 500, 530);

        new Label("L");

        stage.setTitle("Bomb!");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
}