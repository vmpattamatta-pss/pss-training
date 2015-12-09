package com.sample.training;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class RMICalcServer extends UnicastRemoteObject implements RMICalculatorSpec {

	private static final long serialVersionUID = -2080662779504137718L;

	protected RMICalcServer() throws RemoteException {
		super();
	}

	@Override
	public int calculate(int a, int b, int op) throws RemoteException {
		Calculator calc = new Calculator(a, b, op);
		System.out.println("In Server Sending Result :: " + calc.calculate());
		return calc.calculate();
	}

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		RMICalcServer server = new RMICalcServer();
		System.out.println("Started the server");
		LocateRegistry.createRegistry(2222).rebind("RMICalcServer", server);
	}
}
