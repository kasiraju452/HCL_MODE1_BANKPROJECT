package com.bankapp.web.formbeans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Transferbean {
	@NotNull(message = "Account Id cannot be null")
	private Integer fromAccountId;
	
	@NotNull(message = "Account Id cannot be null")
	private Integer toAccountId;
	
	@NotNull(message = "Amount cannot be null")
	@Min(value = 1000 ,message = "Minimum amount should not be less than 100")
	@Max(value = 50000,message = "Maximum amount should not exceed 50000")
	private Double amount;
	public Integer getFromAccountId() {
		return fromAccountId;
	}
	public void setFromAccountId(Integer fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	public Integer getToAccountId() {
		return toAccountId;
	}
	public void setToAccountId(Integer toAccountId) {
		this.toAccountId = toAccountId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Transferbean() {
		
	}
	
	
}
