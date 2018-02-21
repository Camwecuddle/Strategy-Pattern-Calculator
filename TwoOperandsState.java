package calc;
import java.util.ArrayList;

/**
 * If there are two operator stored in the array
 * @author camronvick
 *
 */
public class TwoOperandsState implements CalcState {

	private static TwoOperandsState instance;
	/**
	 * constructor
	 */
	private TwoOperandsState(){
	}

	/**
	 * creates a new instance if there isn't already one, or just returns the active instance of PlusStrat
	 * @return the only instance of OneOperatorState
	 */
	public static TwoOperandsState getInstance()
	{
		if (instance == null)
			instance = new TwoOperandsState();

		return instance;
	}
	

	@Override
	public CalcState equals(ArrayList<Double> operands, HoldWrapper hold, CalcStrategy strat, CalculatorFace face, NegativeState negState, CalcBrain brain) {
		operands.set(1,strat.operate(operands.get(1),operands.get(0))); //performs calculation and sets the result as the second value in the array list
		face.writeToScreen(operands.get(1).toString());
		return getInstance();
	}

	@Override
	public CalcState plusMinus(ArrayList<Double> operands, HoldWrapper hold, CalculatorFace face, NegativeState negState, CalcBrain brain) {
		// TODO Auto-generated method stub
		return getInstance();
	}

	@Override
	public CalcState operator(ArrayList<Double> operands, HoldWrapper hold, CalcStrategy strat, CalculatorFace face, NegativeState negState, DecimalState decState, CalcBrain brain) {
		operands.set(0,operands.get(1)); //performs calculation and sets the result as the second value in the array list
		return OneOperandState.getInstance();
	}

	@Override
	public CalcState num(ArrayList<Double> operands, NegativeState negState, CalcBrain brain) {
		brain.setNegState(Positive.getInstance());
		operands.set(0,0.0);
		operands.set(1,0.0);
		brain.setNegState(Positive.getInstance());
		return NoOperandState.getInstance();
	}

	@Override
	public CalcState dot(ArrayList<Double> operands, HoldWrapper hold, NegativeState negState, DecimalState decState, CalcBrain brain) {
		brain.setDecState(decState.toggleDot(hold));
		operands.set(0,0.0);
		operands.set(1,0.0);
		brain.setNegState(Positive.getInstance());
		
		return getInstance();
	}

}
