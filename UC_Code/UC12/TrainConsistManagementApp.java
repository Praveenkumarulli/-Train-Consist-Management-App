import java.util.ArrayList;
import java.util.List;

/**
 * Train Consist Management App
 * UC12: Safety Compliance Check for Goods Bogies
 */

/**
 * GoodsBogie class to represent a goods bogie with type and cargo.
 */
class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return type + " bogie carrying " + cargo;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Print welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println();

        // UC12: Safety Compliance Check for Goods Bogies
        System.out.println("--- UC12: Safety Compliance Check for Goods Bogies ---");
        System.out.println();

        // Create a list of goods bogies
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Rectangular", "Coal"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Grain"));

        // Display goods bogies
        System.out.println("Goods bogies in the train:");
        for (int i = 0; i < goodsBogies.size(); i++) {
            System.out.println((i + 1) + ". " + goodsBogies.get(i));
        }
        System.out.println();

        // Validate safety compliance using streams
        System.out.println("Checking safety compliance...");
        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> !"Cylindrical".equals(b.getType()) || "Petroleum".equals(b.getCargo()));

        System.out.println("Safety compliance check result: " + (isSafe ? "SAFE" : "UNSAFE"));
        System.out.println();

        if (isSafe) {
            System.out.println("✓ All goods bogies comply with safety rules.");
        } else {
            System.out.println("✗ Safety violation detected! Cylindrical bogies must carry Petroleum only.");
        }
        System.out.println();

        System.out.println("Key Benefits of Stream Validation:");
        System.out.println("✓ Enforces business rules declaratively");
        System.out.println("✓ Prevents unsafe configurations early");
        System.out.println("✓ Uses functional programming for validation");
        System.out.println("✓ Improves code readability and safety");
        System.out.println("✓ Builds foundation for domain rule enforcement");
        System.out.println();

        System.out.println("Program continues...");
    }
}
