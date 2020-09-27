package com.wchallenge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wchallenge.model.PhotoModel;
import com.wchallenge.service.IPhotoService;

@RestController
@RequestMapping("/photos")
public class PhotoController {
	
	@Autowired
	private IPhotoService photoService;
	
	@GetMapping("")
    public List<PhotoModel> getPhotos(){
        return photoService.getAll();
    }
	
	@GetMapping("/{id}")
    public PhotoModel getPhoto(@PathVariable("id") long id){
        return photoService.getPhoto(id);
    }
	
	@GetMapping("/album/{id}")
	public List<PhotoModel> getPhotoByAlbum(@PathVariable("id") long id) {
		List<PhotoModel> photos = new ArrayList<PhotoModel>();
		photos = photoService.findByAlbum(id);
		return photos;
	}
	
	@GetMapping("/user/{id}")
	public List<PhotoModel[]> getPhotoByUser(@PathVariable("id") long id) {
		return photoService.getPhotosByUser(id);
	}

}
