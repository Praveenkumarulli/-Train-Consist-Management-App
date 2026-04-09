/**
 * UC16: Bubble Sort Algorithm - Manual Sorting Without Collections.sort()
 * 
 * This class demonstrates the Bubble Sort algorithm, a simple comparison-based
 * sorting technique that repeatedly compares adjacent elements and swaps them
 * if they are in the wrong order.
 * 
 * Algorithm Overview:
 * - Pass 1: Compare elements pairwise, swap if left > right
 * - Pass 2: Repeat the process, reducing the range each time
 * - Continue until no more swaps are needed (array is sorted)
 * 
 * Time Complexity: O(n²) - Acceptable for small datasets, educational purpose
 * Space Complexity: O(1) - Sorts in-place
 * 
 * Why Bubble Sort?
 * - Simple to understand and implement
 * - Introduces core sorting concepts
 * - Shows how algorithms work step-by-step
 * - Foundation for understanding more complex sorting (Quick Sort, Merge Sort)
 */
public class BubbleSortAlgorithm {
    
    /**
     * Sorts an array of passenger bogie capacities using Bubble Sort
     * 
     * Algorithm Steps:
     * 1. Start with the first element
     * 2. Compare it with the next element
     * 3. If current > next, swap them
     * 4. Move to the next pair
     * 5. Repeat until end of array
     * 6. Continue passes until no swaps occur
     * 
     * @param capacities Array of bogie capacities to sort
     * @return Number of swaps performed during sorting
     */
    public static int bubbleSort(int[] capacities) {
        if (capacities == null || capacities.length == 0) {
            return 0;
        }
        
        int n = capacities.length;
        int totalSwaps = 0;
        
        // Outer loop: Number of passes
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;  // Optimization: detect if array is already sorted
            
            // Inner loop: Compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // Compare: current element with next element
                if (capacities[j] > capacities[j + 1]) {
                    // Swap: Exchange positions if out of order
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                    
                    swapped = true;
                    totalSwaps++;
                }
            }
            
            // Optimization: If no swaps occurred, array is already sorted
            if (!swapped) {
                break;
            }
        }
        
        return totalSwaps;
    }
    
    /**
     * Sorts an array and displays the sorting process step-by-step
     * 
     * @param capacities Array of bogie capacities to sort
     * @param bogieNames Names of bogies for display purposes
     */
    public static void bubbleSortWithSteps(int[] capacities, String[] bogieNames) {
        if (capacities == null || capacities.length == 0) {
            System.out.println("No capacities to sort.");
            return;
        }
        
        int n = capacities.length;
        System.out.println("Initial Array:");
        displayArray(capacities, bogieNames);
        System.out.println();
        
        int passNumber = 1;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            System.out.println("--- Pass " + passNumber + " ---");
            
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("Comparing " + capacities[j] + " and " + 
                               capacities[j + 1] + ": ");
                
                if (capacities[j] > capacities[j + 1]) {
                    // Swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                    System.out.println("SWAP");
                    swapped = true;
                } else {
                    System.out.println("OK");
                }
            }
            
            System.out.print("After Pass " + passNumber + ": ");
            displayArray(capacities, bogieNames);
            System.out.println();
            
            if (!swapped) {
                System.out.println("No swaps in this pass → Array is sorted!");
                break;
            }
            
            passNumber++;
        }
        
        System.out.println("Final Sorted Array:");
        displayArray(capacities, bogieNames);
    }
    
    /**
     * Displays the current state of the array
     * 
     * @param capacities Array of capacities
     * @param bogieNames Names of bogies
     */
    private static void displayArray(int[] capacities, String[] bogieNames) {
        System.out.print("[");
        for (int i = 0; i < capacities.length; i++) {
            if (bogieNames != null && i < bogieNames.length) {
                System.out.print(bogieNames[i] + ":" + capacities[i]);
            } else {
                System.out.print(capacities[i]);
            }
            if (i < capacities.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    /**
     * Displays just the capacity values
     * 
     * @param capacities Array of capacities
     */
    public static void displayArray(int[] capacities) {
        displayArray(capacities, null);
    }
    
    /**
     * Checks if an array is sorted in ascending order
     * 
     * @param capacities Array to check
     * @return true if sorted, false otherwise
     */
    public static boolean isSorted(int[] capacities) {
        for (int i = 0; i < capacities.length - 1; i++) {
            if (capacities[i] > capacities[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
