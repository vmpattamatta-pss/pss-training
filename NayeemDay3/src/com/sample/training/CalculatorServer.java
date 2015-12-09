package com.sample.training;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class CalculatorServer extends Thread {
	private ServerSocket server;
	private Socket socket;

	public CalculatorServer(int port) throws IOException {
		super();
		server = new ServerSocket(port);
		socket = server.accept();
	}

	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			while (true) {
				StringBuffer data = new StringBuffer();
				while (true) {
					try {
						char curr = (char) is.read();
						if (curr == ';') {
							String[] values = data.toString().split(",");
							Calculator cal = new Calculator(Integer.parseInt(values[0]), Integer.parseInt(values[1]),
									Integer.parseInt(values[2]));
							os.write(String.valueOf(cal.calculate()).getBytes());
							os.flush();
							data = new StringBuffer();
							continue;
						} else {
							data.append(curr);
						}
					} catch (Exception e) {
						if (e instanceof SocketException)
							System.out.println(e.getMessage());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		Thread t = new CalculatorServer(10024);
		t.start();
	}

	public ServerSocket getServer() {
		return server;
	}

	public void setServer(ServerSocket server) {
		this.server = server;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}
