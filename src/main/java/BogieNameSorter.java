import java.util.Arrays;

/**
 * UC17: Bogie Name Sorting Utility Using Arrays.sort()
 * 
 * This utility class provides methods to sort bogie names using
 * Java's built-in Arrays.sort() method, which is optimized and
 * production-ready.
 * 
 * Key Differences from UC16:
 * - UC16 (Bubble Sort): Manual implementation, O(n²)
 * - UC17 (Arrays.sort): Library method, O(n log n)
 * 
 * When to use which:
 * - Bubble Sort: Educational purposes, learning algorithms
 * - Arrays.sort: Production code, real-world applications
 */
public class BogieNameSorter {
    
    /**
     * Sorts bogie names alphabetically using Arrays.sort()
     * 
     * This method demonstrates:
     * - How to use built-in sorting library
     * - Natural ordering (alphabetical for strings)
     * - Performance advantage over manual algorithms
     * 
     * @param bogieNames Array of bogie names to sort
     * @return Number of elements sorted
     */
    public static int sortBogieNames(String[] bogieNames) {
        if (bogieNames == null || bogieNames.length == 0) {
            return 0;
        }
        
        Arrays.sort(bogieNames);
        return bogieNames.length;
    }
    
    /**
     * Sorts bogie names and displays the result
     * 
     * @param bogieNames Array of bogie names to sort
     * @param label Description of the sorting operation
     */
    public static void sortAndDisplay(String[] bogieNames, String label) {
        if (bogieNames == null || bogieNames.length == 0) {
            System.out.println("No bogie names to sort.");
            return;
        }
        
        System.out.println("Original (" + label + "):");
        System.out.println(Arrays.toString(bogieNames));
        
        Arrays.sort(bogieNames);
        
        System.out.println("Sorted Result:");
        System.out.println(Arrays.toString(bogieNames));
    }
    
    /**
     * Checks if bogie names are in alphabetical order
     * 
     * @param bogieNames Array to check
     * @return true if sorted, false otherwise
     */
    public static boolean isSorted(String[] bogieNames) {
        if (bogieNames == null || bogieNames.length <= 1) {
            return true;
        }
        
        for (int i = 0; i < bogieNames.length - 1; i++) {
            if (bogieNames[i].compareTo(bogieNames[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Sorts and returns a copy without modifying the original array
     * 
     * @param bogieNames Original array
     * @return Sorted copy of the array
     */
    public static String[] getSortedCopy(String[] bogieNames) {
        if (bogieNames == null || bogieNames.length == 0) {
            return new String[0];
        }
        
        String[] copy = bogieNames.clone();
        Arrays.sort(copy);
        return copy;
    }
    
    /**
     * Counts occurrences of a bogie name in the array
     * 
     * @param bogieNames Array to search
     * @param target Bogie name to count
     * @return Number of occurrences
     */
    public static int countOccurrence(String[] bogieNames, String target) {
        int count = 0;
        if (bogieNames != null && target != null) {
            for (String name : bogieNames) {
                if (name.equals(target)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    /**
     * Displays sorted bogie names with index positions
     * 
     * @param bogieNames Array to display
     */
    public static void displayWithIndex(String[] bogieNames) {
        if (bogieNames == null || bogieNames.length == 0) {
            System.out.println("No bogie names to display.");
            return;
        }
        
        Arrays.sort(bogieNames);
        System.out.println("Index | Bogie Name");
        System.out.println("------|-------------------");
        for (int i = 0; i < bogieNames.length; i++) {
            System.out.printf("%5d | %s%n", i, bogieNames[i]);
        }
    }
    
    /**
     * Calculates statistics about bogie names
     * 
     * @param bogieNames Array to analyze
     */
    public static void displayStatistics(String[] bogieNames) {
        if (bogieNames == null || bogieNames.length == 0) {
            System.out.println("No bogie names to analyze.");
            return;
        }
        
        System.out.println("Statistics:");
        System.out.println("  Total bogies: " + bogieNames.length);
        System.out.println("  Is sorted: " + isSorted(bogieNames));
        
        int maxLength = 0;
        int minLength = Integer.MAX_VALUE;
        for (String name : bogieNames) {
            maxLength = Math.max(maxLength, name.length());
            minLength = Math.min(minLength, name.length());
        }
        
        System.out.println("  Longest name: " + maxLength + " characters");
        System.out.println("  Shortest name: " + minLength + " characters");
    }
}
