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
