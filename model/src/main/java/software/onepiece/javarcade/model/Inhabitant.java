package software.onepiece.javarcade.model;

import java.io.InputStream;

public interface Inhabitant {
    Inhabitant EMPTY = new Inhabitant() {
        @Override
        public char getRef() {
            return ' ';
        }

        @Override
        public InputStream getImage() {
            return null;
        }
    };

    char getRef();

    InputStream getImage();

    default boolean controllable() {
        return false;
    }

    default boolean blocks() {
        return false;
    }
}
