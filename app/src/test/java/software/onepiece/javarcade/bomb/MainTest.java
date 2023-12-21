package software.onepiece.javarcade.bomb;

import org.example.lib.Lib;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MainTest {

    @Test
    void testApp() throws IOException {
        assertEquals("org.example.lib", Lib.class.getModule().getName());
        assertEquals("org.example.app", Main.class.getModule().getName());
        assertEquals("org.example.app", MainTest.class.getModule().getName());
        try (InputStream is = MainTest.class.getResourceAsStream("/data.txt")) {
            assertNotNull(is);
            assertEquals("ABC", new String(is.readAllBytes(), UTF_8));
        }
    }

}