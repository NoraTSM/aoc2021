package aoc.six;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LanternfishTest {

    private static String input;
    Lanternfish unit = new Lanternfish();
    String test = "3,4,3,1,2";

    @BeforeAll
    static void setup() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/6.txt");
        input = new String(fileInputStream.readAllBytes());
    }

    @Test
    void testPopulate_test() {
        assertEquals(5934, unit.populate(80, test));
    }

    @Test
    void testPopulate_input() {
        assertEquals(380758, unit.populate(80, input));
    }



}