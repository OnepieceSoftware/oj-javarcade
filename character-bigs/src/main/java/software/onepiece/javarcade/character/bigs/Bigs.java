package software.onepiece.javarcade.character.bigs;

import software.onepiece.javarcade.model.Character;

import java.io.InputStream;

public class Bigs implements Character {
    @Override
    public InputStream getImage() {
        return getClass().getResourceAsStream("assets/bigs.png");
    }
}
