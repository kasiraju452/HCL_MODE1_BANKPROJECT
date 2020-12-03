package com.bankapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.dao.TransactionLogDao;
import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.entities.TransactionType;


@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;
	public TransactionLogDao transactionLogDao;
	private TransactionLogService transactionLogService;
	
	@Autowired
	public AccountServiceImpl(AccountDao accountDao, TransactionLogService transactionLogService,TransactionLogDao transactionLogDao) {
		this.accountDao = accountDao;
		this.transactionLogService = transactionLogService;
		this.transactionLogDao=transactionLogDao;
	}

	@Override
	public List<Account> getAllAccounts() {
		
		return accountDao.getAllAccounts();
	}

	@Override
	public void deposit(int accountId, double amount) {
		Account account=accountDao.getAccountById(accountId);
		account.setBalance(account.getBalance()+amount);
		//accountDao.updateAccount(account);
		account.setTransactionLog(transactionLogDao.getAllTransactionLogsForAccount(accountId));
		//TransactionLog e = new TransactionLog(txInfo, amount, txnType)
		//111111111111TransactionLog e = new TransactionLog("Deposited to " + accountId , amount,TransactionType.DEPOSIT);
		//1account.getTransactionLog().add(e);
		accountDao.updateAccount(account);
	//	transactionLogService.addTransactionLog("deposit amount" ,amount, TransactionType.DEPOSIT);
		
	}
	
	//@Loggable
	@Override
	public void withdraw(int accountId, double amount) {
		Account account=accountDao.getAccountById(accountId);
		account.setBalance(account.getBalance()-amount);
		accountDao.updateAccount(account);
		//transactionLogService.addTransactionLog("deposit amount" ,amount, TransactionType.WITHDRAW);
		TransactionLog entry = new TransactionLog("Withdraw from " + accountId , amount, TransactionType.WITHDRAW);
		account.getTransactionLog().add(entry);
		accountDao.updateAccount(account);
	}

	@Override
	public void tranfer(int fromAccountId, int toAccountId, double amount) {
		withdraw(fromAccountId, amount);
		deposit(toAccountId, amount);
	}

	@Override
	public void updateAddress(int accountId, String address, String phone, String email) {
		Account account=getAccountById(accountId);
		account.setAddress(account.getAddress());
		account.setPhone(account.getPhone());
		account.setEmail(account.getEmail());
		accountDao.updateAccount(account);
		
	}

	@Override
	public Account deleteAccount(int accountId) {
	
		return accountDao.deleteAccount(accountId);
	}

	@Override
	public Account getAccountById(int accountId) {
		return accountDao.getAccountById(accountId);
	}

	@Override
	public Account addAccount(Account account) {
		return accountDao.addAccount(account);
	}

}
