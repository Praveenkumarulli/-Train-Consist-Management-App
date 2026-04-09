/**
 * UC15: Goods Bogie Class with Safe Cargo Assignment
 * 
 * Represents a goods bogie in the train consist that can carry cargo.
 * Each goods bogie has:
 * - A unique bogie ID
 * - A shape (Rectangular or Cylindrical)
 * - Assigned cargo type (if any)
 * - Safety validation for cargo assignments
 * 
 * Safety Rules:
 * - Petroleum cannot be assigned to Rectangular bogies (fire hazard)
 * - Petroleum can be assigned to Cylindrical bogies (safe)
 * - Other cargo types can be assigned to any bogie shape
 */
public class GoodsBogie {
    private String bogieId;
    private String shape;              // "Rectangular" or "Cylindrical"
    private String assignedCargo;      // null if no cargo assigned
    private boolean cargoAssigned;
    
    /**
     * Constructor to create a goods bogie with specific shape
     * @param bogieId Unique identifier for the bogie
     * @param shape The bogie shape: "Rectangular" or "Cylindrical"
     */
    public GoodsBogie(String bogieId, String shape) {
        this.bogieId = bogieId;
        this.shape = shape;
        this.assignedCargo = null;
        this.cargoAssigned = false;
    }
    
    // Getters
    public String getBogieId() {
        return bogieId;
    }
    
    public String getShape() {
        return shape;
    }
    
    public String getAssignedCargo() {
        return assignedCargo;
    }
    
    public boolean isCargoAssigned() {
        return cargoAssigned;
    }
    
    /**
     * UC15: Safe Cargo Assignment with Exception Handling
     * 
     * This method demonstrates try-catch-finally pattern:
     * - try: Attempt to validate and assign cargo
     * - catch: Handle safety violations by catching CargoSafetyException
     * - finally: Execute cleanup/logging regardless of success or failure
     * 
     * Safety Rule: Petroleum cannot be assigned to Rectangular bogies
     * 
     * @param cargoType The type of cargo to assign (e.g., "Petroleum", "Grain")
     * @throws CargoSafetyException if attempting unsafe assignment
     */
    public void assignCargo(String cargoType) {
        boolean validationComplete = false;
        
        try {
            // Validation logic: Check for unsafe combinations
            if (cargoType == null || cargoType.trim().isEmpty()) {
                throw new CargoSafetyException("Cargo type cannot be empty");
            }
            
            // Safety Check: Petroleum in Rectangular bogie is unsafe
            if (cargoType.equalsIgnoreCase("Petroleum") && 
                this.shape.equalsIgnoreCase("Rectangular")) {
                throw new CargoSafetyException(
                    "SAFETY VIOLATION: Cannot assign Petroleum to Rectangular bogie. " +
                    "Petroleum is flammable; Rectangular bogies have open tops creating fire hazards."
                );
            }
            
            // If we reach here, cargo assignment is safe
            this.assignedCargo = cargoType;
            this.cargoAssigned = true;
            System.out.println("✓ Cargo assignment successful: " + cargoType + 
                             " assigned to bogie " + bogieId + " (" + shape + ")");
            
        } catch (CargoSafetyException e) {
            // Catch and handle the safety exception
            System.err.println("✗ ERROR - Cargo assignment failed for bogie " + bogieId);
            System.err.println("  Reason: " + e.getMessage());
            
            // Ensure cargo is NOT assigned on failure
            this.assignedCargo = null;
            this.cargoAssigned = false;
            
        } finally {
            // Finally block always executes - for logging/cleanup
            validationComplete = true;
            System.out.println("  [Validation Complete] Bogie " + bogieId + 
                             " - Cargo Assignment Status: " + 
                             (cargoAssigned ? "SUCCESS" : "FAILED"));
        }
    }
    
    /**
     * Display bogie details including cargo status
     */
    public void displayDetails() {
        System.out.println("Bogie ID: " + bogieId + ", Shape: " + shape + 
                         ", Cargo: " + (cargoAssigned ? assignedCargo : "None"));
    }
}
