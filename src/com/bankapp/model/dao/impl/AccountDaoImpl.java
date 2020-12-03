package com.bankapp.model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.dao.exceptions.AccountNotFoundException;
import com.bankapp.model.entities.Account;
@Repository
public class AccountDaoImpl implements AccountDao {
	private SessionFactory factory;
	
	@Autowired
	public AccountDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	private Session getSession() {
		return factory.getCurrentSession();
		
		
	}
	@Override
	public List<Account> getAllAccounts() {
		return getSession().createQuery("from Account").list();
	}

	@Override
	public Account updateAccount(Account account) {
		getSession().update(account);
		return account;
		
	}

	@Override
	public Account deleteAccount(int accountId) {
		Account delAccount=getAccountById(accountId);
		getSession().delete(delAccount);
		return delAccount;
	}

	@Override
	public Account getAccountById(int accountId) {
		Account acc=getSession().find(Account.class, accountId);
		if(acc==null) {
			throw new AccountNotFoundException("account with id "+ accountId + " not found!!!");
		}
		return acc;
	}

	@Override
	public Account addAccount(Account account) {
		getSession().save(account);
		return account;
	}

}
