package com.sample.training;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMICalculatorSpec extends Remote {
	public int calculate(int a, int b, int op) throws RemoteException;

}
