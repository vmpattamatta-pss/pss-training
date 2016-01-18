package com.sample.training;

import java.util.Scanner;

public class ComplexCalculator {
	private static ComplexNumber firstNumber;
	private static ComplexNumber secondNumber;
	private static int operation;

	public ComplexNumber getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(ComplexNumber firstNumber) {
		this.firstNumber = firstNumber;
	}

	public ComplexNumber getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(ComplexNumber secondNumber) {
		this.secondNumber = secondNumber;
	}

	public static void main(String[] args) {
		ComplexNumber complexNumber = new ComplexNumber();
		Execute execute = new Execute();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter First number real part and imaginary part ");
		int ffirstpart = scanner.nextInt();
		complexNumber.setReal(ffirstpart);
		int fsecondPart = scanner.nextInt();
		complexNumber.setImaginary(fsecondPart);
		System.out.println("first number is:" + ffirstpart + "+i" + fsecondPart);

		System.out.println("Enter second number real part and imaginary part ");
		int sfirstpart = scanner.nextInt();
		complexNumber.setReal(sfirstpart);
		int ssecondpart = scanner.nextInt();
		complexNumber.setReal(ssecondpart);
		System.out.println("second number is:" + sfirstpart + "+i" + ssecondpart);

		firstNumber = new ComplexNumber(ffirstpart, fsecondPart);
		secondNumber = new ComplexNumber(sfirstpart, ssecondpart);

		System.out.println("select your operation for complex numbers");
		System.out.println("press 1 for addition");
		System.out.println("press 2 for substraction");
		System.out.println("press 3 for multiplication");
		System.out.println("press 4 for division");

		operation = scanner.nextInt();
		switch (operation) {
		case 1:
			ComplexNumber result = execute.add(firstNumber, secondNumber);
			int real = result.getReal();
			int imag = result.getImaginary();

			System.out.println("sum is:" + real + "+i" + imag);

			break;
		case 2:
			ComplexNumber sub = execute.sub(firstNumber, secondNumber);
			real = sub.getReal();
			imag = sub.getImaginary();
			System.out.println("substraction is:" + real + "+i" + imag);

			break;
		case 3:
			ComplexNumber mul = execute.mul(firstNumber, secondNumber);
			real = mul.getReal();
			imag = mul.getImaginary();
			System.out.println("multiplication is:" + real + "+i" + imag);

			break;
		case 4:
			ComplexNumber div = execute.div(firstNumber, secondNumber);
			real = div.getReal();
			imag = div.getImaginary();
			System.out.println("division is:" + real + "+i" + imag);

			break;

		default:
			System.out.println("please select valid operation");
			break;
		}

	}

}
