package com.bankapp.web.formbeans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Withdrawbean {
	@NotNull(message = "Account Id cannot be null")
	private Integer Accountid;
	
	@NotNull(message = "Amount Id cannot be null")
	@Min(value = 1000 ,message = "Minimum amount should not be less than 100")
	@Max(value = 50000,message = "Maximum amount should not exceed 50000")
	private Double amount;
	public Integer getAccountid() {
		return Accountid;
	}
	public void setAccountid(Integer accountid) {
		this.Accountid = accountid;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Withdrawbean() {
		
		
	}
	
}
