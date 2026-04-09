/**
 * UC15: Custom Runtime Exception for Unsafe Cargo Assignments
 * 
 * CargoSafetyException is a custom unchecked (runtime) exception
 * that is thrown when attempting to assign cargo to a bogie in
 * an unsafe combination that violates railway safety constraints.
 * 
 * Example: Assigning Petroleum to a Rectangular bogie is unsafe
 * because Petroleum is flammable and Rectangular bogies have open
 * tops, creating fire hazards.
 * 
 * Key Concept: Runtime exceptions are not checked by the compiler,
 * meaning they can be thrown and handled during program execution
 * rather than at compile time.
 */
public class CargoSafetyException extends RuntimeException {
    
    /**
     * Constructor with error message
     * @param message Description of the safety violation
     */
    public CargoSafetyException(String message) {
        super(message);
    }
    
    /**
     * Constructor with error message and root cause
     * @param message Description of the safety violation
     * @param cause The underlying exception that caused this safety exception
     */
    public CargoSafetyException(String message, Throwable cause) {
        super(message, cause);
    }
}
