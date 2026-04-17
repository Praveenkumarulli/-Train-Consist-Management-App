import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Train Consist Management App
 * UC7: Sort Bogies by Capacity (Comparator)
 */

/**
 * Bogie class to represent a train bogie with name and capacity.
 */
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Print welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println();

        // UC7: Sort Bogies by Capacity (Comparator)
        System.out.println("--- UC7: Sort Bogies by Capacity (Comparator) ---");
        System.out.println();

        // Create a List<Bogie> to store passenger bogies
        List<Bogie> bogies = new ArrayList<>();

        // Add bogies with their capacities
        System.out.println("Creating passenger bogie objects...");
        bogies.add(new Bogie("Sleeper", 72));
        System.out.println("Added: Sleeper with 72 seats");
        bogies.add(new Bogie("AC Chair", 96));
        System.out.println("Added: AC Chair with 96 seats");
        bogies.add(new Bogie("First Class", 48));
        System.out.println("Added: First Class with 48 seats");
        System.out.println();

        // Display bogies before sorting
        System.out.println("Bogies before sorting (insertion order):");
        int count = 1;
        for (Bogie bogie : bogies) {
            System.out.println(count + ". " + bogie);
            count++;
        }
        System.out.println();

        // Sort the list using Comparator.comparingInt()
        System.out.println("Sorting bogies by seating capacity...");
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));
        System.out.println("Sorting completed.");
        System.out.println();

        // Display bogies after sorting
        System.out.println("Bogies after sorting by capacity (ascending):");
        count = 1;
        for (Bogie bogie : bogies) {
            System.out.println(count + ". " + bogie);
            count++;
        }
        System.out.println();

        System.out.println("Key Benefits of Comparator:");
        System.out.println("✓ Introduces object-based collection handling");
        System.out.println("✓ Enables custom sorting based on business rules");
        System.out.println("✓ Improves train planning and capacity analysis");
        System.out.println("✓ Demonstrates separation of data and logic");
        System.out.println("✓ Prepares for enterprise-level sorting operations");
        System.out.println();

        System.out.println("Program continues...");
    }
}
