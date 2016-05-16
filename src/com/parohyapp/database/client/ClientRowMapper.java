package com.parohyapp.database.client;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.parohyapp.bank.Client;

public class ClientRowMapper implements RowMapper<Client>{

	@Override
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client resultClient = new Client(rs.getString("FirstName"), rs.getString("LastName"), rs.getDate("DOB"));
		return resultClient;
	}

}
