package com.bankapp.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionLogService;
import com.bankapp.web.formbeans.Transferbean;
import com.bankapp.web.formbeans.Withdrawbean;

@Controller
public class TransctionController {
	private AccountService accountService;
	private TransactionLogService transactionLogService;
	
	@Autowired
	public TransctionController(AccountService accountService, TransactionLogService transactionLogService) {
		this.accountService = accountService;
		this.transactionLogService = transactionLogService;
	}
	/*@GetMapping("/home")
	public String home() {
		return "home";
	}


	@GetMapping("transfer")
	public String transferGet(ModelMap map) {
		map.addAttribute("transferBean", new Transferbean());
		return "transfer";
	}
	
	@PostMapping("transfer") 
	public String transferPost(@Valid @ModelAttribute("transferBean") Transferbean transferbean, BindingResult result) {
		
		if(result.hasErrors()) {
			return "transfer";
		} else {
		int fromAccountId = transferbean.getFromAccountId();
		int toAccountId = transferbean.getToAccountId();
		Double amount = transferbean.getAmount();
		accountService.tranfer(fromAccountId, toAccountId, amount);
		return "success";
		}
	}
	
	@GetMapping("withdraw")
	public String withdrawGet(ModelMap map) {
		map.addAttribute("withdrawBean", new Withdrawbean());
		return "withdraw";
	}
	
	@PostMapping("withdraw") 
	public String withdrawPost(@Valid @ModelAttribute("withdrawBean") Withdrawbean withdrawbean, BindingResult result) {
		if(result.hasErrors()) {
			return "withdraw";
		} else {
		int accountId = withdrawbean.getAccountid();
		Double amount = withdrawbean.getAmount();
		accountService.withdraw(accountId, amount);
		return "success";
		}
	}
	
	@GetMapping("deposit")
	public String depositGet(ModelMap map) {
		map.addAttribute("depositBean", new Withdrawbean());
		return "deposit";
	}
	
	@PostMapping("deposit") 
	public String depositPost(@Valid @ModelAttribute("depositBean") Withdrawbean withdrawbean, BindingResult result) {
		if(result.hasErrors()) {
			return "deposit";
		} else {
		int accountId = withdrawbean.getAccountid();
		Double amount = withdrawbean.getAmount();
		accountService.deposit(accountId, amount);
		return "success";
		}
	}*/
	
	@GetMapping("getalltransactions")
	public ModelAndView transactionsHistory(HttpServletRequest request, ModelAndView mv) {
		int accountId = Integer.parseInt(request.getParameter("id"));
		//System.out.println("transaction id--------------------------------------------- "+ accountId);
		List<TransactionLog> transactionHistory = transactionLogService.getAllTransactionLogsForAccount(accountId);
		mv.addObject("transactionHistory", transactionHistory);
		mv.setViewName("transactionhistory");
		return mv;
	}
}
