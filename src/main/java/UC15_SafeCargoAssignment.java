/**
 * UC15: Safe Cargo Assignment Using try-catch-finally
 * 
 * This application demonstrates how to safely handle unsafe cargo assignments
 * in a railway system using structured exception handling.
 * 
 * Key Concepts:
 * - Custom Runtime Exceptions (CargoSafetyException)
 * - try-catch-finally blocks for structured error handling
 * - Graceful failure management without application crashes
 * - Logging and cleanup in finally blocks
 * 
 * Scenario:
 * A railway operator attempts to assign various cargo types to different bogies.
 * The system validates safety constraints and handles violations gracefully.
 * 
 * Safety Rule: Petroleum cannot be assigned to Rectangular bogies
 * (Petroleum is flammable; Rectangular bogies have open tops)
 */
public class UC15_SafeCargoAssignment {
    
    public static void main(String[] args) {
        System.out.println("===== UC15: Safe Cargo Assignment Using try-catch-finally =====");
        System.out.println();
        
        // Create goods bogies with different shapes
        System.out.println("--- Phase 1: Initialize Goods Bogies ---");
        System.out.println();
        GoodsBogie rectangularBogie = new GoodsBogie("BG-RECT-101", "Rectangular");
        GoodsBogie cylindricalBogie = new GoodsBogie("BG-CYL-102", "Cylindrical");
        System.out.println("Created two goods bogies: 1 Rectangular, 1 Cylindrical");
        System.out.println();
        
        // Phase 2: Test Case 1 - Safe Cargo Assignment
        System.out.println("--- Phase 2: Test Case 1 - Safe Cargo Assignment ---");
        System.out.println("Attempting: Assign Grain to Rectangular bogie");
        System.out.println();
        rectangularBogie.assignCargo("Grain");
        System.out.println();
        
        // Phase 3: Test Case 2 - Unsafe Cargo Detection
        System.out.println("--- Phase 3: Test Case 2 - Unsafe Cargo Detection ---");
        System.out.println("Attempting: Assign Petroleum to Rectangular bogie (UNSAFE)");
        System.out.println();
        
        GoodsBogie unsafeBogie = new GoodsBogie("BG-RECT-103", "Rectangular");
        unsafeBogie.assignCargo("Petroleum");
        System.out.println();
        
        // Verify cargo was NOT assigned on failure
        System.out.println("Verification: Check if cargo was assigned after failure");
        System.out.println("Cargo assigned? " + unsafeBogie.isCargoAssigned());
        System.out.println();
        
        // Phase 4: Test Case 3 - Safe Assignment to Cylindrical Bogie
        System.out.println("--- Phase 4: Test Case 3 - Safe Petroleum Assignment ---");
        System.out.println("Attempting: Assign Petroleum to Cylindrical bogie (SAFE)");
        System.out.println();
        cylindricalBogie.assignCargo("Petroleum");
        System.out.println();
        
        // Phase 5: Test Case 4 - Program Continuation After Exception
        System.out.println("--- Phase 5: Test Case 4 - Program Continuation After Exception ---");
        System.out.println("This demonstrates that the program continues safely after exceptions");
        System.out.println();
        
        GoodsBogie bogie1 = new GoodsBogie("BG-RECT-201", "Rectangular");
        GoodsBogie bogie2 = new GoodsBogie("BG-CYL-202", "Cylindrical");
        GoodsBogie bogie3 = new GoodsBogie("BG-RECT-203", "Rectangular");
        
        System.out.println("Bogie 1: Assigning Steel (safe)");
        bogie1.assignCargo("Steel");
        System.out.println();
        
        System.out.println("Bogie 2: Attempting Petroleum (unsafe to Rectangular, but this is cylindrical)");
        bogie2.assignCargo("Petroleum");
        System.out.println();
        
        System.out.println("Bogie 3: Attempting Petroleum to Rectangular (UNSAFE - should fail)");
        bogie3.assignCargo("Petroleum");
        System.out.println();
        
        System.out.println("Notice: Despite the failure, execution continues to the next assignment!");
        System.out.println();
        
        // Phase 6: Final Status Report
        System.out.println("--- Phase 6: Final Status Report ---");
        System.out.println();
        System.out.println("Current Bogie Status:");
        bogie1.displayDetails();
        bogie2.displayDetails();
        bogie3.displayDetails();
        System.out.println();
        
        // Phase 7: Test Case 5 - Finally Block Verification
        System.out.println("--- Phase 7: Key Observations about try-catch-finally ---");
        System.out.println();
        System.out.println("✓ try block: Contains cargo assignment logic and validation");
        System.out.println("✓ catch block: Handles CargoSafetyException gracefully");
        System.out.println("✓ finally block: Always executes completion logging (see above)");
        System.out.println("✓ Safety rule enforced: Petroleum cannot go to Rectangular bogies");
        System.out.println("✓ Program resilience: App continues despite safety violations");
        System.out.println("✓ Error feedback: Users get clear error messages on failures");
        System.out.println();
        
        System.out.println("===== UC15 Demonstration Complete =====");
    }
}
