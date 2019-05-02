/**
 * 
 */
package com.quizmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sahana
 *
 */
@Controller
public class HomeController {

	
	@GetMapping("/")
	public String homePage() {
		return "login";
	}
	@GetMapping("/health")
	public String healthChecking() {
		return "Application is running";

	}
}
