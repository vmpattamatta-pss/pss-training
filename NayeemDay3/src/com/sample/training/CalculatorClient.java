package com.sample.training;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class CalculatorClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 10024);
		OutputStream os = socket.getOutputStream();
		InputStream is = socket.getInputStream();
		String input = "1,1,1;2,2,2;";
		os.write(input.getBytes());
		os.flush();
		int i = -1;
		while ((i = is.read()) != -1) {
			char data = (char) i;
			System.out.println(data);
		}
		socket.close();
	}
}
