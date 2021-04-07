package com.project.transaction.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.project.transaction.exception.InsufficientFundsException;
import com.project.transaction.exception.NegativeAmountException;
import com.project.transaction.model.Account;
import com.project.transaction.service.Transaction;
import com.project.transaction.service.TransactionImpl;


public class TransactionImplTest {

	Account account=new Account();
	
	Transaction transaction=new TransactionImpl(account);
	
	
	@Before
	public void setup() {
		account.setBalance(10000);
		account.setUserName("XYZ");
	}
	
	@Test
	public void checkInitialBalanceBeforeDeposit() {
		double balance=transaction.checkBalance();
		assertEquals(10000, balance,0);
	}
	
	@Test
	public void checkDepositFunctionality() throws NegativeAmountException {
		transaction.depositAmount(10000);
		assertEquals(20000, transaction.checkBalance(),0);
	}
	
	@Test(expected = NegativeAmountException.class)
	public void checkDepositFunctionalityWithNegativeAmount() throws NegativeAmountException {
		transaction.depositAmount(-10000);
	}
	
	@Test
	public void checkWithdrawalFunctionality() throws NegativeAmountException,InsufficientFundsException {
		transaction.withdrawAmount(5000);
		assertEquals(5000, transaction.checkBalance(),0);
	}
	
	@Test(expected = InsufficientFundsException.class)
	public void checkWithdrawalFunctionalityForInsufficientFunds() throws NegativeAmountException,InsufficientFundsException {
		transaction.withdrawAmount(20000);
	}
	
	@Test(expected = NegativeAmountException.class)
	public void checkWithdrawalFunctionalityForNegativeAmount() throws NegativeAmountException,InsufficientFundsException {
		transaction.withdrawAmount(-20000);
	}
}
