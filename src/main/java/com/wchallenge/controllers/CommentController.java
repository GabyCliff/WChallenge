package com.wchallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CommentModel>> getComments(){
		List<CommentModel> comments = commentService.getAll();
		return new ResponseEntity<List<CommentModel>>(comments, HttpStatus.OK);
    }
	
	@GetMapping("/post/{id}")
	public ResponseEntity<List<CommentModel>> getCommentByPost(@PathVariable("id") long id) {
		List<CommentModel> comments = commentService.findByPost(id);
		return new ResponseEntity<List<CommentModel>>(comments, HttpStatus.OK);
	}
	
	@GetMapping("/filterByName/{name}")
	public ResponseEntity<CommentModel> getCommentByName(@PathVariable("name") String name){
		CommentModel comment = commentService.findByName(name);
		return new ResponseEntity<CommentModel>(comment, HttpStatus.OK);
	}
	
	@GetMapping("/filterByUser/{id}")
	public ResponseEntity<List<CommentModel[]>> getCommentsByUser(@PathVariable("id") long id){
		List<CommentModel[]> comments = commentService.findByUser(id);
		return new ResponseEntity<List<CommentModel[]>>(comments, HttpStatus.OK);
	}

}
