package com.parohyapp.bank;

public class Card {
	
	private int accountID;
	private boolean block;
	public Card(int accountID, boolean block) {
		super();
		this.accountID = accountID;
		this.block = block;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public boolean getBlock() {
		return block;
	}
	public void setBlock(boolean block) {
		this.block = block;
	}
	
	
}
