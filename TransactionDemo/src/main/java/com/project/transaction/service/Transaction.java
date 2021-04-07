package com.project.transaction.service;

import com.project.transaction.exception.InsufficientFundsException;
import com.project.transaction.exception.NegativeAmountException;

public interface Transaction {

	public double checkBalance();
	
	public void withdrawAmount(double amount) throws InsufficientFundsException,NegativeAmountException;
	
	public void depositAmount(double amount) throws NegativeAmountException;
}
