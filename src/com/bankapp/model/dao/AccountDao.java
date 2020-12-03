package com.bankapp.model.dao;

import java.util.List;

import com.bankapp.model.entities.Account;

public interface AccountDao {
	public List<Account> getAllAccounts();
	public Account updateAccount(Account account);
	public Account deleteAccount(int accountId);
	public Account getAccountById(int accountId);
	public Account addAccount(Account account);
	
}
