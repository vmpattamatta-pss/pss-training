package com.sample.training;


public class Calculator {
	private int intA;
	private int intB;
	private int op;

	public Calculator(int intA, int intB, int op) {
		super();
		this.intA = intA;
		this.intB = intB;
		this.op = op;
	}

	public Calculator(int intA, int intB) {
		super();
		this.intA = intA;
		this.intB = intB;
	}

	public int calculate() {
		int ret = 0;
		switch (op) {
		case 1:
			ret = intA + intB;
			break;
		case 2:
			ret = intA - intB;
			break;
		case 3:
			ret = intA * intB;
			break;
		case 4:
			try {
				ret = intA / intB;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case 5:
			try {
				ret = intA % intB;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		default:
			System.out.println("Invalid Operand Please specify a value between 1-5");
		}
		return ret;
	}

	public int getIntA() {
		return intA;
	}

	public void setIntA(int intA) {
		this.intA = intA;
	}

	public int getIntB() {
		return intB;
	}

	public void setIntB(int intB) {
		this.intB = intB;
	}

	public int getOp() {
		return op;
	}

	public void setOp(int op) {
		this.op = op;
	}

}
