package com.parohyapp.bank;

public class Account {
	
	private int number;
	private float balance;
	public Account(int number, float balance) {
		super();
		this.number = number;
		this.balance = balance;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	
}
