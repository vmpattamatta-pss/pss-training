package com.sample.training;


public class Execute {
	int real;
	int imag;

	public CalcJSFModel add(CalcJSFModel firstNumber, CalcJSFModel secondNumber) {
		real = firstNumber.getReal() + secondNumber.getReal();
		imag = firstNumber.getImaginary() + secondNumber.getImaginary();
		CalcJSFModel add = new CalcJSFModel();
		add.setReal(real);
		add.setImaginary(imag);
		return add;
	}

	public CalcJSFModel sub(CalcJSFModel firstNumber, CalcJSFModel secondNumber) {
		real = firstNumber.getReal() - secondNumber.getReal();
		imag = firstNumber.getImaginary() - secondNumber.getImaginary();
		CalcJSFModel sub = new CalcJSFModel();
		sub.setReal(real);
		sub.setImaginary(imag);
		return sub;

	}

	public CalcJSFModel mul(CalcJSFModel firstNumber, CalcJSFModel secondNumber) {
		real = (firstNumber.getReal() * secondNumber.getReal())
				- (firstNumber.getImaginary() * secondNumber.getImaginary());
		imag = (firstNumber.getImaginary() * secondNumber.getReal())
				+ (firstNumber.getReal() * secondNumber.getImaginary());
		CalcJSFModel mul = new CalcJSFModel();
		mul.setReal(real);
		mul.setImaginary(imag);
		return mul;

	}

	public CalcJSFModel div(CalcJSFModel firstNumber, CalcJSFModel secondNumber) {
		int dividend1 = (firstNumber.getReal() * secondNumber.getReal())
				+ (firstNumber.getImaginary() * secondNumber.getImaginary());
		int dividend2 = (firstNumber.getImaginary() * secondNumber.getReal())
				- (firstNumber.getReal() * secondNumber.getImaginary());
		int divisor = (secondNumber.getReal() * secondNumber.getReal())
				+ (secondNumber.getImaginary() * secondNumber.getImaginary());
		real = dividend1 / divisor;
		imag = dividend2 / divisor;
		CalcJSFModel div = new CalcJSFModel();
		div.setReal(real);
		div.setImaginary(imag);
		return div;

	}

}
