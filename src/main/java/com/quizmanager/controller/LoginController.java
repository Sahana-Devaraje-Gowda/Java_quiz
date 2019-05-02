package com.quizmanager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.quizmanager.dto.UserDetails;
import com.quizmanager.service.UserService;

@RestController
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	HttpSession httssession;

	
	
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView andView = new ModelAndView("index");
		String userName = (String) httssession.getAttribute("username");
		if (userName != null) {
			andView.addObject("username", userName);
		}
		return andView;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView andView = new ModelAndView("login");
		String userName = (String) httssession.getAttribute("username");
		if (userName != null) {
			andView.addObject("username", userName);
		}
		return andView;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout() {
		ModelAndView andView = new ModelAndView("login");
		httssession.invalidate();
		return andView;
	}

	@PostMapping("/loginProcess")
	public UserDetails loginProcess(@RequestBody UserDetails userDetails) {
		UserDetails user = userService.validateUser(userDetails);
		httssession.setAttribute("email", user.getEmail());
		httssession.setAttribute("username", user.getUserName());
		return user;
	}

	@GetMapping("/registration")
	public ModelAndView registration() {
		return new ModelAndView("registration");
	}

	@SuppressWarnings("unused")
	@PostMapping("/signupComplete")
	public String signupComplete(@RequestBody UserDetails user) {
		String result = "";
		if (user != null) {
			result = userService.saveUser(user);
		}
		return result;
	}

	@GetMapping("/loginSucess")
	public ModelAndView registerSucess() {
		ModelAndView andView = new ModelAndView("login");
		andView.addObject("errormsg", "SuccessFully registered ");
		return andView;
	}

	@GetMapping("/forgotpassword")
	public ModelAndView forgotpassword() {
		ModelAndView andView = new ModelAndView("forgotPassword");
		return andView;
	}

	@PostMapping("/resetPassword")
	public String resetPassword(@RequestBody String email) {
		String otp = "";
		if (email != null) {
			otp = userService.forgotPassword(email);
		}
		return otp;
	}

	@PostMapping("/saveNewPassword")
	public String setNewPassword(@RequestBody UserDetails userdetails) {
		if (userdetails.getEmail() != null && userdetails.getPassword() != null) {
			userService.userDetailsUpdate(userdetails.getEmail(), userdetails.getPassword());
		} else {
				throw new NullPointerException("Please try after some time ");

		}
		return "success";
	}

}
