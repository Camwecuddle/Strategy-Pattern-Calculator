package calc;

/**
 * SetUp
 * 
 * Class to set up and start the calculator, plus
 * facilities for test-driving the calculator.
 *
 * @author Thomas VanDrunen
 * CS 245, Wheaton College
 * June 27, 2014
*/
public class SetUp {

	/**
	 * Method for initializing the calculator internals and
	 * connecting them to the calculator face.
	 * @param face The component representing the user interface of 
	 * the calculator. 
	 */
	public static void setUpCalculator(CalculatorFace face) {
		
		/**
		 * instance of brain that will do the operating
		 */
		CalcBrain brain = new CalcBrain();
		
		for (int i = 0; i<10; i++){
			face.addNumberActionListener(i, new NumberListener(face, i, brain));
		}
		face.addActionListener('.', new DecimalListener(face, brain));
		face.addActionListener('+', new OperatorListener(face, PlusStrat.getInstance(), brain));
		face.addActionListener('-', new OperatorListener(face, MinusStrat.getInstance(), brain));
		face.addActionListener('*', new OperatorListener(face, MultiplyStrat.getInstance(), brain));
		face.addActionListener('/', new OperatorListener(face, DivideStrat.getInstance(), brain));
		face.addActionListener('C', new ClearListener(face, brain));
		face.addActionListener('=', new EqualsListener(face, brain));
		face.addPlusMinusActionListener(new PlusMinusListener(face, brain));
	}
	
	
	/**
	 * This main method is for your testing of your calculator.
	 * It will *not* be used during grading. Any changes you make
	 * to this method will be ignored at grading.
	 */
	public static void main(String[] args) {
		setUpCalculator(new PlainCalculatorFace());
	}

}
