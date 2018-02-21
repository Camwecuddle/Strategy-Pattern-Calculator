package calc;

/**
 * Interface to determine the operation used
 * @author camronvick
 *
 */
public interface CalcStrategy {
	
	/**
	 * operates on two values
	 * @param op1 left side of the operation
	 * @param op2 right side of the operation
	 * @return
	 */
	public abstract double operate(double op1, double op2);

}
