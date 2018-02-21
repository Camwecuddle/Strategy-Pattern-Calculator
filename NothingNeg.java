package calc;

import java.util.ArrayList;

/**
 * Determines the function of the plus/minus button when their is nothing on the calculator
 * @author camronvick
 *
 */
public class NothingNeg implements NegativeState {

	private static NothingNeg instance;
	/**
	 * constructor
	 */
	private NothingNeg(){
	}

	/**
	 * creates a new instance if there isn't already one, or just returns the active instance of PlusStrat
	 * @return the only instance of OneOperatorState
	 */
	public static NothingNeg getInstance()
	{
		if (instance == null)
			instance = new NothingNeg();

		return instance;
	}
	
	@Override
	public NegativeState changeSign(ArrayList<Double> operands, HoldWrapper hold, CalculatorFace face) {	
		System.out.println("nothingNeg changeSign");
		hold.setString("-");
		return Negative.getInstance();
	}
	
}

