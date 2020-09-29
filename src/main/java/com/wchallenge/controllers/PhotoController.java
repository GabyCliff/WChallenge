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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/photos")
public class PhotoController {
	
	@Autowired
	private IPhotoService photoService;
	
	@GetMapping("")
	@ApiOperation(value = "Return all Photos", response = PhotoModel.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Photos")
    public ResponseEntity<List<PhotoModel>> getPhotos(){
		List<PhotoModel> photos = photoService.getAll();
		return new ResponseEntity<List<PhotoModel>>(photos, HttpStatus.OK);
    }
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Giving an id, return the photo", response = PhotoModel.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Photo")
    public ResponseEntity<PhotoModel> getPhoto(@PathVariable("id") long id){
        PhotoModel photo = photoService.getPhoto(id);
        return new ResponseEntity<PhotoModel>(photo, HttpStatus.OK);
    }
	
	@GetMapping("/album/{id}")
	@ApiOperation(value = "Giving a album id, return the photos of that album", response = PhotoModel.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Photos")
	public ResponseEntity<List<PhotoModel>> getPhotoByAlbum(@PathVariable("id") long id) {
		List<PhotoModel> photos = photoService.findByAlbum(id);
		return new ResponseEntity<List<PhotoModel>>(photos, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	@ApiOperation(value = "Giving a user id, returns the photos of that user", response = PhotoModel.class)
	@ApiResponse(code = 200, message = "Successfully retrieved Photos")
	public ResponseEntity<List<PhotoModel[]>> getPhotoByUser(@PathVariable("id") long id) {
		List<PhotoModel[]> photos = photoService.getPhotosByUser(id);
		return new ResponseEntity<List<PhotoModel[]>>(photos, HttpStatus.OK);
	}

}
