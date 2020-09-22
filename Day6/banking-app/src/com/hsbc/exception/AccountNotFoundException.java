package com.hsbc.exception;


//Add constructors inside AccountNotFoundException
public class AccountNotFoundException extends Exception {

	public AccountNotFoundException() {
		super("Sorry account not found");
		// TODO Auto-generated constructor stub
	}
	public AccountNotFoundException(String msg) {
		super(msg);
	}
	

}

