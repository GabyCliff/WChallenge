package com.wchallenge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wchallenge.model.PostModel;
import com.wchallenge.service.IPostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private IPostService postService;
	
	@GetMapping("")
    public List<PostModel> getPosts(){
        return postService.getAll();
    }
	
	@GetMapping("/{id}")
	public List<PostModel> getPostByUser(@PathVariable("id") long id) {
		List<PostModel> posts = new ArrayList<PostModel>();
		posts = postService.findByUser(id);
		return posts;
	}

}
