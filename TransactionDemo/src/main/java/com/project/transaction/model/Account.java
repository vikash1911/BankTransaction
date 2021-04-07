package com.project.transaction.model;

public class Account {

	private String userName;
	private double balance=0;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account [userName=" + userName + ", balance=" + balance + "]";
	}
	
	
}
