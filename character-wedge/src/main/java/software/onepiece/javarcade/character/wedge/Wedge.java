package software.onepiece.javarcade.character.wedge;

import software.onepiece.javarcade.model.Character;

import java.io.InputStream;

public class Wedge implements Character {
    @Override
    public InputStream getImage() {
        return getClass().getResourceAsStream("assets/wedge.png");
    }
}
