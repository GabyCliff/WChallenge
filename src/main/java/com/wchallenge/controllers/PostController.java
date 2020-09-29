package com.wchallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wchallenge.model.PostModel;
import com.wchallenge.service.IPostService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private IPostService postService;
	
	@GetMapping("")
	@ApiOperation(value = "Return all Posts", response = PostModel.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Posts")
    public ResponseEntity<List<PostModel>> getPosts(){
		List<PostModel> posts = postService.getAll();
        return new ResponseEntity<List<PostModel>>(posts, HttpStatus.OK);
    }
	
	@GetMapping("/user/{id}")
	@ApiOperation(value = "Giving a user id, return the posts of that user", response = PostModel.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Posts")
	public ResponseEntity<List<PostModel>> getPostByUser(@PathVariable("id") long id) {
		List<PostModel> posts = postService.findByUser(id);
        return new ResponseEntity<List<PostModel>>(posts, HttpStatus.OK);
	}

}
