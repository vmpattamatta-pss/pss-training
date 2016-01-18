package com.sample.training;

public class Execute {
	int real;
	int imag;

	public ComplexNumber add(ComplexNumber firstNumber, ComplexNumber secondNumber) {
		real = firstNumber.getReal() + secondNumber.getReal();
		imag = firstNumber.getImaginary() + secondNumber.getImaginary();
		ComplexNumber add = new ComplexNumber();
		add.setReal(real);
		add.setImaginary(imag);
		return add;
	}

	public ComplexNumber sub(ComplexNumber firstNumber, ComplexNumber secondNumber) {
		real = firstNumber.getReal() - secondNumber.getReal();
		imag = firstNumber.getImaginary() - secondNumber.getImaginary();
		ComplexNumber sub = new ComplexNumber();
		sub.setReal(real);
		sub.setImaginary(imag);
		return sub;

	}

	public ComplexNumber mul(ComplexNumber firstNumber, ComplexNumber secondNumber) {
		real = (firstNumber.getReal() * secondNumber.getReal())
				- (firstNumber.getImaginary() * secondNumber.getImaginary());
		imag = (firstNumber.getImaginary() * secondNumber.getReal())
				+ (firstNumber.getReal() * secondNumber.getImaginary());
		ComplexNumber mul = new ComplexNumber();
		mul.setReal(real);
		mul.setImaginary(imag);
		return mul;

	}

	public ComplexNumber div(ComplexNumber firstNumber, ComplexNumber secondNumber) {
		int dividend1 = (firstNumber.getReal() * secondNumber.getReal())
				+ (firstNumber.getImaginary() * secondNumber.getImaginary());
		int dividend2 = (firstNumber.getImaginary() * secondNumber.getReal())
				- (firstNumber.getReal() * secondNumber.getImaginary());
		int divisor = (secondNumber.getReal() * secondNumber.getReal())
				+ (secondNumber.getImaginary() * secondNumber.getImaginary());
		real = dividend1 / divisor;
		imag = dividend2 / divisor;
		ComplexNumber div = new ComplexNumber();
		div.setReal(real);
		div.setImaginary(imag);
		return div;

	}

}
