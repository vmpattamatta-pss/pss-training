package com.sample.training;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Testcase {
	Execute execute;
	ComplexCalculator calculator;
	ComplexNumber firstNumber;
	ComplexNumber secondNumber;
	int real;
	int imag;

	@Before
	public void setUp() throws Exception {
		execute = new Execute();
		calculator = new ComplexCalculator();
		firstNumber = new ComplexNumber();
		secondNumber = new ComplexNumber();

	}

	@After
	public void tearDown() throws Exception {
		execute = null;
		calculator = null;
	}

	@Test
	public final void testAdd() {
		try {
			firstNumber.setReal(1);
			firstNumber.setImaginary(2);
			secondNumber.setReal(1);
			secondNumber.setImaginary(2);
			ComplexNumber result = execute.add(firstNumber, secondNumber);
			real = result.getReal();
			imag = result.getImaginary();
			assertEquals(2, real);
			assertEquals(4, imag);

		} catch (Exception e) {
		}

	}

	@Test
	public final void testSub() {
		try {
			firstNumber.setReal(2);
			firstNumber.setImaginary(2);
			secondNumber.setReal(1);
			secondNumber.setImaginary(1);
			ComplexNumber sub = execute.sub(firstNumber, secondNumber);
			real = sub.getReal();
			imag = sub.getImaginary();
			assertEquals(1, real);
			assertEquals(1, imag);

		} catch (Exception e) {
		}
	}

	@Test
	public final void testMul() {
		firstNumber.setReal(2);
		firstNumber.setImaginary(2);
		secondNumber.setReal(1);
		secondNumber.setImaginary(1);
		ComplexNumber mul = execute.mul(firstNumber, secondNumber);
		real = mul.getReal();
		imag = mul.getImaginary();
		assertEquals(0, real);
		assertEquals(4, imag);

	}

	@Test
	public final void testDiv() {
		firstNumber.setReal(1);
		firstNumber.setImaginary(1);
		secondNumber.setReal(1);
		secondNumber.setImaginary(1);
		ComplexNumber div = execute.div(firstNumber, secondNumber);
		real = div.getReal();
		imag = div.getImaginary();
		assertEquals(1, real);
		assertEquals(0, imag);
	}

}
