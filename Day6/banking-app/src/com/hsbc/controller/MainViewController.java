package com.hsbc.controller;

import java.util.Scanner;

import com.hsbc.exception.AccountNotFoundException;
import com.hsbc.model.beans.Account;
import com.hsbc.exception.BalanceInsufficientException;
import com.hsbc.model.service.AccountService;
import com.hsbc.model.utility.AccountFactory;
import com.hsbc.model.utility.Type;

public class MainViewController {
	
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// This is getting service object
		AccountService service = (AccountService) AccountFactory.getInstance(Type.SERVICE);
		int option = 0;
		
		do {
			System.out.println("*****************************************************************************************");
			System.out.println("1: Store 2: Fetch All 3: Fetch account by id 4: Transfer Amount. 5: Exit");
			System.out.println("*****************************************************************************************");
			option = scanner.nextInt();
			switch(option) {
			case 1: 
				Account account1 = new Account();
				System.out.println("Enter name");		
				account1.setCustomerName(scanner.next());	
				System.out.println("Enter balance");	
				account1.setBalance(scanner.nextDouble());
				System.out.println("Enter contact no");	
				account1.setContactNumber(scanner.nextLong());
				Account createdAccount = service.createAccount(account1);
				System.out.println("User created with an id: "+createdAccount.getAccountNumber());
				break;
			case 2: 
				Account[] accounts = service.getAllAccounts();
				for(Account temp : accounts) {
					if(temp!=null)
					System.out.println(temp);
				}
				break;
			case 3:
				System.out.println("Enter acc no");
				try {
					Account accountFetched = service.getAccountById(scanner.nextInt());
					// print on different device
					System.out.println(accountFetched);
				} catch (AccountNotFoundException e) {
					// print error on different device
					System.err.println("Error:"+e.getMessage());
				}
				break;
			case 4:
				System.out.println("Enter from to amount");
				try {
					int from=scanner.nextInt();int to= scanner.nextInt();double amt= scanner.nextDouble();
					service.transfer(from,to,amt);
					
					System.out.println(service.getAccountById(from));
					System.out.println(service.getAccountById(to));					
					
					System.out.println();
				} catch(AccountNotFoundException e) {
					System.err.println("Error: "+e.getMessage());
				}
				catch(BalanceInsufficientException e) {
					System.err.println("Error: "+e.getMessage());
				}
				break;
			
			}
		} while(option != 5);
		
		scanner.close();

	}
	
	
	


}
