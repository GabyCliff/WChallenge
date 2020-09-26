package com.wchallenge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wchallenge.helpers.ViewRouteHelper;
import com.wchallenge.model.PostModel;
import com.wchallenge.service.IPostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private IPostService postService;
	
	@GetMapping("")
    public ModelAndView getPosts(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.POST_INDEX);
        mAV.addObject("posts", postService.getAll());
        return mAV;
    }
	
	@GetMapping("/{id}")
	public List<PostModel> getPostByUser(@PathVariable("id") long id) {
		List<PostModel> posts = new ArrayList<PostModel>();
		posts = postService.findByUser(id);
		return posts;
	}

}
