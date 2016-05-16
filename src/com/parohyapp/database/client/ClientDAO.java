package com.parohyapp.database.client;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import com.parohyapp.bank.Client;
import com.parohyapp.database.BankDAO;
import com.parohyapp.database.account.AccountDAO;
import com.parohyapp.database.card.CardDAO;
import com.parohyapp.database.loan.LoanDAO;

public interface ClientDAO extends BankDAO{
	   
	   /** 
	    * This is the method to be used to list down
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
	   public Client getClient(Integer id);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Student table.
	    */
	   public List<Client> listClients();
	   
	   /**
	    * Update client
	    */
	   public void setLoanSource(LoanDAO loanDAO);
	   public void setAccountSource(AccountDAO accountDAO);
	   public void setCardSource(CardDAO cardDAO);
	   public void updateClient(String firstName, String lastName, Date dob, Integer id);
	   public void changePassword(String password, Integer id);
	   public int getLoginClient(String username, String password);
}
