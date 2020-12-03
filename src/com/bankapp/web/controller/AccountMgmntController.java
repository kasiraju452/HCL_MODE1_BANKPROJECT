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

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.AccountType;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.formbeans.Depositbean;
import com.bankapp.web.formbeans.Transferbean;
import com.bankapp.web.formbeans.Withdrawbean;

@Controller
public class AccountMgmntController {
	
	private AccountService accountService;
	
	@Autowired
	public AccountMgmntController(AccountService accountService) {
		this.accountService = accountService;
	}
	/*@GetMapping("/")
	public String entry() {
		return "redirect:/login";
	}*/
	/*@GetMapping("login")
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("login");
	
		return mv;
	}
	@GetMapping("logout")
	public ModelAndView logout(ModelAndView mv) {
		mv.setViewName("logout");
		
		return mv;
	}*/
//	@GetMapping("/")
//	public String entry() {
//		return "redirect:/home";
//	}

	@GetMapping("home")
	public String home() {
		return "home";
	}
	

	@GetMapping("success")
	public String success() {
		return "success";
	}
	
	@GetMapping("transfer")
	public String tranferAmountGet(ModelMap mv) {
		mv.addAttribute("transferbean", new Transferbean());
		return "transfer";
	}
	@PostMapping("transfer")
	public String tranferAmountPost(@Valid @ModelAttribute(name="transferbean") Transferbean transferBean, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "transfer";
		}else {
		
		int fromAcc=transferBean.getFromAccountId();
		int toAcc=transferBean.getToAccountId();
		double amount=transferBean.getAmount();
		accountService.tranfer(fromAcc, toAcc, amount);
		return "redirect:/success";
		}
	}
	//deposit some money code
	@GetMapping("deposit")
	public String depositAmountGet(ModelMap mv) {
		mv.addAttribute("depositBean", new Depositbean());
		return "deposit";
	}
	@PostMapping("deposit")
	public String depositAmountPost(@Valid @ModelAttribute(name="depositBean") Depositbean depositBean,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "deposit";
		} else {
		int fromAcc=depositBean.getAccountid();
		double amount=depositBean.getAmount();
		accountService.deposit(fromAcc, amount);
		return "redirect:/success";
	}}
	//withdraw the money
	@GetMapping("withdraw")
	public String withdrawAmountGet(ModelMap mv) {
		mv.addAttribute("withdrawbean", new Depositbean());
		return "withdraw";
	}
	@PostMapping("withdraw")
	public String withdrawAmountPost(@Valid @ModelAttribute(name="withdrawbean") Withdrawbean withdrawbean,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "withdraw";
		} else{
		int fromAcc=withdrawbean.getAccountid();
		double amount=withdrawbean.getAmount();
		accountService.withdraw(fromAcc, amount);
		return "redirect:/success";
	}
	}
	//adduser 
	/*@GetMapping("adduser")
	public String withdrawAmountGet(ModelMap mv) {
		mv.addAttribute("withdrawbean", new Depositbean());
		return "withdraw";
	}
	@PostMapping("adduser")
	public String withdrawAmountPost(@ModelAttribute(name="withdrawbean") Withdrawbean withdrawbean) {
		int fromAcc=withdrawbean.getAccountid();
		double amount=withdrawbean.getAmount();
		accountService.withdraw(fromAcc, amount);
		return "redirect:/success";
	}*/
	@GetMapping("addaccount")
	public String addAccountrGet(ModelMap map) {
		map.addAttribute("accountBean", new Account());
		return "addaccount";
	}
	
	@PostMapping("addaccount")
	public String addAccountPost(@Valid @ModelAttribute("accountBean") Account account, BindingResult result) {
		System.out.println("==============================================================" + account.getAccountId());
		if(result.hasErrors()) {
			return "addaccount";
		} else {
			if(account.getAccountId() == 0)  {
			accountService.addAccount(account);
			}
			return "redirect:/home";
		}
	}
	
	@ModelAttribute(value = "accounttype")
	public AccountType[] accountType() {
		return AccountType.values();
	}
	
	@GetMapping("showallaccounts")
	public ModelAndView showAllusers(ModelAndView mv) {
		System.out.println("show all accounts");
		//List<Account> account = ;
		mv.addObject("allaccounts", accountService.getAllAccounts());
		mv.setViewName("showallaccounts");
		return mv;
	}

	@GetMapping("updateaccount")
	public String updateUserGet(ModelMap map, HttpServletRequest request) {
		Integer uid = Integer.parseInt(request.getParameter("uId"));
		Account account = accountService.getAccountById(uid);
		map.addAttribute("addAccountBean", account);
		return "updateaccount";
	}
	
	@GetMapping("deleteaccount")
	public String deleteAccount( HttpServletRequest request) {
		Integer uid = Integer.parseInt(request.getParameter("uId"));
		accountService.deleteAccount(uid);
		return "redirect:/showallaccounts";
	}
}
