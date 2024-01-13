package software.onepiece.javarcade.character.bigs;

import software.onepiece.javarcade.model.Inhabitant;

import java.io.InputStream;

public class Bigs implements Inhabitant {
    @Override
    public char getRef() {
        return 'B';
    }

    @Override
    public InputStream getImage() {
        return getClass().getResourceAsStream("assets/bigs.png");
    }
}
