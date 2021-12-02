package aoc.first;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

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
    public static void setup() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/depth1.txt");
        byte[] bytes = fileInputStream.readAllBytes();
        input = new String(bytes);
    }


    @Test
    public void testDepth_test() {

        assertEquals(unit.depth(test), 7);
    }

    @Test
    public void testDepth_input() {

        assertEquals(unit.depth(input), 1387);


    }

    @Test
    public void testDepthWindowed_test() {

        assertEquals(unit.depth_windowed(test), 5);

    }

    @Test
    public void testDepthWindowed_input() {


        assertEquals(unit.depth_windowed(input), 1362);


    }


}