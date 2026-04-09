/**
 * UC17: Sort Bogie Names Using Arrays.sort() – Library Optimization
 * 
 * This application demonstrates using Java's built-in Arrays.sort() method
 * instead of manual sorting implementations.
 * 
 * Why Arrays.sort()?
 * - Highly optimized performance (O(n log n))
 * - Uses advanced algorithms (Dual-pivot Quicksort, TimSort)
 * - Proven, tested, and reliable
 * - Professional production standard
 * - Code is clean and maintainable
 * 
 * Comparison with UC16:
 * - UC16: Manual Bubble Sort - O(n²), educational
 * - UC17: Arrays.sort() - O(n log n), production-ready
 * 
 * Use Case:
 * Railway system needs to display bogie types in alphabetical order
 * for reports, dashboards, and user interfaces.
 */
public class UC17_ArraysSort {
    
    public static void main(String[] args) {
        System.out.println("===== UC17: Sort Bogie Names Using Arrays.sort() =====");
        System.out.println();
        
        // Phase 1: Introduction
        System.out.println("--- Phase 1: Introduction to Arrays.sort() ---");
        System.out.println("Java provides built-in sorting through Arrays.sort()");
        System.out.println("Method: java.util.Arrays.sort()");
        System.out.println("Algorithm: Dual-pivot Quicksort or TimSort (optimized)");
        System.out.println("Time Complexity: O(n log n)");
        System.out.println("Improvement over UC16 Bubble Sort: ~n times faster");
        System.out.println();
        
        // Phase 2: Test Case 1 - Basic Alphabetical Sorting
        System.out.println("--- Phase 2: Test Case 1 - Basic Alphabetical Sorting ---");
        System.out.println("Scenario: Sort various passenger bogie types alphabetically");
        System.out.println();
        
        String[] bogieTypes1 = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        System.out.println("Original order:");
        System.out.println(java.util.Arrays.toString(bogieTypes1));
        
        java.util.Arrays.sort(bogieTypes1);
        
        System.out.println("After Arrays.sort():");
        System.out.println(java.util.Arrays.toString(bogieTypes1));
        System.out.println("✓ Sorted alphabetically: AC Chair → First Class → General → Luxury → Sleeper");
        System.out.println();
        
        // Phase 3: Test Case 2 - Unsorted Input
        System.out.println("--- Phase 3: Test Case 2 - Unsorted Input Handling ---");
        System.out.println("Scenario: Handle completely random order of bogie names");
        System.out.println();
        
        String[] bogieTypes2 = {"Luxury", "General", "Sleeper", "AC Chair"};
        System.out.println("Original order:");
        System.out.println(java.util.Arrays.toString(bogieTypes2));
        
        java.util.Arrays.sort(bogieTypes2);
        
        System.out.println("After Arrays.sort():");
        System.out.println(java.util.Arrays.toString(bogieTypes2));
        System.out.println("✓ Rearranged to alphabetical order");
        System.out.println();
        
        // Phase 4: Test Case 3 - Already Sorted Array
        System.out.println("--- Phase 4: Test Case 3 - Already Sorted Array ---");
        System.out.println("Scenario: Array is already in alphabetical order");
        System.out.println();
        
        String[] bogieTypes3 = {"AC Chair", "First Class", "General"};
        System.out.println("Original order:");
        System.out.println(java.util.Arrays.toString(bogieTypes3));
        
        java.util.Arrays.sort(bogieTypes3);
        
        System.out.println("After Arrays.sort():");
        System.out.println(java.util.Arrays.toString(bogieTypes3));
        System.out.println("✓ Order preserved (optimization - no unnecessary work)");
        System.out.println();
        
        // Phase 5: Test Case 4 - Duplicate Bogie Names
        System.out.println("--- Phase 5: Test Case 4 - Duplicate Bogie Names ---");
        System.out.println("Scenario: Multiple bogies of the same type");
        System.out.println();
        
        String[] bogieTypes4 = {"Sleeper", "AC Chair", "Sleeper", "General"};
        System.out.println("Original order:");
        System.out.println(java.util.Arrays.toString(bogieTypes4));
        
        java.util.Arrays.sort(bogieTypes4);
        
        System.out.println("After Arrays.sort():");
        System.out.println(java.util.Arrays.toString(bogieTypes4));
        System.out.println("✓ Duplicates retained and positioned correctly");
        System.out.println();
        
        // Phase 6: Test Case 5 - Single Element
        System.out.println("--- Phase 6: Test Case 5 - Single Element Array ---");
        System.out.println("Scenario: Array contains only one bogie name");
        System.out.println();
        
        String[] bogieTypes5 = {"Sleeper"};
        System.out.println("Original order:");
        System.out.println(java.util.Arrays.toString(bogieTypes5));
        
        java.util.Arrays.sort(bogieTypes5);
        
        System.out.println("After Arrays.sort():");
        System.out.println(java.util.Arrays.toString(bogieTypes5));
        System.out.println("✓ Single element remains unchanged");
        System.out.println();
        
        // Phase 7: Case Sensitivity
        System.out.println("--- Phase 7: Case Sensitivity in Sorting ---");
        System.out.println("Scenario: Bogie names with different cases");
        System.out.println();
        
        String[] bogieTypes6 = {"sleeper", "AC Chair", "LUXURY", "General"};
        System.out.println("Original order (mixed case):");
        System.out.println(java.util.Arrays.toString(bogieTypes6));
        
        java.util.Arrays.sort(bogieTypes6);
        
        System.out.println("After Arrays.sort():");
        System.out.println(java.util.Arrays.toString(bogieTypes6));
        System.out.println("Note: Uppercase letters come before lowercase in ASCII order");
        System.out.println();
        
        // Phase 8: Larger Dataset
        System.out.println("--- Phase 8: Larger Dataset Example ---");
        System.out.println("Scenario: Sorting 10 bogie types");
        System.out.println();
        
        String[] bogieTypes7 = {"Pantry Car", "Guard Brake", "Sleeper", "AC 3-Tier", 
                               "AC 2-Tier", "First Class", "General", "Luxury", 
                               "Goods", "Compartment"};
        System.out.println("Original order (10 bogies):");
        System.out.println(java.util.Arrays.toString(bogieTypes7));
        
        long startTime = System.nanoTime();
        java.util.Arrays.sort(bogieTypes7);
        long endTime = System.nanoTime();
        long timeTaken = endTime - startTime;
        
        System.out.println("After Arrays.sort():");
        System.out.println(java.util.Arrays.toString(bogieTypes7));
        System.out.println("Time taken: " + timeTaken + " nanoseconds");
        System.out.println();
        
        // Phase 9: Comparison with Manual Sorting
        System.out.println("--- Phase 9: Why Arrays.sort() is Better ---");
        System.out.println();
        System.out.println("✓ Performance: O(n log n) vs O(n²) for Bubble Sort");
        System.out.println("  - For 1000 items: ~10,000 operations vs 1,000,000");
        System.out.println("  - For 1,000,000 items: ~20,000,000 vs 1,000,000,000,000");
        System.out.println();
        System.out.println("✓ Reliability: Tested and proven in production");
        System.out.println("  - Handles edge cases");
        System.out.println("  - Works with any data type");
        System.out.println();
        System.out.println("✓ Maintainability: Single line of code");
        System.out.println("  - java.util.Arrays.sort(array);");
        System.out.println("  - vs 15-20 lines for manual implementation");
        System.out.println();
        System.out.println("✓ Flexibility: Works with custom comparators");
        System.out.println("  - Ascending, descending, custom rules");
        System.out.println();
        System.out.println("✓ Optimization: Advanced algorithms");
        System.out.println("  - TimSort for stability");
        System.out.println("  - Dual-pivot Quicksort for speed");
        System.out.println();
        
        System.out.println("===== UC17 Demonstration Complete =====");
    }
}
