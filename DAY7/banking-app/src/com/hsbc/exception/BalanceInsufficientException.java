package com.hsbc.exception;

public class BalanceInsufficientException extends Exception {
	
	
	public BalanceInsufficientException() {
		super("Sorry balance insuff ");
		// TODO Auto-generated constructor stub
	}
	public BalanceInsufficientException(String msg) {
		super(msg);
	}
}
