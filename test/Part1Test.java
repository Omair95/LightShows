import com.technicalTest.Part1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Part1Test {
    Part1 part1;

    @BeforeEach
    void setUp() {
        part1 = new Part1();
    }

    @Test
    @DisplayName("Test all lights are ON")
    void test_all_lights_on() {
        int[][] lights = new int[1000][1000];
        part1.lightAction(lights, 0, 0, 999, 999, "on");
        assertEquals(1000000, part1.lightsOn);
    }

    @Test
    @DisplayName("Test ON/OFF lights")
    void test_all_lights_on_off() {
        int[][] lights = new int[1000][1000];
        part1.lightAction(lights, 0, 0, 999, 999, "on");
        part1.lightAction(lights, 499, 499, 500, 500, "off");
        assertEquals(999996, part1.lightsOn);
    }

    @Test
    @DisplayName("Test TOGGLE lights")
    void test_all_lights_toggle() {
        int[][] lights = new int[1000][1000];
        part1.lightAction(lights, 0, 0, 999, 999, "on");
        part1.lightAction(lights, 499, 499, 500, 500, "off");
        part1.lightAction(lights, 0, 499, 999, 500, "toggle");
        assertEquals(998004, part1.lightsOn);
    }
}