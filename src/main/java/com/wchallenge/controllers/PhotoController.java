package com.wchallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<PhotoModel>> getPhotos(){
		List<PhotoModel> photos = photoService.getAll();
		return new ResponseEntity<List<PhotoModel>>(photos, HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<PhotoModel> getPhoto(@PathVariable("id") long id){
        PhotoModel photo = photoService.getPhoto(id);
        return new ResponseEntity<PhotoModel>(photo, HttpStatus.OK);
    }
	
	@GetMapping("/album/{id}")
	public ResponseEntity<List<PhotoModel>> getPhotoByAlbum(@PathVariable("id") long id) {
		List<PhotoModel> photos = photoService.findByAlbum(id);
		return new ResponseEntity<List<PhotoModel>>(photos, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<PhotoModel[]>> getPhotoByUser(@PathVariable("id") long id) {
		List<PhotoModel[]> photos = photoService.getPhotosByUser(id);
		return new ResponseEntity<List<PhotoModel[]>>(photos, HttpStatus.OK);
	}

}
