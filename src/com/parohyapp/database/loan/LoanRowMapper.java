package com.parohyapp.database.loan;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.parohyapp.bank.Loan;

public class LoanRowMapper implements RowMapper<Loan>{

	@Override
	public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
		Loan loanResult = new Loan(rs.getFloat("Amount"), rs.getFloat("Interest"), rs.getInt("Paid"));		
		return loanResult;
	}

}
