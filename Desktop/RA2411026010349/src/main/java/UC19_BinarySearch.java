import java.util.Arrays;

public class UC19_BinarySearch {
    
    /**
     * Performs a binary search to find a bogie ID efficiently in an array.
     * Ensure the array is sorted before searching as per Binary Search preconditions.
     * 
     * @param bogies    Array of bogie IDs
     * @param searchKey The ID to search for
     * @return true if the bogie exists, false otherwise
     */
    public static boolean searchBogie(String[] bogies, String searchKey) {
        // Empty Array Handling & null checks
        if (bogies == null || bogies.length == 0 || searchKey == null) {
            return false;
        }

        // Unsorted Input Handling: 
        // Ensure data is sorted before applying Binary Search
        String[] sortedBogies = bogies.clone();
        Arrays.sort(sortedBogies);

        // Initialize low and high indexes
        int low = 0;
        int high = sortedBogies.length - 1;

        // Steps repeat until found or exhausted
        while (low <= high) {
            // Compute mid index correctly
            int mid = low + (high - low) / 2;
            
            // Compare key with mid element using compareTo()
            int comparison = searchKey.compareTo(sortedBogies[mid]);
            
            if (comparison == 0) {
                // Match found
                return true; 
            } else if (comparison < 0) {
                // Adjust search range accordingly: Key is in the left half
                high = mid - 1;
            } else {
                // Adjust search range accordingly: Key is in the right half
                low = mid + 1;
            }
        }
        
        // Match not found
        return false;
    }

    public static void main(String[] args) {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";

        System.out.println("Searching for bogie ID: " + searchKey);
        
        boolean found = searchBogie(bogies, searchKey);
        if (found) {
            System.out.println("Result: Bogie " + searchKey + " exists in the consist.");
        } else {
            System.out.println("Result: Bogie " + searchKey + " was NOT found in the consist.");
        }
    }
}
