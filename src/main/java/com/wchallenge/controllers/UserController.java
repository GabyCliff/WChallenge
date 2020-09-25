package com.wchallenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wchallenge.helpers.ViewRouteHelper;
import com.wchallenge.model.UserModel;
import com.wchallenge.service.IUserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/{id}")
	public UserModel getUser(@PathVariable("id") long id) {
		return userService.findById(id);
	}
	
	@GetMapping("")
    public ModelAndView getUsers(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.USER_INDEX);
        mAV.addObject("users", userService.getAll());
        return mAV;
    }

}
