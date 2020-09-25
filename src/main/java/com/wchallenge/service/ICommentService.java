package com.wchallenge.service;

import java.util.List;

import com.wchallenge.model.CommentModel;

public interface ICommentService {
	
	public List<CommentModel> getAll();
	public CommentModel findByPost(long id);

}
