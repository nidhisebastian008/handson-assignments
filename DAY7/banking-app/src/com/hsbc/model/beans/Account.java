package com.hsbc.model.beans;

public class Account {
	
	private int accountNumber;
	private String customerName;
	private double balance;
	private long contactNumber;
	// generate account number at the time of object creation
	// generate required constructors, getters & setters
	private static int accountNumberCounter=1;
	
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
	public Account() {
		super();
		this.accountNumber=accountNumberCounter++;
//		this.customerName = customerName;
//		this.balance = balance;
//		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", customerName=" + customerName + ", balance=" + balance
				+ ", contactNumber=" + contactNumber + "]";
	}
	
	

}
