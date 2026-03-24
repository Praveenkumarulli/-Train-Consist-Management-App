import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Train Consist Management App
 * UC1: Initialize Train and Display Consist Summary
 * UC2: Add Passenger Bogies to Train (ArrayList Operations)
 * UC3: Track Unique Bogie IDs (Set – HashSet)
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Print welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println();

        // UC1: Initialize an empty List using ArrayList to store bogies
        List<String> passengerBogies = new ArrayList<>();

        // Display the initial bogie count
        System.out.println("Train consist initialized successfully.");
        System.out.println("Initial bogie count: " + passengerBogies.size());
        System.out.println();

        // UC2: Add Passenger Bogies to Train (ArrayList Operations)
        System.out.println("--- UC2: Adding Passenger Bogies ---");
        System.out.println();

        // Add bogies: Sleeper, AC Chair, First Class
        System.out.println("Adding passenger bogies...");
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");
        System.out.println("Bogies added successfully.");
        System.out.println();

        // Print the list after insertion
        System.out.println("Current passenger bogies in train:");
        for (int i = 0; i < passengerBogies.size(); i++) {
            System.out.println((i + 1) + ". " + passengerBogies.get(i));
        }
        System.out.println("Total bogies: " + passengerBogies.size());
        System.out.println();

        // Remove one bogie (for example AC Chair)
        System.out.println("Removing AC Chair bogie...");
        passengerBogies.remove("AC Chair");
        System.out.println("AC Chair removed successfully.");
        System.out.println();

        // Print the list after removal
        System.out.println("Updated passenger bogies in train:");
        for (int i = 0; i < passengerBogies.size(); i++) {
            System.out.println((i + 1) + ". " + passengerBogies.get(i));
        }
        System.out.println("Total bogies: " + passengerBogies.size());
        System.out.println();

        // Use contains() to check if Sleeper exists
        System.out.println("Checking if Sleeper bogie exists...");
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("✓ Sleeper bogie exists in the consist.");
        } else {
            System.out.println("✗ Sleeper bogie does not exist in the consist.");
        }
        System.out.println();

        // Print final list state
        System.out.println("Final Train Consist Summary:");
        System.out.println("Total passenger bogies: " + passengerBogies.size());
        System.out.println("Composition: " + passengerBogies.toString());
        System.out.println();

        // UC3: Track Unique Bogie IDs (Set – HashSet)
        System.out.println("--- UC3: Track Unique Bogie IDs (HashSet) ---");
        System.out.println();

        // Create a HashSet<String> for bogie IDs
        Set<String> bogieIDs = new HashSet<>();

        // Add duplicate values intentionally to show deduplication
        System.out.println("Adding bogie IDs (including duplicates)...");
        bogieIDs.add("BG101");
        System.out.println("Added: BG101");
        bogieIDs.add("BG102");
        System.out.println("Added: BG102");
        bogieIDs.add("BG103");
        System.out.println("Added: BG103");
        bogieIDs.add("BG101");  // Duplicate - will be ignored
        System.out.println("Attempted to add: BG101 (duplicate)");
        bogieIDs.add("BG102");  // Duplicate - will be ignored
        System.out.println("Attempted to add: BG102 (duplicate)");
        bogieIDs.add("BG104");
        System.out.println("Added: BG104");
        System.out.println();

        // Print the final set (observe that duplicates are removed automatically)
        System.out.println("Unique bogie IDs in train (after automatic deduplication):");
        System.out.println("IDs: " + bogieIDs.toString());
        System.out.println("Total unique bogies: " + bogieIDs.size());
        System.out.println();

        // Display each unique ID
        System.out.println("Listing all unique bogie IDs:");
        int count = 1;
        for (String id : bogieIDs) {
            System.out.println(count + ". " + id);
            count++;
        }
        System.out.println();

        // Demonstrate membership checking
        System.out.println("Checking bogie ID existence:");
        String testID = "BG102";
        if (bogieIDs.contains(testID)) {
            System.out.println("✓ " + testID + " exists in the consist.");
        } else {
            System.out.println("✗ " + testID + " does not exist in the consist.");
        }
        System.out.println();

        System.out.println("Key Benefits of HashSet:");
        System.out.println("✓ Enforces business constraints (no duplicate IDs)");
        System.out.println("✓ Prevents data corruption");
        System.out.println("✓ Automatic deduplication without manual checks");
        System.out.println("✓ Fast lookup using hashing");
        System.out.println();

        System.out.println("Program continues...");
    }
}
