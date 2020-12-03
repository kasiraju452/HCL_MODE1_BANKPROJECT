package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
@ControllerAdvice
public class DataAccessExceptionController {

	@ExceptionHandler(DataAccessException.class)
	public ModelAndView ExceptionHandler(HttpServletRequest req, Exception ex) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("dataAcessExceptionPage");
		mv.addObject("key", ex.getMessage());
		return mv;
	}

}
