package com.sample.training;

import javax.faces.event.AjaxBehaviorEvent;

import org.jboss.resteasy.util.StringContextReplacement;

public class CalcJSFController {
	private CalcJSFModel model;
	private String result;
	private boolean showResult;

	public String goBack() {
		model = null;
		showResult = false;
		return "goBack";
	}

	public void calculateValue(AjaxBehaviorEvent evt) {
		Calculator calc = new Calculator(model.getIntA(), model.getIntB(), model.getOp());
		switch (model.getOp()) {
		case 1:
			result = "Performed Addition on " + model.getIntA() + "," + model.getIntB() + " and the result is :: "
					+ calc.calculate();
			break;
		case 2:
			result = "Performed Substraction on " + model.getIntA() + "," + model.getIntB() + " and the result is :: "
					+ calc.calculate();
			break;
		case 3:
			result = "Performed Multiplication on " + model.getIntA() + "," + model.getIntB() + " and the result is :: "
					+ calc.calculate();
			break;
		case 4:
			result = "Performed Division on " + model.getIntA() + "," + model.getIntB() + " and the result is :: "
					+ calc.calculate();
			break;
		case 5:
			result = "Performed Modulus on " + model.getIntA() + "," + model.getIntB() + " and the result is :: "
					+ calc.calculate();
			break;
		default:
			result = "Invalid Operation on " + model.getIntA() + "," + model.getIntB();
			break;
		}
		showResult = true;
	}

	public CalcJSFModel getModel() {
		if (model == null)
			model = new CalcJSFModel();
		return model;
	}

	public void setModel(CalcJSFModel model) {
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
