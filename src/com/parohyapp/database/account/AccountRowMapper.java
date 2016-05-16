package com.parohyapp.database.account;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.parohyapp.bank.Account;

public class AccountRowMapper implements RowMapper<Account>{

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account resultAccount = new Account(rs.getInt("AccountID"), rs.getFloat("Balance"));
		return resultAccount;
	}

}
