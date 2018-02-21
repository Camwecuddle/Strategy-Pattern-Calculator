package calc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action Listener for the Plus Minus button
 * @author camronvick
 *
 */
public class PlusMinusListener implements ActionListener {

	/**
	 * instance of CalculatorFace
	 */
	private CalculatorFace face;
	
	/**
	 * instance of CalcBrain for methods
	 */
	private CalcBrain brain;
	
	public PlusMinusListener(CalculatorFace face, CalcBrain brain){
		this.face = face;
		this.brain = brain;
	}
	
	/**
	 * What will happen based on the previous NegativeState of the calculator
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		brain.plusMin(face, brain);
	}

}
