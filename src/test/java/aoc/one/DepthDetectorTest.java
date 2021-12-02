package aoc.one;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepthDetectorTest {

    private static String input;
    DepthDetector unit = new DepthDetector();

    String test = """
                199
                200
                208
                210
                200
                207
                240
                269
                260
                263
                """;

    @BeforeAll
    static void setup() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/depth1.txt");
        byte[] bytes = fileInputStream.readAllBytes();
        input = new String(bytes);
    }


    @Test
    void testDepth_test() {
        assertEquals(7, unit.depth(test));
    }

    @Test
    void testDepth_input() {
        assertEquals(1387, unit.depth(input));
    }

    @Test
    void testDepthWindowed_test() {
        assertEquals(5, unit.depthWindowed(test));
    }

    @Test
    void testDepthWindowed_input() {
        assertEquals(1362, unit.depthWindowed(input));
    }


}