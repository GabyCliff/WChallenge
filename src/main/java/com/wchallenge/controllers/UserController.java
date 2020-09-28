package com.wchallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<UserModel>> getUsers() {
		List<UserModel> users = userService.getAll();
		return new ResponseEntity<List<UserModel>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserModel> getUser(@PathVariable("id") long id) {
		UserModel user = userService.findById(id);
		return new ResponseEntity<UserModel>(user, HttpStatus.OK);
	}
	
	

}
