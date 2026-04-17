import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // LinkedHashSet preserves insertion order + uniqueness
        Set<String> trainFormation = new LinkedHashSet<>();

        // Attach bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Attempt duplicate insertion
        trainFormation.add("Sleeper"); // duplicate ignored

        // Display final formation
        System.out.println("\nFinal Train Formation:");
        System.out.println(trainFormation);
    }
}