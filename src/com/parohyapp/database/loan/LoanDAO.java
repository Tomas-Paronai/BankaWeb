package com.parohyapp.database.loan;

import java.util.List;

import com.parohyapp.bank.Loan;
import com.parohyapp.database.BankDAO;

public interface LoanDAO extends BankDAO{
	public Loan getLoan(Integer id);
	public List<Loan> getLoans(Integer clientID); 
	public void payBack(float amount, Integer id);
	public void createLoan(float amount, float interest, Integer clientID);
}
