package com.bankapp.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
@ControllerAdvice
public class PageNotFoundException {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView ExceptionHandler() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("404");
		return mv;
	}

}
