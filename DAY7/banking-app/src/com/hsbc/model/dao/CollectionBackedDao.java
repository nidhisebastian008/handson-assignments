package com.hsbc.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.model.beans.Account;

public class CollectionBackedDao implements AccountDao {

	
	private static List<Account>accountList= new ArrayList<>();
	@Override
	public Account store(Account account) {
		// TODO Auto-generated method stub
		accountList.add(account);
		return account;
	}

	@Override
	public Account[] fetchAccounts() {
		// TODO Auto-generated method stub
		Account[]accountArray= new Account[accountList.size()];
		accountArray=accountList.toArray(accountArray);
		return accountArray;
	}

	@Override
	public Account fetchAccountById(int accountNumber) {
		// TODO Auto-generated method stub
		for(Account acc:accountList)
		{
			if(acc.getAccountNumber()==accountNumber)return acc;
		}
		return null;
	}

	@Override
	public Account updateAccount(int accountNumber, Account account) {
		// TODO Auto-generated method stub
		for(int i = 0; i < accountList.size(); i++) {
			if(accountList.get(i).getAccountNumber()== accountNumber) {
				accountList.set(i,account);
				break;
			}
		}
		return account;
	}

}
