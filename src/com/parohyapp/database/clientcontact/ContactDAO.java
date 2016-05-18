package com.parohyapp.database.clientcontact;

import com.parohyapp.bank.Contact;
import com.parohyapp.database.BankDAO;

public interface ContactDAO extends BankDAO{
	public Contact getClientContact(Integer id);
	public int getIdByEmail(String email);
	public void updateContact(Integer id, String phone, String email);
}
