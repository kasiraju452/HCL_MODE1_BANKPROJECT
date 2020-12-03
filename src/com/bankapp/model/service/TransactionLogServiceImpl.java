package com.bankapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.TransactionLogDao;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.entities.TransactionType;


@Service("transactionLogService")
@Transactional
public class TransactionLogServiceImpl implements TransactionLogService{
	private TransactionLogDao txlogDao;
	
	
	@Autowired
	public TransactionLogServiceImpl(TransactionLogDao txlogDao) {
		super();
		this.txlogDao = txlogDao;
	}

	@Override
	public TransactionLog addTransactionLog(String txInfo, Double amount, TransactionType txnType) {
		return txlogDao.addTransactionLog(txInfo, amount, txnType);
	}

	/*@Override
	public List<TransactionLog> getAllTransactionLogs() {
	
		return null;
	}*/

	@Override
	public List<TransactionLog> getAllTransactionLogsForAccount(int accountId) {
		
		return null;
	}

}
