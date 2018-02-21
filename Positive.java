package calc;

import java.util.ArrayList;

/**
 * Determines the function of the plus/minus button when the number on the calc is positive
 * @author camronvick
 *
 */
public class Positive implements NegativeState {

	private static Positive instance;
	/**
	 * constructor
	 */
	private Positive(){
	}

	/**
	 * creates a new instance if there isn't already one, or just returns the active instance of PlusStrat
	 * @return the only instance of OneOperatorState
	 */
	public static Positive getInstance()
	{
		if (instance == null)
			instance = new Positive();

		return instance;
	}
	
	/**
	 * appends a negative to the front of the number
	 */
	@Override
	public NegativeState changeSign(ArrayList<Double> operands, HoldWrapper hold, CalculatorFace face) {	
		System.out.println("positive changeSign");
		hold.setString("-" + hold.getString());
		face.writeToScreen(hold.getString());
		return Negative.getInstance();
	}
	
}
