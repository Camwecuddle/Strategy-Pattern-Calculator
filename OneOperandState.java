package calc;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * If there is one operator stored in the array
 * @author camronvick
 *
 */
public class OneOperandState implements CalcState {

	private static OneOperandState instance;
	
	DecimalFormat output = new DecimalFormat("0.#############");
	
	/**
	 * constructor
	 */
	private OneOperandState(){
	}

	/**
	 * creates a new instance if there isn't already one, or just returns the active instance of PlusStrat
	 * @return the only instance of OneOperatorState
	 */
	public static OneOperandState getInstance()
	{
		if (instance == null)
			instance = new OneOperandState();

		return instance;
	}
	

	@Override
	public CalcState equals(ArrayList<Double> operands, HoldWrapper hold, CalcStrategy strat, CalculatorFace face, NegativeState negState, CalcBrain brain) {
		try{ //for dealing with division by zero
			double num = Double.parseDouble(hold.getString());
			operands.set(1,num);
			operands.set(1,Double.parseDouble(output.format(strat.operate(operands.get(0),operands.get(1))))); //performs calculation and sets the result as the second value in the array list
			operands.set(0,num);
			face.writeToScreen(operands.get(1).toString());
			brain.setDecState(NoDecimal.getInstance());
			return TwoOperandsState.getInstance();
		} catch(NumberFormatException e){
			face.writeToScreen("ERROR: div by 0");
			return NoOperandState.getInstance();
		}
		
	}

	@Override
	public CalcState plusMinus(ArrayList<Double> operands, HoldWrapper hold, CalculatorFace face, NegativeState negState, CalcBrain brain) {
		brain.setNegState(negState.changeSign(operands, hold, face));
		face.writeToScreen(hold.getString());
		return getInstance();
	}

	@Override
	public CalcState operator(ArrayList<Double> operands, HoldWrapper hold, CalcStrategy strat, CalculatorFace face, NegativeState negState, DecimalState decState, CalcBrain brain) {
		double num = Double.parseDouble(hold.getString());
		operands.set(1,num);
		operands.set(0,Double.parseDouble(output.format(strat.operate(operands.get(0),operands.get(1))))); //performs calculation and sets the result as the second value in the array list
		face.writeToScreen(operands.get(0).toString());
		return OneOperandState.getInstance();
	}

	@Override
	public CalcState num(ArrayList<Double> operands, NegativeState negState, CalcBrain brain) {
		return getInstance();
	}

	@Override
	public CalcState dot(ArrayList<Double> operands, HoldWrapper hold, NegativeState negState, DecimalState decState, CalcBrain brain) {
		brain.setDecState(decState.toggleDot(hold));
		return getInstance();
	}

}