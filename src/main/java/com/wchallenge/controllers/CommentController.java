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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
	@GetMapping("")
	@ApiOperation(value = "Return all Comments", response = CommentModel.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Comments")
    public ResponseEntity<List<CommentModel>> getComments(){
		List<CommentModel> comments = commentService.getAll();
		return new ResponseEntity<List<CommentModel>>(comments, HttpStatus.OK);
    }
	
	@GetMapping("/post/{id}")
	@ApiOperation(value = "Giving an id, return the comments of that post", response = CommentModel.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Comments")
	public ResponseEntity<List<CommentModel>> getCommentByPost(@PathVariable("id") long id) {
		List<CommentModel> comments = commentService.findByPost(id);
		return new ResponseEntity<List<CommentModel>>(comments, HttpStatus.OK);
	}
	
	@GetMapping("/filterByName/{name}")
	@ApiOperation(value = "Giving a name, return the comment", response = CommentModel.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Comment")
	public ResponseEntity<CommentModel> getCommentByName(@PathVariable("name") String name){
		CommentModel comment = commentService.findByName(name);
		return new ResponseEntity<CommentModel>(comment, HttpStatus.OK);
	}
	
	@GetMapping("/filterByUser/{id}")
	@ApiOperation(value = "Giving an id, return the comments of that user", response = CommentModel.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Comments")
	public ResponseEntity<List<CommentModel[]>> getCommentsByUser(@PathVariable("id") long id){
		List<CommentModel[]> comments = commentService.findByUser(id);
		return new ResponseEntity<List<CommentModel[]>>(comments, HttpStatus.OK);
	}

}
