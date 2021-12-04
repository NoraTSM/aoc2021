package aoc.three;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryDiagnosticTest {
    private static String input;
    BinaryDiagnostic unit = new BinaryDiagnostic();

    String test = """
            00100
            11110
            10110
            10111
            10101
            01111
            00111
            11100
            10000
            11001
            00010
            01010
            """;

    @BeforeAll
    static void setup() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/3.txt");
        input = new String(fileInputStream.readAllBytes());

    }

    @Test
    void testPower_test() {
        assertEquals(198, unit.power(test));
    }

    @Test
    void testPower_input() {
        assertEquals(2743844, unit.power(input));
    }

    @Test
    void testLifeSupport_test() {
        assertEquals(230, unit.lifeSupportRating(test));
    }

    @Test
    void testLifeSupport_input() {
        assertEquals(6677951, unit.lifeSupportRating(input));
    }


}