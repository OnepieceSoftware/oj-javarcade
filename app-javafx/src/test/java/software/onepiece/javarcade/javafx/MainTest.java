package software.onepiece.javarcade.javafx;

import org.junit.jupiter.api.Test;
import software.onepiece.javarcade.model.Spot;

import java.io.IOException;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MainTest {

    @Test
    void testApp() throws IOException {
        assertEquals("software.onepiece.javarcade.model", Spot.class.getModule().getName());
        assertEquals("software.onepiece.javarcade.app.javafx", Main.class.getModule().getName());
        assertEquals("software.onepiece.javarcade.app.javafx", MainTest.class.getModule().getName());
        try (InputStream is = MainTest.class.getResourceAsStream("/data.txt")) {
            assertNotNull(is);
            assertEquals("ABC", new String(is.readAllBytes(), UTF_8));
        }
    }

}