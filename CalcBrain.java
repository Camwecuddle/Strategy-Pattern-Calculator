package calc;

import java.util.ArrayList;

/**
 * Class that will do the operations for the calculator
 * @author camronvick
 *
 */

public class CalcBrain {
	
	/**
	 * state that the calulator is in based on number of operators
	 */
	private CalcState opState;
	
	/**
	 * is the number being operated on positive or negative
	 */
	private NegativeState negState;
	
	/**
	 * The instance of decimalstate that determines if there is already a decommal in the number or not.
	 */
	private DecimalState decState;
	
	/**
	 * CalcStrategy that has the operate function we need
	 */
	
	private CalcStrategy strat;
	/**
	 * holds the number being created on the calculator
	 */
	
	private HoldWrapper hold;
	
	/**
	 * ArrayList to hold the operands that will be operated on
	 */
	private ArrayList<Double> operands;
	
	/**
	 * constructor
	 */
	public CalcBrain(){
		operands = new ArrayList<Double>(2); //initializing the arrayList
		operands.add(0.0);
		operands.add(0.0);
		hold = new HoldWrapper("");
		opState = NoOperandState.getInstance();
		decState = NoDecimal.getInstance();
		negState = NothingNeg.getInstance();
	}
	
	/**
	 * Moves to the next opState when a number button is pressed.
	 */
	public void number(CalcBrain brain){
		opState = opState.num(operands, negState, brain);
	}
	
	/**
	 * Tells the brain to do some calculation/action
	 */
	public void op(CalculatorFace face, CalcBrain brain){
		opState = opState.operator(operands, hold, strat, face, negState, decState, brain);
		hold.setString("");
		
		System.out.print("Operators:");
		for(double d: operands){
			System.out.print(d+", ");
		}
		System.out.println();
	}
	
	/**
	 * resets all the calculators instance variables to their original states
	 */
	public void clear(){
		opState = NoOperandState.getInstance();
		operands.set(0,0.0);
		operands.set(1,0.0);
		hold.setString("");
		strat = null;
		negState = NothingNeg.getInstance();
		decState = NoDecimal.getInstance();
	}
	
	/**
	 * When the equals button is pressed the opState will move to the next CalcState
	 */
	public void equal(CalculatorFace face, CalcBrain brain){
		opState = opState.equals(operands, hold, strat, face, negState, brain);
		hold.setString("");
		
		System.out.print("Operators:");
		for(double d: operands){
			System.out.print(d+", ");
		}
		System.out.println();
	}
	
	/**
	 * When the decimal button is pressed the calculator will move to the next state
	 */
	public void decimal(CalcBrain brain){
		opState = opState.dot(operands, hold, negState, decState, brain);
	}
	
	/**
	 * When the plusMinus button is pushed
	 */
	public void plusMin(CalculatorFace face, CalcBrain brain){
		opState.plusMinus(operands, hold, face, negState, brain);
	}
	
	/**
	 * appends num onto the tail of op
	 */
	public void append(int num){
		hold.setString(hold.getString() + Integer.toString(num));

	}
	
	/**
	 * sets the strat
	 * @param newStrat the strat with the operate function that we need
	 */
	public void setStrat(CalcStrategy newStrat){
		strat = newStrat;
	}
	
	/**
	 * sets the negState
	 * @param newState the state with the functions that we need
	 */
	public void setNegState(NegativeState newState){
		negState = newState;
	}
	
	/**
	 * sets the decState
	 * @param newState the state with the functions that we need
	 */
	public void setDecState(DecimalState newState){
		decState = newState;
	}

	public HoldWrapper getHold() {
		return hold;
	}

	public ArrayList<Double> getOperands(){
		return operands;
	}

	
}
