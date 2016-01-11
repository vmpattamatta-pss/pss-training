package com.sample.training;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class complexcalc {
	public static void main(String args[]) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int a, b, c, d;

		System.out.println("Program to add two complex numbers..");

		System.out.println("\n" + "Enter first number a+bi");

		System.out.print("Enter value for a: ");
		a = Integer.parseInt(in.readLine());

		System.out.print("Enter value for b: ");
		b = Integer.parseInt(in.readLine());

		System.out.println("\n" + "Enter second number c+di");

		System.out.print("Enter value for c: ");
		c = Integer.parseInt(in.readLine());
		System.out.print("Enter value for d: ");
		d = Integer.parseInt(in.readLine());

		System.out.println("\n" + "Result of addtion");
		System.out.print(a + c);
		System.out.print((b + d) > 0 ? "+" : "");
		System.out.print(b + d + "i ");

		System.out.println("\n" + "Result of subtraction");
		System.out.print(a - c);
		System.out.print((b - d) > 0 ? "-" : "");
		System.out.print(b - d + "i ");

		System.out.println("\n" + "Result of multiplication");
		System.out.print(a * c);
		System.out.print((b * d) > 0 ? "*" : "");
		System.out.print((b * d) + "i ");

		System.out.println("\n" + "Result of division");
		System.out.print(a / c);
		System.out.print((b / d) > 0 ? "/" : "");
		System.out.print((b / d) + "i ");

	}

	public int[] calculate(int a, int b, int c, int d, int op) {
		int[] ret = new int[2];
		switch (op) {
		case 1:
			ret[0] = a + c;
			ret[1] = b + d;
			break;
		case 2:
			ret[0] = a - c;
			ret[1] = b - d;
			break;
		case 3:
			ret[0] = a * c;
			ret[1] = b * d;
			break;
		case 4:
			ret[0] = a / c;
			ret[1] = b / d;
			break;
		}
		return ret;
	}
}
