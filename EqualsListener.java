package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EqualsListener implements ActionListener {

	/**
	 * instance of CalcBrain for methods
	 */
	private CalcBrain brain;
	
	/**
	 * instance of CalculatorFace
	 */
	private CalculatorFace face;
	
	public EqualsListener(CalculatorFace face, CalcBrain brain){
		this.face = face;
		this.brain = brain;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		brain.equal(face, brain);
		//face.writeToScreen(brain.getOperands().get(1).toString());

	}

}
