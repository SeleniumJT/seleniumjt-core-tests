package com.jtevent.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
public abstract class BaseJspController {
	
	protected final String MESSAGE = "message";
	protected final Log logger = LogFactory.getLog(getClass());
	
	
	@ExceptionHandler (Exception.class)
    @ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleAllExceptions(HttpServletRequest request, Exception ex) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		modelAndView.addObject("name", ex.getClass().getSimpleName());
		modelAndView.addObject("message", ex.getMessage());
		try {
			modelAndView.addObject("contextpath", setContextPath(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
	    logger.error("Exception in "+ex.getClass().getSimpleName(), ex);
	    return modelAndView;
    }  

	@ModelAttribute("contextpath")
	public String setContextPath(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		return "/".equals(contextPath) ? "" : contextPath;
	}
	
}
