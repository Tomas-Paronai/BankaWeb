package com.parohyapp.database.client;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.parohyapp.bank.Account;
import com.parohyapp.bank.Card;
import com.parohyapp.bank.Client;
import com.parohyapp.bank.Loan;
import com.parohyapp.database.account.AccountDAO;
import com.parohyapp.database.card.CardDAO;
import com.parohyapp.database.loan.LoanDAO;

import org.springframework.jdbc.core.JdbcTemplate;

public class ClientDAOImpl implements ClientDAO{	
	
	private AccountDAO accountDAO;
	private CardDAO cardDAO;
	private LoanDAO loanDAO;
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplateObject = new JdbcTemplate(ds);
	}
	
	@Override
	public void setAccountSource(AccountDAO accountDAO){
		this.accountDAO = accountDAO;
	}
	
	@Override
	public void setCardSource(CardDAO cardDAO){
		this.cardDAO = cardDAO;
	}
	
	@Override
	public void setLoanSource(LoanDAO loanDAO) {
		this.loanDAO = loanDAO;		
	}
	
	@Override
	public Client getClient(Integer id) {
		String query = "SELECT * FROM clients WHERE ClientID=?";
		Client client = jdbcTemplateObject.queryForObject(query,new Object[]{id}, new ClientRowMapper());
		
		List<Loan> loans = loanDAO.getLoans(id);
		client.setLoans(loans);
		
		List<Account> accounts = accountDAO.getAccounts(id);
		client.setAccounts(accounts);
		
		for(Account tmpAcc : accounts){
			List<Card> cards = cardDAO.getCards(tmpAcc.getNumber());
			client.setCards(cards);
		}
		
		return client;
	}
	@Override
	public List<Client> listClients() {
		String query = "SELECT * FROM clients";
		List<Client> clients = jdbcTemplateObject.query(query, new ClientRowMapper());
		return clients;
	}
	@Override
	public void delete(Integer id) {
		String query = "DELETE FROM Clients WHERE ClientID=?";
		jdbcTemplateObject.update(query,id);
	}
	@Override
	public void updateClient(String firstName, String lastName, Date dob, Integer id) {
		String query = "UPDATE clients SET FirstName=?, LastName=?, DOB=? "
					 + "WHERE ClientdID=?";
		jdbcTemplateObject.update(query,new Object[]{firstName,lastName,dob,id});
	}
	@Override
	public int getLoginClient(String username, String password) {
		String query = "SELECT * FROM client_login WHERE Username=? and Password=?";
		try {
			PreparedStatement statement = dataSource.getConnection().prepareStatement(query);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if(rs.next()){
				return rs.getInt("ClientID");
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public void changePassword(String password, Integer id) {
		String query = "UPDATE client_login SET Password=? WHERE ClientID=?";
		jdbcTemplateObject.update(query,new Object[]{password,id});
	}

	
	
	

}
