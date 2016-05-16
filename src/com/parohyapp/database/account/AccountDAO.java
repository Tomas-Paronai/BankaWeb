package com.parohyapp.database.account;

import java.util.List;

import com.parohyapp.bank.Account;
import com.parohyapp.database.BankDAO;

public interface AccountDAO extends BankDAO{
	public Account getAccount(Integer id);
	public List<Account> getAccounts(Integer id);
	public void updateAccount(Integer id, float balance);
}
