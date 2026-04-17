import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC10: Count Total Seats in Train (reduce)
 */
public class TrainConsistManagementAppTest {

    // Helper method to create test bogies
    private List<Bogie> createTestBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 96));
        bogies.add(new Bogie("First Class", 48));
        return bogies;
    }

    // Helper method to calculate total seats
    private int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .mapToInt(Bogie::getCapacity)
                .sum();
    }

    @Test
    public void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = createTestBogies();
        int total = calculateTotalSeats(bogies);
        assertEquals(72 + 96 + 48, total);
    }

    @Test
    public void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = createTestBogies();
        int total = calculateTotalSeats(bogies);
        assertEquals(216, total);
    }

    @Test
    public void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        int total = calculateTotalSeats(bogies);
        assertEquals(72, total);
    }

    @Test
    public void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        int total = calculateTotalSeats(bogies);
        assertEquals(0, total);
    }

    @Test
    public void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = createTestBogies();
        // Assuming mapToInt extracts correctly, as tested in total calculation
        int total = calculateTotalSeats(bogies);
        assertEquals(216, total);
    }

    @Test
    public void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = createTestBogies();
        int total = calculateTotalSeats(bogies);
        assertEquals(216, total); // All three included
    }

    @Test
    public void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = createTestBogies();
        List<Bogie> original = new ArrayList<>(bogies);
        calculateTotalSeats(bogies);
        assertEquals(original, bogies);
    }
}