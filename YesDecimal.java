package calc;

/**
 * Class to determine the function of the dot button when there is already a decimal present
 * @author camronvick
 *
 */
public class YesDecimal implements DecimalState {

	private static YesDecimal instance;
	/**
	 * constructor
	 */
	private YesDecimal(){
	}

	/**
	 * creates a new instance if there isn't already one, or just returns the active instance of PlusStrat
	 * @return the only instance of OneOperatorState
	 */
	public static YesDecimal getInstance()
	{
		if (instance == null)
			instance = new YesDecimal();

		return instance;
	}
	
	@Override
	public DecimalState toggleDot(HoldWrapper hold) {
		return getInstance();
	}

}
