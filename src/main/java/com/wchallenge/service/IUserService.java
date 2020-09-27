package com.wchallenge.service;

import java.util.List;

import com.wchallenge.model.UserModel;

public interface IUserService {
	
	public List<UserModel> getAll();
	public UserModel findById(long id);
	

}
