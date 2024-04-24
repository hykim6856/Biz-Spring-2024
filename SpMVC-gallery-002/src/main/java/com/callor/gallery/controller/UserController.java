package com.callor.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class UserController {
	

	
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String Join(Model model) {		
		
		return null;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {		
		
		return null;
	}
	
}
