package com.hsbc.model.dao;
import com.hsbc.model.beans.Account;

public interface AccountDao {
	public Account store(Account account);
	public Account[] fetchAccounts();
	public Account fetchAccountById(int accountNumber);
	public Account updateAccount(int accountNumber, Account account);
}
