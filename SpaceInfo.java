/****************************************************************************
 * SpaceInfo
 ****************************************************************************
 * Project description
 * Provides information on planets such as surface area, diameter, and distance from Earth in various scales.
 * Jeffrey Stanley
 * Final Version date: March 7th, 2020
 * CMSC 255 Section 3
 ****************************************************************************/

import java.util.Scanner;


public class SpaceInfo {

    /***************
     * Set up main method
     * have it call processInput() method
     **************/
    public static void main(String[] args) {
        processInput();
    }

    /***************
     * Set up processInput method
     * set up while loop to terminate if "quit" is entered at end of program
     * set up if statement that is executed if verifyPlanet() returns true
     * incase of verifyPlanet() returning a "False" value, system should output the appropriate messages
     * after if statement is valid, have system call remaining methods
     * once all methods have been called and returned their values, the system must output the results while rounded to 2 decimals and commas
     * finally, ask user if they want to input another planet name
     **************/
    public static void processInput() {
        boolean quit = false;
        Scanner input = new Scanner(System.in);
        while (quit == false) {
            System.out.println("Enter the planet:");
            String planet = input.nextLine().trim();
            if (verifyPlanet(planet) == true) {
                double diameter = getDiameter(planet);
                double surfaceArea = calcSurfaceArea(diameter);
                long distance = getDistance(planet);
                System.out.println("Enter the scale you want displayed:");
                String scale = input.nextLine().trim();
                double convertedDistance = convertDistance(distance, scale);
                System.out.printf(planet + " has a surface area of: " + "%,.2f\n", surfaceArea);
                System.out.printf(planet + " is " + "%,.2f" + " " + scale + " from Earth\n", convertedDistance);
            } else {
                System.out.println("Please enter a valid planet name");
            }
            System.out.println("Would you like to enter another planet? Enter quit to exit.");
            String response = input.nextLine().trim().toLowerCase();
            if (response.equals("quit")) {
                quit = true;
            }
        }
    }

    /***************
     * set up verifyMethod() to check if planet input is valid
     **************/
    public static boolean verifyPlanet(String planet) {
        if (planet.equals("Mercury")) {
            return true;
        } else if (planet.equals("Venus")) {
            return true;
        } else if (planet.equals("Earth")) {
            return true;
        } else if (planet.equals("Mars")) {
            return true;
        } else if (planet.equals("Jupiter")) {
            return true;
        } else if (planet.equals("Saturn")) {
            return true;
        } else if (planet.equals("Uranus")) {
            return true;
        } else if (planet.equals("Neptune")) {
            return true;
        } else {
            //System.out.println("Please enter a valid planet name");
            return false;
        }
    }

    /***************
     * Set up method that returns planet's diameter in miles
     **************/
    public static double getDiameter(String planet) {
        double[] getDiameter = {3031.9, 7520.8, 7917.5, 4212.3, 86881.0, 72367.0, 31518.0, 30599.0};
        double diameter = 0.0;
        if (planet.equals("Mercury")) {
            diameter = getDiameter[0];
        } else if (planet.equals("Venus")) {
            diameter = getDiameter[1];
        } else if (planet.equals("Earth")) {
            diameter = getDiameter[2];
        } else if (planet.equals("Mars")) {
            diameter = getDiameter[3];
        } else if (planet.equals("Jupiter")) {
            diameter = getDiameter[4];
        } else if (planet.equals("Saturn")) {
            diameter = getDiameter[5];
        } else if (planet.equals("Uranus")) {
            diameter = getDiameter[6];
        } else if (planet.equals("Neptune")) {
            diameter = getDiameter[7];
        } else {
            diameter = -1.0;
        }
        return diameter;
    }

    /***************
     * set up method to return planet's surface area in miles
     **************/
    public static double calcSurfaceArea(double diameter) {
        final double RADIUS = (diameter / 2);
        double surfaceArea = (4 * Math.PI * RADIUS * RADIUS);
        return surfaceArea;
    }

    /***************
     *set up method that returns planet's distance from earth in miles
     **************/
    public static long getDistance(String planet) {
        long[] planetDistance = {56974146L, 25724767L, 0L, 78340000L, 628730000L, 1275000000L, 2723950000L, 4351400000L};
        long distance = 0L;
        if (planet.equals("Mercury")) {
            distance = planetDistance[0];
        } else if (planet.equals("Venus")) {
            distance = planetDistance[1];
        } else if (planet.equals("Earth")) {
            distance = planetDistance[2];
        } else if (planet.equals("Mars")) {
            distance = planetDistance[3];
        } else if (planet.equals("Jupiter")) {
            distance = planetDistance[4];
        } else if (planet.equals("Saturn")) {
            distance = planetDistance[5];
        } else if (planet.equals("Uranus")) {
            distance = planetDistance[6];
        } else if (planet.equals("Neptune")) {
            distance = planetDistance[7];
        } else {
            distance = -1;
        }
        return distance;
    }

    /***************
     * set up method to convert distance into kilometers, meters, or yards
     **************/
    public static double convertDistance(long distance, String scale) {
        final double DISTANCE_KILO = (distance * 1.60934);
        final double DISTANCE_METERS = (distance * 1609.34);
        final double DISTANCE_YARDS = (distance * 1760);
        double convertedDistance;
        if (scale.equals("Kilometers")) {
            convertedDistance = DISTANCE_KILO;
        } else if (scale.equals("Meters")) {
            convertedDistance = DISTANCE_METERS;
        } else if (scale.equals("Yards")) {
            convertedDistance = DISTANCE_YARDS;
        } else if (scale.equals("Miles")) {
            convertedDistance = distance;
        } else {
            convertedDistance = 0.0;
        }
        return convertedDistance;
    }

}
