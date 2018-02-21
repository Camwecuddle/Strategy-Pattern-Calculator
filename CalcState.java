package calc;
import java.util.ArrayList;

/**
 * Determines the state of the calculator based on the number of operators in the arraylist
 * @author camronvick
 *
 */
public interface CalcState {
	
	/**
	 * if an operator is pressed
	 * @param operands
	 * @param hold
	 * @param strat
	 * @param face
	 * @param negState
	 * @param decState
	 * @return
	 */
	public abstract CalcState operator(ArrayList<Double> operands, HoldWrapper hold, CalcStrategy strat, CalculatorFace face, NegativeState negState, DecimalState decState, CalcBrain brain);
	
	/**
	 * When a number button is pressed
	 * @param operands
	 * @param negState
	 * @param brain
	 * @return
	 */
	public abstract CalcState num(ArrayList<Double> operands, NegativeState negState, CalcBrain brain);
	
	/**
	 * When the equals button is pressed
	 * @param operands
	 * @param hold
	 * @param strat
	 * @param face
	 * @param negState
	 * @return
	 */
	public abstract CalcState equals(ArrayList<Double> operands, HoldWrapper hold, CalcStrategy strat, CalculatorFace face, NegativeState negState, CalcBrain brain);
	
	/**
	 * When the pulsMinus button is pressed
	 * @param operands
	 * @param hold
	 * @param face
	 * @param negState
	 * @return
	 */
	public abstract CalcState plusMinus(ArrayList<Double> operands, HoldWrapper hold, CalculatorFace face, NegativeState negState, CalcBrain brain);
	
	/**
	 * when the decimal button is pressed
	 * @param operands
	 * @param hold
	 * @param negState
	 * @param decState
	 * @return
	 */
	public abstract CalcState dot(ArrayList<Double> operands, HoldWrapper hold, NegativeState negState, DecimalState decState, CalcBrain brain);
	

}
