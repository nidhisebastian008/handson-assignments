package com.hsbc.model.service;

import com.hsbc.exception.AccountNotFoundException;
import com.hsbc.model.beans.Account;
import com.hsbc.exception.BalanceInsufficientException;
import com.hsbc.model.dao.AccountDao;
import com.hsbc.model.utility.AccountFactory;
import com.hsbc.model.utility.Type;

public class AccountServiceImpl  implements AccountService{
	
	
	
	private AccountDao dao;
	public AccountServiceImpl() {
		// this is the way you get different instance
		dao = (AccountDao)AccountFactory.getInstance(Type.DAO);
	}

	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		
		Account createdAccount =  dao.store(account);
		return createdAccount;
		
	}
	@Override
	public Account[] getAllAccounts() {
		// no business validations
		return dao.fetchAccounts();
	}

	@Override
	public Account getAccountById(int accountNumber) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		
		Account acc = dao.fetchAccountById(accountNumber);
		if(acc == null) {
			throw new AccountNotFoundException("Sorry user with an id "+accountNumber+" not found");
		}
		return acc;
		
	}

	@Override
	public void transfer(int from, int to, double amount) throws AccountNotFoundException,BalanceInsufficientException {
		// TODO Auto-generated method stub
		
		Account sourceAccount=this.getAccountById(from);
		Account desAccount=this.getAccountById(to);
		if(sourceAccount == null) {
			throw new AccountNotFoundException("Sorry user with an id "+from+" not found");
		}
		if(desAccount == null) {
			throw new AccountNotFoundException("Sorry user with an id "+to+" not found");
		}
		if(sourceAccount.getBalance()<amount)
		{
			throw new BalanceInsufficientException("balance insufficient in acc no "+from);
		}
		sourceAccount.setBalance(sourceAccount.getBalance()-amount);
		dao.updateAccount(sourceAccount.getAccountNumber(), sourceAccount);
		desAccount.setBalance(desAccount.getBalance()+amount);
		dao.updateAccount(desAccount.getAccountNumber(), desAccount);
		
		
		
		
	}

}
