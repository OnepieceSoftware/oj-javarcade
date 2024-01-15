package software.onepiece.javarcade.border.blocks;

import software.onepiece.javarcade.model.Inhabitant;

import java.io.InputStream;

public class WallLeft implements Inhabitant {
    @Override
    public char getRef() {
        return '[';
    }

    @Override
    public InputStream getImage() {
        return getClass().getResourceAsStream("assets/wall_left.png");
    }
}
