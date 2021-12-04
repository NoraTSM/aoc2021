package aoc.two;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    static void setup() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/2.txt");
        input = new String(fileInputStream.readAllBytes());
    }

    @Test
    void testCruise() {
        assertEquals(150, unit.cruise(test));
    }

    @Test
    void testCruise_input() {
        assertEquals(1815044, unit.cruise(input));
    }

    @Test
    void testCruiseWithAim() {
        assertEquals(900, unit.cruiseWithAim(test));
    }

    @Test
    void testCruiseWithAim_input() {
        assertEquals(1739283308, unit.cruiseWithAim(input));
    }
}