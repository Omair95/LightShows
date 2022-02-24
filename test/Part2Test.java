import com.technicalTest.Part2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Part2Test {
    Part2 part2;

    @BeforeEach
    void setUp() {
        part2 = new Part2();
    }

    @Test
    @DisplayName("Test all lights are ON")
    void test_all_lights_on() {
        int[][] lights = new int[1000][1000];
        part2.lightAction(lights, 0, 0, 999, 999, "on");
        assertEquals(1000000, part2.lightsOn);
    }

    @Test
    @DisplayName("Test ON/OFF lights")
    void test_all_lights_on_off() {
        int[][] lights = new int[1000][1000];
        part2.lightAction(lights, 0, 0, 999, 999, "on");
        part2.lightAction(lights, 499, 499, 500, 500, "off");
        assertEquals(999996, part2.lightsOn);
    }

    @Test
    @DisplayName("Test TOGGLE lights")
    void test_all_lights_toggle() {
        int[][] lights = new int[1000][1000];
        part2.lightAction(lights, 0, 0, 999, 999, "on");
        part2.lightAction(lights, 499, 499, 500, 500, "off");
        part2.lightAction(lights, 0, 499, 999, 500, "toggle");
        assertEquals(1003996, part2.lightsOn);
    }
}