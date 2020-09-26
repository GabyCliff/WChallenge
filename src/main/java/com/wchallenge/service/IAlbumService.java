package com.wchallenge.service;

import java.util.List;

import com.wchallenge.model.AlbumModel;

public interface IAlbumService {
	
	public List<AlbumModel> getAll();
	public List<AlbumModel> findByUser(long id);

}
