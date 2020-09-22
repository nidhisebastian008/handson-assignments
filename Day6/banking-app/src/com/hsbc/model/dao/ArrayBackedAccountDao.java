package com.hsbc.model.dao;


import com.hsbc.model.beans.Account;

public class ArrayBackedAccountDao implements AccountDao {

		// temporary database
		private static Account[] accountArray = new Account[10];
		
		private static int index = 0;
		
		@Override
		public Account store(Account acc) {
			accountArray[index++] = acc;
			return acc;
		}
		@Override
		public Account[] fetchAccounts() {
			return accountArray;
		}
		@Override
		public Account fetchAccountById(int accNo) {
			Account user = null;
			for(int i = 0; i < index; i++) {
				if(accountArray[i].getAccountNumber() == accNo) { 
					user = accountArray[i];
					return user;
				}
			}
			return null;
		}
		// Implement this method
		@Override
		public Account updateAccount(int accNo, Account acc) {
			for(int i = 0; i < index; i++) {
				if(accountArray[i].getAccountNumber()== accNo) {
					accountArray[i] =acc ;
					break;
				}
			}
			return acc;
		}


}
