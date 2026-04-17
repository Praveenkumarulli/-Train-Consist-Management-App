commit 7f7a2bf9a3f9f3206eb95833f586818c985f3cf1
Author: Student Name <student@email.com>
Date:   Wed Apr 1 09:19:55 2026 +0530

    UC10: Count Total Seats in Train (reduce)

diff --git a/Desktop/RA2411026010349/.idea/workspace.xml b/Desktop/RA2411026010349/.idea/workspace.xml
new file mode 100644
index 0000000..ad457d1
--- /dev/null
+++ b/Desktop/RA2411026010349/.idea/workspace.xml
@@ -0,0 +1,47 @@
+<?xml version="1.0" encoding="UTF-8"?>
+<project version="4">
+  <component name="AutoImportSettings">
+    <option name="autoReloadType" value="SELECTIVE" />
+  </component>
+  <component name="ChangeListManager">
+    <list default="true" id="3b5551bf-a0dd-4f3e-932d-82b496146392" name="Changes" comment="" />
+    <option name="SHOW_DIALOG" value="false" />
+    <option name="HIGHLIGHT_CONFLICTS" value="true" />
+    <option name="HIGHLIGHT_NON_ACTIVE_CHANGELIST" value="false" />
+    <option name="LAST_RESOLUTION" value="IGNORE" />
+  </component>
+  <component name="ProjectColorInfo"><![CDATA[{
+  "associatedIndex": 2
+}]]></component>
+  <component name="ProjectId" id="3Bjs8mZPmq14m6PnsoF0sLyFKM1" />
+  <component name="ProjectViewState">
+    <option name="hideEmptyMiddlePackages" value="true" />
+    <option name="showLibraryContents" value="true" />
+  </component>
+  <component name="PropertiesComponent"><![CDATA[{
+  "keyToString": {
+    "ModuleVcsDetector.initialDetectionPerformed": "true",
+    "RunOnceActivity.ShowReadmeOnStart": "true",
+    "ignore.virus.scanning.warn.message": "true",
+    "kotlin-language-version-configured": "true",
+    "last_opened_file_path": "C:/Users/Admin/Desktop/RA2411026010349"
+  }
+}]]></component>
+  <component name="SharedIndexes">
+    <attachedChunks>
+      <set>
+        <option value="bundled-jdk-30f59d01ecdd-2fc7cc6b9a17-intellij.indexing.shared.core-IU-253.31033.145" />
+      </set>
+    </attachedChunks>
+  </component>
+  <component name="TaskManager">
+    <task active="true" id="Default" summary="Default task">
+      <changelist id="3b5551bf-a0dd-4f3e-932d-82b496146392" name="Changes" comment="" />
+      <created>1775013657012</created>
+      <option name="number" value="Default" />
+      <option name="presentableId" value="Default" />
+      <updated>1775013657012</updated>
+    </task>
+    <servers />
+  </component>
+</project>
\ No newline at end of file
diff --git a/Desktop/RA2411026010349/src/main/java/TrainConsistManagementApp.java b/Desktop/RA2411026010349/src/main/java/TrainConsistManagementApp.java
new file mode 100644
index 0000000..71dc0f0
--- /dev/null
+++ b/Desktop/RA2411026010349/src/main/java/TrainConsistManagementApp.java
@@ -0,0 +1,77 @@
+∩╗┐import java.util.ArrayList;
+import java.util.List;
+
+/**
+ * Train Consist Management App
+ * UC10: Count Total Seats in Train (reduce)
+ */
+
+/**
+ * Bogie class to represent a train bogie with name and capacity.
+ */
+class Bogie {
+    private String name;
+    private int capacity;
+
+    public Bogie(String name, int capacity) {
+        this.name = name;
+        this.capacity = capacity;
+    }
+
+    public String getName() {
+        return name;
+    }
+
+    public int getCapacity() {
+        return capacity;
+    }
+
+    @Override
+    public String toString() {
+        return name + " (" + capacity + " seats)";
+    }
+}
+
+public class TrainConsistManagementApp {
+
+    public static void main(String[] args) {
+        // Print welcome message
+        System.out.println("=== Train Consist Management App ===");
+        System.out.println();
+
+        // UC10: Count Total Seats in Train (reduce)
+        System.out.println("--- UC10: Count Total Seats in Train (reduce) ---");
+        System.out.println();
+
+        // Create a List<Bogie> with bogies
+        List<Bogie> bogies = new ArrayList<>();
+        bogies.add(new Bogie("Sleeper", 72));
+        bogies.add(new Bogie("AC Chair", 96));
+        bogies.add(new Bogie("First Class", 48));
+
+        // Display all bogies
+        System.out.println("Bogies in the train:");
+        for (int i = 0; i < bogies.size(); i++) {
+            System.out.println((i + 1) + ". " + bogies.get(i));
+        }
+        System.out.println();
+
+        // Calculate total seats using stream reduce
+        System.out.println("Calculating total seating capacity...");
+        int totalSeats = bogies.stream()
+                .mapToInt(Bogie::getCapacity)
+                .sum();
+        System.out.println("Total seating capacity: " + totalSeats + " seats");
+        System.out.println();
+
+        System.out.println("Key Benefits of Stream reduce:");
+        System.out.println("Γ£ô Enables functional aggregation of data");
+        System.out.println("Γ£ô Provides quantitative metrics for planning");
+        System.out.println("Γ£ô Replaces manual summation loops");
+        System.out.println("Γ£ô Improves code readability and safety");
+        System.out.println("Γ£ô Builds foundation for advanced analytics");
+        System.out.println();
+
+        System.out.println("Program continues...");
+    }
+}
diff --git a/Desktop/RA2411026010349/src/test/java/TrainConsistManagementAppTest.java b/Desktop/RA2411026010349/src/test/java/TrainConsistManagementAppTest.java
new file mode 100644
index 0000000..3e52a5b
--- /dev/null
+++ b/Desktop/RA2411026010349/src/test/java/TrainConsistManagementAppTest.java
@@ -0,0 +1,78 @@
+import org.junit.jupiter.api.Test;
+import java.util.ArrayList;
+import java.util.List;
+import static org.junit.jupiter.api.Assertions.*;
+
+/**
+ * Test class for UC10: Count Total Seats in Train (reduce)
+ */
+public class TrainConsistManagementAppTest {
+
+    // Helper method to create test bogies
+    private List<Bogie> createTestBogies() {
+        List<Bogie> bogies = new ArrayList<>();
+        bogies.add(new Bogie("Sleeper", 72));
+        bogies.add(new Bogie("AC Chair", 96));
+        bogies.add(new Bogie("First Class", 48));
+        return bogies;
+    }
+
+    // Helper method to calculate total seats
+    private int calculateTotalSeats(List<Bogie> bogies) {
+        return bogies.stream()
+                .mapToInt(Bogie::getCapacity)
+                .sum();
+    }
+
+    @Test
+    public void testReduce_TotalSeatCalculation() {
+        List<Bogie> bogies = createTestBogies();
+        int total = calculateTotalSeats(bogies);
+        assertEquals(72 + 96 + 48, total);
+    }
+
+    @Test
+    public void testReduce_MultipleBogiesAggregation() {
+        List<Bogie> bogies = createTestBogies();
+        int total = calculateTotalSeats(bogies);
+        assertEquals(216, total);
+    }
+
+    @Test
+    public void testReduce_SingleBogieCapacity() {
+        List<Bogie> bogies = new ArrayList<>();
+        bogies.add(new Bogie("Sleeper", 72));
+        int total = calculateTotalSeats(bogies);
+        assertEquals(72, total);
+    }
+
+    @Test
+    public void testReduce_EmptyBogieList() {
+        List<Bogie> bogies = new ArrayList<>();
+        int total = calculateTotalSeats(bogies);
+        assertEquals(0, total);
+    }
+
+    @Test
+    public void testReduce_CorrectCapacityExtraction() {
+        List<Bogie> bogies = createTestBogies();
+        // Assuming mapToInt extracts correctly, as tested in total calculation
+        int total = calculateTotalSeats(bogies);
+        assertEquals(216, total);
+    }
+
+    @Test
+    public void testReduce_AllBogiesIncluded() {
+        List<Bogie> bogies = createTestBogies();
+        int total = calculateTotalSeats(bogies);
+        assertEquals(216, total); // All three included
+    }
+
+    @Test
+    public void testReduce_OriginalListUnchanged() {
+        List<Bogie> bogies = createTestBogies();
+        List<Bogie> original = new ArrayList<>(bogies);
+        calculateTotalSeats(bogies);
+        assertEquals(original, bogies);
+    }
+}
\ No newline at end of file
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
