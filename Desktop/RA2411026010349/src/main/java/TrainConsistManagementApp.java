import java.util.ArrayList;
import java.util.List;

/**
 * Train Consist Management App
 * UC10: Count Total Seats in Train (reduce)
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

        // UC10: Count Total Seats in Train (reduce)
        System.out.println("--- UC10: Count Total Seats in Train (reduce) ---");
        System.out.println();

        // Create a List<Bogie> with bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        bogies.add(new Bogie("First Class", 48));

        // Display all bogies
        System.out.println("Bogies in the train:");
        for (int i = 0; i < bogies.size(); i++) {
            System.out.println((i + 1) + ". " + bogies.get(i));
        }
        System.out.println();

        // Calculate total seats using stream reduce
        System.out.println("Calculating total seating capacity...");
        int totalSeats = bogies.stream()
                .mapToInt(Bogie::getCapacity)
                .sum();
        System.out.println("Total seating capacity: " + totalSeats + " seats");
        System.out.println();

        System.out.println("Key Benefits of Stream reduce:");
        System.out.println("✓ Enables functional aggregation of data");
        System.out.println("✓ Provides quantitative metrics for planning");
        System.out.println("✓ Replaces manual summation loops");
        System.out.println("✓ Improves code readability and safety");
        System.out.println("✓ Builds foundation for advanced analytics");
        System.out.println();

        System.out.println("Program continues...");
    }
}
