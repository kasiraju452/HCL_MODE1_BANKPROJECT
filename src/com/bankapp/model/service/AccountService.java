package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entities.Account;

public interface AccountService {

	public List<Account> getAllAccounts();
	public void deposit(int accountId, double amount);
	public void withdraw(int accountId, double amount);
	public void tranfer(int fromAccountId,int toAccountId, double amount);
	public void updateAddress(int accountId,String address,String phone,String email);
	public Account deleteAccount(int accountId);
	public Account getAccountById(int accountId);
	public Account addAccount(Account account);
	
}
