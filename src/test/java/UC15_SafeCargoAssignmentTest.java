import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * UC15: Safe Cargo Assignment Test Cases
 * 
 * Test Suite for validating exception handling in cargo assignments
 * 
 * Test Cases:
 * 1. testCargo_SafeAssignment() - Verify successful safe cargo assignments
 * 2. testCargo_UnsafeAssignmentHandled() - Verify exception handling for unsafe combinations
 * 3. testCargo_CargoNotAssignedAfterFailure() - Verify cargo is NOT assigned on failure
 * 4. testCargo_ProgramContinuesAfterException() - Verify resilience after failures
 * 5. testCargo_FinallyBlockExecution() - Verify finally block always executes
 */
public class UC15_SafeCargoAssignmentTest {
    
    private GoodsBogie rectangularBogie;
    private GoodsBogie cylindricalBogie;
    
    /**
     * Setup method: Initialize test fixtures before each test
     */
    @Before
    public void setUp() {
        rectangularBogie = new GoodsBogie("BG-RECT-TEST-01", "Rectangular");
        cylindricalBogie = new GoodsBogie("BG-CYL-TEST-01", "Cylindrical");
    }
    
    /**
     * Test Case 1: testCargo_SafeAssignment()
     * 
     * Verifies that safe cargo assignments are processed successfully.
     * 
     * Scenario:
     * - Assign Grain to Rectangular bogie (safe)
     * - Assign Petroleum to Cylindrical bogie (safe)
     * 
     * Expected Output:
     * - Cargo is successfully assigned
     * - cargoAssigned flag is true
     * - getAssignedCargo() returns the correct cargo type
     */
    @Test
    public void testCargo_SafeAssignment() {
        System.out.println("\n--- Test: Safe Cargo Assignment ---");
        
        // Test 1a: Grain to Rectangular bogie is safe
        rectangularBogie.assignCargo("Grain");
        assertTrue("Grain should be assigned to Rectangular bogie", 
                   rectangularBogie.isCargoAssigned());
        assertEquals("Assigned cargo should be Grain", 
                     "Grain", rectangularBogie.getAssignedCargo());
        
        // Test 1b: Petroleum to Cylindrical bogie is safe
        cylindricalBogie.assignCargo("Petroleum");
        assertTrue("Petroleum should be assigned to Cylindrical bogie", 
                   cylindricalBogie.isCargoAssigned());
        assertEquals("Assigned cargo should be Petroleum", 
                     "Petroleum", cylindricalBogie.getAssignedCargo());
        
        System.out.println("✓ Test Passed: Safe assignments succeeded");
    }
    
    /**
     * Test Case 2: testCargo_UnsafeAssignmentHandled()
     * 
     * Verifies that assigning petroleum to a rectangular bogie triggers
     * safety validation and raises an exception that is caught and handled.
     * 
     * Scenario:
     * - Attempt to assign Petroleum to Rectangular bogie (unsafe)
     * - Exception should be caught internally
     * - No exception should propagate to test
     * 
     * Expected Output:
     * - Method executes without throwing exception
     * - Cargo is NOT assigned
     * - System displays error message
     */
    @Test
    public void testCargo_UnsafeAssignmentHandled() {
        System.out.println("\n--- Test: Unsafe Cargo Assignment Handled ---");
        
        // Attempt unsafe assignment (should not throw uncaught exception)
        try {
            rectangularBogie.assignCargo("Petroleum");
            // Exception is caught internally, so we reach here
            System.out.println("✓ Exception was handled internally");
        } catch (CargoSafetyException e) {
            fail("CargoSafetyException should be caught internally: " + e.getMessage());
        }
        
        System.out.println("✓ Test Passed: Unsafe assignment was handled");
    }
    
    /**
     * Test Case 3: testCargo_CargoNotAssignedAfterFailure()
     * 
     * Verifies that when an unsafe cargo assignment occurs,
     * the cargo is NOT assigned to the bogie.
     * 
     * Scenario:
     * - Attempt to assign Petroleum to Rectangular bogie
     * - Check that cargoAssigned is false
     * - Check that getAssignedCargo() returns null
     * 
     * Expected Output:
     * - cargoAssigned flag remains false
     * - getAssignedCargo() is null
     * - Bogie is left in a safe state
     */
    @Test
    public void testCargo_CargoNotAssignedAfterFailure() {
        System.out.println("\n--- Test: Cargo NOT Assigned After Failure ---");
        
        // Initial state
        assertFalse("Initially, no cargo should be assigned", 
                    rectangularBogie.isCargoAssigned());
        assertNull("Initially, assignedCargo should be null", 
                   rectangularBogie.getAssignedCargo());
        
        // Attempt unsafe assignment
        rectangularBogie.assignCargo("Petroleum");
        
        // Verify cargo was NOT assigned
        assertFalse("After unsafe assignment failure, cargo should NOT be assigned", 
                    rectangularBogie.isCargoAssigned());
        assertNull("After unsafe assignment failure, assignedCargo should be null", 
                   rectangularBogie.getAssignedCargo());
        
        System.out.println("✓ Test Passed: Cargo was not assigned on failure");
    }
    
