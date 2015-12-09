package com.sample.training;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMICalcClient {
	public static void main(String[] args) throws AccessException, RemoteException, NotBoundException {
		RMICalculatorSpec inst = (RMICalculatorSpec) LocateRegistry.getRegistry(2222).lookup("RMICalcServer");
		System.out.println("In Client :: Received Result :: " + inst.calculate(10, 20, 2));
	}
}
