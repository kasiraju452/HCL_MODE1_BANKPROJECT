package com.bankapp.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="transactionLog_table")
public class TransactionLog{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer txId;
	
	private String txInfo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;
	
	private Double amount;
	
	@Enumerated(EnumType.STRING)
	private TransactionType txnType;
	
	public TransactionLog() {
		
	}

	public Integer getTxId() {
		return txId;
	}

	public void setTxId(Integer txId) {
		this.txId = txId;
	}

	public String getTxInfo() {
		return txInfo;
	}

	public void setTxInfo(String txInfo) {
		this.txInfo = txInfo;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public TransactionType getTxnType() {
		return txnType;
	}

	public void setTxnType(TransactionType txnType) {
		this.txnType = txnType;
	}

	public TransactionLog(String txInfo, Double amount, TransactionType txnType) {
		this.txInfo = txInfo;
		this.amount = amount;
		this.txnType = txnType;
	}

	
}