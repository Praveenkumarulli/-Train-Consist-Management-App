import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Train Consist Management App
 * UC1: Initialize Train and Display Consist Summary
 * UC2: Add Passenger Bogies to Train (ArrayList Operations)
 * UC3: Track Unique Bogie IDs (Set – HashSet)
 * UC4: Maintain Ordered Bogie IDs (LinkedList)
 * UC5: Preserve Insertion Order of Bogies (LinkedHashSet)
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

        // UC4: Maintain Ordered Bogie IDs (LinkedList)
        System.out.println("--- UC4: Maintain Ordered Bogie IDs (LinkedList) ---");
        System.out.println();

        // Create a LinkedList<String> for the consist
        LinkedList<String> trainConsist = new LinkedList<>();

        // Add bogies: Engine, Sleeper, AC, Cargo, Guard
        System.out.println("Building train consist with LinkedList...");
        trainConsist.addLast("Engine");
        trainConsist.addLast("Sleeper");
        trainConsist.addLast("AC");
        trainConsist.addLast("Cargo");
        trainConsist.addLast("Guard");
        System.out.println("Initial consist added successfully.");
        System.out.println();

        // Display the consist before modification
        System.out.println("Initial Train Consist (in order):");
        for (int i = 0; i < trainConsist.size(); i++) {
            System.out.println((i + 1) + ". " + trainConsist.get(i));
        }
        System.out.println("Total bogies: " + trainConsist.size());
        System.out.println();

        // Insert a Pantry Car at position 2 (between Sleeper and AC)
        System.out.println("Inserting Pantry Car at position 2...");
        trainConsist.add(2, "Pantry Car");
        System.out.println("Pantry Car inserted successfully.");
        System.out.println();

        // Display the consist after insertion
        System.out.println("Train Consist after insertion:");
        for (int i = 0; i < trainConsist.size(); i++) {
            System.out.println((i + 1) + ". " + trainConsist.get(i));
        }
        System.out.println("Total bogies: " + trainConsist.size());
        System.out.println();

        // Remove the first and last bogie
        System.out.println("Removing first bogie (Engine)...");
        String removedFirst = trainConsist.removeFirst();
        System.out.println("Removed: " + removedFirst);
        System.out.println();

        System.out.println("Removing last bogie (Guard)...");
        String removedLast = trainConsist.removeLast();
        System.out.println("Removed: " + removedLast);
        System.out.println();

        // Display the final ordered train consist
        System.out.println("Final Train Consist (after removals):");
        for (int i = 0; i < trainConsist.size(); i++) {
            System.out.println((i + 1) + ". " + trainConsist.get(i));
        }
        System.out.println("Total bogies: " + trainConsist.size());
        System.out.println();

        System.out.println("Key Benefits of LinkedList:");
        System.out.println("✓ Models real-world chaining behavior (node-based structure)");
        System.out.println("✓ Efficient insertion and deletion at head/tail O(1)");
        System.out.println("✓ Maintains insertion order (physical train sequence)");
        System.out.println("✓ Better than ArrayList for frequent insertions/deletions");
        System.out.println();

        // UC5: Preserve Insertion Order of Bogies (LinkedHashSet)
        System.out.println("--- UC5: Preserve Insertion Order with LinkedHashSet ---");
        System.out.println();

        // Create a LinkedHashSet<String> to represent the train formation
        Set<String> trainFormation = new LinkedHashSet<>();

        // Attach bogies: Engine, Sleeper, Cargo, Guard
        System.out.println("Attaching bogies to train formation...");
        trainFormation.add("Engine");
        System.out.println("Added: Engine");
        trainFormation.add("Sleeper");
        System.out.println("Added: Sleeper");
        trainFormation.add("Cargo");
        System.out.println("Added: Cargo");
        trainFormation.add("Guard");
        System.out.println("Added: Guard");
        System.out.println();

        // Attempt to attach a duplicate bogie intentionally (Sleeper again)
        System.out.println("Attempting to attach duplicate bogie (Sleeper)...");
        boolean sleeper_duplicate = trainFormation.add("Sleeper");
        if (!sleeper_duplicate) {
            System.out.println("Notice: Sleeper not added (duplicate ignored - auto-deduplication by LinkedHashSet)");
        }
        System.out.println();

        // Attempt another duplicate
        System.out.println("Attempting to attach another duplicate bogie (Cargo)...");
        boolean cargo_duplicate = trainFormation.add("Cargo");
        if (!cargo_duplicate) {
            System.out.println("Notice: Cargo not added (duplicate ignored - auto-deduplication by LinkedHashSet)");
        }
        System.out.println();

        // Display the final formation order using System.out.println()
        System.out.println("Final Train Formation (maintaining insertion order with uniqueness):");
        int position = 1;
        for (String bogie : trainFormation) {
            System.out.println(position + ". " + bogie);
            position++;
        }
        System.out.println("Total unique bogies: " + trainFormation.size());
        System.out.println();

        // Display key characteristics
        System.out.println("Formation Details:");
        System.out.println("- Original order preserved: Engine -> Sleeper -> Cargo -> Guard");
        System.out.println("- Duplicate attempts rejected: 2 attempted duplicates (Sleeper, Cargo)");
        System.out.println("- Final composition: " + trainFormation.toString());
        System.out.println();

        System.out.println("Key Benefits of LinkedHashSet:");
        System.out.println("✓ Enforces real-world business rules (no duplicate bogies)");
        System.out.println("✓ Preserves physical attachment sequence of the train");
        System.out.println("✓ Combines ordering with uniqueness (SetInterface)");
        System.out.println("✓ Better than HashSet for maintaining insertion order");
        System.out.println("✓ Better than List for enforcing uniqueness");
        System.out.println("✓ Predictable train composition logic");
        System.out.println();

        System.out.println("Program continues...");
    }
}
