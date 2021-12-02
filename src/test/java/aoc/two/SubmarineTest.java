package aoc.two;

import aoc.first.DepthDetector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SubmarineTest {


    private static String input;
    Submarine unit = new Submarine();

    String test = """
            forward 5
            down 5
            forward 8
            up 3
            down 8
            forward 2
                """;

    @BeforeAll
    public static void setup() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/navigation2.txt");
        byte[] bytes = fileInputStream.readAllBytes();
        input = new String(bytes);
    }

    @Test
    public void testCruise() {
        assertEquals(unit.cruise(test), 150);
    }

    @Test
    public void testCruise_input() {
        assertEquals(unit.cruise(input), 1815044);
    }


    @Test
    public void testCruiseWithAim() {
        assertEquals(unit.cruiseWithAim(test), 900);
    }

    @Test
    public void testCruiseWithAim_input() {
        assertEquals(unit.cruiseWithAim(input), 1739283308);
    }
}