package com.sample.training.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sample.training.Calculator;

public class CalculatorTest {

	private Calculator calc = new Calculator(20, 10);

	@Test
	public void testCalculateAdd() {
		calc.setOp(1);
		assertEquals(calc.calculate(), 30);
	}

	@Test
	public void testCalculateSub() {
		calc.setOp(2);
		assertEquals(calc.calculate(), 10);
	}

	@Test
	public void testCalculateMul() {
		calc.setOp(3);
		assertEquals(calc.calculate(), 200);
	}

	@Test
	public void testCalculateDiv() {
		calc.setOp(4);
		assertEquals(calc.calculate(), 2);
	}

	@Test
	public void testCalculateMod() {
		calc.setOp(5);
		assertEquals(calc.calculate(), 0);
	}

}
