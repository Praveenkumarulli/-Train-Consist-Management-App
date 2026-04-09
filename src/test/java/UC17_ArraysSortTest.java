import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

/**
 * UC17: Sort Bogie Names Using Arrays.sort() Test Cases
 * 
 * Test Suite for validating Arrays.sort() implementation
 * 
 * Test Cases:
 * 1. testSort_BasicAlphabeticalSorting() - Verify alphabetical sorting
 * 2. testSort_UnsortedInput() - Verify unsorted input handling
 * 3. testSort_AlreadySortedArray() - Verify sorted array remains unchanged
 * 4. testSort_DuplicateBogieNames() - Verify duplicate handling
 * 5. testSort_SingleElementArray() - Verify single element array
 */
public class UC17_ArraysSortTest {
    
    private BogieNameSorter sorter;
    
    /**
     * Setup method: Initialize test fixtures before each test
     */
    @Before
    public void setUp() {
        sorter = new BogieNameSorter();
    }
    
    /**
     * Test Case 1: testSort_BasicAlphabeticalSorting()
     * 
     * Verifies that bogie names are sorted alphabetically using Arrays.sort().
     * 
     * Scenario:
     * - Input: {"Sleeper", "AC Chair", "First Class", "General", "Luxury"}
     * - Expected: {"AC Chair", "First Class", "General", "Luxury", "Sleeper"}
     * 
     * Expected Output:
     * - Array is sorted in alphabetical order
     * - All elements are preserved
     * - Order matches alphabetical sequence
     */
    @Test
    public void testSort_BasicAlphabeticalSorting() {
        System.out.println("\n--- Test: Basic Alphabetical Sorting ---");
        
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        
        int count = BogieNameSorter.sortBogieNames(bogieNames);
        
        // Verify correct sorting
        assertArrayEquals("Bogie names should be sorted alphabetically", 
                         expected, bogieNames);
        
        // Verify all elements present
        assertEquals("All elements should be sorted", 5, count);
        
        // Verify array is sorted
        assertTrue("Array should be sorted", BogieNameSorter.isSorted(bogieNames));
        
        System.out.println("✓ Test Passed: Sorted to {AC Chair, First Class, General, Luxury, Sleeper}");
    }
    
    /**
     * Test Case 2: testSort_UnsortedInput()
     * 
     * Verifies that an unsorted list of bogie names is rearranged into correct alphabetical order.
     * 
     * Scenario:
     * - Input: {"Luxury", "General", "Sleeper", "AC Chair"}
     * - Expected: {"AC Chair", "General", "Luxury", "Sleeper"}
     * 
     * Expected Output:
     * - Completely random order is corrected
     * - Alphabetical order is established
     * - All elements retained
     */
    @Test
    public void testSort_UnsortedInput() {
        System.out.println("\n--- Test: Unsorted Input Handling ---");
        
        String[] bogieNames = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};
        
        BogieNameSorter.sortBogieNames(bogieNames);
        
        // Verify correct sorting
        assertArrayEquals("Unsorted array should be rearranged alphabetically", 
                         expected, bogieNames);
        
        // Verify array is sorted
        assertTrue("Array should be sorted", BogieNameSorter.isSorted(bogieNames));
        
