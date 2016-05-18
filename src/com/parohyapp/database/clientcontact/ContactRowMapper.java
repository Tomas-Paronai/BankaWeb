package com.parohyapp.database.clientcontact;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.parohyapp.bank.Contact;

public class ContactRowMapper implements RowMapper<Contact>{

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact resultContact = new Contact(rs.getString("Tel"),rs.getString("Email"));
		return resultContact;
	}

}
