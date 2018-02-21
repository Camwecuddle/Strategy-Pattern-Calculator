package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DecimalListener implements ActionListener {

	CalcBrain brain;
	
	CalculatorFace face;
	
	public DecimalListener(CalculatorFace face, CalcBrain brain){
		this.face = face;
		this.brain = brain;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		brain.decimal(brain);
		face.writeToScreen(brain.getHold().getString());

	}

}
