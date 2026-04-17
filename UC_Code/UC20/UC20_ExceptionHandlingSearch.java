commit 651aecd7a75660f353bc0eee356bcf09b767dc6d
Author: asishvemparala11 <asishvemparala@gmail.com>
Date:   Fri Apr 17 10:45:03 2026 +0530

    UC20: Add Exception Handling During Search Operations

diff --git a/Desktop/RA2411026010349/src/main/java/UC19_BinarySearch.java b/Desktop/RA2411026010349/src/main/java/UC19_BinarySearch.java
deleted file mode 100644
index 4e82f2e..0000000
--- a/Desktop/RA2411026010349/src/main/java/UC19_BinarySearch.java
+++ /dev/null
@@ -1,65 +0,0 @@
-import java.util.Arrays;
-
-public class UC19_BinarySearch {
-    
-    /**
-     * Performs a binary search to find a bogie ID efficiently in an array.
-     * Ensure the array is sorted before searching as per Binary Search preconditions.
-     * 
-     * @param bogies    Array of bogie IDs
-     * @param searchKey The ID to search for
-     * @return true if the bogie exists, false otherwise
-     */
-    public static boolean searchBogie(String[] bogies, String searchKey) {
-        // Empty Array Handling & null checks
-        if (bogies == null || bogies.length == 0 || searchKey == null) {
-            return false;
-        }
-
-        // Unsorted Input Handling: 
-        // Ensure data is sorted before applying Binary Search
-        String[] sortedBogies = bogies.clone();
-        Arrays.sort(sortedBogies);
-
-        // Initialize low and high indexes
-        int low = 0;
-        int high = sortedBogies.length - 1;
-
-        // Steps repeat until found or exhausted
-        while (low <= high) {
-            // Compute mid index correctly
-            int mid = low + (high - low) / 2;
-            
-            // Compare key with mid element using compareTo()
-            int comparison = searchKey.compareTo(sortedBogies[mid]);
-            
-            if (comparison == 0) {
-                // Match found
-                return true; 
-            } else if (comparison < 0) {
-                // Adjust search range accordingly: Key is in the left half
-                high = mid - 1;
-            } else {
-                // Adjust search range accordingly: Key is in the right half
-                low = mid + 1;
-            }
-        }
-        
-        // Match not found
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
diff --git a/Desktop/RA2411026010349/src/main/java/UC20_ExceptionHandlingSearch.java b/Desktop/RA2411026010349/src/main/java/UC20_ExceptionHandlingSearch.java
new file mode 100644
index 0000000..4464a3c
--- /dev/null
+++ b/Desktop/RA2411026010349/src/main/java/UC20_ExceptionHandlingSearch.java
@@ -0,0 +1,48 @@
+public class UC20_ExceptionHandlingSearch {
+    
+    /**
+     * Searches for a bogie ID with defensive fail-fast programming.
+     * 
+     * @param bogies    Array of bogie IDs
+     * @param searchKey The ID to search for
+     * @return true if the bogie exists, false otherwise
+     * @throws IllegalStateException if the bogie collection is empty
+     */
+    public static boolean searchBogie(String[] bogies, String searchKey) {
+        // State Validation: Defensive Programming
+        // Fail-Fast Behavior: Check whether the bogie collection is empty before searching
+        if (bogies == null || bogies.length == 0) {
+            throw new IllegalStateException("Cannot perform search: Train consist has no bogies.");
+        }
+
+        // Basic search logic (proceed with search normally)
+        if (searchKey == null) {
+            return false;
+        }
+
+        for (String bogie : bogies) {
+            if (searchKey.equals(bogie)) {
+                return true; // Match found
+            }
+        }
+        
+        return false; // Match not found
+    }
+
+    public static void main(String[] args) {
+        String searchKey = "BG101";
+
+        System.out.println("Scenario 1: Searching in an empty train consist");
+        try {
+            String[] emptyBogies = {};
+            searchBogie(emptyBogies, searchKey);
+        } catch (IllegalStateException e) {
+            System.out.println("Exception Caught: " + e.getMessage());
+        }
+
+        System.out.println("\nScenario 2: Searching in a valid train consist");
+        String[] validBogies = {"BG101", "BG205"};
+        boolean found = searchBogie(validBogies, searchKey);
+        System.out.println("Search successful. Bogie " + searchKey + " found: " + found);
+    }
+}
diff --git a/Desktop/RA2411026010349/src/test/java/UC19_BinarySearchTest.java b/Desktop/RA2411026010349/src/test/java/UC19_BinarySearchTest.java
deleted file mode 100644
index dca016e..0000000
--- a/Desktop/RA2411026010349/src/test/java/UC19_BinarySearchTest.java
+++ /dev/null
@@ -1,47 +0,0 @@
-import org.junit.jupiter.api.Test;
-import static org.junit.jupiter.api.Assertions.*;
-
-public class UC19_BinarySearchTest {
-
-    @Test
-    void testBinarySearch_BogieFound() {
-        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
-        assertTrue(UC19_BinarySearch.searchBogie(bogies, "BG309"), "Should return true for found bogie");
-    }
-
-    @Test
-    void testBinarySearch_BogieNotFound() {
-        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
-        assertFalse(UC19_BinarySearch.searchBogie(bogies, "BG999"), "Should return false for non-existent bogie");
-    }
-
-    @Test
-    void testBinarySearch_FirstElementMatch() {
-        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
-        assertTrue(UC19_BinarySearch.searchBogie(bogies, "BG101"), "Should return true for first element match");
-    }
-
-    @Test
-    void testBinarySearch_LastElementMatch() {
-        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
-        assertTrue(UC19_BinarySearch.searchBogie(bogies, "BG550"), "Should return true for last element match");
-    }
-
-    @Test
-    void testBinarySearch_SingleElementArray() {
-        String[] bogies = {"BG101"};
-        assertTrue(UC19_BinarySearch.searchBogie(bogies, "BG101"), "Should return true for single element match");
-    }
-
-    @Test
-    void testBinarySearch_EmptyArray() {
-        String[] bogies = {};
-        assertFalse(UC19_BinarySearch.searchBogie(bogies, "BG101"), "Should handle empty array and return false");
-    }
-
-    @Test
-    void testBinarySearch_UnsortedInputHandled() {
-        String[] bogies = {"BG309", "BG101", "BG550", "BG205", "BG412"};
-        assertTrue(UC19_BinarySearch.searchBogie(bogies, "BG205"), "Should sort input and return true if bogie is found");
-    }
-}
diff --git a/Desktop/RA2411026010349/src/test/java/UC20_ExceptionHandlingSearchTest.java b/Desktop/RA2411026010349/src/test/java/UC20_ExceptionHandlingSearchTest.java
new file mode 100644
index 0000000..81bed01
--- /dev/null
+++ b/Desktop/RA2411026010349/src/test/java/UC20_ExceptionHandlingSearchTest.java
@@ -0,0 +1,42 @@
+import org.junit.jupiter.api.Test;
+import static org.junit.jupiter.api.Assertions.*;
+
+public class UC20_ExceptionHandlingSearchTest {
+
+    @Test
+    void testSearch_ThrowsExceptionWhenEmpty() {
+        String[] bogies = {};
+        
+        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
+            UC20_ExceptionHandlingSearch.searchBogie(bogies, "BG101");
+        });
+        
+        assertEquals("Cannot perform search: Train consist has no bogies.", exception.getMessage());
+    }
+
+    @Test
+    void testSearch_AllowsSearchWhenDataExists() {
+        String[] bogies = {"BG101", "BG205"};
+        assertDoesNotThrow(() -> {
+            UC20_ExceptionHandlingSearch.searchBogie(bogies, "BG101");
+        });
+    }
+
+    @Test
+    void testSearch_BogieFoundAfterValidation() {
+        String[] bogies = {"BG101", "BG205", "BG309"};
+        assertTrue(UC20_ExceptionHandlingSearch.searchBogie(bogies, "BG205"), "Should return true if bogie exists");
+    }
+
+    @Test
+    void testSearch_BogieNotFoundAfterValidation() {
+        String[] bogies = {"BG101", "BG205", "BG309"};
+        assertFalse(UC20_ExceptionHandlingSearch.searchBogie(bogies, "BG999"), "Should return false if bogie does not exist");
+    }
+
+    @Test
+    void testSearch_SingleElementValidCase() {
+        String[] bogies = {"BG101"};
+        assertTrue(UC20_ExceptionHandlingSearch.searchBogie(bogies, "BG101"), "Should gracefully handle a single positive element match");
+    }
+}
public class UC20_ExceptionHandlingSearch {
    
