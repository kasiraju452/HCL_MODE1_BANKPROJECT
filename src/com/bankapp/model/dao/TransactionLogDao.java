package com.bankapp.model.dao;

import java.util.List;
import com.bankapp.model.entities.*;

public interface TransactionLogDao {
	public TransactionLog addTransactionLog(String txInfo, Double amount, TransactionType txnType);
	//public List<TransactionLog> getAllTransactionLogs();
	public List<TransactionLog> getAllTransactionLogsForAccount(int accountId);
}
