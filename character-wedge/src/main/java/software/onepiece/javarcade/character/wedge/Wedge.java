package software.onepiece.javarcade.character.wedge;

import software.onepiece.javarcade.model.Inhabitant;

import java.io.InputStream;

public class Wedge implements Inhabitant {
    @Override
    public char getRef() {
        return 'W';
    }

    @Override
    public InputStream getImage() {
        return getClass().getResourceAsStream("assets/wedge.png");
    }

    @Override
    public boolean controllable() {
        return true;
    }
}
