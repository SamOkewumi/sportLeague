package com.oke.league.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/test")
	public String testController() {
		logger.debug("The testController() method was invoked");
		return "The League app is up and running";
	}
}
