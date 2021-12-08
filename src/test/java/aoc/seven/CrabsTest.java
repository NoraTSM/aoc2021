package aoc.seven;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CrabsTest {

    private static String input;
    Crabs unit = new Crabs();
    String test = "16,1,2,0,4,2,7,1,2,14";

    @BeforeAll
    static void setup() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/7.txt");
        input = new String(fileInputStream.readAllBytes());
    }

    @Test
    void testAlign_test() {
        assertEquals(37L, unit.align(test));
    }

    @Test
    void testAlign_input() {
        assertEquals(328187, unit.align(input));
    }

    @Test
    void testAlignFactorial_test() {
        assertEquals(168L, unit.alignFactorial(test));
    }

    @Test
    void testAlignFactorial_input() {
        assertEquals(91257582L, unit.alignFactorial(input));
    }

    @Test
    void testFactorial_zero() {
        assertEquals(0, unit.factorial(0));
    }

    @Test
    void testFactorial_one() {
        assertEquals(1, unit.factorial(1));
    }

    @Test
    void testFactorial_two() {
        assertEquals(3, unit.factorial(2));
    }

    @Test
    void testFactorial_three() {
        assertEquals(6, unit.factorial(3));
    }

    @Test
    void testFactorial_fiveminus16() {
        assertEquals(66, unit.factorial(Math.abs(5-16)));
    }
}