import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UC20_ExceptionHandlingSearchTest {

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] bogies = {};
        
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            UC20_ExceptionHandlingSearch.searchBogie(bogies, "BG101");
        });
        
        assertEquals("Cannot perform search: Train consist has no bogies.", exception.getMessage());
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] bogies = {"BG101", "BG205"};
        assertDoesNotThrow(() -> {
            UC20_ExceptionHandlingSearch.searchBogie(bogies, "BG101");
        });
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};
        assertTrue(UC20_ExceptionHandlingSearch.searchBogie(bogies, "BG205"), "Should return true if bogie exists");
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] bogies = {"BG101", "BG205", "BG309"};
        assertFalse(UC20_ExceptionHandlingSearch.searchBogie(bogies, "BG999"), "Should return false if bogie does not exist");
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] bogies = {"BG101"};
        assertTrue(UC20_ExceptionHandlingSearch.searchBogie(bogies, "BG101"), "Should gracefully handle a single positive element match");
    }
}
