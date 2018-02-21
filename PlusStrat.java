package calc;

/**
 * Singleton class that will be instantiated whenever a new calculator is loaded for the plus button 
 * @author camronvick
 *
 */
public class PlusStrat implements CalcStrategy{

	private static PlusStrat instance;
	/**
	 * constructor
	 */
	private PlusStrat(){
	}

	/**
	 * creates a new instance if there isn't already one, or just returns the active instance of PlusStrat
	 * @return the only instance of PlusStrat
	 */
	public static PlusStrat getInstance()
	{
		if (instance == null)
			instance = new PlusStrat();

		return instance;
	}
	
	public double operate(double op1, double op2){
		double res = op1 + op2;
		return res;
	}
	
	public void act(){
		
	}

}