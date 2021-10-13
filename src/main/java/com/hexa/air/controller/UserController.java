package com.hexa.air.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.hexa.air.entity.User;
import com.hexa.air.service.UserService;

@CrossOrigin(origins = { "*" })
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/test")
	public String test() {
		return "Microservice is working good!!!";
	}
	
	@RequestMapping(value = "/signup", method=RequestMethod.POST)
	public String signup(@RequestBody User user) {
		return userService.signup(user);
	}
	
	@RequestMapping(value = "/signin", method=RequestMethod.POST)
	public String signin(@RequestBody ObjectNode objectNode) {
		String id = objectNode.get("id").asText();
		String password = objectNode.get("password").asText();
		return userService.signin(id, password);
	}
	
	@RequestMapping(value = "/getuser/{id}", method=RequestMethod.GET)
	public String getUser(@PathVariable("id") String id){
		return userService.getUser(id);
	}
	
}
