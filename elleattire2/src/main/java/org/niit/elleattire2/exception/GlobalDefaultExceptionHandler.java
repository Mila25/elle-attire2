package org.niit.elleattire2.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException() {
		
		 	ModelAndView mv = new ModelAndView("error");
		 	mv.addObject("errorTitle", "The Page is not Constrtucted");

		 	mv.addObject("errorDescription", "Oops! This page is not available now!");
		 	
		 	mv.addObject("title", "404 Error Page");
		 	
		 	return mv;
		 	
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		
		 	ModelAndView mv = new ModelAndView("error");
		 	mv.addObject("errorTitle", "Product not available");

		 	mv.addObject("errorDescription", "Oops! This product is not available now!");
		 	
		 	mv.addObject("title", "Product Unavailable");
		 	
		 	return mv;
		 	
	}      
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		
		 	ModelAndView mv = new ModelAndView("error");
		 	mv.addObject("errorTitle", "Contact your Administrator!");
		 	
		 	//only for debugging your application
		 	StringWriter sw = new  StringWriter();
		 	PrintWriter pw = new PrintWriter(sw);
		 	
		 	ex.printStackTrace(pw);

		 	mv.addObject("errorDescription", sw.toString());
		 	
		 	mv.addObject("title", "Error");
		 	
		 	return mv;
		 	
	}      
	
	
}
