import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

/**
 * UC16: Bubble Sort Algorithm Test Cases
 * 
 * Test Suite for validating Bubble Sort implementation
 * 
 * Test Cases:
 * 1. testSort_BasicSorting() - Verify correct sorting of unsorted array
 * 2. testSort_AlreadySortedArray() - Verify sorted array remains unchanged
 * 3. testSort_DuplicateValues() - Verify duplicate values are handled
 * 4. testSort_SingleElementArray() - Verify single element array
 * 5. testSort_AllEqualValues() - Verify all equal values remain unchanged
 */
public class UC16_BubbleSortTest {
    
    private BubbleSortAlgorithm sorter;
    
    /**
     * Setup method: Initialize test fixtures before each test
     */
    @Before
    public void setUp() {
        sorter = new BubbleSortAlgorithm();
    }
    
    /**
     * Test Case 1: testSort_BasicSorting()
     * 
     * Verifies that the Bubble Sort algorithm correctly sorts a typical unsorted array.
     * 
     * Scenario:
     * - Input: {72, 56, 24, 70, 60}
     * - Expected: {24, 56, 60, 70, 72}
     * 
     * Expected Output:
     * - Array is sorted in ascending order
     * - All elements are preserved
     * - Array is correctly arranged
     */
    @Test
    public void testSort_BasicSorting() {
        System.out.println("\n--- Test: Basic Sorting ---");
        
        int[] capacities = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};
        
        int swaps = BubbleSortAlgorithm.bubbleSort(capacities);
        
        // Verify correct sorting
        assertArrayEquals("Array should be sorted in ascending order", 
                         expected, capacities);
        
        // Verify that sorting was performed
        assertTrue("Swaps should have been performed", swaps > 0);
        
        // Verify array is sorted
        assertTrue("Array should be sorted", BubbleSortAlgorithm.isSorted(capacities));
        
