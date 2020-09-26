package com.wchallenge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wchallenge.helpers.ViewRouteHelper;
import com.wchallenge.model.CommentModel;
import com.wchallenge.service.ICommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
	@GetMapping("")
    public ModelAndView getComments(){
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.COMMENT_INDEX);
        mAV.addObject("comments", commentService.getAll());
        return mAV;
    }
	
	@GetMapping("/{id}")
	public List<CommentModel> getCommentByPost(@PathVariable("id") long id) {
		List<CommentModel> comments = new ArrayList<CommentModel>();
		comments = commentService.findByPost(id);
		return comments;
	}

}
