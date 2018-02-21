package calc;
import java.util.ArrayList;

/**
 * If there is no operator stored in the array
 * @author camronvick
 *
 */
public class NoOperandState implements CalcState {
	
	private static NoOperandState instance;
	/**
	 * constructor
	 */
	private NoOperandState(){
		
	}

	/**
	 * creates a new instance if there isn't already one, or just returns the active instance of PlusStrat
	 * @return the only instance of NoOperatorState
	 */
	public static NoOperandState getInstance()
	{
		if (instance == null)
			instance = new NoOperandState();

		return instance;
	}

	@Override
	public CalcState equals(ArrayList<Double> operands, HoldWrapper hold, CalcStrategy strat, CalculatorFace face, NegativeState negState, CalcBrain brain) {
		return getInstance();
	}

	@Override
	public CalcState plusMinus(ArrayList<Double> operands, HoldWrapper hold, CalculatorFace face, NegativeState negState, CalcBrain brain) {
		brain.setNegState(negState.changeSign(operands, hold, face));
		return getInstance();
	}

	@Override
	public CalcState operator(ArrayList<Double> operands, HoldWrapper hold, CalcStrategy strat, CalculatorFace face, NegativeState negState, DecimalState decState, CalcBrain brain) {
		operands.set(0,Double.parseDouble(hold.getString()));
		brain.setNegState(Positive.getInstance());
		brain.setDecState(NoDecimal.getInstance());
		return OneOperandState.getInstance();
	}

	@Override
	public CalcState num(ArrayList<Double> operands, NegativeState negState, CalcBrain brain) {
		System.out.println("change to positive");
		brain.setNegState(Positive.getInstance());
		return getInstance();
	}

	@Override
	public CalcState dot(ArrayList<Double> operands, HoldWrapper hold, NegativeState negState, DecimalState decState, CalcBrain brain) {
		brain.setDecState(decState.toggleDot(hold));
		brain.setNegState(Positive.getInstance());
		return getInstance();
	}

}
