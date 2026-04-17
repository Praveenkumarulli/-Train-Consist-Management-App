import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC14: Handle Invalid Bogie Capacity (Custom Exception)
 */
public class TrainConsistManagementAppTest {

    @Test
    public void testException_ValidCapacityCreation() throws InvalidCapacityException {
        Bogie bogie = new Bogie("Sleeper", 72);
        assertEquals("Sleeper", bogie.getName());
        assertEquals(72, bogie.getCapacity());
    }

    @Test
    public void testException_NegativeCapacityThrowsException() {
        InvalidCapacityException exception = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Invalid", -10);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    public void testException_ZeroCapacityThrowsException() {
        InvalidCapacityException exception = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Zero", 0);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    public void testException_ExceptionMessageValidation() {
        InvalidCapacityException exception = assertThrows(InvalidCapacityException.class, () -> {
            new Bogie("Test", -1);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        Bogie bogie = new Bogie("AC Chair", 96);
        assertEquals("AC Chair", bogie.getName());
        assertEquals(96, bogie.getCapacity());
    }

    @Test
    public void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        Bogie bogie1 = new Bogie("Sleeper", 72);
        Bogie bogie2 = new Bogie("First Class", 48);
        assertNotNull(bogie1);
        assertNotNull(bogie2);
        assertEquals("Sleeper", bogie1.getName());
        assertEquals("First Class", bogie2.getName());
    }
}
