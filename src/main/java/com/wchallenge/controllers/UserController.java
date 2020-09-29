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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/users")
@Api
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("")
	@ApiOperation(value = "Return all Users", response = UserModel.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Users")
	public ResponseEntity<List<UserModel>> getUsers() {
		List<UserModel> users = userService.getAll();
		return new ResponseEntity<List<UserModel>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Giving an id, return the User", response = UserModel.class)
	@ApiResponse(code = 200, message = "Successfully retrieved User")
	public ResponseEntity<UserModel> getUser(@PathVariable("id") long id) {
		UserModel user = userService.findById(id);
		return new ResponseEntity<UserModel>(user, HttpStatus.OK);
	}
	
	

}
