package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorListener implements ActionListener {

	/**
	 * instance of CalculatorFace
	 */
	private CalculatorFace face;
	
	/**
	 * strat for the right operator method
	 */
	private CalcStrategy strat;
	
	/**
	 * instance of CalcBrain for methods
	 */
	private CalcBrain brain;
	
	public OperatorListener(CalculatorFace face, CalcStrategy strat, CalcBrain brain){
		this.face = face;
		this.strat = strat;
		this.brain = brain;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
			brain.op(face, brain);
			brain.setStrat(strat);
	}

}
