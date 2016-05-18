package com.parohyapp.database.client;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import com.parohyapp.bank.Client;
import com.parohyapp.database.BankDAO;
import com.parohyapp.database.account.AccountDAO;
import com.parohyapp.database.card.CardDAO;
import com.parohyapp.database.clientcontact.ContactDAO;
import com.parohyapp.database.loan.LoanDAO;

public interface ClientDAO extends BankDAO{

	   public Client getClient(Integer id);
	   public List<Client> listClients();
	   public void setLoanSource(LoanDAO loanDAO);
	   public void setAccountSource(AccountDAO accountDAO);
	   public void setCardSource(CardDAO cardDAO);
	   public void setContactSource(ContactDAO contactDAO);
	   public void updateClient(String firstName, String lastName, Date dob, Integer id);
	   public void changePassword(String password, Integer id);
	   public int getLoginClient(String username, String password);
	   public int getLoginTry(Integer id);
	   public void addLoginTry(Integer id);
	   public void deleteLoginTry(Integer id);
}
