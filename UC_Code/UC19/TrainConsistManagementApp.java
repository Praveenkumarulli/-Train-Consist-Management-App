commit 94db689477111401e66ad9a30cf3e7d30a85ccb5
Author: asishvemparala11 <asishvemparala@gmail.com>
Date:   Fri Apr 17 10:42:10 2026 +0530

    Cleanup: Remove legacy UCs from UC19 branch

diff --git a/Desktop/RA2411026010349/src/main/java/TrainConsistManagementApp.java b/Desktop/RA2411026010349/src/main/java/TrainConsistManagementApp.java
deleted file mode 100644
index e873397..0000000
--- a/Desktop/RA2411026010349/src/main/java/TrainConsistManagementApp.java
+++ /dev/null
@@ -1,94 +0,0 @@
-∩╗┐import java.util.ArrayList;
-import java.util.Comparator;
-import java.util.List;
-
-/**
- * Train Consist Management App
- * UC7: Sort Bogies by Capacity (Comparator)
- */
-
-/**
- * Bogie class to represent a train bogie with name and capacity.
- */
-class Bogie {
-    private String name;
-    private int capacity;
-
-    public Bogie(String name, int capacity) {
-        this.name = name;
-        this.capacity = capacity;
-    }
-
-    public String getName() {
-        return name;
-    }
-
-    public int getCapacity() {
-        return capacity;
-    }
-
-    @Override
-    public String toString() {
-        return name + " (" + capacity + " seats)";
-    }
-}
-
-public class TrainConsistManagementApp {
-
-    public static void main(String[] args) {
-        // Print welcome message
-        System.out.println("=== Train Consist Management App ===");
-        System.out.println();
-
-        // UC7: Sort Bogies by Capacity (Comparator)
-        System.out.println("--- UC7: Sort Bogies by Capacity (Comparator) ---");
-        System.out.println();
-
-        // Create a List<Bogie> to store passenger bogies
-        List<Bogie> bogies = new ArrayList<>();
-
-        // Add bogies with their capacities
-        System.out.println("Creating passenger bogie objects...");
-        bogies.add(new Bogie("Sleeper", 72));
-        System.out.println("Added: Sleeper with 72 seats");
-        bogies.add(new Bogie("AC Chair", 96));
-        System.out.println("Added: AC Chair with 96 seats");
-        bogies.add(new Bogie("First Class", 48));
-        System.out.println("Added: First Class with 48 seats");
-        System.out.println();
-
-        // Display bogies before sorting
-        System.out.println("Bogies before sorting (insertion order):");
-        int count = 1;
-        for (Bogie bogie : bogies) {
-            System.out.println(count + ". " + bogie);
-            count++;
-        }
-        System.out.println();
-
-        // Sort the list using Comparator.comparingInt()
-        System.out.println("Sorting bogies by seating capacity...");
-        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));
-        System.out.println("Sorting completed.");
-        System.out.println();
-
-        // Display bogies after sorting
-        System.out.println("Bogies after sorting by capacity (ascending):");
-        count = 1;
-        for (Bogie bogie : bogies) {
-            System.out.println(count + ". " + bogie);
-            count++;
-        }
-        System.out.println();
-
-        System.out.println("Key Benefits of Comparator:");
-        System.out.println("Γ£ô Introduces object-based collection handling");
-        System.out.println("Γ£ô Enables custom sorting based on business rules");
-        System.out.println("Γ£ô Improves train planning and capacity analysis");
-        System.out.println("Γ£ô Demonstrates separation of data and logic");
-        System.out.println("Γ£ô Prepares for enterprise-level sorting operations");
-        System.out.println();
-
-        System.out.println("Program continues...");
-    }
-}
diff --git a/Desktop/RA2411026010349/src/main/java/UC18_LinearSearch.java b/Desktop/RA2411026010349/src/main/java/UC18_LinearSearch.java
deleted file mode 100644
index 11f0dbf..0000000
--- a/Desktop/RA2411026010349/src/main/java/UC18_LinearSearch.java
+++ /dev/null
@@ -1,41 +0,0 @@
-public class UC18_LinearSearch {
-    
-    /**
-     * Performs a linear search to find a bogie ID in an unsorted array.
-     * 
-     * @param bogies    Array of bogie IDs
-     * @param searchKey The ID to search for
-     * @return true if the bogie exists, false otherwise
-     */
-    public static boolean searchBogie(String[] bogies, String searchKey) {
-        if (bogies == null || searchKey == null) {
-            return false;
-        }
-
-        // Sequentially traverse the array
-        for (String bogie : bogies) {
-            // Equality comparison
-            if (bogie != null && bogie.equals(searchKey)) {
-                // Match found, search stops (Early Termination)
-                return true; 
-            }
-        }
-        
-        // Traversed entire array, match not found
-        return false;
-    }
-
-    public static void main(String[] args) {
-        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
-        String searchKey = "BG309";
-
-        System.out.println("Searching for bogie ID: " + searchKey);
-        
-        boolean found = searchBogie(bogies, searchKey);
-        if (found) {
-            System.out.println("Result: Bogie " + searchKey + " exists in the consist.");
-        } else {
-            System.out.println("Result: Bogie " + searchKey + " was NOT found in the consist.");
-        }
-    }
-}
diff --git a/Desktop/RA2411026010349/src/test/java/TrainConsistManagementAppTest.java b/Desktop/RA2411026010349/src/test/java/TrainConsistManagementAppTest.java
deleted file mode 100644
index cbf340a..0000000
--- a/Desktop/RA2411026010349/src/test/java/TrainConsistManagementAppTest.java
+++ /dev/null
@@ -1,2 +0,0 @@
-// Placeholder for JUnit tests - UC7: Comparator sorting
-// No specific tests implemented yet
\ No newline at end of file
diff --git a/Desktop/RA2411026010349/src/test/java/UC18_LinearSearchTest.java b/Desktop/RA2411026010349/src/test/java/UC18_LinearSearchTest.java
deleted file mode 100644
index f65a409..0000000
--- a/Desktop/RA2411026010349/src/test/java/UC18_LinearSearchTest.java
+++ /dev/null
@@ -1,35 +0,0 @@
-import org.junit.jupiter.api.Test;
-import static org.junit.jupiter.api.Assertions.*;
-
-public class UC18_LinearSearchTest {
-
-    @Test
-    void testSearch_BogieFound() {
-        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
-        assertTrue(UC18_LinearSearch.searchBogie(bogies, "BG309"), "Should return true for found bogie");
-    }
-
-    @Test
-    void testSearch_BogieNotFound() {
-        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
-        assertFalse(UC18_LinearSearch.searchBogie(bogies, "BG999"), "Should return false for non-existent bogie");
-    }
-
-    @Test
-    void testSearch_FirstElementMatch() {
-        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
-        assertTrue(UC18_LinearSearch.searchBogie(bogies, "BG101"), "Should return true for first element match");
-    }
-
-    @Test
-    void testSearch_LastElementMatch() {
-        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
-        assertTrue(UC18_LinearSearch.searchBogie(bogies, "BG550"), "Should return true for last element match");
-    }
-
-    @Test
-    void testSearch_SingleElementArray() {
-        String[] bogies = {"BG101"};
-        assertTrue(UC18_LinearSearch.searchBogie(bogies, "BG101"), "Should return true for single element match");
-    }
-}
∩╗┐import java.util.ArrayList;
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
        System.out.println("Γ£ô Enables functional aggregation of data");
        System.out.println("Γ£ô Provides quantitative metrics for planning");
        System.out.println("Γ£ô Replaces manual summation loops");
        System.out.println("Γ£ô Improves code readability and safety");
        System.out.println("Γ£ô Builds foundation for advanced analytics");
        System.out.println();

        System.out.println("Program continues...");
    }
}
