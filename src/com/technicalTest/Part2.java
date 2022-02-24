package com.technicalTest;

public class Part2 {

    public static int lightsOn = 0;

    // (a, b) and (c, d) coordinates
    // action "on", "off" or "toggle"
    public static void lightAction(int[][] lights, int a, int b, int c, int d, String action) {
        for (int i = a; i <= c; ++i) {
            for (int j = b; j <= d; ++j) {
                if (action.equals("on")) {
                    ++lights[i][j];
                    ++lightsOn;
                } else if (action.equals("off")) {
                    --lights[i][j];
                    if (lights[i][j] < 0) lights[i][j] = 0;
                    --lightsOn;
                } else if (action.equals("toggle")) {
                    lights[i][j] = lights[i][j] + 2;
                    lightsOn = lightsOn + 2;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] lights = new int[1000][1000];

        lightAction(lights, 0, 0, 999, 999, "on");
        System.out.println("Number of lights ON = " + lightsOn);

        lightAction(lights, 499, 499, 500, 500, "off");
        System.out.println("Number of lights ON = " + lightsOn);

        lightAction(lights, 0, 499, 999, 500, "toggle");
        System.out.println("Number of lights ON = " + lightsOn);
    }
}
