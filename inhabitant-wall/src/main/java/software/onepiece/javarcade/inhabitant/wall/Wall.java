package software.onepiece.javarcade.inhabitant.wall;

import software.onepiece.javarcade.model.Inhabitant;

import java.io.InputStream;

public class Wall implements Inhabitant {
    @Override
    public char getRef() {
        return 'x';
    }

    @Override
    public InputStream getImage() {
        return getClass().getResourceAsStream("assets/wall.png");
    }

    @Override
    public boolean blocks() {
        return true;
    }
}
