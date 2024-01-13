package software.onepiece.javarcade.level.classic;

import software.onepiece.javarcade.model.Level;

public class ClassicLevel extends Level {
    @Override
    protected String define() {
        return """
                W.............
                .xx.xxxxxx.xx.
                .x..........x.
                .x.xxxxxxxx.x.
                .x.xxxxxxxx.x.
                .x.xx....xx.x.
                .x.xx.xx.xx.x.
                .x.xx.xx.xx.x.
                .x.xx....xx.x.
                .x.xxxxxxxx.x.
                .x.xxxxxxxx.x.
                .x..........x.
                .xx.xxxxxx.xx.
                .............B
                """;
    }
}
