package com.sample.training;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HelloWorld {

	protected String a;

	public static void main(String[] args) throws Exception {
		System.out.println(Integer.reverse(20));
	}

	public static void display() {
		System.out.print("Hello World");
	}

	public static void readConsole() throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for (;;) {
			String dataLine = reader.readLine();
			if (dataLine == null || dataLine.length() == 0) {
				break;
			} else {
				System.out.println("Hello :: " + dataLine);
			}
		}
	}

	public static void commandLineDisplay(String[] args) {
		for (String string : args) {
			System.out.println(string);
		}
	}

	public static void executeOSCommand() throws Exception {
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec("ipconfig");
		InputStream processIn = process.getInputStream();
		InputStream processErr = process.getErrorStream();
		InputStreamReader processInISR = new InputStreamReader(processIn);
		BufferedReader processInBR = new BufferedReader(processInISR);
		String line = null;
		while ((line = processInBR.readLine()) != null)
			System.out.println(line);
		InputStreamReader processErrISR = new InputStreamReader(processErr);
		BufferedReader processErrBR = new BufferedReader(processErrISR);
		line = null;
		while ((line = processErrBR.readLine()) != null)
			System.err.println(line);
		for (;;) {
			if (process.isAlive()) {
				Thread.sleep(10000);
			} else
				break;
		}
		System.out.println(process.exitValue());
	}
}
