package com.wchallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wchallenge.model.UserModel;
import com.wchallenge.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("")
	public List<UserModel> getUsers() {
		return userService.getAll();
	}
	
	@GetMapping("/{id}")
	public UserModel getUser(@PathVariable("id") long id) {
		return userService.findById(id);
	}
	

}