    /**
     * Searches for a bogie ID with defensive fail-fast programming.
     * 
     * @param bogies    Array of bogie IDs
     * @param searchKey The ID to search for
     * @return true if the bogie exists, false otherwise
     * @throws IllegalStateException if the bogie collection is empty
     */
    public static boolean searchBogie(String[] bogies, String searchKey) {
        // State Validation: Defensive Programming
        // Fail-Fast Behavior: Check whether the bogie collection is empty before searching
        if (bogies == null || bogies.length == 0) {
            throw new IllegalStateException("Cannot perform search: Train consist has no bogies.");
        }

        // Basic search logic (proceed with search normally)
        if (searchKey == null) {
            return false;
        }

        for (String bogie : bogies) {
            if (searchKey.equals(bogie)) {
                return true; // Match found
            }
        }
        
        return false; // Match not found
    }

    public static void main(String[] args) {
        String searchKey = "BG101";

        System.out.println("Scenario 1: Searching in an empty train consist");
        try {
            String[] emptyBogies = {};
            searchBogie(emptyBogies, searchKey);
        } catch (IllegalStateException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        }

        System.out.println("\nScenario 2: Searching in a valid train consist");
        String[] validBogies = {"BG101", "BG205"};
        boolean found = searchBogie(validBogies, searchKey);
        System.out.println("Search successful. Bogie " + searchKey + " found: " + found);
    }
}
