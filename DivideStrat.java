package calc;

/**
 * Singleton class that will be instantiated whenever a new calculator is loaded
 * @author camronvick
 *
 */

public class DivideStrat implements CalcStrategy{

	private static DivideStrat instance;
	/**
	 * constructor
	 */
	private DivideStrat(){
	}

	/**
	 * creates a new instance if there isn't already one, or just returns the active instance of PlusStrat
	 * @return the only instance of PlusStrat
	 */
	public static DivideStrat getInstance()
	{
		if (instance == null)
			instance = new DivideStrat();

		return instance;
	}
	
	public double operate(double op1, double op2){
			double res = op1 / op2;
			return res;
	}
	
	public void act(){
		
	}

}