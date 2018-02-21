package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberListener implements ActionListener {

	/**
	 * instance of CalculatorFace
	 */
	private CalculatorFace face;
	
	/**
	 * integer to be added to hold
	 */
	private int num;
	
	/**
	 * instance of CalcBrain for methods
	 */
	private CalcBrain brain;
	
	public NumberListener(CalculatorFace face, int num, CalcBrain brain){
		this.face = face;
		this.num = num;
		this.brain = brain;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		brain.append(num);
		brain.number(brain);
		face.writeToScreen(brain.getHold().getString());
	}

}
