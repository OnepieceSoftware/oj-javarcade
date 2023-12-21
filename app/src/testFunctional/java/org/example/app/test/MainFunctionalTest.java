package org.example.app.test;

import org.junit.jupiter.api.Test;
import software.onepiece.javarcade.bomb.Main;

import java.io.IOException;
import java.io.InputStream;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MainFunctionalTest {

    @Test
    void testAppFunctional() throws IOException {
        assertEquals("org.example.app", Main.class.getModule().getName());
        assertEquals("org.example.app.test.functional", MainFunctionalTest.class.getModule().getName());
        try (InputStream is = MainFunctionalTest.class.getResourceAsStream("/data.txt")) {
            assertNotNull(is);
            assertEquals("DEF", new String(is.readAllBytes(), UTF_8));
        }
    }

}