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

}