        System.out.println("✓ Test Passed: Array sorted from {72, 56, 24, 70, 60} to {24, 56, 60, 70, 72}");
        System.out.println("  Swaps performed: " + swaps);
    }
    
    /**
     * Test Case 2: testSort_AlreadySortedArray()
     * 
     * Verifies that an already sorted array remains unchanged after sorting.
     * 
     * Scenario:
     * - Input: {24, 56, 60, 70, 72}
     * - Expected: {24, 56, 60, 70, 72} (no change)
     * 
     * Expected Output:
     * - Array remains unchanged
     * - No swaps are needed (optimization)
     * - isSorted() returns true
     */
    @Test
    public void testSort_AlreadySortedArray() {
        System.out.println("\n--- Test: Already Sorted Array ---");
        
        int[] capacities = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};
        
        int swaps = BubbleSortAlgorithm.bubbleSort(capacities);
        
        // Verify array remains unchanged
        assertArrayEquals("Already sorted array should remain unchanged", 
                         expected, capacities);
        
        // Verify no swaps were needed (optimization)
        assertEquals("No swaps should be performed for already sorted array", 
                    0, swaps);
        
        // Verify array is sorted
        assertTrue("Array should be sorted", BubbleSortAlgorithm.isSorted(capacities));
        
        System.out.println("✓ Test Passed: Already sorted array remains {24, 56, 60, 70, 72}");
        System.out.println("  Swaps performed: " + swaps + " (optimization: early termination)");
    }
    
    /**
     * Test Case 3: testSort_DuplicateValues()
     * 
     * Verifies that duplicate capacities are handled correctly during sorting.
     * 
     * Scenario:
     * - Input: {72, 56, 56, 24}
     * - Expected: {24, 56, 56, 72}
     * 
     * Expected Output:
     * - Duplicate values are preserved
     * - Array is correctly sorted
     * - All elements are retained
     */
    @Test
    public void testSort_DuplicateValues() {
        System.out.println("\n--- Test: Duplicate Values ---");
        
        int[] capacities = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        
        int swaps = BubbleSortAlgorithm.bubbleSort(capacities);
        
        // Verify correct sorting with duplicates
        assertArrayEquals("Array with duplicates should be sorted correctly", 
                         expected, capacities);
        
        // Verify length is preserved (no elements lost)
        assertEquals("Array length should remain unchanged", 4, capacities.length);
        
        // Verify array is sorted
        assertTrue("Array should be sorted", BubbleSortAlgorithm.isSorted(capacities));
        
        System.out.println("✓ Test Passed: Duplicates handled correctly {72, 56, 56, 24} → {24, 56, 56, 72}");
        System.out.println("  Swaps performed: " + swaps);
    }
    
    /**
     * Test Case 4: testSort_SingleElementArray()
     * 
     * Verifies that sorting a single element array does not modify the array.
     * 
     * Scenario:
     * - Input: {50}
     * - Expected: {50}
     * 
     * Expected Output:
     * - Single element remains unchanged
     * - No swaps needed
     * - Array is considered sorted
     */
    @Test
    public void testSort_SingleElementArray() {
        System.out.println("\n--- Test: Single Element Array ---");
        
        int[] capacities = {50};
        int[] expected = {50};
        
        int swaps = BubbleSortAlgorithm.bubbleSort(capacities);
        
        // Verify single element remains unchanged
        assertArrayEquals("Single element array should remain unchanged", 
                         expected, capacities);
        
        // Verify no swaps are performed
        assertEquals("No swaps should be performed for single element", 
                    0, swaps);
        
        // Verify array is sorted
        assertTrue("Single element array should be sorted", 
                  BubbleSortAlgorithm.isSorted(capacities));
        
        System.out.println("✓ Test Passed: Single element array {50} remains {50}");
        System.out.println("  Swaps performed: " + swaps);
    }
    
    /**
     * Test Case 5: testSort_AllEqualValues()
     * 
     * Verifies that arrays containing identical values remain unchanged.
     * 
     * Scenario:
     * - Input: {40, 40, 40}
     * - Expected: {40, 40, 40}
     * 
     * Expected Output:
     * - Array remains unchanged
     * - No swaps needed (all elements equal)
     * - Array is considered sorted
     */
    @Test
    public void testSort_AllEqualValues() {
        System.out.println("\n--- Test: All Equal Values ---");
        
        int[] capacities = {40, 40, 40};
        int[] expected = {40, 40, 40};
        
        int swaps = BubbleSortAlgorithm.bubbleSort(capacities);
        
        // Verify array with equal values remains unchanged
        assertArrayEquals("Array with equal values should remain unchanged", 
                         expected, capacities);
        
        // Verify no swaps are needed
        assertEquals("No swaps should be performed when all values are equal", 
                    0, swaps);
        
        // Verify array is sorted
        assertTrue("Array with equal values should be sorted", 
                  BubbleSortAlgorithm.isSorted(capacities));
        
        System.out.println("✓ Test Passed: All equal values {40, 40, 40} remain {40, 40, 40}");
        System.out.println("  Swaps performed: " + swaps);
    }
    
    /**
     * Additional Test: testSort_ReverseSortedArray()
     * 
     * Verifies behavior when array is in reverse (worst case) order
     */
    @Test
    public void testSort_ReverseSortedArray() {
        System.out.println("\n--- Test: Reverse Sorted Array (Worst Case) ---");
        
        int[] capacities = {72, 60, 70, 24, 56};
        int[] expected = {24, 56, 60, 70, 72};
        
        int swaps = BubbleSortAlgorithm.bubbleSort(capacities);
        
        assertArrayEquals("Reverse sorted array should be corrected", 
                         expected, capacities);
        
        assertTrue("Array should be sorted", BubbleSortAlgorithm.isSorted(capacities));
        
        System.out.println("✓ Test Passed: Reverse sorted array handled");
        System.out.println("  Swaps performed: " + swaps + " (worst case: many swaps)");
    }
    
    /**
     * Additional Test: testSort_LargeArray()
     * 
     * Verifies that the algorithm works with larger datasets
     */
    @Test
    public void testSort_LargeArray() {
        System.out.println("\n--- Test: Larger Array ---");
        
        int[] capacities = {95, 45, 23, 67, 89, 34, 56, 12, 78, 90};
        int[] expected = {12, 23, 34, 45, 56, 67, 78, 89, 90, 95};
        
        int swaps = BubbleSortAlgorithm.bubbleSort(capacities);
        
        assertArrayEquals("Larger array should be sorted correctly", 
                         expected, capacities);
        
        assertTrue("Array should be sorted", BubbleSortAlgorithm.isSorted(capacities));
        
        System.out.println("✓ Test Passed: Larger array sorted correctly");
        System.out.println("  Array size: " + capacities.length);
        System.out.println("  Swaps performed: " + swaps);
    }
    
    /**
     * Additional Test: testSort_TwoElementArray()
     * 
     * Verifies that a two-element array is sorted correctly
     */
    @Test
    public void testSort_TwoElementArray() {
        System.out.println("\n--- Test: Two Element Array ---");
        
        // Test case 1: Unsorted
        int[] capacities1 = {60, 40};
        int[] expected1 = {40, 60};
        BubbleSortAlgorithm.bubbleSort(capacities1);
        assertArrayEquals("Two element unsorted array should be sorted", 
                         expected1, capacities1);
        
        // Test case 2: Already sorted
        int[] capacities2 = {40, 60};
        int[] expected2 = {40, 60};
        int swaps = BubbleSortAlgorithm.bubbleSort(capacities2);
        assertArrayEquals("Two element sorted array should remain sorted", 
                         expected2, capacities2);
        assertEquals("No swaps for already sorted two element array", 0, swaps);
        
        System.out.println("✓ Test Passed: Two element arrays handled correctly");
    }
}
