package com.jtevent.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class SimpleController extends BaseJspController {

	@RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
	public String getBusTimesByBusNumberStrinct(ModelMap model, @PathVariable String page) throws IOException {
		model.addAttribute("title", "Title is "+page);
		return "tests/"+page;
	}



	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getBusTimes(ModelMap model) throws IOException {
		return "home";
	}
	

}
