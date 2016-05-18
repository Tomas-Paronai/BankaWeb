package com.parohyapp.database.client;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import com.parohyapp.bank.Account;
import com.parohyapp.bank.Card;
import com.parohyapp.bank.Client;
import com.parohyapp.bank.Contact;
import com.parohyapp.bank.Loan;
import com.parohyapp.database.ErrorCode;
import com.parohyapp.database.account.AccountDAO;
import com.parohyapp.database.card.CardDAO;
import com.parohyapp.database.clientcontact.ContactDAO;
import com.parohyapp.database.loan.LoanDAO;

import org.springframework.jdbc.core.JdbcTemplate;

public class ClientDAOImpl implements ClientDAO{	
	
	private AccountDAO accountDAO;
	private CardDAO cardDAO;
	private LoanDAO loanDAO;
	private ContactDAO contactDAO;
	
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
	public void setContactSource(ContactDAO contactDAO){
		this.contactDAO = contactDAO;
	}
	
	@Override
	public Client getClient(Integer id) {
		String query = "SELECT * FROM clients WHERE ClientID=?";
		Client client = jdbcTemplateObject.queryForObject(query,new Object[]{id}, new ClientRowMapper());
		
		Contact contact = contactDAO.getClientContact(id);
		client.setContact(contact);
		
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
				int id = rs.getInt("ClientID");
				if(getLoginTry(id) <=3 ){
					deleteLoginTry(id);
					insertLoginHistory(id);
					return id;
				}
				else{
					return ErrorCode.ACCOUNT_BLOCKED.getCode();
				}
			}
			else{
				query = "SELECT * FROM client_login WHERE Username=?";				
				statement = dataSource.getConnection().prepareStatement(query);
				statement.setString(1, username);
				rs = statement.executeQuery();
				if(rs.next()){
					int id = rs.getInt("ClientID");
					addLoginTry(id);
					return ErrorCode.INVALID_ACCESS.getCode();
				}
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return ErrorCode.INVALID_ACCESS.getCode();
	}
	@Override
	public void changePassword(String password, Integer id) {
		String query = "UPDATE client_login SET Password=? WHERE ClientID=?";
		jdbcTemplateObject.update(query,new Object[]{password,id});
	}

	@Override
	public void addLoginTry(Integer id) {
		System.out.println("inserting new login try");
		String query = "INSERT INTO invalid_access VALUES (?,?)";
		long time = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(time);
		jdbcTemplateObject.update(query,new Object[]{id,timestamp});
	}

	@Override
	public int getLoginTry(Integer id) {
		System.out.println("Returning login tries.");
		String query = "SELECT count(*) FROM invalid_access WHERE ClientID=?";
		return jdbcTemplateObject.queryForInt(query,new Object[]{id});
	}

	@Override
	public void deleteLoginTry(Integer id) {
		System.out.println("Deleting previous invalid tries for user ID: "+id);
		String query = "DELETE FROM invalid_access WHERE ClientID=?";
		jdbcTemplateObject.update(query,new Object[]{id});		
	}
	
	@Override
	public void insertLoginHistory(Integer id){
		long time = System.currentTimeMillis();
		Timestamp timestamp = new Timestamp(time);
		System.out.println("Login history dated "+timestamp);
		
		String query = "INSERT INTO client_history_login VALUES (?,?)";
		jdbcTemplateObject.update(query,new Object[]{id,timestamp});
	}
	

}
