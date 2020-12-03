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

import com.bankapp.model.entities.User;
import com.bankapp.model.entities.UserType;
import com.bankapp.model.service.UserService;
import com.bankapp.web.formbeans.UserBean;

@Controller
public class UserController {
private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	//"adduser"
	@GetMapping("adduser")
	public String addUserGet(ModelMap map) {
		map.addAttribute("userBean", new UserBean());
		return "adduser";
	}
	
	@PostMapping("adduser")
	public String addUserPost(@Valid @ModelAttribute("userBean") User userBean, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/adduser";
		} else {
			userService.addUser(userBean);
		return "redirect:/home";
		}
	}
	
	@GetMapping("updateuser")
	public String updateUserGet(ModelMap map, HttpServletRequest request) {
		System.out.println("updateuser");
		Integer uid = Integer.parseInt(request.getParameter("id"));
		User user = userService.getUserById(uid);
		map.addAttribute("userBean", user);
		System.out.println(user);//111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
		return "updateuser";
	}
	
	@GetMapping("deleteuser")
	public String deleteAccount( HttpServletRequest request) {
		Integer uid = Integer.parseInt(request.getParameter("id"));
		User user = userService.getUserById(uid);
		userService.deleteUser(user);
		return "redirect:/showallusers";
	}
	
	@GetMapping("showallusers")
	public ModelAndView showAllusers(ModelAndView mv) {
		List<User> users = userService.getAllUsers();
		mv.addObject("allusers", users);
		mv.setViewName("showallusers");
		return mv;
	}
	@ModelAttribute(value = "usertype")
	public UserType[] userType() {
		return UserType.values();
		//return UserType.values();
	}
	
	
	
}
