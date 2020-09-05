package io.raut.springboot.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class First {
	
	@RequestMapping("/hi")
	public String sayHi() {
		return "Hello";
	}
}