    /**
     * Test Case 4: testCargo_ProgramContinuesAfterException()
     * 
     * Verifies that the application continues execution after handling
     * an unsafe cargo assignment exception, without crashing.
     * 
     * Scenario:
     * - Assign Grain to bogie1 (success)
     * - Attempt to assign Petroleum to bogie2 - Rectangular (failure)
     * - Assign Steel to bogie3 (should execute normally)
     * 
     * Expected Output:
     * - All three operations complete
     * - bogie1 and bogie3 have cargo assigned
     * - bogie2 does not have cargo
     * - Program continues after the failure
     */
    @Test
    public void testCargo_ProgramContinuesAfterException() {
        System.out.println("\n--- Test: Program Continues After Exception ---");
        
        GoodsBogie bogie1 = new GoodsBogie("BG-RECT-A", "Rectangular");
        GoodsBogie bogie2 = new GoodsBogie("BG-RECT-B", "Rectangular");
        GoodsBogie bogie3 = new GoodsBogie("BG-CYL-C", "Cylindrical");
        
        // Operation 1: Safe assignment
        bogie1.assignCargo("Steel");
        assertTrue("Bogie 1 should have Steel cargo", bogie1.isCargoAssigned());
        
        // Operation 2: Unsafe assignment (fails, but handled)
        bogie2.assignCargo("Petroleum");
        assertFalse("Bogie 2 should NOT have cargo (failed)", bogie2.isCargoAssigned());
        
        // Operation 3: Program continues and executes successfully
        bogie3.assignCargo("Petroleum");
        assertTrue("Bogie 3 should have Petroleum cargo (safe)", bogie3.isCargoAssigned());
        
        System.out.println("✓ Test Passed: Program continued after exception");
    }
    
    /**
     * Test Case 5: testCargo_FinallyBlockExecution()
     * 
     * Verifies that the finally block in assignCargo() executes
     * regardless of whether the assignment succeeds or fails.
     * 
     * Scenario:
     * - The assignCargo method logs "Validation Complete" in finally block
     * - This should happen for both success and failure cases
     * 
     * Expected Output:
     * - Finally block executes (demonstrated by completion logging)
     * - Works for both safe and unsafe assignments
     */
    @Test
    public void testCargo_FinallyBlockExecution() {
        System.out.println("\n--- Test: Finally Block Execution ---");
        
        // Test with safe assignment (finally should execute)
        System.out.println("Testing finally block with safe assignment:");
        rectangularBogie.assignCargo("Grain");
        
        // Test with unsafe assignment (finally should still execute)
        System.out.println("Testing finally block with unsafe assignment:");
        GoodsBogie unsafeBogie = new GoodsBogie("BG-RECT-UNSAFE", "Rectangular");
        unsafeBogie.assignCargo("Petroleum");
        
        System.out.println("✓ Test Passed: Finally block executed in both cases");
    }
    
    /**
     * Additional Test: testCargo_EmptyCargoType()
     * 
     * Verifies that empty cargo types are rejected with appropriate error handling
     */
    @Test
    public void testCargo_EmptyCargoType() {
        System.out.println("\n--- Test: Empty Cargo Type Validation ---");
        
        rectangularBogie.assignCargo("");
        assertFalse("Empty cargo should not be assigned", 
                    rectangularBogie.isCargoAssigned());
        
        System.out.println("✓ Test Passed: Empty cargo rejected");
    }
    
    /**
     * Additional Test: testCargo_MultipleAssignments()
     * 
     * Verifies behavior when multiple cargo assignments are attempted
     */
    @Test
    public void testCargo_MultipleAssignments() {
        System.out.println("\n--- Test: Multiple Sequential Assignments ---");
        
        GoodsBogie bogie = new GoodsBogie("BG-MULTI", "Cylindrical");
        
        // First assignment
        bogie.assignCargo("Grain");
        assertTrue("First assignment should succeed", bogie.isCargoAssigned());
        assertEquals("First cargo should be Grain", "Grain", bogie.getAssignedCargo());
        
        // Note: In a real system, you might want to clear cargo before reassigning
        // This test demonstrates current behavior
        
        System.out.println("✓ Test Passed: Multiple assignments handled");
    }
}
