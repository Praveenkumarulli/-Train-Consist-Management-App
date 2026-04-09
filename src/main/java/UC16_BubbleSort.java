/**
 * UC16: Sort Passenger Bogies by Capacity (Bubble Sort – Algorithm Intro)
 * 
 * This application demonstrates the Bubble Sort algorithm without using
 * built-in sorting methods like Arrays.sort() or Collections.sort().
 * 
 * Why Manual Sorting?
 * - Students understand how sorting works internally
 * - Foundation for learning more complex algorithms
 * - Develops algorithmic thinking skills
 * - Prepares for optimization and debugging
 * 
 * Scenario:
 * The railway system needs to sort passenger bogies by their seating capacity
 * to optimize allocation and planning. Instead of using library methods,
 * we manually implement Bubble Sort to understand the process.
 * 
 * Algorithm: Bubble Sort
 * - Compare adjacent elements
 * - Swap if out of order
 * - Repeat passes until sorted
 * - Time Complexity: O(n²)
 */
public class UC16_BubbleSort {
    
    public static void main(String[] args) {
        System.out.println("===== UC16: Sort Passenger Bogies by Capacity (Bubble Sort) =====");
        System.out.println();
        
        // Phase 1: Introduction
        System.out.println("--- Phase 1: Algorithm Introduction ---");
        System.out.println("Bubble Sort: A simple comparison-based sorting algorithm");
        System.out.println("Method: Compare adjacent elements and swap if out of order");
        System.out.println("Complexity: O(n²) - suitable for small datasets");
        System.out.println();
        
        // Phase 2: Test Case 1 - Basic Sorting
        System.out.println("--- Phase 2: Test Case 1 - Basic Sorting ---");
        System.out.println("Scenario: Sort passenger bogie capacities in ascending order");
        System.out.println();
        
        int[] basicCapacities = {72, 56, 24, 70, 60};
        String[] basicBogies = {"Sleeper", "ACChair", "FirstClass", "Pantry", "Guard"};
        
        System.out.println("Initial capacities: ");
        BubbleSortAlgorithm.displayArray(basicCapacities, basicBogies);
        System.out.println();
        
        int swaps = BubbleSortAlgorithm.bubbleSort(basicCapacities);
        
        System.out.println("After sorting: ");
        BubbleSortAlgorithm.displayArray(basicCapacities, basicBogies);
        System.out.println("Total swaps performed: " + swaps);
        System.out.println("Is sorted? " + BubbleSortAlgorithm.isSorted(basicCapacities));
        System.out.println();
        
        // Phase 3: Test Case 2 - Already Sorted Array
        System.out.println("--- Phase 3: Test Case 2 - Already Sorted Array ---");
        System.out.println("Scenario: Array is already in sorted order");
        System.out.println();
        
        int[] sortedCapacities = {24, 56, 60, 70, 72};
        
        System.out.println("Initial capacities: ");
        BubbleSortAlgorithm.displayArray(sortedCapacities);
        System.out.println();
        
        swaps = BubbleSortAlgorithm.bubbleSort(sortedCapacities);
        
        System.out.println("After sorting: ");
        BubbleSortAlgorithm.displayArray(sortedCapacities);
        System.out.println("Total swaps performed: " + swaps + " (optimization: no swaps needed)");
        System.out.println("Is sorted? " + BubbleSortAlgorithm.isSorted(sortedCapacities));
        System.out.println();
        
        // Phase 4: Test Case 3 - Duplicate Values
        System.out.println("--- Phase 4: Test Case 3 - Duplicate Values ---");
        System.out.println("Scenario: Multiple bogies have identical capacities");
        System.out.println();
        
        int[] duplicateCapacities = {72, 56, 56, 24};
        
        System.out.println("Initial capacities: ");
        BubbleSortAlgorithm.displayArray(duplicateCapacities);
        System.out.println();
        
        swaps = BubbleSortAlgorithm.bubbleSort(duplicateCapacities);
        
        System.out.println("After sorting: ");
        BubbleSortAlgorithm.displayArray(duplicateCapacities);
        System.out.println("Total swaps performed: " + swaps);
        System.out.println("Is sorted? " + BubbleSortAlgorithm.isSorted(duplicateCapacities));
        System.out.println();
        
        // Phase 5: Test Case 4 - Single Element
        System.out.println("--- Phase 5: Test Case 4 - Single Element Array ---");
        System.out.println("Scenario: Array contains only one bogie");
        System.out.println();
        
        int[] singleCapacity = {50};
        
        System.out.println("Initial capacities: ");
        BubbleSortAlgorithm.displayArray(singleCapacity);
        System.out.println();
        
        swaps = BubbleSortAlgorithm.bubbleSort(singleCapacity);
        
        System.out.println("After sorting: ");
        BubbleSortAlgorithm.displayArray(singleCapacity);
        System.out.println("Total swaps performed: " + swaps + " (no sorting needed)");
        System.out.println("Is sorted? " + BubbleSortAlgorithm.isSorted(singleCapacity));
        System.out.println();
        
        // Phase 6: Test Case 5 - All Equal Values
        System.out.println("--- Phase 6: Test Case 5 - All Equal Values ---");
        System.out.println("Scenario: All bogies have the same capacity");
        System.out.println();
        
        int[] equalCapacities = {40, 40, 40};
        
        System.out.println("Initial capacities: ");
        BubbleSortAlgorithm.displayArray(equalCapacities);
        System.out.println();
        
        swaps = BubbleSortAlgorithm.bubbleSort(equalCapacities);
        
        System.out.println("After sorting: ");
        BubbleSortAlgorithm.displayArray(equalCapacities);
        System.out.println("Total swaps performed: " + swaps);
        System.out.println("Is sorted? " + BubbleSortAlgorithm.isSorted(equalCapacities));
        System.out.println();
        
        // Phase 7: Detailed Step-by-Step Sorting
        System.out.println("--- Phase 7: Step-by-Step Sorting Demonstration ---");
        System.out.println("Showing detailed comparison and swap operations:");
        System.out.println();
        
        int[] detailedCapacities = {50, 30, 40};
        String[] detailedBogies = {"Bogie1", "Bogie2", "Bogie3"};
        
        BubbleSortAlgorithm.bubbleSortWithSteps(detailedCapacities, detailedBogies);
        System.out.println();
        
        // Phase 8: Algorithm Characteristics
        System.out.println("--- Phase 8: Bubble Sort Characteristics ---");
        System.out.println();
        System.out.println("✓ Time Complexity: O(n²)");
        System.out.println("  - Best case: O(n) when array is already sorted");
        System.out.println("  - Worst case: O(n²) when array is reverse sorted");
        System.out.println("  - Average case: O(n²)");
        System.out.println();
        System.out.println("✓ Space Complexity: O(1)");
        System.out.println("  - Sorts in-place, no extra array needed");
        System.out.println();
        System.out.println("✓ Stability: Yes");
        System.out.println("  - Maintains relative order of equal elements");
        System.out.println();
        System.out.println("✓ Advantages:");
        System.out.println("  - Simple to understand and implement");
        System.out.println("  - Educational value for algorithm learning");
        System.out.println("  - Works on any data type");
        System.out.println();
        System.out.println("✓ Disadvantages:");
        System.out.println("  - Inefficient for large datasets");
        System.out.println("  - Poor performance compared to Quick Sort, Merge Sort");
        System.out.println();
        
        System.out.println("===== UC16 Demonstration Complete =====");
    }
}
