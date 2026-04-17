import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC11: Validate Train ID & Cargo Codes (Regex)
 */
public class TrainConsistManagementAppTest {

    // Helper methods for validation
    private boolean isValidTrainId(String trainId) {
        Pattern pattern = Pattern.compile("TRN-\\d{4}");
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    private boolean isValidCargoCode(String cargoCode) {
        Pattern pattern = Pattern.compile("PET-[A-Z]{2}");
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(isValidTrainId("TRN-1234"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat() {
        assertFalse(isValidTrainId("TRAIN12"));
        assertFalse(isValidTrainId("TRN12A"));
        assertFalse(isValidTrainId("1234-TRN"));
    }

    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(isValidCargoCode("PET-AB"));
    }

    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        assertFalse(isValidCargoCode("PET-ab"));
        assertFalse(isValidCargoCode("PET123"));
        assertFalse(isValidCargoCode("AB-PET"));
    }

    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(isValidTrainId("TRN-123"));
        assertFalse(isValidTrainId("TRN-12345"));
    }

    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(isValidCargoCode("PET-ab"));
        assertFalse(isValidCargoCode("PET-aB"));
    }

    @Test
    public void testRegex_EmptyInputHandling() {
        assertFalse(isValidTrainId(""));
        assertFalse(isValidCargoCode(""));
    }

    @Test
    public void testRegex_ExactPatternMatch() {
        assertFalse(isValidTrainId("TRN-1234extra"));
        assertFalse(isValidCargoCode("PET-ABextra"));
    }
}
