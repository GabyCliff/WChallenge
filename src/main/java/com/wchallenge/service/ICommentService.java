package com.wchallenge.service;

import java.util.List;

import com.wchallenge.model.CommentModel;

public interface ICommentService {
	
	public List<CommentModel> getAll();
	public List<CommentModel> findByPost(long id);
	public CommentModel findByName(String name);
	public List<CommentModel[]> findByUser(long id);

}
