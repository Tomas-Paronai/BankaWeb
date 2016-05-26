package com.parohyapp.database.loan;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.parohyapp.bank.Loan;

public class LoanDAOImpl implements LoanDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void delete(Integer id) {
		String query = "DELETE FROM loans WHERE LoanID=?";
		jdbcTemplateObject.update(query, new Object[]{id});		
	}

	@Override
	public Loan getLoan(Integer id) {
		String query = "SELECT * FROM loans WHERE LoanID=?";
		Loan result = jdbcTemplateObject.queryForObject(query, new Object[]{id}, new LoanRowMapper());
		return result;
	}

	@Override
	public List<Loan> getLoans(Integer clientID) {
		String query = "SELECT * FROM loans WHERE ClientID=?";
		List<Loan> loans = jdbcTemplateObject.query(query, new Object[]{clientID}, new LoanRowMapper());
		return loans;
	}

	@Override
	public void payBack(float amount, Integer id) {
		String query = "UPDATE loans SET amount=amount+? WHERE LoanID=?";
		jdbcTemplateObject.update(query,new Object[]{amount,id});
	}

	@Override
	public void createLoan(float amount, float interest, Integer accountID) {
		//String query =  "INSERT INTO loans (ClientID,Amount,Interest) VALUES (?,?,?)";		
		//jdbcTemplateObject.update(query,new Object[]{clientID,amount,interest});
	}

}
