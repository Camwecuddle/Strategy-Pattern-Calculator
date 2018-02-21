package calc;

/**
 * Singleton class that will be instantiated whenever a new calculator is loaded
 * @author camronvick
 *
 */

public class MinusStrat implements CalcStrategy{

	private static MinusStrat instance;
	/**
	 * constructor
	 */
	private MinusStrat(){
	}

	/**
	 * creates a new instance if there isn't already one, or just returns the active instance of PlusStrat
	 * @return the only instance of PlusStrat
	 */
	public static MinusStrat getInstance()
	{
		if (instance == null)
			instance = new MinusStrat();

		return instance;
	}
	
	public double operate(double op1, double op2){
		double res = op1 - op2;
		return res;
	}
	
	public void act(){
		
	}

}