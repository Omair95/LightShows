package com.technicalTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part1 {

    public static int lightsOn = 0;

    // (a, b) and (c, d) coordinates
    // action "on", "off" or "toggle"
    public static void lightAction(int[][] lights, int a, int b, int c, int d, String action) {
        for (int i = a; i <= c; ++i) {
            for (int j = b; j <= d; ++j) {
                if (action.equals("on")) {
                    if (lights[i][j] == 0) {
                        lights[i][j] = 1;
                        ++lightsOn;
                    }
                } else if (action.equals("off")) {
                    if (lights[i][j] == 1) {
                        lights[i][j] = 0;
                        --lightsOn;
                    }
                } else if (action.equals("toggle")) {
                    if (lights[i][j] == 1) {
                        lights[i][j] = 0;
                        --lightsOn;
                    } else if (lights[i][j] == 0){
                        lights[i][j] = 1;
                        ++lightsOn;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] lights = new int[1000][1000];

        try {
            File myObj = new File("resources/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Scanner coordinates = new Scanner(data).useDelimiter("\\D+");
                String action = null;

                if (data.contains("on")) action = "on";
                else if (data.contains("off")) action = "off";
                else if (data.contains("toggle")) action = "toggle";

                int a = coordinates.nextInt();
                int b = coordinates.nextInt();
                int c = coordinates.nextInt();
                int d = coordinates.nextInt();

                lightAction(lights, a, b, c, d, action);
                System.out.println("Number of lights ON = " + lightsOn);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
