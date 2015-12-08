package com.sample.training;

public class ComplexCalculator {
	private ComplexNumber numberA;
	private ComplexNumber numberB;
	private int op;

	public ComplexNumber calculate() {
		ComplexNumber ret = new ComplexNumber();
		switch (op) {

		}
		return ret;
	}

	public ComplexNumber getNumberA() {
		return numberA;
	}

	public void setNumberA(ComplexNumber numberA) {
		this.numberA = numberA;
	}

	public ComplexNumber getNumberB() {
		return numberB;
	}

	public void setNumberB(ComplexNumber numberB) {
		this.numberB = numberB;
	}

	public int getOp() {
		return op;
	}

	public void setOp(int op) {
		this.op = op;
	}

}
