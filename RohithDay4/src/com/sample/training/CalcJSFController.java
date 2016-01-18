package com.sample.training;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

public class CalcJSFController implements Serializable {
	private static final long serialVersionUID = -1971570752744302458L;
	private CalcJSFModel model;
	private CalcJSFModel result;
	private CalcJSFModel firstNumber;
	private CalcJSFModel secondNumber;
	private String retOutcome;
	private String printresult;

	public String calculate() {
		Execute execute = new Execute();
		firstNumber = new CalcJSFModel(model.getFfirstpart(), model.getFsecondPart());
		secondNumber = new CalcJSFModel(model.getSfirstpart(), model.getSsecondpart());
		switch (model.getOp()) {
		case 1:
			result = (CalcJSFModel) execute.add(firstNumber, secondNumber);
			printresult = "Addition performed and result is" + result.getReal() + "+i" + result.getImaginary();
			retOutcome = "Res";
			break;

		case 2:
			result = (CalcJSFModel) execute.sub(firstNumber, secondNumber);
			printresult = "substrction performed and result is" + result.getReal() + "+i" + result.getImaginary();
			retOutcome = "Res";
			break;
		case 3:
			result = (CalcJSFModel) execute.mul(firstNumber, secondNumber);
			printresult = "multiplication performed and result is" + result.getReal() + "+i" + result.getImaginary();
			retOutcome = "Res";
			break;
		case 4:
			result = (CalcJSFModel) execute.div(firstNumber, secondNumber);
			printresult = "division performed and result is" + result.getReal() + "+i" + result.getImaginary();
			retOutcome = "Res";
			break;
		default:
			printresult = "Invalid Operation ";
			break;
		}
		return retOutcome;
	}

	public void setModel(CalcJSFModel model) {
		this.model = model;
	}

	public CalcJSFModel getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(CalcJSFModel firstNumber) {
		this.firstNumber = firstNumber;
	}

	public CalcJSFModel getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(CalcJSFModel secondNumber) {
		this.secondNumber = secondNumber;
	}

	public String getRetOutcome() {
		return retOutcome;
	}

	public void setRetOutcome(String retOutcome) {
		this.retOutcome = retOutcome;
	}

	public CalcJSFModel getModel() {
		if (model == null)
			model = new CalcJSFModel();
		return model;
	}

	public CalcJSFModel getResult() {

		return result;
	}

	public void setResult(CalcJSFModel result) {
		this.result = result;
	}

	public String getPrintresult() {
		return printresult;
	}

	public void setPrintresult(String printresult) {
		this.printresult = printresult;
	}

}
