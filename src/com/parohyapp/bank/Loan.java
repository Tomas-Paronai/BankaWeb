package com.parohyapp.bank;

public class Loan {
	private float interest;
	private float amount;
	private int paid;
	private boolean repaid;
	public Loan(float interest, float amount, int paid) {
		super();
		this.interest = interest;
		this.amount = amount;
		this.paid = paid;
		
		if(paid >= amount+amount*interest){
			repaid = true;
		}
	}
	public float getInterest() {
		return interest;
	}
	public void setInterest(float interest) {
		this.interest = interest;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public int getPaid() {
		return paid;
	}
	public void setPaid(int paid) {
		this.paid = paid;
	}
	public boolean getRepaid() {
		return repaid;
	}
	public void setRepaid(boolean repaid) {
		this.repaid = repaid;
	}	
	
}
