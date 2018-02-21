package calc;
import java.util.ArrayList;

/**
 * interface to determine the sign in front of the important operand
 * @author camronvick
 *
 */
public interface NegativeState {

	/**
	 * method to change the important operators sign and print it to the screen
	 * @param operands
	 * @param hold
	 * @return
	 */
	public abstract NegativeState changeSign(ArrayList<Double> operands, HoldWrapper hold, CalculatorFace face);
	
	
	
	
}
