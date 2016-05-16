package com.parohyapp.database;

import javax.sql.DataSource;

public interface BankDAO {
	public void setDataSource(DataSource ds);
	public void delete(Integer id);	
}
