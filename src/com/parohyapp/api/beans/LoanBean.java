package com.parohyapp.api.beans;

import com.parohyapp.bank.Account;

public class LoanBean {
	
	private Account account;
	private double amount;
	private double interest;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	
}
