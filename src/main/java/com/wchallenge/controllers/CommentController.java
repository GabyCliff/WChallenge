package com.wchallenge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wchallenge.model.CommentModel;
import com.wchallenge.service.ICommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
	@GetMapping("")
    public List<CommentModel> getComments(){
        return commentService.getAll();
    }
	
	@GetMapping("/post/{id}")
	public List<CommentModel> getCommentByPost(@PathVariable("id") long id) {
		List<CommentModel> comments = new ArrayList<CommentModel>();
		comments = commentService.findByPost(id);
		return comments;
	}
	
	@GetMapping("/filterByName/{name}")
	public CommentModel getCommentByName(@PathVariable("name") String name){
		CommentModel comment = commentService.findByName(name);
		return comment;
	}
	
	@GetMapping("/filterByUser/{id}")
	public List<CommentModel[]> getCommentsByUser(@PathVariable("id") long id){
		List<CommentModel[]> comments = commentService.findByUser(id);
		return comments;
	}

}
