package software.onepiece.javarcade.inhabitant.floor;

import software.onepiece.javarcade.model.Inhabitant;

import java.io.InputStream;

public class Floor implements Inhabitant {
    @Override
    public char getRef() {
        return 'x';
    }

    @Override
    public InputStream getImage() {
        return getClass().getResourceAsStream("assets/floor.png");
    }
}
