import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC13: Performance Comparison (Loops vs Streams)
 */
public class TrainConsistManagementAppTest {

    // Helper methods for filtering
    private List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie bogie : bogies) {
            if (bogie.getCapacity() > 60) {
                result.add(bogie);
            }
        }
        return result;
    }

    private List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    private List<Bogie> createTestBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 50));
        bogies.add(new Bogie("First Class", 96));
        bogies.add(new Bogie("Sleeper", 40));
        return bogies;
    }

    @Test
    public void testLoopFilteringLogic() {
        List<Bogie> bogies = createTestBogies();
        List<Bogie> filtered = filterWithLoop(bogies);
        assertEquals(2, filtered.size());
        assertTrue(filtered.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    public void testStreamFilteringLogic() {
        List<Bogie> bogies = createTestBogies();
        List<Bogie> filtered = filterWithStream(bogies);
        assertEquals(2, filtered.size());
        assertTrue(filtered.stream().allMatch(b -> b.getCapacity() > 60));
    }

    @Test
    public void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = createTestBogies();
        List<Bogie> loopResult = filterWithLoop(bogies);
        List<Bogie> streamResult = filterWithStream(bogies);
        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    public void testExecutionTimeMeasurement() {
        List<Bogie> bogies = createTestBogies();
        long start = System.nanoTime();
        filterWithLoop(bogies);
        long end = System.nanoTime();
        long elapsed = end - start;
        assertTrue(elapsed > 0);
    }

    @Test
    public void testLargeDatasetProcessing() {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            bogies.add(new Bogie("Test", 50 + i));
        }
        List<Bogie> filtered = filterWithStream(bogies);
        assertTrue(filtered.size() > 0);
    }
}
