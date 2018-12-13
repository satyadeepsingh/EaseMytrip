package org.ems.com.asdits.controllers;

import org.ems.com.asdits.api.IConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewControllerApi10 {
	
	@RequestMapping(method=RequestMethod.GET, value=IConstant.HOME)
	private String getHome() {
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET, value=IConstant.LOGIN)
	public String showLoginPage() {
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.GET, value=IConstant.WELCOME)
	public String showWelcomePage() {
		return "index";
	}
}
