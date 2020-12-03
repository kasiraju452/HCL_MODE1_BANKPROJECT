package com.bankapp.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="account_table")
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer accountId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String address;
	
	@Column(nullable=false)
	private String phone;
	
	@Column(nullable=false)
	private String email;
	
	private Double balance;
	
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	
	private AccountStatusType status=AccountStatusType.ACTIVE;
	
	@Column(unique=true,nullable=false)
	private String panNumber;
	
	@Column(unique=true,nullable=false)
	private String aadharNumber;
	
	@JoinColumn(name="account_Id_fk")
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<TransactionLog> transactionLog= new ArrayList<TransactionLog>();

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public AccountStatusType getStatus() {
		return status;
	}

	public void setStatus(AccountStatusType status) {
		this.status = status;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public List<TransactionLog> getTransactionLog() {
		return transactionLog;
	}

	public void setTransactionLog(List<TransactionLog> transactionLog) {
		this.transactionLog = transactionLog;
	}

	public Account(String name, String address, String phone, String email, Double balance, AccountType accountType,
			AccountStatusType status, String panNumber, String aadharNumber, List<TransactionLog> transactionLog) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.balance = balance;
		this.accountType = accountType;
		this.status = status;
		this.panNumber = panNumber;
		this.aadharNumber = aadharNumber;
		this.transactionLog = transactionLog;
	}

	public Account(String name, String address, String phone, String email, Double balance, AccountType accountType,
			String panNumber, String aadharNumber) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.balance = balance;
		this.accountType = accountType;
		this.panNumber = panNumber;
		this.aadharNumber = aadharNumber;
	}

	public Account() {
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", balance=" + balance + ", accountType=" + accountType + ", status=" + status
				+ ", panNumber=" + panNumber + ", aadharNumber=" + aadharNumber + "]";
	}

	
	
	
	
	
}
