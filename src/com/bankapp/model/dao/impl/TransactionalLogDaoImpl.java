package com.bankapp.model.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.model.dao.TransactionLogDao;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.entities.TransactionType;
@Repository
public class TransactionalLogDaoImpl implements TransactionLogDao{
	private SessionFactory factory;
	
	@Autowired
	public TransactionalLogDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}
	@Override
	public TransactionLog addTransactionLog(String txInfo, Double amount, TransactionType txnType) {
		TransactionLog log=new TransactionLog(txInfo, amount, txnType);
		getSession().persist(log);
		return log;
	}
/*
	@Override
	public List<TransactionLog> getAllTransactionLogs() {
		return null;
	}*/

	@Override
	public List<TransactionLog> getAllTransactionLogsForAccount(int accountId) {
		Query query = getSession().createNativeQuery("select * from transactionLog_table t where t.account_id_fk=:accountId", TransactionLog.class);
		query.setParameter("accountId", accountId);
		TransactionLog log=getSession().find(TransactionLog.class, accountId);
		return  (List<TransactionLog>) log;
		
	}

}
