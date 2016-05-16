package com.parohyapp.bank;

import java.sql.Date;
import java.util.List;

public class Client {
	
	private String firstName;
	private String lastName;
	private Date dob;
	
	private List<Account> accounts;
	private List<Card> cards;
	private List<Loan> loans;
	
	public Client(String firstName, String lastName, Date dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getName(){
		return firstName + " " + lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		if(this.cards == null){
			this.cards = cards;
		}
		else{
			this.cards.addAll(cards);
		}
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		if(this.loans == null){
			this.loans = loans;
		}
		else{
			this.loans.addAll(loans);
		}
	}
			
	
}
