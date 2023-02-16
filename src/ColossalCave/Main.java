package ColossalCave;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static String userInputConverter(String textLine) {
        String[] textList = textLine.split(" ");
        String output = null;
        for(String i : textList) {
            if(i.equalsIgnoreCase("EAST")) {
                output = "E";
            } else if (i.equalsIgnoreCase("WEST")) {
                output = "W";
            } else if (i.equalsIgnoreCase("NORTH")) {
                output = "N";
            } else if (i.equalsIgnoreCase("SOUTH")) {
                output = "S";
            } else if (i.equalsIgnoreCase("QUIT")) {
                output = "Q";
            }
        }
        return output;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0, "I am sitting",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are in the train",tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "I am sitting or not",tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "I am sitting here",tempExit));


        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "I am sitting there",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "I am sitting and jumping",tempExit));

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if(loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are: ");
            for(String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction  = scanner.nextLine().toUpperCase();

            if (direction.length() > 1) {
                direction = userInputConverter(direction);
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("Cannot go to that direction");
            }
        }
    }
}
