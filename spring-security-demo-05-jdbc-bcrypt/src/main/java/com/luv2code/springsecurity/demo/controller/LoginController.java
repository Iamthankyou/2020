package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/showFormLogin")
	public String showFormLogin(){
		return "fancy-login";
	}
	
	@GetMapping("/denied")
	public String showAccessDenied(){
		return "denied";
	}
}