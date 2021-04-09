package com.project.transaction.service;

import com.project.transaction.exception.InsufficientFundsException;
import com.project.transaction.exception.NegativeAmountException;
import com.project.transaction.model.Account;

public class TransactionImpl implements Transaction {
	
	private Account account;
	
	public TransactionImpl(Account account) {
		this.account=account;
	}
	

	public double checkBalance() {
		System.out.println(String.format("The current balance for user %s is : %s",account.getUserName(),account.getBalance()));
        System.out.println();
		return account.getBalance();

	}

	public void withdrawAmount(double amount) throws InsufficientFundsException,NegativeAmountException {
		System.out.println("Withdrawn Operation:");
        System.out.println("Withdrawing Amount : "
                           + amount);
        
        double balance=account.getBalance();
        
        if (amount<0) {
        	throw new NegativeAmountException("The amount entered cannot be negative.Please try again!!");
        }
        
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println(
                "Please collect your money and collect the card");
            
        }
        else {
            throw new InsufficientFundsException("Sorry! Insufficient Funds in the account.Please enter a valid amount");
            
        }
        
        account.setBalance(balance);
        
	}

	public void depositAmount(double amount) throws NegativeAmountException {
		System.out.println("Deposit Operation:");
        System.out.println("Depositing Amount : "
                           + amount);
        
        double balance=account.getBalance();
        
        if(amount<0) {
        	throw new NegativeAmountException("The amount entered cannot be negative.Please try again!!");
        }
        
        balance = balance + amount;
        System.out.println(
            "Your Money has been successfully deposited.");
        
        account.setBalance(balance);
        
	}

}
