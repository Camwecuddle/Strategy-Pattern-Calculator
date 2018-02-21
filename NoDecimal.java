package calc;

/**
 * Class to determine the function of the dot button when there is no decimal already present
 * @author camronvick
 *
 */
public class NoDecimal implements DecimalState {

	private static NoDecimal instance;
	/**
	 * constructor
	 */
	private NoDecimal(){
	}

	/**
	 * creates a new instance if there isn't already one, or just returns the active instance of PlusStrat
	 * @return the only instance of OneOperatorState
	 */
	public static NoDecimal getInstance()
	{
		if (instance == null)
			instance = new NoDecimal();

		return instance;
	}
	
	@Override
	public DecimalState toggleDot(HoldWrapper hold) {
		hold.setString(hold.getString()+".");
		return YesDecimal.getInstance();

	}

}
