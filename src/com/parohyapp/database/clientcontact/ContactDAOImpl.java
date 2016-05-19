package com.parohyapp.database.clientcontact;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.parohyapp.bank.Contact;
import com.parohyapp.database.ErrorCode;

public class ContactDAOImpl implements ContactDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource ds) {
		dataSource = ds;
		jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public void delete(Integer id) {
		String query = "DELETE FROM client_detail WHERE ClientID=?";
		jdbcTemplateObject.update(query,new Object[]{id});		
	}

	@Override
	public Contact getClientContact(Integer id) {
		String query = "SELECT * FROM client_detail WHERE ClientID=?";
		Contact result = jdbcTemplateObject.queryForObject(query, new Object[]{id}, new ContactRowMapper());
		return result;
	}
	
	@Override
	public int getIdByEmail(String email){
		String query = "SELECT count(*) FROM client_detail WHERE Email=?";
		int count = jdbcTemplateObject.queryForObject(query,new Object[]{email},Integer.class);
		int id;
		if(count == 1){
			query = "SELECT ClientID FROM client_detail WHERE Email=?";
			id = jdbcTemplateObject.queryForObject(query,new Object[]{email},Integer.class);
		}
		else{
			id = ErrorCode.NO_SUCH_USER.getCode();
		}
		return id;
	}

	@Override
	public void updateContact(Integer id, String phone, String email) {
		String query = "UPDATE client_detail SET Tel=?, Email=? WHERE ClientID=?";
		jdbcTemplateObject.update(query,new Object[]{phone,email,id});		
	}

}
