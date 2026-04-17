import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Train Consist Management App
 * UC11: Validate Train ID & Cargo Codes (Regex)
 */

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        // Print welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println();

        // UC11: Validate Train ID & Cargo Codes (Regex)
        System.out.println("--- UC11: Validate Train ID & Cargo Codes (Regex) ---");
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        // Get Train ID
        System.out.print("Enter Train ID (format: TRN-1234): ");
        String trainId = scanner.nextLine();

        // Get Cargo Code
        System.out.print("Enter Cargo Code (format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // Validate Train ID
        Pattern trainIdPattern = Pattern.compile("TRN-\\d{4}");
        Matcher trainIdMatcher = trainIdPattern.matcher(trainId);
        boolean isTrainIdValid = trainIdMatcher.matches();

        // Validate Cargo Code
        Pattern cargoCodePattern = Pattern.compile("PET-[A-Z]{2}");
        Matcher cargoCodeMatcher = cargoCodePattern.matcher(cargoCode);
        boolean isCargoCodeValid = cargoCodeMatcher.matches();

        // Display results
        System.out.println();
        System.out.println("Validation Results:");
        System.out.println("Train ID '" + trainId + "': " + (isTrainIdValid ? "Valid" : "Invalid"));
        System.out.println("Cargo Code '" + cargoCode + "': " + (isCargoCodeValid ? "Valid" : "Invalid"));

        if (isTrainIdValid && isCargoCodeValid) {
            System.out.println("✓ All inputs are valid. Proceeding with train operations.");
        } else {
            System.out.println("✗ Invalid input detected. Please correct and try again.");
        }
        System.out.println();

        System.out.println("Key Benefits of Regex Validation:");
        System.out.println("✓ Ensures data integrity and format correctness");
        System.out.println("✓ Prevents invalid data from entering the system");
        System.out.println("✓ Introduces pattern-based validation techniques");
        System.out.println("✓ Improves robustness of input handling");
        System.out.println("✓ Builds foundation for enterprise validation rules");
        System.out.println();

        System.out.println("Program continues...");
    }
}
