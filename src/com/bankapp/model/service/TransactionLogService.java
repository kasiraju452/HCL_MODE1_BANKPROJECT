package com.bankapp.model.service;

import java.util.List;

import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.entities.TransactionType;

public interface TransactionLogService {
	public TransactionLog addTransactionLog(String txInfo, Double amount, TransactionType txnType);
	//public List<TransactionLog> getAllTransactionLogs();
	public List<TransactionLog> getAllTransactionLogsForAccount(int accountId);

}
