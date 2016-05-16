package com.parohyapp.database.account;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.parohyapp.bank.Account;

public class AccountDAOImpl implements AccountDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void delete(Integer id) {
		String query = "DELETE FROM accounts WHERE AccountID=?";
		jdbcTemplateObject.update(query,new Object[]{id});
	}

	@Override
	public Account getAccount(Integer id) {
		String query = "SELECT * FROM accounts WHERE AccountID=?";
		Account result = jdbcTemplateObject.queryForObject(query, new Object[]{id},new AccountRowMapper());
		return result;
	}

	@Override
	public List<Account> getAccounts(Integer clientID) {
		String query = "SELECT * FROM accounts WHERE ClientID=?";
		List<Account> accounts = jdbcTemplateObject.query(query,new Object[]{clientID},new AccountRowMapper());
		return accounts;
	}

	@Override
	public void updateAccount(Integer id, float balance) {
		String query = "UPDATE accounts SET balance=? WHERE AccountID=?";
		jdbcTemplateObject.update(query,new Object[]{id,balance});		
	}

}
