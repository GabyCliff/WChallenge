package com.wchallenge.service;

import java.util.List;

import com.wchallenge.model.PhotoModel;

public interface IPhotoService {
	
	public List<PhotoModel> getAll();
	public List<PhotoModel> findByAlbum(long id);
	public PhotoModel getPhoto(long photoId);
	public List<PhotoModel[]> getPhotosByUser(long userId);

}
