import java.util.ArrayList;
import java.util.List;

/**
 * Train Consist Management App
 * UC14: Handle Invalid Bogie Capacity (Custom Exception)
 */

/**
 * Custom exception for invalid bogie capacity.
 */
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

/**
 * Bogie class to represent a train bogie with name and capacity.
 */
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
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

        // UC14: Handle Invalid Bogie Capacity (Custom Exception)
        System.out.println("--- UC14: Handle Invalid Bogie Capacity (Custom Exception) ---");
        System.out.println();

        List<Bogie> validBogies = new ArrayList<>();

        // Test valid bogie creation
        try {
            Bogie sleeper = new Bogie("Sleeper", 72);
            validBogies.add(sleeper);
            System.out.println("✓ Created valid bogie: " + sleeper);
        } catch (InvalidCapacityException e) {
            System.out.println("✗ Unexpected error: " + e.getMessage());
        }

        // Test invalid bogie creation (negative capacity)
        try {
            Bogie invalidBogie = new Bogie("Invalid", -10);
            System.out.println("✗ This should not print: " + invalidBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("✓ Caught invalid capacity: " + e.getMessage());
        }

        // Test invalid bogie creation (zero capacity)
        try {
            Bogie zeroBogie = new Bogie("Zero", 0);
            System.out.println("✗ This should not print: " + zeroBogie);
        } catch (InvalidCapacityException e) {
            System.out.println("✓ Caught invalid capacity: " + e.getMessage());
        }

        // Test another valid bogie
        try {
            Bogie acChair = new Bogie("AC Chair", 96);
            validBogies.add(acChair);
            System.out.println("✓ Created valid bogie: " + acChair);
        } catch (InvalidCapacityException e) {
            System.out.println("✗ Unexpected error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Valid bogies created: " + validBogies.size());
        for (Bogie b : validBogies) {
            System.out.println("- " + b);
        }
        System.out.println();

        System.out.println("Key Benefits of Custom Exceptions:");
        System.out.println("✓ Enforces business rules at object creation");
        System.out.println("✓ Prevents invalid data from entering the system");
        System.out.println("✓ Provides clear error messages");
        System.out.println("✓ Encourages fail-fast validation");
        System.out.println("✓ Improves system reliability");
        System.out.println();

        System.out.println("Program continues...");
    }
}
