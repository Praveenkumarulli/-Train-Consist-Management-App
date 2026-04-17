import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC19_BinarySearchTest {

    @Test
    void testBinarySearch_BogieFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UC19_BinarySearch.searchBogie(bogies, "BG309"), "Should return true for found bogie");
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(UC19_BinarySearch.searchBogie(bogies, "BG999"), "Should return false for non-existent bogie");
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UC19_BinarySearch.searchBogie(bogies, "BG101"), "Should return true for first element match");
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] bogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UC19_BinarySearch.searchBogie(bogies, "BG550"), "Should return true for last element match");
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] bogies = {"BG101"};
        assertTrue(UC19_BinarySearch.searchBogie(bogies, "BG101"), "Should return true for single element match");
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] bogies = {};
        assertFalse(UC19_BinarySearch.searchBogie(bogies, "BG101"), "Should handle empty array and return false");
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] bogies = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(UC19_BinarySearch.searchBogie(bogies, "BG205"), "Should sort input and return true if bogie is found");
    }
}
