package calc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for the clear button
 * @author camronvick
 *
 */
public class ClearListener implements ActionListener {
	/**
	 * instance of CalcBrain for methods
	 */
	private CalcBrain brain;
	
	/**
	 * instance of CalculatorFace
	 */
	private CalculatorFace face;
	
	public ClearListener(CalculatorFace face, CalcBrain brain){
		this.brain = brain;
		this.face = face;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		brain.clear();
		face.writeToScreen("");
	}

}
