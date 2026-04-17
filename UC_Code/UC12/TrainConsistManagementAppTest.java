import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for UC12: Safety Compliance Check for Goods Bogies
 */
public class TrainConsistManagementAppTest {

    // Helper method to check safety
    private boolean isSafe(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b -> !"Cylindrical".equals(b.getType()) || "Petroleum".equals(b.getCargo()));
    }

    @Test
    public void testSafety_AllBogiesValid() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Rectangular", "Coal"));
        assertTrue(isSafe(bogies));
    }

    @Test
    public void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Coal"));
        assertFalse(isSafe(bogies));
    }

    @Test
    public void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));
        assertTrue(isSafe(bogies));
    }

    @Test
    public void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Cylindrical", "Coal"));
        assertFalse(isSafe(bogies));
    }

    @Test
    public void testSafety_EmptyBogieList() {
        List<GoodsBogie> bogies = new ArrayList<>();
        assertTrue(isSafe(bogies));
    }
}
