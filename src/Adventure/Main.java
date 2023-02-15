package Adventure;

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

        locations.put(0, new Location(0, "I am sitting"));
        locations.put(1, new Location(1, "You are in the train"));
        locations.put(2, new Location(2, "I am sitting or not"));
        locations.put(3, new Location(3, "I am sitting here"));
        locations.put(4, new Location(4, "I am sitting there"));
        locations.put(5, new Location(5, "I am sitting and jumping"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

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
