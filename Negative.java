package calc;

import java.util.ArrayList;

/**
 * Determines the function of the plus/minus button when the number is negative
 * @author camronvick
 *
 */
public class Negative implements NegativeState {

	private static Negative instance;
	/**
	 * constructor
	 */
	private Negative(){
	}

	/**
	 * creates a new instance if there isn't already one, or just returns the active instance of PlusStrat
	 * @return the only instance of OneOperatorState
	 */
	public static Negative getInstance()
	{
		if (instance == null)
			instance = new Negative();

		return instance;
	}
	
	@Override
	public NegativeState changeSign(ArrayList<Double> operands, HoldWrapper hold, CalculatorFace face) {
		System.out.println("Negative changeSign");
		hold.setString(hold.getString().substring(1));
		face.writeToScreen(hold.getString());
		return Positive.getInstance();
	}
}