        System.out.println("✓ Test Passed: Random order corrected to alphabetical");
    }
    
    /**
     * Test Case 3: testSort_AlreadySortedArray()
     * 
     * Verifies that an already sorted bogie name array remains unchanged after sorting.
     * 
     * Scenario:
     * - Input: {"AC Chair", "First Class", "General"}
     * - Expected: {"AC Chair", "First Class", "General"} (no change)
     * 
     * Expected Output:
     * - Array remains unchanged
     * - Order preserved
     * - Efficient (no unnecessary operations)
     */
    @Test
    public void testSort_AlreadySortedArray() {
        System.out.println("\n--- Test: Already Sorted Array ---");
        
        String[] bogieNames = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};
        
        BogieNameSorter.sortBogieNames(bogieNames);
        
        // Verify array remains unchanged
        assertArrayEquals("Already sorted array should remain unchanged", 
                         expected, bogieNames);
        
        // Verify array is sorted
        assertTrue("Array should remain sorted", BogieNameSorter.isSorted(bogieNames));
        
        System.out.println("✓ Test Passed: Already sorted array remains {AC Chair, First Class, General}");
    }
    
    /**
     * Test Case 4: testSort_DuplicateBogieNames()
     * 
     * Verifies that duplicate bogie names are retained and correctly ordered after sorting.
     * 
     * Scenario:
     * - Input: {"Sleeper", "AC Chair", "Sleeper", "General"}
     * - Expected: {"AC Chair", "General", "Sleeper", "Sleeper"}
     * 
     * Expected Output:
     * - Duplicate values are preserved
     * - Array is correctly sorted
     * - All elements retained (length unchanged)
     */
    @Test
    public void testSort_DuplicateBogieNames() {
        System.out.println("\n--- Test: Duplicate Bogie Names ---");
        
        String[] bogieNames = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};
        
        BogieNameSorter.sortBogieNames(bogieNames);
        
        // Verify correct sorting with duplicates
        assertArrayEquals("Array with duplicates should be sorted correctly", 
                         expected, bogieNames);
        
        // Verify length is preserved
        assertEquals("Array length should remain unchanged", 4, bogieNames.length);
        
        // Verify duplicates are counted correctly
        int sleeperCount = BogieNameSorter.countOccurrence(bogieNames, "Sleeper");
        assertEquals("Sleeper should appear twice", 2, sleeperCount);
        
        // Verify array is sorted
        assertTrue("Array should be sorted", BogieNameSorter.isSorted(bogieNames));
        
        System.out.println("✓ Test Passed: Duplicates retained {AC Chair, General, Sleeper, Sleeper}");
    }
    
    /**
     * Test Case 5: testSort_SingleElementArray()
     * 
     * Verifies that sorting a single element array does not change the array contents.
     * 
     * Scenario:
     * - Input: {"Sleeper"}
     * - Expected: {"Sleeper"}
     * 
     * Expected Output:
     * - Single element remains unchanged
     * - Array length remains 1
     * - Operation completes without issues
     */
    @Test
    public void testSort_SingleElementArray() {
        System.out.println("\n--- Test: Single Element Array ---");
        
        String[] bogieNames = {"Sleeper"};
        String[] expected = {"Sleeper"};
        
        BogieNameSorter.sortBogieNames(bogieNames);
        
        // Verify single element remains unchanged
        assertArrayEquals("Single element array should remain unchanged", 
                         expected, bogieNames);
        
        // Verify length
        assertEquals("Length should be 1", 1, bogieNames.length);
        
        // Verify array is sorted
        assertTrue("Single element array should be sorted", BogieNameSorter.isSorted(bogieNames));
        
        System.out.println("✓ Test Passed: Single element {Sleeper} remains {Sleeper}");
    }
    
    /**
     * Additional Test: testSort_LargeArray()
     * 
     * Verifies that Arrays.sort() efficiently handles larger datasets
     */
    @Test
    public void testSort_LargeArray() {
        System.out.println("\n--- Test: Larger Array ---");
        
        String[] bogieNames = {"Pantry Car", "Guard Brake", "Sleeper", "AC 3-Tier", 
                              "AC 2-Tier", "First Class", "General", "Luxury", 
                              "Goods", "Compartment"};
        
        BogieNameSorter.sortBogieNames(bogieNames);
        
        // Verify array is sorted
        assertTrue("Larger array should be sorted", BogieNameSorter.isSorted(bogieNames));
        
        // Verify all elements preserved
        assertEquals("All elements should be retained", 10, bogieNames.length);
        
        System.out.println("✓ Test Passed: 10 bogie names sorted efficiently");
        System.out.println("  Sorted result: " + Arrays.toString(bogieNames));
    }
    
    /**
     * Additional Test: testSort_CaseSensitivity()
     * 
     * Verifies handling of different case letters
     */
    @Test
    public void testSort_CaseSensitivity() {
        System.out.println("\n--- Test: Case Sensitivity ---");
        
        String[] bogieNames = {"sleeper", "AC Chair", "LUXURY", "General"};
        BogieNameSorter.sortBogieNames(bogieNames);
        
        // Verify array is sorted (uppercase comes before lowercase in ASCII)
        assertTrue("Array should be sorted (case-sensitive)", BogieNameSorter.isSorted(bogieNames));
        
        System.out.println("✓ Test Passed: Case-sensitive sorting handled");
        System.out.println("  Result: " + Arrays.toString(bogieNames));
    }
    
    /**
     * Additional Test: testSort_GetSortedCopy()
     * 
     * Verifies that original array is not modified when using getSortedCopy
     */
    @Test
    public void testSort_GetSortedCopy() {
        System.out.println("\n--- Test: Get Sorted Copy ---");
        
        String[] original = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] sorted = BogieNameSorter.getSortedCopy(original);
        
        // Original should remain unchanged
        assertArrayEquals("Original should remain unchanged", 
                         new String[]{"Luxury", "General", "Sleeper", "AC Chair"}, original);
        
        // Copy should be sorted
        assertTrue("Copy should be sorted", BogieNameSorter.isSorted(sorted));
        
        System.out.println("✓ Test Passed: Original preserved, copy sorted");
    }
    
    /**
     * Additional Test: testSort_EmptyArray()
     * 
     * Verifies handling of empty arrays
     */
    @Test
    public void testSort_EmptyArray() {
        System.out.println("\n--- Test: Empty Array ---");
        
        String[] bogieNames = {};
        int count = BogieNameSorter.sortBogieNames(bogieNames);
        
        assertEquals("Empty array should return 0", 0, count);
        assertEquals("Array should remain empty", 0, bogieNames.length);
        
        System.out.println("✓ Test Passed: Empty array handled correctly");
    }
    
    /**
     * Additional Test: testSort_NullInput()
     * 
     * Verifies handling of null input
     */
    @Test
    public void testSort_NullInput() {
        System.out.println("\n--- Test: Null Input ---");
        
        int count = BogieNameSorter.sortBogieNames(null);
        
        assertEquals("Null input should return 0", 0, count);
        
        System.out.println("✓ Test Passed: Null input handled gracefully");
    }
}
