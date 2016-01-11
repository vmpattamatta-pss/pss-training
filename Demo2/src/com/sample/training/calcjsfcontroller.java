package com.sample.training;

import com.sample.training.calcjsfmodel;
import com.sample.training.complexcalc;

public class calcjsfcontroller {
	private calcjsfmodel model;
	private String result;
	private boolean showResult;

	public String goBack() {
		model = null;
		showResult = false;
		return "goBack";
	}

	public String calculate() {
		String retOutcome = "";
		complexcalc calc = new complexcalc();
		switch (model.getOp()) {
		case 1:
			int[] calRes = calc.calculate(model.getIntA(), model.getIntB(), model.getIntC(), model.getIntD(), 1);
			result = "Performed Addition on Complex Number " + model.getIntA() + "+i" + model.getIntB() + " and "
					+ model.getIntC() + "+i" + model.getIntD() + " and the result is :: " + calRes[0] + "+i"
					+ calRes[1];
			retOutcome = "addRes";
			break;
		case 2:
			int[] calRes = calc.calculate(model.getIntA(), model.getIntB(), model.getIntC(), model.getIntD(), 1);
			result = "Performed Subtraction on Complex Number " + model.getIntA() + "+i" + model.getIntB() + " and "
					+ model.getIntC() + "+i" + model.getIntD() + " and the result is :: " + calRes[0] + "+i"
					+ calRes[1];
			retOutcome = "subRes";
			break;
		case 3:
			int[] calRes = calc.calculate(model.getIntA(), model.getIntB(), model.getIntC(), model.getIntD(), 1);
			result = "Performed Multiplication on Complex Number " + model.getIntA() + "+i" + model.getIntB() + " and "
					+ model.getIntC() + "+i" + model.getIntD() + " and the result is :: " + calRes[0] + "+i"
					+ calRes[1];
			retOutcome = "mulRes";
			break;
		case 4:
			int[] calRes = calc.calculate(model.getIntA(), model.getIntB(), model.getIntC(), model.getIntD(), 1);
			result = "Performed Division on Complex Number " + model.getIntA() + "+i" + model.getIntB() + " and "
					+ model.getIntC() + "+i" + model.getIntD() + " and the result is :: " + calRes[0] + "+i"
					+ calRes[1];
			retOutcome = "divRes";
			break;
		
		default:
			result = "Invalid Operation on " + model.getIntA() + "," + model.getIntB();
			retOutcome = "addRes";
			break;
		}
		return retOutcome;

	}

	public void calculateValue() {
		complexcalc calc = new complexcalc(model.getIntA(), model.getIntB(),model.getIntc(),model.getIntD() model.getOp());
		switch (model.getOp()) {
		case 1:
			result = "Performed Addition on " + model.getIntA() + "," +model.getIntB() + "," +model.getIntC() + "," + model.getIntD() + " and the result is :: "
					+ calc.complexcalc();
			break;
		case 2:
			result = "Performed Substraction on " + model.getIntA() + "," +model.getIntB() + "," +model.getIntD() + "," + model.getIntD() + " and the result is :: "
					+ calc.calculate();
			break;
		case 3:
			result = "Performed Multiplication on " + model.getIntA() + "," + model.getIntB() + " and the result is :: "
					+ calc.calculate();
			break;
		case 4:
			result = "Performed Division on " + model.getIntA() + "," + model.getIntB() + "," + model.getIntC() + "," + model.getIntD() + " and the result is :: "
					+ calc.calculate();
			break;
		
		default:
			result = "Invalid Operation on " + model.getIntA() + "," + model.getIntB() + "," + model.getIntC() + "," + model.getIntD();
			break;
		}
		showResult = true;
	}

	public calcjsfmodel getModel() {
		if (model == null)
			model = new calcjsfmodel();
		return model;
	}

	public void setModel(calcjsfmodel model) {
		this.model = model;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public boolean isShowResult() {
		return showResult;
	}

	public void setShowResult(boolean showResult) {
		this.showResult = showResult;
	}

}
