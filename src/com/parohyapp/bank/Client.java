package com.parohyapp.bank;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.parohyapp.api.HashGen;

public class Client {
	
	private int id;
	private String firstName;
	private String lastName;
	private Date dob;
	
	private Contact contact;
	
	private List<Account> accounts;
	private List<Card> cards;
	private List<Loan> loans;
	
	public Client(int id,String firstName, String lastName, Date dob) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}
		
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public List<Card> getActiveCards(){
		List<Card> result = new ArrayList<Card>();
		for(Card tmpCard : cards){
			if(!tmpCard.getBlock()){
				result.add(tmpCard);
			}
		}
		return result;
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
	
	
	
	public Contact getContact() {
		return contact;
	}


	public void setContact(Contact contact) {
		this.contact = contact;
	}


	public String getCodedId(){
		return HashGen.getCodedId(String.valueOf(id));
	}
}
